package controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.DaoI;
import daoservice.ForumDaoIService;
import daoservice.ForumMServiceDao;
import daoservice.ForumReplyISerivce;
import model.ForumModel;
import model.ForumReply;
import model.UserModel;

@Controller
public class ForumReplyController {
	
	@Autowired
	ForumReplyISerivce frserivce;
	@Autowired
	ForumMServiceDao forumservice;
	
DaoI usermodel;
	
	@RequestMapping("addreply")
	public String addReply(@RequestParam("forumid")int fid,@ModelAttribute("replypage")ForumReply fr,Principal user)
	{
		
		
		fr.setForumid(fid);
		
		String username=user.getName();
		fr.setUsername(username);
		System.out.println("ddddddd&&&&&&&&7"+fr.getMyreply());
		int i=frserivce.addNewReply(fr);
		System.out.println("ddddddd&&&&&&&&"+i);
		return "redirect:/forum1";
	}
	
	@RequestMapping("viewreply")
	public ModelAndView viewreply(@RequestParam("forumid")int fid)
	{System.out.println("repliessss");
		
		List<ForumModel> list= forumservice.getAllForum();
		List<ForumReply> frlist=frserivce.getAllForumReply();
		ModelAndView mv=new ModelAndView("NewForum1");
		mv.addObject("replylist", frlist);
		mv.addObject("viewreplyclick", true);
		mv.addObject("forumid", fid);
		mv.addObject("forum", list);
		return mv;
		
		
	}

}
