package com.jun.dpms.propertyCharge.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;
import com.jun.dpms.propertyCharge.dao.IDpmsPropertyChargeDao;

public class DpmsPropertyChargeDaoImpl implements IDpmsPropertyChargeDao{
	private SessionFactory sessinFactory;
	
	public void setSessinFactory(SessionFactory sessionFactory){
		this.sessinFactory=sessionFactory;
	}
	public Session getCurrentSession(){
		return this.sessinFactory.openSession();
	}
	@Override
	public List<DpmsPropertyCharge> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("from DpmsPropertyCharge p");
		q.setMaxResults(eachPage);
		q.setFirstResult((currentPage-1)*eachPage);
		return q.list();
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return ((Number)(this.getCurrentSession().createQuery("select  count(*) from DpmsPropertyCharge p").uniqueResult())).intValue();
	}
	@Override
	public DpmsPropertyCharge searchByPropertyName(String propertyName) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("from DpmsPropertyCharge p where p.propertyName=?");
		q.setString(0, propertyName);
		List<DpmsPropertyCharge> dpmsPropertyCharges=q.list();
		if(dpmsPropertyCharges!=null&&!dpmsPropertyCharges.isEmpty()){
			for (DpmsPropertyCharge dpmsPropertyCharge : dpmsPropertyCharges) {
				return dpmsPropertyCharge;
			}
		}else{
			return null;
		}
		return null;
	}
	@Override
	public void addPropertyName(DpmsPropertyCharge dpmsPropertyCharge) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(dpmsPropertyCharge);
	}
	@Override
	public void updatePropertyCharge(DpmsPropertyCharge dpmsPropertyCharge) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("update DpmsPropertyCharge p set p.isNecessary=?,p.cycle=?,p.standard=?,p.modifyPerson=?,p.modifyDate=? where p.propertyName=?");
		q.setString(0, dpmsPropertyCharge.getIsNecessary());
		q.setInteger(1, dpmsPropertyCharge.getCycle());
		q.setString(2, dpmsPropertyCharge.getStandard());
		q.setString(3, dpmsPropertyCharge.getModifyPerson());
		q.setString(4, dpmsPropertyCharge.getModifyDate());
		q.setString(5, dpmsPropertyCharge.getPropertyName());
		q.executeUpdate();
	}
	@Override
	public void delPropertyCharge(int[] ids) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("delete from DpmsPropertyCharge p where p.id=?");
		for (int i : ids) {
			q.setInteger(0,i);
			q.executeUpdate();
		}
	}
	
}
