package com.sathya.eshopfornt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.EshopBackEnd.model.Supplier;

@Controller
public class Suppliercontroller {
	@Autowired
	com.sathya.EshopBackEnd.DaoImpl.SupplierDaoImpl SupplierDaoImpl;

	@RequestMapping("/Supplier")
	public ModelAndView goToSupplierform() {
		System.out.println("at supplier");
		ModelAndView mv = new ModelAndView("AddSupplier");

		mv.addObject("sup", new Supplier());
		mv.addObject("ButtonName", "AddSupplier");

		return mv;
	}

	@RequestMapping(value = "/addsup", method = RequestMethod.POST)
	public ModelAndView recieveSupplierFormData(@ModelAttribute("sup") Supplier supplier) {
		ModelAndView mv = new ModelAndView("AdminHome");
		System.out.println(supplier.getSupplierName());
		System.out.println(supplier.getSupplierDetails());
		if (supplier.getSupplierId() == 0) {
			SupplierDaoImpl.saveSupplier(supplier);
		} else {
			SupplierDaoImpl.editSupplier(supplier);
		}
		return mv;
	}

	@RequestMapping("/ShowSupplierDetails")
	public ModelAndView retrieveAllSupplierData() {
		List<Supplier> supplierlist = SupplierDaoImpl.getSupplierList();
		ModelAndView modelAndView = new ModelAndView("ShowSupplier");
		modelAndView.addObject("suplist", supplierlist);
		return modelAndView;
	}

	@RequestMapping("/sdel")

	public String deleteCategoryData(@RequestParam("supId") int supplierId) {
		Supplier supplier = SupplierDaoImpl.getSupplier(supplierId);
		SupplierDaoImpl.deleteSupplier(supplier);
		return "redirect:ShowSupplierDetails";

	}

	@RequestMapping("/sedit")
	public ModelAndView editCategoryData(@RequestParam("supId") int supplierId) {
		Supplier supplier = SupplierDaoImpl.getSupplier(supplierId);
		SupplierDaoImpl.getSupplier(supplierId);
		ModelAndView modelAndView = new ModelAndView("AddSupplier");
		modelAndView.addObject("sup", supplier);
		modelAndView.addObject("ButtonName", "UpdateSupplier");
		return modelAndView;
	}
}