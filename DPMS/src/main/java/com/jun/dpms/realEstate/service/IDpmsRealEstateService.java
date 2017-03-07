package com.jun.dpms.realEstate.service;

import java.util.List;

import com.jun.dpms.realEstate.bean.DpmsRealEstate;


public interface IDpmsRealEstateService {
	public List<DpmsRealEstate> findAll(int eachPage,int currentPage);
	public int getTotalItem();
	public DpmsRealEstate searchByEstateNo(int estateNo);
	public void updateRealEstat(DpmsRealEstate dpmsRealEstate);
	public void addRealEstat(DpmsRealEstate dpmsRealEstate);
	
	public void delRealEstate(int[] estateNos);
}
