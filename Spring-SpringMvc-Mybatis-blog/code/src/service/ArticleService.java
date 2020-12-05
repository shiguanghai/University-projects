package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Blog;
import entity.Category;
import entity.CategoryExample;
import entity.CommentExample;
import mapping.BlogMapper;
import mapping.CategoryMapper;
import mapping.CommentMapper;

@Service
public class ArticleService {
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private BlogMapper blogMapper;
	@Autowired
	private CommentMapper commentMapper;
	
	// ������е�������Ϣ����������Ϣ
	public List<Blog> getAllArticle() {
		return blogMapper.selectAll();
	}
    
	//ͨ��������ȡ�������´�������Ϣ
    public Blog selectByPrimaryKeyWithCategory(Integer id) {
    	return blogMapper.selectByPrimaryKeyWithCategory(id);
    }

    //��ȡ���е����´�������Ϣ
	public List<Blog> getAll() {
		return blogMapper.selectByExampleWithCategory(null);
	}

	// ��ȡ���еķ�����Ϣ
	public List<Category> getCategoryName() {
		return categoryMapper.selectByExample(null);
	}

	// �õ�����������Ӧ�� ID ֵ
	public Integer getCategoryId(String categoryName) {
		CategoryExample example = new CategoryExample();
		example.createCriteria().andNameEqualTo(categoryName);
		Category category = categoryMapper.selectByExample(example).get(0);
		Integer id = category.getId();
		return id;
	}

	// �洢һƪ����
	public void save(Blog blog) {
		blogMapper.insert(blog);
	}

	// ��ȡ id ����Ӧ�������´��������ݿ�� md 
	public String getArticleMdStr(int id) {
		Blog blog = blogMapper.selectByPrimaryKeyWithCategory(id);
		String md = blog.getMd();
		// md Ϊ null,���ؿ��ַ���
		if(md == null)
			return "";
		return md;
	}

	public Blog selectBlogById(int id) {
		Blog blog = blogMapper.selectByPrimaryKeyWithCategory(id);
		return blog;
	}

	public void deleteArticleById(int id) {
		CommentExample example = new CommentExample();
		example.createCriteria().andBlogIdEqualTo(id);
		commentMapper.deleteByExample(example);
		blogMapper.deleteByPrimaryKey(id);
	}

	public void update(Blog blog) {
		blogMapper.updateByPrimaryKeyWithBLOBs(blog);
	}
	
	// postarticle
	public List<Blog> postarticle(List<Blog> list) {
		List<Blog> listRtnBlogs = new ArrayList<Blog>();
		if(list != null && list.size() > 4) {
			// ��������������ƪ����ȡ����
			for(int i = 0 ; i < 4; i++) {
			
				for(int j = i + 1; j < list.size(); j++) {
					Blog temp;
					long t1,t2;
					CommentExample example = new CommentExample();
					example.createCriteria().andBlogIdEqualTo(list.get(i).getId());
					t1 = commentMapper.countByExample(example);
					
					CommentExample example1 = new CommentExample();
					example1.createCriteria().andBlogIdEqualTo(list.get(j).getId());
					t2 = commentMapper.countByExample(example1);
					
					if(t1 < t2) {
						 temp = list.get(i);
						 list.set(i, list.get(j));
						 list.set(j, temp);
					}
				}
			}
			listRtnBlogs = list.subList(0, 4);
		}
		
		if(list != null) {
			listRtnBlogs = list.subList(0, list.size());
		}
		return listRtnBlogs;
	}
}
