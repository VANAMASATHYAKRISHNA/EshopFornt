package com.sathya.eshopfornt.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.EshopBackEnd.DaoImpl.CartDaoImpl;
import com.sathya.EshopBackEnd.DaoImpl.ProductDaoImpl;
import com.sathya.EshopBackEnd.DaoImpl.UserDaoImpl;
import com.sathya.EshopBackEnd.model.Cart;
import com.sathya.EshopBackEnd.model.Product;
import com.sathya.EshopBackEnd.model.User;


@Controller
public class CartController
{
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	@Autowired
	CartDaoImpl cartDaoImpl;

//	@RequestMapping("/addtocart")
//	 public String Addtocart(@RequestParam("proId") int productId)
//	 {
//	Product product = productDaoImpl.getProduct(productId);
//		 
//	AddTOCart addTOCart=addToCartDaoImpl.getsavetocart(product);
//		return null;
//		 
//	 }
	@RequestMapping("/Cart")
	 public ModelAndView Addtocart(HttpServletRequest httpServletRequest,HttpSession session)
	 {
		ModelAndView  modelAndView=new ModelAndView("userhome");
		int productId = Integer.parseInt(httpServletRequest.getParameter("s"));
		int quantity = Integer.parseInt(httpServletRequest.getParameter("k"));
		Product product = productDaoImpl.getProduct(productId);
	String userName=(String)	session.getAttribute("un");
	System.out.println(userName);
	Cart cart =new Cart();
	if( cart.getCartid()==0)
	{
	boolean car=cartDaoImpl.saveCart(product, quantity,userName);
	}
	else
	{
		boolean car=cartDaoImpl.editCart(product, quantity,userName);
	}
		modelAndView.addObject("cartlist", cart);
		return modelAndView;
	 }
	@RequestMapping("/DisplayCart")
	public ModelAndView displayCart( HttpSession httpSession) 
	{
		String userName=(String)	httpSession.getAttribute("un");
		ModelAndView  modelAndView=new ModelAndView("Displaycart");
		 List<Cart> cartlist  =  cartDaoImpl.getCartList(userName);
		 modelAndView.addObject("cartlist", cartlist);
		 return modelAndView;
	}
	@RequestMapping("/cdel")
	public String deleteCartData(@RequestParam("cartId")int cartid)
	{
		Cart cart=cartDaoImpl.getCart(cartid);
		cartDaoImpl.deleteCart(cart);
		File file= new File("E:\\eclipse-workspace-fornt\\EshopFornt\\src\\main\\webapp\\resources\\product-images\\"+cart.getCartid()+".jpg"); 
		  file.delete(); 
		return "redirect:DisplayCart";
}
	@RequestMapping("/cedit")
	public ModelAndView editCartData(@RequestParam("cartId")int cartid)
	{
		ModelAndView  modelAndView=new ModelAndView("oneproduct");
		Cart cart=cartDaoImpl.getCart(cartid);
		modelAndView.addObject("prolist", cart);
		return modelAndView;
}
}
