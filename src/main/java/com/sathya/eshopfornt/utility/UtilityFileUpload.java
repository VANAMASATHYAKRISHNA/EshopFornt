package com.sathya.eshopfornt.utility;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.sathya.EshopBackEnd.DaoImpl.CategoryDaoImpl;
import com.sathya.EshopBackEnd.DaoImpl.ProductDaoImpl;
import com.sathya.EshopBackEnd.model.Product;

public class UtilityFileUpload
{
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	public void fileUpload(@ModelAttribute("pro") Product product)
	{
		MultipartFile imag =product.getProimg();
		System.out.println("testing image="+imag);
		BufferedOutputStream bufferedOutputStream=null;
		try {
			FileOutputStream fileOutputStream=new FileOutputStream("E:\\eclipse-workspace-fornt\\EshopFornt\\src\\main\\webapp\\resources\\product-images\\"+product.getProductId()+".jpg");
			 bufferedOutputStream= new BufferedOutputStream(fileOutputStream);
			 byte bytearray[]= imag .getBytes();
			 bufferedOutputStream.write(bytearray);

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	finally
		{
		
			try {
			bufferedOutputStream .close();
		} catch (IOException e) {
				e.printStackTrace();
			}	
	}
	}
	

}
