package com.product.spring;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Productratingcontroller {

	@Autowired
	ProductratingserviceImpl productratingserviceImpl;
	
	@RequestMapping({"/","showHome"})
	public String showhomeview() {
		
		return "Home";
	}
	
	@RequestMapping("/addproductview")
	public String openProductview(Model model) {
		
		Userbean bean=new Userbean();
		model.addAttribute("pb",bean);
		
		List<String> productname = Arrays.asList("Lab Test Order","Mindfulness","CarePlan","Well Being","Covid 19","Dolo");
		model.addAttribute("productname",productname);
		return "Addproduct";
	}
	
	@RequestMapping("/commitproduct")
	public String addProduct(@Valid @ModelAttribute("pb")Userbean bean,BindingResult result,Model model) {
		
		if(result.hasErrors())
		{
			return "Addproduct";
		}
		else
		{
			String msg=productratingserviceImpl.addProduct(bean);
			if(msg.equals(Constants.SUCCESS))
			return "Success";
			
			else
			{
				return "Error";
			}
			
			
		}
	}
	
	@RequestMapping("/Displayproductdetails")
	public String fethallProductsDetails(Model model) {
		
		List<Userbean> list=productratingserviceImpl.getAllProducts();
		if(list!=null) {
			
			model.addAttribute("productdata",list);
		}
		return "Displayproductdetails";
	}
	
	@RequestMapping("/Update")
	public String updateProductRating(Userbean bean) {
		
		String msg=productratingserviceImpl.updateRating(bean);
		if(msg.equals(Constants.UPDSUCCESS))
		{
			return "Update"; 
		}
		else
		{
			return "Errorupdate";
		}
		
	}
	
	@RequestMapping("/Avg")
	public String totalRating(Model model) {
		
		String msg=productratingserviceImpl.avgRating();
		if(msg!=null)
		{
			model.addAttribute("avgdaata",msg);
			return "Avg";
		}
		else
		{
			return "Error";
		}
	}
     
	@RequestMapping("/Count")
	public String countRating(Model model) {
		
		List<String> list=productratingserviceImpl.getcountofRatings();
		if(list!=null) {
			
			model.addAttribute("data",list);
		}
		return "Count";
	}
	
}
