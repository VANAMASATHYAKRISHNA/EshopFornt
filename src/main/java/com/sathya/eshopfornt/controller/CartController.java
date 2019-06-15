package com.sathya.eshopfornt.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.EshopBackEnd.DaoImpl.CartDaoImpl;
import com.sathya.EshopBackEnd.DaoImpl.ProductDaoImpl;
import com.sathya.EshopBackEnd.model.Cart;
import com.sathya.EshopBackEnd.model.Product;


@Controller
public class CartController
{
	@Autowired
	ProductDaoImpl productDaoImpl;
	@Autowired
	CartDaoImpl cartDaoImpl;
	@RequestMapping("/user")
	 public ModelAndView userProductData()
		{
		List<Product> productlist=productDaoImpl.getProductList();
			ModelAndView  modelAndView=new ModelAndView("userproducts");
			modelAndView.addObject("prolist",productlist);
			return modelAndView;
		}
	 @RequestMapping("viewdetails")
	 public ModelAndView productDetails(@RequestParam("proId") int productId)
		{
		
		Product product = productDaoImpl.getProduct(productId);
		ModelAndView  modelAndView=new ModelAndView("oneproduct");
       modelAndView.addObject("car", new Cart());
		modelAndView.addObject("prolist",product);
	    return modelAndView;
}
	@PostMapping("/Cart")
	 public ModelAndView Addtocart(@ModelAttribute("car") Cart cart,HttpSession session,HttpServletRequest httpServletRequest)
	 {
		  String userName=(String)	session.getAttribute("un");
	      cart.setUsername(userName);
	      int quantity=cart.getQuantity();
		 cart.setQuantity(quantity);
	cart.setTotalprice(cart.getProductPrice()*cart.getQuantity());
	      ModelAndView  modelAndView=new ModelAndView("userhome");
		 if(cart.getCartid()==0)
		  {
			  cartDaoImpl.saveCart(cart);  
		  }
		 else
		 {
			 cartDaoImpl.editCart(cart);
		 }
	      return modelAndView;
	 }
    @RequestMapping("/DisplayCart")
	public ModelAndView displayCart( HttpSession httpSession ) 
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
		modelAndView.addObject("car", cart);
		return modelAndView;
}
	
}