package com.sathya.eshopfornt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.EshopBackEnd.DaoImpl.CategoryDaoImpl;
import com.sathya.EshopBackEnd.model.Category;

@Controller
public class CategoryContoller
{ 
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
@RequestMapping(value = "/addCategory" ,method=RequestMethod.GET )
public ModelAndView goToCategoryForm()
{
ModelAndView modelAndView= new ModelAndView("AddCategory");
	modelAndView.addObject("cat",new Category() );
	return modelAndView;
}
@RequestMapping(value="addcat",method=RequestMethod.POST)
public ModelAndView recieveCategoryFormData(@ModelAttribute ("cat") Category category)
{
ModelAndView  mv=new ModelAndView("AdminHome");
if(category.getCategoryId()==0)
{
    categoryDaoImpl.saveCategory(category);
}
else
{
	categoryDaoImpl.editCategory(category);
}
return mv;
}
@RequestMapping("ShowCat")
public ModelAndView retrieveAllCategoryData()
{
List<Category> categoriesList=categoryDaoImpl.getCategoryList();
    ModelAndView  modelAndView=new ModelAndView("Showcategory");
    modelAndView.addObject("catlist", categoriesList);
    return modelAndView  ;
}

@RequestMapping("/del")
public String deleteCategoryData(@RequestParam("catId") int categoryId)
{
Category category= categoryDaoImpl.getCategory(categoryId);
categoryDaoImpl.deleteCategory(category);
 return "redirect:ShowCat";
}
@RequestMapping("/edit")
public ModelAndView editCategoryData(@RequestParam("catId") int categoryId)
{
Category category= categoryDaoImpl.getCategory(categoryId);

ModelAndView  modelAndView=new ModelAndView("AddCategory");
 modelAndView.addObject("cat", category);
 modelAndView.addObject("ButtonName","UpdateCategory");
    return modelAndView  ;
}
}
