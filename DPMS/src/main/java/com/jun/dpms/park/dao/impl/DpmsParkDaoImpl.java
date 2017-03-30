package com.jun.dpms.park.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.park.bean.DpmsPark;
import com.jun.dpms.park.dao.IDpmsParkDao;

public class DpmsParkDaoImpl implements IDpmsParkDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getCurrentSession(){
		return this.sessionFactory.openSession();
	}
	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return ((Number)this.getCurrentSession().createQuery("select count(*) from DpmsPark p where p.isCharge='否' or p.isCharge=null").uniqueResult()).intValue();
	}

	@Override
	public int getHisTotalItem() {
		// TODO Auto-generated method stub
		return ((Number)this.getCurrentSession().createQuery("select count(*) from DpmsPark p where p.isCharge='是'").uniqueResult()).intValue();
	}

	@Override
	public List<DpmsPark> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(" from DpmsPark p where p.isCharge='否' or p.isCharge=null");
		q.setMaxResults(eachPage);
		q.setFirstResult((currentPage-1)*eachPage);
		List<DpmsPark> results=q.list();
		List<String> plateNumbers=new ArrayList<>();
		List<DpmsPark> dpmsParks=new ArrayList<>();
		if(!results.isEmpty()&&results!=null){
			for (DpmsPark result : results) {
				plateNumbers.add(result.getPlateNumber());
			}
		}
		
		for (String plateNumber : plateNumbers) {
			List<DpmsPark> rs=this.searchByPlateNumber(plateNumber);
			if(rs!=null&&!rs.isEmpty()){
				for (DpmsPark dpmsPark : rs) {
					dpmsParks.add(dpmsPark);
				}
			}
		}
		
		return dpmsParks;
	}

	@Override
	public List<DpmsPark> findHisAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("from DpmsPark p where p.isCharge='是'");
		q.setMaxResults(eachPage);
		q.setFirstResult((currentPage-1)*eachPage);
		return q.list();
	}
	@Override
	public List<DpmsPark> searchByPlateNumber(String plateNumber) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("select p.dpmsHousehold,p.startTime,p.endTime,p.price,p.isCharge from DpmsPark p where p.plateNumber=?");
		q.setString(0, plateNumber);
		List<Object> objs=q.list();
		List<DpmsPark> dpmsParks=new ArrayList<>();
		if(objs!=null&&!objs.isEmpty()){
			for (Object object : objs) {
				Object[] objects=(Object[])object;
				DpmsHousehold dpmsHousehold = (DpmsHousehold)objects[0];
				String startTime=(String)objects[1];
				String endTime=(String)objects[2];
				String price=(String)objects[3];
				String isCharge=(String)objects[4];
				
				DpmsPark dpmsPark=new DpmsPark();
				dpmsPark.setDpmsHousehold(dpmsHousehold);
				dpmsPark.setPlateNumber(plateNumber);
				dpmsPark.setStartTime(startTime);
				dpmsPark.setEndTime(endTime);
				dpmsPark.setPrice(price);
				dpmsPark.setIsCharge(isCharge);
				dpmsParks.add(dpmsPark);
			}
			return dpmsParks;
		}else{
			q=this.getCurrentSession().createQuery("from DpmsPark p where p.plateNumber=?");
			q.setString(0, plateNumber);
			dpmsParks=q.list();
			return dpmsParks;
		}
	}
	@Override
	public boolean updateLeave(String plateNumber) {
		// TODO Auto-generated method stub
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String endTime = df.format(new Date());
			Query q = this.getCurrentSession().createQuery("update DpmsPark p set p.isCharge='是',p.price='0',p.endTime=? where p.plateNumber=?");
			q.setString(0, endTime);
			q.setString(1, plateNumber);
			q.executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	@Override
	public boolean updateCharge(DpmsPark dpmsPark) {
		// TODO Auto-generated method stub
		try {
			Query q = this.getCurrentSession().createQuery("update DpmsPark p set p.isCharge='是',p.price=?,p.endTime=? where p.plateNumber=?");
			System.out.println(dpmsPark.getPlateNumber());
			q.setString(0, dpmsPark.getPrice());
			q.setString(1, dpmsPark.getEndTime());
			q.setString(2, dpmsPark.getPlateNumber());
			q.executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	@Override
	public void addPark(DpmsPark dpmsPark) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("from DpmsHousehold h where h.hasPackin='是' and h.plateNumber=?");
		q.setString(0, dpmsPark.getPlateNumber());
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTime=df.format(new Date());
		dpmsPark.setStartTime(startTime);
		dpmsPark.setIsCharge("否");
		dpmsPark.setPlateNumber(dpmsPark.getPlateNumber());
		List<DpmsHousehold> dpmsHouseholds = q.list();
		if(dpmsHouseholds!=null&&!dpmsHouseholds.isEmpty()){
			for (DpmsHousehold dpmsHousehold : dpmsHouseholds) {
				dpmsPark.setDpmsHousehold(dpmsHousehold);
			}
		}
		this.getCurrentSession().save(dpmsPark);
	}
	@Override
	public void delPark(int[] ids) {
		// TODO Auto-generated method stub
		Query q =this.getCurrentSession().createQuery("delete from DpmsPark p where p.id=?");
		for (int i : ids) {
			q.setInteger(0, i);
			q.executeUpdate();
		}
	}
	
}
