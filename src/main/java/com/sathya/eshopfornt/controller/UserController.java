package com.sathya.eshopfornt.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.EshopBackEnd.DaoImpl.UserDaoImpl;
import com.sathya.EshopBackEnd.model.User;
@Controller
public class UserController
{
@Autowired
UserDaoImpl userDaoImpl;
@RequestMapping("/Registration")
public ModelAndView gotoresgesterform()
{
	ModelAndView  modelAndView=new ModelAndView("Register");
	
	modelAndView.addObject("reg",new User());
	return modelAndView;
}
@RequestMapping(value="/register",method=RequestMethod.POST)
public ModelAndView reciveuserformdata(@ModelAttribute("reg") User user)
{
	ModelAndView  modelAndView=new ModelAndView("userhome");
	userDaoImpl.addUser(user);
	return modelAndView; 
}
@RequestMapping("/LOGIN")
public ModelAndView responcetologin()
{

ModelAndView  modelAndView=new ModelAndView("Login");
modelAndView.addObject("reg",new User());
return modelAndView;

}
@RequestMapping(value="/loginsuc",method=RequestMethod.POST)
public ModelAndView reciveloginformdata(@ModelAttribute("reg") User user)
{

	boolean result=userDaoImpl.checkLogin(user);
	if(result==true)
	{
		ModelAndView  modelAndView=new ModelAndView("Loginsucess");	
		return modelAndView;
	}
	else
	{
		ModelAndView  modelAndView=new ModelAndView("Login");
		modelAndView.addObject("loginfo" ,"worngemail/password");
		return modelAndView;	
	}
	}
//Spring Security
@RequestMapping(value="/loginerror")
public ModelAndView afterloginfail()
{
	ModelAndView  modelAndView=new ModelAndView("Login");
	modelAndView.addObject("reg",new User());
	modelAndView.addObject("loginfo" ,"worngemail/password"); 
	return modelAndView;
}
@RequestMapping(value="/AfterLoginsucess")
public String AfterAfterLoginsucess(HttpSession httpSession)
{
	String pagename="";
SecurityContext securityContext = SecurityContextHolder.getContext();
 Authentication authentication  = securityContext.getAuthentication();
     String name    = authentication.getName();
     httpSession.setAttribute("un", name);
     System.out.println(name);
     Collection<GrantedAuthority> grantedAuthorities=(Collection<GrantedAuthority>) authentication.getAuthorities();
 for (GrantedAuthority grantedAuthority : grantedAuthorities) 
 {
    String authority= grantedAuthority.getAuthority();
    if(authority.equals("ROLE_USER"))
    {
    pagename="userhome";
    return pagename;
    }
    else if(authority.equals("ROLE_ADMIN"))
    {
    	pagename="AdminHome";
        return pagename;	
    }
    	 
}
 return pagename;
}
}
	