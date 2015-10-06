package com.mojoping.session;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/* USER INFORMATION FOR CURRENT SESSION */
public class CurrentUser {
	
	/*Returns anonymousUser if no user is logged on */
	public String getCurrentUserName(){
		String username = null;
	    
	    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    
	    if (principal instanceof UserDetails) {
	     username = ((UserDetails)principal).getUsername();
	    } else {
	     username = principal.toString();
	    }
	    
	    return username;
	}
	

}
