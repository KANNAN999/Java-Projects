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
import com.business.bean.OrderBean;
import com.service.CakeService;

@Controller
public class UpdateCakeOrderController {

	@Autowired
	private CakeService cakeService;
	
	
	@RequestMapping(value="update.html",method=RequestMethod.GET)
	public ModelAndView showUpdatePage(){
		ModelAndView view=new ModelAndView();
		view.setViewName("Search");
		view.addObject("cakeOrderId", new OrderBean());
		return view;
	}
	
	
	@RequestMapping(value="searchOrderById.html",method=RequestMethod.POST)
	public ModelAndView searchOrderById(@Valid @ModelAttribute("cakeOrderId") OrderBean cakeOrderId,BindingResult result){
		ModelAndView view=new ModelAndView();
		if(result.hasErrors()){
			view.setViewName("Search");
		}
		else
		{
		CakeOrderBean bean=cakeService.searchOrderById(cakeOrderId);
		view.setViewName("UpdateOrder");
		view.addObject("cakeOrderBeanUpdate",bean);
		}
		return view;
	}
	
	@RequestMapping(value="updateOrderById.html",method=RequestMethod.POST)
	public ModelAndView updateOrderById(@Valid @ModelAttribute("cakeOrderBeanUpdate") CakeOrderBean cakeOrderBeanUpdate){
		ModelAndView view=new ModelAndView();
		CakeOrderBean retBean=cakeService.updateOrderById(cakeOrderBeanUpdate);
		view.setViewName("UpdateSuccess");
		view.addObject("message","Order with OrderId : "+retBean.getOrderId()+" has been successfully updated. "
				+ "Thank You.");		
		return view;
	}
	
	
	@ModelAttribute("cakeList")
	public Map<Integer,String> populateCakeList(){
		
		Map<Integer,String> retMap=cakeService.populateCakeList();
		return retMap;
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

