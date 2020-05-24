package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.business.bean.CakeBean;
import com.business.bean.CakeOrderBean;
import com.business.bean.OrderBean;
import com.entity.CakeEntity;
import com.entity.CakeOrderEntity;

@Repository
@Transactional(value = "txManager")
public class CakeDAOWrapper {

	@Autowired
	private CakeDAO cakeDAO;
	
	@Autowired
	private CakeOrderDAO cakeOrderDAO;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<CakeBean> populateCakeDetails(){
		List<CakeBean> retList=new ArrayList();
		List<CakeEntity> retListEntity=cakeDAO.findAll();
		for(CakeEntity c:retListEntity){
			CakeBean bean=bean=convertEntityToBean(c);
			retList.add(bean);
		}
		
		return retList;
	}
	
	
	
	public Double getCakeCost(Integer cakeId){
		CakeEntity entity=cakeDAO.findOne(cakeId);
		double cost=entity.getPrice();
		return cost;
	}
	
	
	
	//Conversion Methods
	public static CakeBean convertEntityToBean(CakeEntity entity) {
		CakeBean cakeBean = new CakeBean();
		BeanUtils.copyProperties(entity, cakeBean);
		return cakeBean;
	}
	public static CakeEntity convertBeanToEntity(CakeBean bean) {
		CakeEntity entity = new CakeEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}

public static CakeOrderBean convertEntityToBean(CakeOrderEntity entity){
	CakeOrderBean cakeBean=new CakeOrderBean();
	BeanUtils.copyProperties(entity, cakeBean);
	return cakeBean;
}

public static CakeOrderEntity convertBeanToEntity(CakeOrderBean bean){
	CakeOrderEntity entity=new CakeOrderEntity();
	BeanUtils.copyProperties(bean, entity);
	return entity;
}

	public CakeOrderBean orderCake(CakeOrderBean cakeBean) {
		// TODO Auto-generated method stub
		CakeOrderEntity entity=convertBeanToEntity(cakeBean);
		entity=cakeOrderDAO.save(entity);
		CakeOrderBean bean=convertEntityToBean(entity);
		return bean;
	}



	public List<CakeOrderBean> generateOrderReport(Double fromPrice, Double toPrice) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("select k from CakeOrderEntity k where k.bill between ?1 and ?2");
		query.setParameter(1, fromPrice);
		query.setParameter(2, toPrice);
		List<CakeOrderEntity> cakeEntity=query.getResultList();
		List<CakeOrderBean> retBean=new ArrayList();
		for(CakeOrderEntity entity:cakeEntity){
			CakeOrderBean bean=convertEntityToBean(entity);
			retBean.add(bean);
		}
		return retBean;
	}



	public CakeOrderBean searchOrderById(OrderBean cakeOrderId) {
		// TODO Auto-generated method stub
		Integer id=cakeOrderId.getOrderId();
		CakeOrderEntity entity=cakeOrderDAO.findOne(id);
		CakeOrderBean bean=convertEntityToBean(entity);
		return bean;
	}



	public CakeOrderBean updateOrderById(CakeOrderBean cakeOrderBeanUpdate) {
		// TODO Auto-generated method stub
		Double price=this.getCakeCost(cakeOrderBeanUpdate.getCakeID());
		Integer quantity=cakeOrderBeanUpdate.getNoOfPiecesOrdered();
		double bill=price*quantity;
		cakeOrderBeanUpdate.setBill(bill);
		Integer id=cakeOrderBeanUpdate.getOrderId();
		CakeOrderEntity entity=convertBeanToEntity(cakeOrderBeanUpdate);
		entityManager.find(CakeOrderEntity.class, id);
		CakeOrderBean bean=convertEntityToBean(entityManager.merge(entity));
		return bean;
	}



	public String deleteOrder(CakeOrderBean cakeOrderBeanDelete) {
		// TODO Auto-generated method stub
		CakeOrderEntity entity=convertBeanToEntity(cakeOrderBeanDelete);
		entity=entityManager.find(CakeOrderEntity.class, entity.getOrderId());
		entityManager.remove(entity);
		return "Order with OrderId : "+cakeOrderBeanDelete.getOrderId()+" has been successfully deleted. Thank You";
		
		
	}
}
