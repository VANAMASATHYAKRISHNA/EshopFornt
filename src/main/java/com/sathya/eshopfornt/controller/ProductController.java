package com.sathya.eshopfornt.controller;

import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.EshopBackEnd.DaoImpl.CategoryDaoImpl;
import com.sathya.EshopBackEnd.DaoImpl.ProductDaoImpl;
import com.sathya.EshopBackEnd.DaoImpl.SupplierDaoImpl;
import com.sathya.EshopBackEnd.model.Category;
import com.sathya.EshopBackEnd.model.Product;
import com.sathya.EshopBackEnd.model.Supplier;
import com.sathya.eshopfornt.utility.UtilityFileUpload;


@Controller
public class ProductController 
{
	@Autowired
	ProductDaoImpl productDaoImpl;
	@Autowired
	 CategoryDaoImpl categoryDaoImpl;
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	@RequestMapping("AddProduct")
	public ModelAndView gotoproductform()
	{
       List<Category> categorylist=categoryDaoImpl.getCategoryList();
       List<Supplier> supplierlist=	supplierDaoImpl.getSupplierList();
		ModelAndView modelAndView = new ModelAndView("AddProduct");
		
		modelAndView.addObject("ButtonName","AddProduct");
		modelAndView.addObject("catlist" ,categorylist);
		modelAndView.addObject("suplist", supplierlist);
		Product product=new Product();
		//int id=(int)(Math.random()*10000);
		//product.setProductId(id);
		modelAndView.addObject("pro", product);
		return modelAndView;
	}
	@RequestMapping(value="/addpro",method=RequestMethod.POST)
	public String recieveProductFormData(@ModelAttribute("pro") Product product)
    {
		categoryDaoImpl.getCategoryList();
		if(product.getProductId()==0)
		{
			int id=(int)(Math.random()*10000);
			product.setProductId(id);
		productDaoImpl.saveProduct(product);
		}
		else
		{
			productDaoImpl.editProduct(product);	
		}
	UtilityFileUpload utilityFileUpload=new UtilityFileUpload();
	utilityFileUpload.fileUpload(product);
		return "AdminHome";
		}
	//retrive productdata
	@RequestMapping("/ShowProduct")
	public ModelAndView reciveAllproductData()
	{
	List<Product> productlist=productDaoImpl.getProductList();
	ModelAndView  modelAndView=new ModelAndView("ShowProduct");
		modelAndView.addObject("prolist",productlist);
		return modelAndView;
	}
	//product deleteing
	 @RequestMapping("/pdel")
	    public String deleteCategoryData(@RequestParam("proId") int productId)
	    {
	  Product product = productDaoImpl.getProduct(productId);
	  productDaoImpl.deleteProduct(product);
	File file= new File("E:\\eclipse-workspace-fornt\\EshopFornt\\src\\main\\webapp\\resources\\product-images\\"+product.getProductId()+".jpg"); 
	  file.delete(); 
	    return "redirect:ShowProduct";
	    }
	 //product editing
	 @RequestMapping("/pedit")
	 public ModelAndView editProductData(@RequestParam("proId") int productId)
	 {
		 //getting product object
		 Product product = productDaoImpl.getProduct(productId);
		 //getting categorylist 
		 List<Category> categorylist=categoryDaoImpl.getCategoryList();
		 //getting supplierlist 
		 List<Supplier> supplierlist=	supplierDaoImpl.getSupplierList();
		 ModelAndView  modelAndView=new ModelAndView("AddProduct");
		 modelAndView.addObject("pro", product);
		 modelAndView.addObject("ButtonName","UpdateProduct");
		modelAndView.addObject("catlist" ,categorylist);
		modelAndView.addObject("suplist", supplierlist);
		 return modelAndView ;
	 }
	                             
	 
}
