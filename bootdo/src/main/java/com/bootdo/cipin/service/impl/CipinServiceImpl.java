package com.bootdo.cipin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.cipin.dao.CipinDao;
import com.bootdo.cipin.domain.CipinDO;
import com.bootdo.cipin.service.CipinService;



@Service
public class CipinServiceImpl implements CipinService {
	@Autowired
	private CipinDao cipinDao;
	
	@Override
	public CipinDO get(Integer id){
		return cipinDao.get(id);
	}
	
	@Override
	public List<CipinDO> list(Map<String, Object> map){
		return cipinDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return cipinDao.count(map);
	}
	
	@Override
	public int save(CipinDO cipin){
		return cipinDao.save(cipin);
	}
	
	@Override
	public int update(CipinDO cipin){
		return cipinDao.update(cipin);
	}
	
	@Override
	public int remove(Integer id){
		return cipinDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return cipinDao.batchRemove(ids);
	}
	
}
