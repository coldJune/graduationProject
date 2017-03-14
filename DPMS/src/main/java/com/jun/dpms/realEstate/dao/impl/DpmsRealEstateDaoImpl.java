package com.jun.dpms.realEstate.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jun.dpms.realEstate.bean.DpmsRealEstate;
import com.jun.dpms.realEstate.dao.IDpmsRealEstateDao;

public class DpmsRealEstateDaoImpl implements IDpmsRealEstateDao {
	private SessionFactory sessionFactory;

	private Session getCurrentSession(){
		return sessionFactory.openSession();
	}
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<DpmsRealEstate> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("from DpmsRealEstate r");
		q.setMaxResults(eachPage);
		q.setFirstResult((currentPage-1)*eachPage);
		return q.list();
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return ((Number)(this.getCurrentSession().createQuery("select count(*) from DpmsRealEstate").uniqueResult())).intValue();
	}

	@Override
	public DpmsRealEstate searchByEstateNo(int estateNo) {
		// TODO Auto-generated method stub
		Query q =this.getCurrentSession().createQuery("from DpmsRealEstate r where r.estateNo=?");
		q.setInteger(0, estateNo);
		
		List<DpmsRealEstate> results=q.list();
		if(results!=null&&!results.isEmpty()){
			for (DpmsRealEstate dpmsRealEstate : results) {
				return dpmsRealEstate;
			}
		}else{
			return null;
		}
		return null;
	}

	@Override
	public void updateRealEstat(DpmsRealEstate dpmsRealEstate) {
		// TODO Auto-generated method stub
		Query q =this.getCurrentSession().createQuery("update DpmsRealEstate r set r.roomNo=?,r.floorNo=?,r.roomInNo=?,r.roomOnSaleNo=?,r.elevatorNo=?,r.unitNo=?,r.hasDoor=?,r.hasGas=?,r.hasBordhand=?,r.relatePerson=?,r.phone=? where r.estateNo=?");
		q.setInteger(0, dpmsRealEstate.getRoomNo());
		q.setInteger(1, dpmsRealEstate.getFloorNo());
		q.setInteger(2, dpmsRealEstate.getRoomInNo());
		q.setInteger(3, dpmsRealEstate.getRoomOnSaleNo());
		q.setInteger(4, dpmsRealEstate.getElevatorNo());
		q.setInteger(5, dpmsRealEstate.getUnitNo());
		q.setString(6, dpmsRealEstate.getHasDoor());
		q.setString(7, dpmsRealEstate.getHasGas());
		q.setString(8, dpmsRealEstate.getHasBordhand());
		q.setString(9, dpmsRealEstate.getRelatePerson());
		q.setString(10, dpmsRealEstate.getPhone());
		q.setInteger(11, dpmsRealEstate.getEstateNo());
		q.executeUpdate();
	}

	@Override
	public void addRealEstat(DpmsRealEstate dpmsRealEstate) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(dpmsRealEstate);

	}

	@Override
	public void delRealEstate(int[] estateNos) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery("delete from DpmsRealEstate where estateNo=?");
		for (int i : estateNos) {
			q.setInteger(0, i);
			q.executeUpdate();
		}
	}

}
