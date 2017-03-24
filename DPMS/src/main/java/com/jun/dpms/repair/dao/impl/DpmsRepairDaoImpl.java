package com.jun.dpms.repair.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		Query q = this.getCurrentSession().createQuery("select r.dpmsHousehold,r.id,r.details,r.repairDate,r.isDeal,r.sparePhone from DpmsRepair r");
		q.setMaxResults(eachPage);
		q.setFirstResult((currentPage-1)*eachPage);
		List<Object> objs=q.list();
		List<DpmsRepair> dpmsComplains = new ArrayList<>();
		for (Object object : objs) {
			Object[] objects=(Object[]) object;
			DpmsHousehold dpmsHousehold=(DpmsHousehold)objects[0];
			int id = (int) objects[1];
			String details=(String)objects[2];
			String repairDate=(String)objects[3];
			String isDeal=(String)objects[4];
			String sparePhone=(String)objects[5];
			DpmsRepair dpmsRepair = new DpmsRepair();
			dpmsRepair.setDpmsHousehold(dpmsHousehold);
			dpmsRepair.setId(id);
			dpmsRepair.setDetails(details);
			dpmsRepair.setRepairDate(repairDate);
			dpmsRepair.setIsDeal(isDeal);
			dpmsRepair.setSparePhone(sparePhone);
			dpmsComplains.add(dpmsRepair);
		}
		return dpmsComplains;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return ((Number)this.getCurrentSession().createQuery("select count(*) from DpmsRepair r ").uniqueResult()).intValue();
	}

	@Override
	public List<DpmsRepair> searchByHoldName(String holdName) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("select r.dpmsHousehold,r.id,r.details,r.repairDate,r.isDeal,r.sparePhone from DpmsRepair r where r.dpmsHousehold.holdName=?");
		q.setString(0, holdName);
		List<Object> objs=q.list();
		List<DpmsRepair> dpmsComplains = new ArrayList<>();
		for (Object object : objs) {
			Object[] objects=(Object[]) object;
			DpmsHousehold dpmsHousehold=(DpmsHousehold)objects[0];
			int id = (int) objects[1];
			String details=(String)objects[2];
			String repairDate=(String)objects[3];
			String isDeal=(String)objects[4];
			String sparePhone=(String)objects[5];
			DpmsRepair dpmsRepair = new DpmsRepair();
			dpmsRepair.setDpmsHousehold(dpmsHousehold);
			dpmsRepair.setId(id);
			dpmsRepair.setDetails(details);
			dpmsRepair.setRepairDate(repairDate);
			dpmsRepair.setIsDeal(isDeal);
			dpmsRepair.setSparePhone(sparePhone);
			dpmsComplains.add(dpmsRepair);
		}
		return dpmsComplains;
	}

	@Override
	public void updateRepair(DpmsRepair dpmsRepair) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("update DpmsRepair r set r.details=?,r.isDeal=?,r.sparePhone=? where r.id=?");
		q.setString(0, dpmsRepair.getDetails());
		q.setString(1, dpmsRepair.getIsDeal());
		q.setString(2, dpmsRepair.getSparePhone());
		q.setInteger(3, dpmsRepair.getId());
		q.executeUpdate();
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
		Query q =this.getCurrentSession().createQuery("delete from DpmsRepair r where r.id=?");
		for (int i : ids) {
			q.setInteger(0, i);
			q.executeUpdate();
		}
	}

	@Override
	public DpmsRepair searchById(int id) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("select r.dpmsHousehold,r.id,r.details,r.repairDate,r.isDeal,r.sparePhone from DpmsRepair r where r.id=?");
		q.setInteger(0, id);
		List<Object> objs=q.list();
		if(objs!=null&&!objs.isEmpty()){
			for (Object object : objs) {
				Object[] objects=(Object[]) object;
				DpmsHousehold dpmsHousehold=(DpmsHousehold)objects[0];
				String details=(String)objects[2];
				String repairDate=(String)objects[3];
				String isDeal=(String)objects[4];
				String sparePhone=(String)objects[5];
				DpmsRepair dpmsRepair = new DpmsRepair();
				dpmsRepair.setDpmsHousehold(dpmsHousehold);
				dpmsRepair.setId(id);
				dpmsRepair.setDetails(details);
				dpmsRepair.setRepairDate(repairDate);
				dpmsRepair.setIsDeal(isDeal);
				dpmsRepair.setSparePhone(sparePhone);
				return dpmsRepair;
			}
		}else{
			return null;
		}
		return null;
	}

	@Override
	public Map<String, String> checkHousehold(DpmsHousehold dpmsHousehold) {
		// TODO Auto-generated method stub
		return null;
	}

}
