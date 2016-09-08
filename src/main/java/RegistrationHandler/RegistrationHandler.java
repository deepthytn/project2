package RegistrationHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import model.UserModel;

@Component
public class RegistrationHandler {

	public UserModel getInstance(){
		return new UserModel();
	}
	
	public String validateDetails(UserModel user,MessageContext messageContext) {
		String status="success";
		
		
		if(user.getId()!=0) {
			
			
			 messageContext.addMessage(new MessageBuilder().error().source("id").defaultText("UserId cannot be empty").build());
			 status="failure";
		}
		if(user.getName().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("name").defaultText("Name cannot be empty").build());
			status="failure";
		}
		if(user.getPassword().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("password").defaultText("Password cannot be empty").build());
			status="failure";
		}
		
	
		if(user.getEmail().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("mailid").defaultText("MailId cannot be empty").build());
			status="failure";
		}
		if(user.getAddress().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("address").defaultText("Address cannot be empty").build());
			status="failure";
		}
		
		return status;
	}
	
	public void add(RequestContext context, UserModel user){
	    HttpSession session = ((HttpServletRequest)context.getExternalContext().getNativeRequest()).getSession();
	              session.setAttribute("user",user);
}
}
