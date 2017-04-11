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
import com.jun.dpms.sysUser.bean.DpmsSysUser;

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
		Query q1 = this.getCurrentSession().createQuery("delete from DpmsPropertyCharge p where p.id=?");
		Query q2 =this.getCurrentSession().createSQLQuery("delete from dpmspropertychargehis  where PROPERTY_ID=?");
		for (int i : ids) {
			q2.setInteger(0, i);
			q2.executeUpdate();
			q1.setInteger(0,i);
			q1.executeUpdate();
		}
	}
	@Override
	public List<DpmsPropertyChargeHis> searchByPropertyCharge(DpmsPropertyCharge p) throws ParseException {
		// TODO Auto-generated method stub
		//��ѯ���շѵ���Ŀ
		Query q =this.getCurrentSession().createQuery("from DpmsPropertyCharge p where p.propertyName=?");
		q.setString(0, p.getPropertyName());
		List<DpmsPropertyCharge> dpmsPropertyCharges = q.list();
		
		DpmsPropertyCharge dpmsPropertyCharge=null;
		if(dpmsPropertyCharges!=null&&!dpmsPropertyCharges.isEmpty()){
		
			for (DpmsPropertyCharge pc : dpmsPropertyCharges) {
				dpmsPropertyCharge=pc;
				
				break;
			}
			
			if(dpmsPropertyCharge.getIsNecessary().equals("��")){
				//����Ǳ���ɷ�
				List<DpmsPropertyChargeHis> dpmsPropertyChargeHisss=new ArrayList<>();//δ�շѵļ���
				
				//���ס��
				q=this.getCurrentSession().createQuery("from DpmsHousehold h ");
				List<DpmsHousehold> dpmsHouseholds=q.list();
				for (DpmsHousehold dpmsHousehold : dpmsHouseholds) {
					DpmsPropertyChargeHis dpmsPropertyChargeHi=new DpmsPropertyChargeHis();//δ�շѵĵ���
					//�����Ŀ
					dpmsPropertyChargeHi.setDpmsPropertyCharge(dpmsPropertyCharge);
					int householdId=dpmsHousehold.getId();
					//ȡ�����һ�νɷѵļ�¼����Ŀ����
					q=this.getCurrentSession().createQuery("from DpmsPropertyChargeHis ph  where  ph.id=(select max(id) from  DpmsPropertyChargeHis  where household_id =? and property_id=?)");
					q.setInteger(0, householdId);
					q.setInteger(1, dpmsPropertyCharge.getId());
					List<DpmsPropertyChargeHis> dpmsPropertyChargeHiss=q.list();
					//���������
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
					}else{//û������
						dpmsPropertyChargeHi.setDpmsHousehold(dpmsHousehold);
						dpmsPropertyChargeHisss.add(dpmsPropertyChargeHi);
					}
					
				}
				return dpmsPropertyChargeHisss;
			}
		}
		
		
		return null;
	}
	@Override
	public DpmsPropertyChargeHis searchChargeDetail(DpmsPropertyChargeHis dpmsPropertyChargeHis) {
		// TODO Auto-generated method stub
		//��ѯ���շ����Ӧ����Ŀ
		Query q = this.getCurrentSession().createQuery("from DpmsPropertyCharge p where p.propertyName=?");
		q.setString(0, dpmsPropertyChargeHis.getDpmsPropertyCharge().getPropertyName());
		List<DpmsPropertyCharge> dpmsPropertyCharges=q.list();
		DpmsPropertyChargeHis dChargeHis=new DpmsPropertyChargeHis();
		if(dpmsPropertyCharges!=null&&!dpmsPropertyCharges.isEmpty()){
			for (DpmsPropertyCharge dpmsPropertyCharge : dpmsPropertyCharges) {
				dChargeHis.setDpmsPropertyCharge(dpmsPropertyCharge);
				break;
			}
		}
		//��ѯ�ɷѵ���
		q=this.getCurrentSession().createQuery("from DpmsHousehold h where h.id=?");
		q.setInteger(0, dpmsPropertyChargeHis.getDpmsHousehold().getId());
		List<DpmsHousehold> dpmsHouseholds = q.list();
		if(dpmsHouseholds!=null&&!dpmsHouseholds.isEmpty()){
			for (DpmsHousehold dpmsHousehold : dpmsHouseholds) {
				dChargeHis.setDpmsHousehold(dpmsHousehold);
				break;
			}
		}
		return dChargeHis;
	}
	@Override
	public void addChargeHis(DpmsPropertyChargeHis dpmsPropertyChargeHis) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("from DpmsSysUser u where u.userName=?");
		q.setString(0,dpmsPropertyChargeHis.getOpPerson());
		List<DpmsSysUser> dpmsSysUsers=q.list();
		if(dpmsSysUsers!=null&&!dpmsSysUsers.isEmpty()){
			for (DpmsSysUser dpmsSysUser : dpmsSysUsers) {
				dpmsPropertyChargeHis.setOpPerson(dpmsSysUser.getName());
				dpmsPropertyChargeHis.setOpPhone(dpmsSysUser.getPhone());
				break;
			}
		}
		this.getCurrentSession().save(dpmsPropertyChargeHis);
	}
	@Override
	public List<DpmsPropertyChargeHis> findAllHis(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("select ph.dpmsHousehold,ph.dpmsPropertyCharge,ph.id,ph.chargeTime,ph.price,ph.opPerson,ph.opPhone,ph.id from DpmsPropertyChargeHis ph");
		q.setMaxResults(eachPage);
		q.setFirstResult((currentPage-1)*eachPage);
		List<Object> objects=q.list();
		List<DpmsPropertyChargeHis> dpmsPropertyChargeHiss=new ArrayList<>();
		if(objects!=null&&!objects.isEmpty()){
			for (Object object : objects) {
				Object[] objs=(Object[])object;
				DpmsPropertyChargeHis dpmsPropertyChargeHis = new DpmsPropertyChargeHis();
				DpmsHousehold dpmsHousehold=(DpmsHousehold)objs[0];
				DpmsPropertyCharge dpmsPropertyCharge=(DpmsPropertyCharge)objs[1];
				int id =(int)objs[2];
				String chargeTime=(String)objs[3];
				String price = (String)objs[4];
				String opPerson=(String)objs[5];
				String opPhone=(String)objs[6];
				dpmsPropertyChargeHis.setId(id);
				dpmsPropertyChargeHis.setChargeTime(chargeTime);
				dpmsPropertyChargeHis.setPrice(price);
				dpmsPropertyChargeHis.setDpmsHousehold(dpmsHousehold);
				dpmsPropertyChargeHis.setDpmsPropertyCharge(dpmsPropertyCharge);
				dpmsPropertyChargeHis.setOpPerson(opPerson);
				dpmsPropertyChargeHis.setOpPhone(opPhone);
				dpmsPropertyChargeHiss.add(dpmsPropertyChargeHis);
			}
			return dpmsPropertyChargeHiss;
		}
		return null;
	}
	@Override
	public int getHisTotalItem() {
		// TODO Auto-generated method stub
		return ((Number)(this.getCurrentSession().createQuery("select  count(*) from DpmsPropertyChargeHis ph").uniqueResult())).intValue();
	}
	@Override
	public List<DpmsPropertyChargeHis> searchByHoldName(String holdName) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("select ph.dpmsHousehold,ph.dpmsPropertyCharge,ph.id,ph.chargeTime,ph.price,ph.opPerson,ph.opPhone,ph.id from DpmsPropertyChargeHis ph where ph.dpmsHousehold.holdName=?");
		q.setString(0, holdName);
		List<Object> objects=q.list();
		List<DpmsPropertyChargeHis> dpmsPropertyChargeHiss=new ArrayList<>();
		if(objects!=null&&!objects.isEmpty()){
			for (Object object : objects) {
				Object[] objs=(Object[])object;
				DpmsPropertyChargeHis dpmsPropertyChargeHis = new DpmsPropertyChargeHis();
				DpmsHousehold dpmsHousehold=(DpmsHousehold)objs[0];
				DpmsPropertyCharge dpmsPropertyCharge=(DpmsPropertyCharge)objs[1];
				int id =(int)objs[2];
				String chargeTime=(String)objs[3];
				String price = (String)objs[4];
				String opPerson=(String)objs[5];
				String opPhone=(String)objs[6];
				dpmsPropertyChargeHis.setId(id);
				dpmsPropertyChargeHis.setChargeTime(chargeTime);
				dpmsPropertyChargeHis.setPrice(price);
				dpmsPropertyChargeHis.setDpmsHousehold(dpmsHousehold);
				dpmsPropertyChargeHis.setDpmsPropertyCharge(dpmsPropertyCharge);
				dpmsPropertyChargeHis.setOpPerson(opPerson);
				dpmsPropertyChargeHis.setOpPhone(opPhone);
				dpmsPropertyChargeHiss.add(dpmsPropertyChargeHis);
			}
			return dpmsPropertyChargeHiss;
		}
		return null;
	}
	@Override
	public DpmsPropertyChargeHis searchHisById(int id) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("select ph.dpmsHousehold,ph.dpmsPropertyCharge,ph.id,ph.chargeTime,ph.price,ph.opPerson,ph.opPhone,ph.id from DpmsPropertyChargeHis ph where ph.id=?");
		q.setInteger(0, id);
		List<Object> objects=q.list();
		DpmsPropertyChargeHis dpmsPropertyChargeHis = new DpmsPropertyChargeHis();
		if(objects!=null&&!objects.isEmpty()){
			for (Object object : objects) {
				Object[] objs=(Object[])object;
				DpmsHousehold dpmsHousehold=(DpmsHousehold)objs[0];
				DpmsPropertyCharge dpmsPropertyCharge=(DpmsPropertyCharge)objs[1];
				String chargeTime=(String)objs[3];
				String price = (String)objs[4];
				String opPerson=(String)objs[5];
				String opPhone=(String)objs[6];
				dpmsPropertyChargeHis.setId(id);
				dpmsPropertyChargeHis.setChargeTime(chargeTime);
				dpmsPropertyChargeHis.setPrice(price);
				dpmsPropertyChargeHis.setDpmsHousehold(dpmsHousehold);
				dpmsPropertyChargeHis.setDpmsPropertyCharge(dpmsPropertyCharge);
				dpmsPropertyChargeHis.setOpPerson(opPerson);
				dpmsPropertyChargeHis.setOpPhone(opPhone);
				break;
			}
			return dpmsPropertyChargeHis;
		}
		return null;
	}
	
}
