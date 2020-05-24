package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.business.bean.CakeOrderBean;
import com.business.bean.OrderBean;
import com.service.CakeService;

@Controller
public class DeleteCakeOrderController {

	@Autowired
	private CakeService cakeService;
	

	@RequestMapping(value="delete.html",method=RequestMethod.GET)
	public ModelAndView showDeletePage(){
		ModelAndView view=new ModelAndView();
		view.setViewName("Search1");
		view.addObject("cakeOrderId", new OrderBean());
		return view;
	}
	
	@RequestMapping(value="searchOrderToDelete.html",method=RequestMethod.POST)
	public ModelAndView searchOrderByIdToDelete(@ModelAttribute("cakeOrderId") OrderBean cakeOrderId){
		ModelAndView view=new ModelAndView();
		CakeOrderBean bean=cakeService.searchOrderById(cakeOrderId);
		view.setViewName("DeleteOrder");
		view.addObject("cakeOrderBeanDelete",bean);
		return view;
	}
	
	@RequestMapping(value="deleteOrderById.html",method=RequestMethod.POST)
	public ModelAndView deleteOrder(@ModelAttribute("cakeOrderBeanDelete") CakeOrderBean cakeOrderBeanDelete){
		ModelAndView view =new ModelAndView();
		System.out.println("Controller");
		System.out.println(cakeOrderBeanDelete.getOrderId());
		String retMsg=cakeService.deleteOrder(cakeOrderBeanDelete);
		view.setViewName("DeleteSuccess");
		view.addObject("message",retMsg);	
		
		return view;
		
	}
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){	
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
}
