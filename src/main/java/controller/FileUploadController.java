package controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import model.UserModel;

/**
 * Handles requests  for the application file upload requests
 */  
@Controller
public class FileUploadController {

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping("/upload")
	public String upload(){
		System.out.println("ddddddddddddddd-----------");
		
		return "upload";
		
		
	}
	/*@RequestMapping(value="/item/addItem", method = RequestMethod.POST)
	 public String addItemPost(@Valid @ModelAttribute("item") UserModel user,BindingResult result,
             HttpServletRequest request,Model model) {
		/* MultipartFile itemImage = item.getItemImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+item.getItemId()+".png");


        if (itemImage != null && !itemImage.isEmpty()) {
            try {
            	itemImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("item image saving failed.", e);
            }
        }

        return "redirect:/admin/furnitureinventory";
		 * 
		 * 
	}*/
	@RequestMapping(value = "/uploadFile1", method = RequestMethod.POST)
	public String uploading(HttpServletRequest request) throws IOException, ServletException{
		
		Part p=request.getPart("name");
		BufferedReader r=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String des=r.readLine();
		p=request.getPart("file");
		p.write("datafile");
		return "redirect:/home";
	}
	
	/*@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(
            @RequestParam("file") MultipartFile file){
		System.out.println("ddddddddddddddd-----------");
        String name = file.getOriginalFilename();
       String path = "E:\\Test\\uploads";
        if (!file.isEmpty()) {
            try {
            	System.out.println("ddddddddddddddd");
            	File imgDirectory = new File(path);
            	if(!imgDirectory.exists())
            	{System.out.println("ddddddddddddddd");
            		imgDirectory.mkdir();
            	}
            	
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(path+"\\"+name)));
                stream.write(bytes);
                stream.close();
                System.out.println("ddddddddddddddd");
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

	/**
	 * Upload multiple file using Spring Controller
	 */
	/*
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadMultipleFileHandler(@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files) {

		if (files.length != names.length)
			return "Mandatory information missing";

		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				
				message = message + "You successfully uploaded file=" + name
						+ "";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		return message;
	}*/
	
}