package controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Comment;
import entity.Msg;
import service.CommentService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	// �ύ����
	@RequestMapping(value="/sendcomment", method=RequestMethod.POST)
	@ResponseBody
	public Msg sendcomment(@RequestParam(value="id", required=true)int id, 
			@RequestParam("name") String name, @RequestParam("comment") String comment) throws ParseException {
		System.out.println("name = " + name + " \ncomment = " + comment);
		commentService.sendcomment(id, name, comment);
		Msg msg = Msg.success();
		msg.setMsg("�ύ���۳ɹ���");
		return msg;
	}
	
	// �������
	@RequestMapping(value="/getComments", method=RequestMethod.GET)
	@ResponseBody
	public Msg getComments(@RequestParam("id")int id) {
		// ��ȡ�������е�����
		List<Comment> list = commentService.getComments(id);
		return Msg.success().add("commentsList", list);
	}
	
	// �����������
	@RequestMapping(value="/getallcomments", method=RequestMethod.GET)
	@ResponseBody
	public Msg getallcomments() {
		List<Comment> list = commentService.selectAll();
		return Msg.success().add("commentList", list);
	}
	
	// ���ۺ�̨����
	@RequestMapping("/commentback")
	public String commentback(HttpServletRequest request,HttpServletResponse response) {
		//�õ� session ��ֵ���ж��Ƿ��Ѿ���½
		if(request.getSession().getAttribute("username") != null) {
			String username = request.getSession().getAttribute("username").toString();
			if(username != null) {
				return "admin/commentadmin";
			}
		}
		return "admin/error";
	}
	
	// ɾ��һ������
	@RequestMapping(value="/deleteacomment",method=RequestMethod.GET)
	@ResponseBody
	public Msg deleteacomment(@RequestParam("id") int id) {
		commentService.deletea(id);
		Msg msg = Msg.success();
		msg.setMsg("����������ɾ����");
		return msg;
	}
	
	// �ύ����
	@RequestMapping(value="/sendheartword", method=RequestMethod.POST)
	@ResponseBody
	public Msg sendheartword(@RequestParam(value="id", required=true)int id, 
			@RequestParam("name") String name, @RequestParam("comment") String comment) throws ParseException {
		System.out.println("name = " + name + " \ncomment = " + comment);
		commentService.sendcomment(id, name, comment);
		Msg msg = Msg.success();
		msg.setMsg("���յ���������ˣ�");
		return msg;
	}

}
