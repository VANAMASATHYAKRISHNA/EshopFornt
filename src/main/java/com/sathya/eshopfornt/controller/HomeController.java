package com.sathya.eshopfornt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
@RequestMapping("/Adminhomecontoller")
public String goHome()
{
	return "AdminHome";
}
@RequestMapping("/Aboutus")
public String goAboutUs()
{
	return "AboutUs";
}
@RequestMapping("/Contactus")
public String goContactUs()
{
	return "ContactUs";
}
@RequestMapping("/userhome")
public String goUserHome()
{
	return "userhome";
}
@RequestMapping("/userAboutus")
public String gouserAboutUs()
{
	return "AboutUs";
}
@RequestMapping("/userContactus")
public String gouserContactUs()
{
	return "ContactUs";
}
}
