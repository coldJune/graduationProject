package com.jun.dpms.repair.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.repair.bean.DpmsRepair;
import com.jun.dpms.repair.dao.IDpmsRepairDao;

public class DpmsRepairDaoImpl implements IDpmsRepairDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public Session getCurrentSession(){
		return this.sessionFactory.openSession();
	}
	@Override
	public List<DpmsRepair> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DpmsRepair> searchByHoldName(String holdName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRepair(DpmsRepair dpmsRepair) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRepair(DpmsRepair dpmsRepair) {
		// TODO Auto-generated method stub
		Query q =this.getCurrentSession().createQuery("select h.id from DpmsHousehold h where h.relateRealEstate=? and h.relateFloor=? and h.relateUnit=? and h.relateNo=?");
		q.setInteger(0, dpmsRepair.getDpmsHousehold().getRelateRealEstate());
		q.setInteger(1, dpmsRepair.getDpmsHousehold().getRelateFloor());
		q.setInteger(2, dpmsRepair.getDpmsHousehold().getRelateUnit());
		q.setInteger(3, dpmsRepair.getDpmsHousehold().getRelateNo());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String repairDate= df.format(new Date());
		List<Integer> l = q.list();
		int id=0;
		for (Integer integer : l) {
			if(integer!=null){
				System.out.println(integer);
				id=integer.intValue();
			}
		}
		dpmsRepair.getDpmsHousehold().setId(id);
		dpmsRepair.setRepairDate(repairDate);
		this.getCurrentSession().save(dpmsRepair);
	}

	@Override
	public void delRepair(int[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DpmsRepair searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> checkHousehold(DpmsHousehold dpmsHousehold) {
		// TODO Auto-generated method stub
		return null;
	}

}
