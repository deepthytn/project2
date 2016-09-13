package controller;

import java.security.Principal;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.UserModel;

import util.FileUtil;

@Controller
public class UserController {
	
	
	private String path = "E:\\Test\\";
	@RequestMapping("/myprofile")
	public ModelAndView myprofile(@ModelAttribute UserModel user)
	
	{
	
		ModelAndView mc=new ModelAndView("myprofile");
		mc.addObject("person",user);
		
		return mc  ;
	}
	
	@RequestMapping("/myimage")
	public ModelAndView myprof(@ModelAttribute("product") UserModel user)
	
	{
	
		ModelAndView mc=new ModelAndView("upload");
		
		
		return mc  ;
	}
	
	@RequestMapping(value = "/addimage", method = RequestMethod.POST)
	public @ResponseBody String addProduct(@RequestParam("file") MultipartFile file) {
		
System.out.println("ddddddddddddddddddddddddd");
String name = file.getOriginalFilename();
String path = "D:\\Test\\uploads";
		
		//MultipartFile file = product.getImage();
		
		
		FileUtil.upload(path, file,"id.jpg");
		
		return "redirect:/myprofile";
	}
	 @RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied() {

			ModelAndView model = new ModelAndView();
			
			//check if user is login
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken)) {
				UserModel userDetail = (UserModel) auth.getPrincipal();
				System.out.println(userDetail);
			
				model.addObject("username", userDetail.getUsername());
				
			}
			
			model.setViewName("403");
			return model;

		}
	 
	

}
