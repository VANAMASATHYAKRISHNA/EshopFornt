package com.sathya.eshopfornt.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.EshopBackEnd.DaoImpl.CartDaoImpl;
import com.sathya.EshopBackEnd.DaoImpl.OrderDaoImpl;
import com.sathya.EshopBackEnd.DaoImpl.UserDaoImpl;
import com.sathya.EshopBackEnd.model.Cart;
import com.sathya.EshopBackEnd.model.ShippingAddress;
import com.sathya.EshopBackEnd.model.User;
import com.sathya.EshopBackEnd.model.UserOrder;
@Controller
public class OrderController 
{
	@Autowired
	UserDaoImpl userDaoImpl;
	@Autowired
	CartDaoImpl cartDaoImpl;
	@Autowired
	OrderDaoImpl orderDaoImpl;
@RequestMapping("/placeorder")
public ModelAndView goToShippingAddressForm(HttpSession httpSession)
{
	ModelAndView modelAndView= new ModelAndView("ShippingAddress");
	  String username = (String)httpSession.getAttribute("un");
	  User user= userDaoImpl.getUser(username);
   ShippingAddress shippingAddress=	user.getShippingAddress();
   modelAndView.addObject("ship", shippingAddress);
	//int id=(int)(Math.random()*10000);
	//shippingAddress.setId(id);
	return modelAndView;
}
@RequestMapping(value="addship",method=RequestMethod.POST)
public ModelAndView recieveShippingAddressFormData(@ModelAttribute("ship") ShippingAddress shippingAddress, HttpSession httpSession)
{
	ModelAndView modelAndView= new ModelAndView("orderdetails");
    System.out.println(shippingAddress.getHouseNumber());
    String email = (String)httpSession.getAttribute("un");
    User user= userDaoImpl.getUser(email);
    System.out.println(email);
     List<Cart> cartlist=cartDaoImpl.getCartList(email);
    System.out.println("--------------"+cartlist);
  	int grandTotal = 0;
  	for(Cart c:cartlist)
  	{
  	grandTotal=c.getTotalprice()+grandTotal;
  	}
  	UserOrder userOrder =new UserOrder();
  	System.out.println(grandTotal);
  	userOrder.setUser(user);
	userOrder.setGrandTotal(grandTotal);
	userOrder.setPurchaseDate(new Date());
	modelAndView.addObject("order", userOrder);
	//cartDaoImpl.deleteCart(cartlist);
	orderDaoImpl.saveOrder(userOrder);
	return modelAndView;
	}

   }
