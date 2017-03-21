package com.jun.dpms.complain.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jun.dpms.complain.bean.DpmsComplain;
import com.jun.dpms.complain.dao.IDpmsComplainDao;
import com.jun.dpms.household.bean.DpmsHousehold;

public class DpmsComplainDaoImpl implements IDpmsComplainDao {
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return this.sessionFactory.openSession();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Override
	public List<DpmsComplain> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("select c.dpmsHousehold,c.id,c.details,c.complainDate,c.isDeal from DpmsComplain c");
		q.setMaxResults(eachPage);
		q.setFirstResult((currentPage-1)*eachPage);
		List<Object> objs=q.list();
		List<DpmsComplain> dpmsComplains = new ArrayList<>();
		for (Object object : objs) {
			Object[] objects=(Object[]) object;
			DpmsHousehold dpmsHousehold=(DpmsHousehold)objects[0];
			int id = (int) objects[1];
			String details=(String)objects[2];
			String complainDate=(String)objects[3];
			String isDeal=(String)objects[4];
			DpmsComplain dpmsComplain = new DpmsComplain();
			dpmsComplain.setDpmsHousehold(dpmsHousehold);
			dpmsComplain.setId(id);
			dpmsComplain.setDetails(details);
			dpmsComplain.setComplainDate(complainDate);
			dpmsComplain.setIsDeal(isDeal);
			dpmsComplains.add(dpmsComplain);
		}
		return dpmsComplains;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return ((Number)(this.getCurrentSession().createQuery("select  count(*) from DpmsComplain")).uniqueResult()).intValue();
	}

	@Override
	public DpmsComplain searchByHoldName(String	holdName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateComplain(DpmsComplain dpmsComplain) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("update DpmsComplain c set c.details=?,c.isDeal=? where c.id=?");
		q.setString(0, dpmsComplain.getDetails());
		q.setString(1, dpmsComplain.getIsDeal());
		q.setInteger(2, dpmsComplain.getId());
		q.executeUpdate();
	}

	@Override
	public void addComplain(DpmsComplain dpmsComplain) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(dpmsComplain);
	}

	@Override
	public void delComplaine(int[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DpmsComplain searchById(int id) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("select c.dpmsHousehold,c.id,c.details,c.complainDate,c.isDeal from DpmsComplain c where c.id=?");
		q.setInteger(0, id);
		List<Object> objs=q.list();
		if(objs!=null&&!objs.isEmpty()){
			for (Object object : objs) {
				Object[] objects=(Object[]) object;
				DpmsHousehold dpmsHousehold=(DpmsHousehold)objects[0];
				String details=(String)objects[2];
				String complainDate=(String)objects[3];
				String isDeal=(String)objects[4];
				DpmsComplain dpmsComplain = new DpmsComplain();
				dpmsComplain.setDpmsHousehold(dpmsHousehold);
				dpmsComplain.setId(id);
				dpmsComplain.setDetails(details);
				dpmsComplain.setComplainDate(complainDate);
				dpmsComplain.setIsDeal(isDeal);
				return dpmsComplain;
			}
		}else{
			return null;
		}
		return null;
		
	}

}
