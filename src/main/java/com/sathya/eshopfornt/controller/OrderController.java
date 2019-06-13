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
import com.sathya.EshopBackEnd.DaoImpl.ProductDaoImpl;
import com.sathya.EshopBackEnd.DaoImpl.UserDaoImpl;
import com.sathya.EshopBackEnd.model.Cart;
import com.sathya.EshopBackEnd.model.Product;
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
	@Autowired
	ProductDaoImpl productDaoImpl;
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
    String email = (String)httpSession.getAttribute("un");
    User user= userDaoImpl.getUser(email);
    user.setShippingAddress(shippingAddress);
   List<Cart> cartlist=cartDaoImpl.getCartList(email);
    int grandTotal = 0;
  	for(Cart c:cartlist)
  	{
  	grandTotal=c.getTotalprice()+grandTotal;
  	int productid=	c.getProductId();
  	 Product product=     productDaoImpl.getProduct(productid);
  	int stock=product.getStock()-c.getQuantity();
  	product.setStock(stock);
  	productDaoImpl.editProduct(product);
  	cartDaoImpl.deleteCart(c);
  	}
  	UserOrder userOrder =new UserOrder();
  	userOrder.setShippingAddress(shippingAddress);
  	userOrder.setUser(user);
	userOrder.setGrandTotal(grandTotal);
	userOrder.setPurchaseDate(new Date());
	orderDaoImpl.saveOrder(userOrder);
	modelAndView.addObject("order", userOrder);
	return modelAndView;
	}
@RequestMapping(value="/myorder")
public ModelAndView myOrders(HttpSession session)
{
    String user=(String)session.getAttribute("un");
    List<UserOrder>  u=orderDaoImpl.getMyOrders(user);
    ModelAndView modelAndView=new ModelAndView("MyOrders");
    modelAndView.addObject("my", u);
    return modelAndView;

   }
}