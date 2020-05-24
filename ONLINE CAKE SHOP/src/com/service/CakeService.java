package com.service;

import java.util.List;
import java.util.Map;

import com.business.bean.CakeOrderBean;
import com.business.bean.OrderBean;

public interface CakeService {

	Map<Integer, String> populateCakeList();

	CakeOrderBean orderCake(CakeOrderBean cakeBean);

	List<CakeOrderBean> generateOrderReport(Double fromPrice, Double toPrice);

	CakeOrderBean searchOrderById(OrderBean cakeOrderId);

	CakeOrderBean updateOrderById(CakeOrderBean cakeOrderBeanUpdate);

	String deleteOrder(CakeOrderBean cakeOrderBeanDelete);

}