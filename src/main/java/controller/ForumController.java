package controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import daoservice.ForumMServiceDao;

import model.ForumModel;
import model.ForumReply;

@Controller
public class ForumController {
	
	@Autowired
	ForumMServiceDao forumservice;
	
	
	
	
	@RequestMapping("/forum")
	public ModelAndView myforum()
	{
		ModelAndView mv=new ModelAndView("forum");
		
		return mv;
		
	}
	
	@RequestMapping("/addforum")
	public ModelAndView addforumpage()
	{
		
		
		ModelAndView addf=new ModelAndView("NewForum1");
		return addf;
	}
	@RequestMapping("/addnewforum")
	public ModelAndView addnewforumpage(@ModelAttribute("addnewforum") ForumModel f)
	{
		
		
		ModelAndView addf=new ModelAndView("AddForum");
		return addf;
	}
	@RequestMapping(value="/addNewforum",method=RequestMethod.POST)
	public String addForum(@ModelAttribute("addnewforum") ForumModel f,Principal p)
	{
		
			String username=p.getName();
			f.setUsername(username);
			int res=forumservice.addNewForum(f);
			if(res==1)
			{
				return "redirect:/forum";
			}
			else
			{
				return "redirect:/forum";
			}
		
	}
	@RequestMapping("forum1")
	public ModelAndView getAllForum(@ModelAttribute("commentspage") ForumReply f)
	{
		List<ForumModel> list= forumservice.getAllForum();
		for(ForumModel d :list)
		{
			System.out.println("dddddddddddddddddd"+d.getSubject());
			
		}
		ModelAndView mv=new ModelAndView("NewForum1");
		mv.addObject("forum", list);
		
		return mv;
	}
	
	@RequestMapping("replyforum")
	public ModelAndView replyforum()
	{
	System.out.println("+++++++++");
		
		ModelAndView addf=new ModelAndView("redirect:/forum1");
		addf.addObject("replyclick", false);
		return addf;
	}

}
