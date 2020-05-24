package com.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.business.bean.BillRangeBean;
import com.business.bean.CakeOrderBean;
import com.service.CakeService;

@Controller
public class CakeReportController {

	@Autowired
	private CakeService cakeService;
	
	
	@RequestMapping(value="report.html",method=RequestMethod.GET)
	public ModelAndView showOrderReport(){
		ModelAndView view=new ModelAndView();
		view.setViewName("OrderReport");
		view.addObject("billBean",new BillRangeBean());
		return view;
	}
	
	
	@RequestMapping(value="generateReport.html",method=RequestMethod.POST)
	public ModelAndView generateOrderReport(@Valid @ModelAttribute("billBean") BillRangeBean billBean
			,BindingResult result) throws Exception{
		ModelAndView view=new ModelAndView();
		
		if(result.hasErrors()){
			view.setViewName("OrderReport");
		}
		
		else
		{
		try{
		List<CakeOrderBean> cakeOrderList=cakeService.generateOrderReport(billBean.getFromPrice(),billBean.getToPrice());
		if(cakeOrderList==null || cakeOrderList.size()==0) {
			throw new Exception("No records where found for the entered Bill Range!");
		}else {
			view.setViewName("OrderReport");
			view.addObject("beans",cakeOrderList);
		}
		}catch(Exception e) {
			throw e;
		}
	}
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
