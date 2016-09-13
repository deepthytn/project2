package controller;

import com.niit.shoppingcart.App;
import java.nio.file.Path;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import daoservice.DaoIServ;

import model.UserModel;;
@Controller
public class HomeController {
	
	@Autowired
	DaoIServ dc;
	
	List<UserModel> plist=null;
	Path path;
	String message = "Welcome ! ";
	String setName = ""; 
	
	App a=new App();
	
	
	@RequestMapping("/")
	public String myhome(){
		
		return "myhome";
	}
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload()
	{
		return "hello";
		
	}
	
	@RequestMapping("/register")
	public String reg(@ModelAttribute("p") UserModel p){
		
		return "register";
	}
	@RequestMapping(value={"/addUser"},method=RequestMethod.POST)
	public ModelAndView adding(@ModelAttribute("p") UserModel p)
	{
		
		
		dc.addproduct(p);//calls service method
		

	return new ModelAndView("myhome");
	}
	/*-------------------admin---------------*/
	 @RequestMapping(value = "/admin**", method = RequestMethod.GET)
		public ModelAndView adminPage() {

			ModelAndView model = new ModelAndView();
			model.addObject("title", "Spring Security Hello World");
			model.addObject("message", "This is protected page!");
			model.setViewName("admin");

			return model;

		}
	 @RequestMapping(value = { "/welcome**" }, method = RequestMethod.GET)
		public ModelAndView defaultPage() {

			ModelAndView model = new ModelAndView();
			model.addObject("title", "Spring Security Login Form - Database Authentication");
			model.addObject("message", "This is default page!");
			model.setViewName("hello");
			return model;

		}
	 
	/*-----------login---------------------*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	@RequestMapping("/myprofile1")
	public ModelAndView profilepage(Principal p)
	{
		ModelAndView mv=new ModelAndView("myprofile");
		String name = p.getName();
		System.out.println(name);
		UserModel mypro=null;
		List<UserModel> nm=dc.getAll();
		for ( UserModel us : nm) {
			if(us.getUsername().equals(name))
			{
				mypro=us;
				
			}
		}
		
		mv.addObject("usermodel", mypro);
		
		return mv;
}

}
