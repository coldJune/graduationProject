package com.jun.dpms.household.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.household.dao.IDpmsHouseholdDao;

public class DpmsHouseholdDaoImpl implements IDpmsHouseholdDao {
	
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.openSession();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<DpmsHousehold> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		Query q =this.getCurrentSession().createQuery("from DpmsHousehold h");
		q.setMaxResults(eachPage);
		q.setFirstResult((currentPage-1)*eachPage);
		
		return q.list();
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		
		return ((Number)(this.getCurrentSession().createQuery("select count(*) from DpmsHousehold").uniqueResult())).intValue();
	}

	@Override
	public List<DpmsHousehold> searchByHoldName(String holdName) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("from DpmsHousehold h where h.holdName=?");
		q.setString(0, holdName);
		return q.list();
	}

	@Override
	public void updateRealEstat(DpmsHousehold dpmsHousehold) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("update DpmsHousehold h  set h.holdAge=?,h.familyNo=?,h.hasPackin=?,h.relateNo=?,h.holdPhone=?,h.plateNumber=?,h.area=? where h.id=?");
		q.setInteger(0, dpmsHousehold.getHoldAge());
		q.setInteger(1, dpmsHousehold.getFamilyNo());
		q.setString(2, dpmsHousehold.getHasPackin());
		q.setInteger(3, dpmsHousehold.getRelateNo());
		q.setString(4, dpmsHousehold.getHoldPhone());
		q.setString(5, dpmsHousehold.getPlateNumber());
		q.setDouble(6, dpmsHousehold.getArea());
		q.setInteger(7, dpmsHousehold.getId());
		q.executeUpdate();
	}

	@Override
	public void addRealEstat(DpmsHousehold dpmsHousehold) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(dpmsHousehold);
	}

	@Override
	public void delHousehold(int[] ids) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("delete from DpmsHousehold h where h.id=?");
		for (int i : ids) {
			q.setInteger(0, i);
			q.executeUpdate();
		}
	}

	@Override
	public DpmsHousehold searchById(int id) {
		// TODO Auto-generated method stub
		Query q=  this.getCurrentSession().createQuery("from DpmsHousehold h where h.id=?");
		q.setInteger(0, id);
		List<DpmsHousehold> dpmsHouseholds=q.list();
		if(dpmsHouseholds!=null&&!dpmsHouseholds.isEmpty()){
			for (DpmsHousehold dpmsHousehold : dpmsHouseholds) {
				return dpmsHousehold;
			}
		}else{
			return null;
		}
		return null;
	}

	@Override
	public List searchRealEstate() {
		// TODO Auto-generated method stub
		Query q=this.getCurrentSession().createQuery("select r.estateNo from DpmsRealEstate r ");
		return q.list();
	}

	@Override
	public List searchUnitAndFloor(int relateRealEstate) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("select r.unitNo,r.floorNo from DpmsRealEstate r where r.estateNo=?");
		q.setInteger(0, relateRealEstate);
		return q.list();
	}

	@Override
	public boolean checkRelate(DpmsHousehold dpmsHousehold) {
		// TODO Auto-generated method stub
		Query q =this.getCurrentSession().createQuery("from DpmsHousehold h where h.relateRealEstate=? and h.relateFloor=? and h.relateUnit=? and h.relateNo=?");
		q.setInteger(0, dpmsHousehold.getRelateRealEstate());
		q.setInteger(1, dpmsHousehold.getRelateFloor());
		q.setInteger(2, dpmsHousehold.getRelateUnit());
		q.setInteger(3, dpmsHousehold.getRelateNo());
		
		if(q.list()==null||q.list().isEmpty()){
			return true;
		}else{
			return false;
		}
	}

}
