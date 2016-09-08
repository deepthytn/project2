package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import daoservice.BlogDaoService;


import model.Blog;



@Controller
public class BlogController {
	
	
	@Autowired
	BlogDaoService blogdc;
	
	List<Blog> plist=null;
	
	@RequestMapping("/myblog")
	public String blog()
	{
		
		return "Blog";
	}
	
	@RequestMapping("/p")
	public @ResponseBody String getValues()
	{	
		plist=blogdc.getAllBlog();
		Gson gson=new Gson();
		String result= gson.toJson(plist);
		return result;
		//return "login";
		 
		}
	
	@RequestMapping(value={"/addNewBlog"},method=RequestMethod.POST)
	public ModelAndView adding(@ModelAttribute("newb") Blog p)
	{
		
		blogdc.addBlog(p);//calls service method
		

	return new ModelAndView("redirect:myblog");
	}
	@RequestMapping("/newblogreg")
	public String reg(@ModelAttribute("newb") Blog p){
		
		return "newblog";
	}
}
