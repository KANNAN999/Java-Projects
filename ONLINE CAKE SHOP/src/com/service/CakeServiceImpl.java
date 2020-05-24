package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.bean.CakeBean;
import com.business.bean.CakeOrderBean;
import com.business.bean.OrderBean;
import com.dao.CakeDAOWrapper;
import com.entity.CakeEntity;

@Service
public class CakeServiceImpl implements CakeService {

	@Autowired
	private CakeDAOWrapper cakeDAOWrapper;
	
	
	@Override
	public Map<Integer, String> populateCakeList() {
		// TODO Auto-generated method stub
		List<CakeBean> cakeList=cakeDAOWrapper.populateCakeDetails();
		Map<Integer,String> retMap=new HashMap();
		for(CakeBean cake:cakeList){
			retMap.put(cake.getCakeId(), cake.getCakeName());
		}
		return retMap;
	}

	@Override
	public CakeOrderBean orderCake(CakeOrderBean cakeBean) {
		double cost=cakeDAOWrapper.getCakeCost(cakeBean.getCakeID());
		int quantity=cakeBean.getNoOfPiecesOrdered();
		double bill=cost*quantity;
		cakeBean.setBill(bill);
		CakeOrderBean retBean=cakeDAOWrapper.orderCake(cakeBean);
		return retBean;
	}

	@Override
	public List<CakeOrderBean> generateOrderReport(Double fromPrice, Double toPrice) {
		// TODO Auto-generated method stub
		List<CakeOrderBean> retList=cakeDAOWrapper.generateOrderReport(fromPrice,toPrice);
		return retList;
	}

	@Override
	public CakeOrderBean searchOrderById(OrderBean cakeOrderId) {
		// TODO Auto-generated method stub
		CakeOrderBean bean=cakeDAOWrapper.searchOrderById(cakeOrderId);
		return bean;
	}

	@Override
	public CakeOrderBean updateOrderById(CakeOrderBean cakeOrderBeanUpdate) {
		// TODO Auto-generated method stub
		CakeOrderBean bean=cakeDAOWrapper.updateOrderById(cakeOrderBeanUpdate);
		return bean;
	}

	@Override
	public String deleteOrder(CakeOrderBean cakeOrderBeanDelete) {
		// TODO Auto-generated method stub
		String bean=cakeDAOWrapper.deleteOrder(cakeOrderBeanDelete);
		return bean;
	}

}
