package com.jun.dpms.propertyCharge.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;
import com.jun.dpms.propertyCharge.bean.DpmsPropertyChargeHis;
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
	@Override
	public List<DpmsPropertyChargeHis> searchByPropertyCharge(DpmsPropertyCharge p) throws ParseException {
		// TODO Auto-generated method stub
		//查询出收费的项目
		Query q =this.getCurrentSession().createQuery("from DpmsPropertyCharge p where p.propertyName=?");
		q.setString(0, p.getPropertyName());
		List<DpmsPropertyCharge> dpmsPropertyCharges = q.list();
		
		DpmsPropertyCharge dpmsPropertyCharge=null;
		if(dpmsPropertyCharges!=null&&!dpmsPropertyCharges.isEmpty()){
		
			for (DpmsPropertyCharge pc : dpmsPropertyCharges) {
				dpmsPropertyCharge=pc;
				
				break;
			}
			
			if(dpmsPropertyCharge.getIsNecessary().equals("是")){
				//如果是必须缴费
				List<DpmsPropertyChargeHis> dpmsPropertyChargeHisss=new ArrayList<>();//未收费的集合
				
				//添加住户
				q=this.getCurrentSession().createQuery("from DpmsHousehold h ");
				List<DpmsHousehold> dpmsHouseholds=q.list();
				for (DpmsHousehold dpmsHousehold : dpmsHouseholds) {
					DpmsPropertyChargeHis dpmsPropertyChargeHi=new DpmsPropertyChargeHis();//未收费的单项
					//添加项目
					dpmsPropertyChargeHi.setDpmsPropertyCharge(dpmsPropertyCharge);
					int householdId=dpmsHousehold.getId();
					//取到最后一次缴费的记录该项目该人
					q=this.getCurrentSession().createQuery("from DpmsPropertyChargeHis ph  where  ph.id=(select max(id) from  DpmsPropertyChargeHis  where household_id =? and property_id=?)");
					q.setInteger(0, householdId);
					q.setInteger(1, dpmsPropertyCharge.getId());
					List<DpmsPropertyChargeHis> dpmsPropertyChargeHiss=q.list();
					//如果交过费
					if(dpmsPropertyChargeHiss!=null&&!dpmsPropertyChargeHiss.isEmpty()){
						for (DpmsPropertyChargeHis dpmsPropertyChargeHis : dpmsPropertyChargeHiss) {
								Date now = new Date();
								DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								Date lastChargeTime=df.parse(dpmsPropertyChargeHis.getChargeTime());
								double  differ=(now.getTime()-lastChargeTime.getTime())/(1000*60*60*24.0);
								if(differ-dpmsPropertyCharge.getCycle()>0.000001){
									dpmsPropertyChargeHi.setDpmsHousehold(dpmsHousehold);
									dpmsPropertyChargeHisss.add(dpmsPropertyChargeHi);
								}
						}
					}else{//没交过费
						dpmsPropertyChargeHi.setDpmsHousehold(dpmsHousehold);
						dpmsPropertyChargeHisss.add(dpmsPropertyChargeHi);
					}
					
				}
				return dpmsPropertyChargeHisss;
			}
		}
		
		
		return null;
	}
	
}
