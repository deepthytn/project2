package controller;

import com.niit.shoppingcart.App;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import daoservice.DaoIServ;
import model.Message;
import model.OutputMessage;
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
	/*@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload()
	{
		return "hello";
		
	}*/
	
	@RequestMapping("/register")
	public String reg(@ModelAttribute("p") UserModel p){
		
		return "register";
	}
	@RequestMapping(value={"/addUser"},method=RequestMethod.POST)
	public ModelAndView adding(@ModelAttribute("p") UserModel p)
	{
		ModelAndView mv=new ModelAndView("myhome");
		System.out.println("nullllllllllllllllllllllllllll324");
		if(!p.getUsername().isEmpty() && !p.getPassword().isEmpty())
		{
			System.out.println("nullllllllllllllllllllllllllll");
		dc.addproduct(p);
		}
		else
		{
			mv.addObject("errormsg", true);
			mv.addObject("message", "some required fields left blank");
			
			System.out.println("nullllllllllllllllllllllllllll");
		}//calls service method
		

	return  mv;
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
	public ModelAndView profilepage(Principal p,HttpServletRequest request)
	{
		 String path = request.getSession().getServletContext().getRealPath("/resources/images/"+p.getName()+".jpg");
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
		mv.addObject("path", path);
		mv.addObject("usermodel", mypro);
		
		return mv;
}
	
	@RequestMapping("/Chat")
	  public String viewApplication() 
	{
			System.out.println("i am in controller");
	    return "MyChat";
	  }
	    
	@MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message) {
		System.out.println("asdsad"+message.getMessage());
	    return new OutputMessage(message, new Date());
	  }
	 
	 /* @MessageMapping("/hello")
	    @SendTo("/topic/greetings")
	    public OutputMessage greeting(Message message) throws Exception {
	        Thread.sleep(3000); // simulated delay
	        System.out.println(message.getId());
	        return new OutputMessage("Hello, " + message.getMessage() + "!");
	    }*/
	  
	  @RequestMapping("/registerwithupload")
		public ModelAndView RegPage(@ModelAttribute("user") UserModel user)
		{
		  ModelAndView mv = new ModelAndView("registerwithupload");
			return mv;
		}
	  
	  @RequestMapping(method = RequestMethod.POST,value="registerwithupload1")
	  public String createUser(@ModelAttribute("user") UserModel user , Model model,HttpServletRequest request, MultipartFile file) throws IOException
		{
			
			String filename = null;
		    byte[] bytes;
		    
		    		user.setUserrole("ROLE_USER");
		    
		    		dc.addproduct(user);
		    		System.out.println("Data Inserted");
		            //String path = request.getSession().getServletContext().getRealPath("/resources/images/" + user.getUserid() + ".jpg");
		    		MultipartFile image = user.getImage();
		            //Path path;
		    
		            String path = request.getSession().getServletContext().getRealPath("/resources/images/"+user.getUsername()+".jpg");
		            System.out.println("Path="+path);
		            System.out.println("File name = " + user.getImage().getOriginalFilename());
		          
		            if(image!=null && !image.isEmpty())
		            {
		            	try
		            	{
		            		image.transferTo(new File(path.toString()));
		            		System.out.println("Image saved  in:"+path.toString());
		            	}
		            	catch(Exception e)
		            	{
		            		e.printStackTrace();
		            		System.out.println("Image not saved");
		            	}
		            }
		    	
		     	    
		    return "myhome";
		
			
		}
	  
}
