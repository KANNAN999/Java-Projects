package com.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.business.bean.CakeOrderBean;
import com.service.CakeService;

@Controller
public class CakeController {

	
	@Autowired
	private CakeService cakeService;
	
	
	@RequestMapping(value="order.html",method=RequestMethod.GET)
	public ModelAndView showOrderPage(){
		ModelAndView view=new ModelAndView();
		view.setViewName("OrderCake");
		view.addObject("cakeBean",new CakeOrderBean());
		return view;
	}
	
	
	@RequestMapping(value="placeOrder.html",method=RequestMethod.POST)
	public ModelAndView orderCake(@Valid @ModelAttribute("cakeBean") CakeOrderBean cakeBean,BindingResult result){
		ModelAndView view=new ModelAndView();
		if(result.hasErrors()){
			view.setViewName("OrderCake");
		}
		else
		{
		CakeOrderBean bean=cakeService.orderCake(cakeBean);
		view.setViewName("OrderSuccess");
		view.addObject("message","Thank You "+bean.getCustomerName()+" !!!! Your Order has been placed successfully"
				+ "With Order Id : "+bean.getOrderId()+" And amount to be paid is Rs "
						+bean.getBill()+"/-");
		}
		return view;
		
		
	}
	
	
	
	@ModelAttribute("cakeList")
	public Map<Integer,String> populateCakeList(){
		
		Map<Integer,String> retMap=cakeService.populateCakeList();
		return retMap;
	}
	
	//Error Handler:
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){	
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
	
}
