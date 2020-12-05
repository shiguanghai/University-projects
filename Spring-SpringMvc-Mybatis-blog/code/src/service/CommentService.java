package service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mapping.CommentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Comment;
import entity.CommentExample;

@Service
public class CommentService {
	@Autowired
	private CommentMapper commentMapper;

	// ��������
	public void sendcomment(int id, String name, String comment) throws ParseException {
		if(name.equals("")) {
			name = new String("����");
		} 
		if(comment.equals("")) {
			comment = new String("ɶ��û���£�");
		}
		// ����ʱ��
		Date now = new Date();
	    
	    Comment comment2 = new Comment();
	    comment2.setBlogId(id);
	    comment2.setUsername(name);
	    comment2.setContent(comment);
	    comment2.setCreatedtime(now);
	    commentMapper.insertSelective(comment2);
	}

	public List<Comment> getComments(int id) {
		CommentExample example = new CommentExample();
		example.createCriteria().andBlogIdEqualTo(id);
		List<Comment> list = commentMapper.selectByExample(example);
		if(list == null) {
			list = new ArrayList<Comment>();
		}
		return list;
	}

	public List<Comment> selectAll() {
		CommentExample example = new CommentExample();
		example.createCriteria().andIdIsNotNull();
		return commentMapper.selectByExample(example);
	}

	public void deletea(int id) {
		commentMapper.deleteByPrimaryKey(id);
	}
}
