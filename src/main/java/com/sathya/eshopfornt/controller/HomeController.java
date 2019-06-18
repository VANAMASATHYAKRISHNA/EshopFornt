package com.sathya.eshopfornt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sathya.EshopBackEnd.DaoImpl.CategoryDaoImpl;

@Controller
public class HomeController {

	@Autowired
	private CategoryDaoImpl categoryDaoImpl;

	@RequestMapping("/Adminhomecontoller")
	public String goHome() {
		return "AdminHome";
	}

	@RequestMapping("/Aboutus")
	public String goAboutUs() {
		return "AboutUs";
	}

	@RequestMapping("/Contactus")
	public String goContactUs() {
		return "ContactUs";
	}

	@RequestMapping("/userheadder")
	public String goUserHeadder(HttpSession httpSession) {
		httpSession.setAttribute("catList", categoryDaoImpl.getCategoryList());
		return "userheadder";
	}

	@RequestMapping("/userhome")
	public String goUserHome(HttpSession httpSession) {
		httpSession.setAttribute("catList", categoryDaoImpl.getCategoryList());
		return "userhome";
	}

	@RequestMapping("/userAboutus")
	public String gouserAboutUs() {
		return "AboutUs";
	}

	@RequestMapping("/userContactus")
	public String gouserContactUs() {
		return "ContactUs";
	}
}
