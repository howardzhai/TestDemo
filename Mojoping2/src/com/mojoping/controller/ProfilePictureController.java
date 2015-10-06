package com.mojoping.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.mojoping.model.FileUpload;
import com.mojoping.model.User;
import com.mojoping.service.UserService;
import com.mojoping.session.CurrentUser;

@Controller
public class ProfilePictureController {
	
	@Autowired
	UserService user_service;
	
	@RequestMapping(value="/edit_picture", method = RequestMethod.POST)
	public String editPicture(@ModelAttribute("fileUpload") FileUpload fileUpload, BindingResult result, Model model, HttpServletRequest request) throws IOException{		
		MultipartFile file = fileUpload.getFile();  	
		
		if(!file.getContentType().contains("image")){
			//If the uploaded file is not image
			result.rejectValue("file", "error.fileUpload", "Please select an image!");
			
			//Send user info back to page
			model.addAttribute("fileUpload", fileUpload);
			
			return "profile";
		}else {
			String username = new CurrentUser().getCurrentUserName();		
			
			User user = user_service.getUser(username);
			
			this.savePictureToDirectory(file, user, request);
			
			user.setProfile_pic_path(file.getOriginalFilename());
			
			user_service.updateUser(user);

			String user_profile_pic_path = user.getProfile_pic_path();
			if(user_profile_pic_path == null ){
				String profile_pic_path = "/Mojoping2/resources/images/mojoping_logo.png";
				model.addAttribute("profilePicture", profile_pic_path);
			}else{
				String profile_pic_path = "/Mojoping2/resources/images/" + username + "/" + user_profile_pic_path;
				model.addAttribute("profilePicture", profile_pic_path);
			}			
			
			model.addAttribute("user", user);
			return "profile";
		}		
		
	}	
	
	public void savePictureToDirectory(MultipartFile file, User user, HttpServletRequest request) throws IOException{
		String fileName = file.getOriginalFilename();
		String basePath = request.getSession().getServletContext().getRealPath("");
		
		String file_directory = basePath + "\\WEB-INF\\classes\\META-INF\\web-resources\\images\\";
		
		InputStream inputStream = null;  
		OutputStream outputStream = null; 
		
		try {  
			   inputStream = file.getInputStream();  
			  
			   File newFile = new File(file_directory + user.getUsername());  
			   if (!newFile.exists()) {  
			    newFile.mkdirs();  
			   }  
			   
			   newFile= new File(file_directory + user.getUsername()+ "\\" + fileName);
			   if (!newFile.exists()) {  
				    newFile.createNewFile(); 
			   }
			   outputStream = new FileOutputStream(newFile);  
			   
			   int read = 0;  
			   byte[] bytes = new byte[1024];  
			  
			   while ((read = inputStream.read(bytes)) != -1) {  
			    outputStream.write(bytes, 0, read);  
			   }  
			  } catch (IOException e) {  
			   e.printStackTrace();  
			  }  finally{
				  inputStream.close();
				  outputStream.close();
			  }
	}
	
}
