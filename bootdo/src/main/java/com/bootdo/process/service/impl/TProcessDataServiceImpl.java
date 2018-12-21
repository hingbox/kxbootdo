package com.bootdo.process.service.impl;

import com.bootdo.process.dao.TProcessDataDao;
import com.bootdo.process.domain.TProcessDataDO;
import com.bootdo.process.service.TProcessDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class TProcessDataServiceImpl implements TProcessDataService {
	@Autowired
	private TProcessDataDao tProcessDataDao;
	
	@Override
	public TProcessDataDO get(Integer id){
		return tProcessDataDao.get(id);
	}
	
	@Override
	public List<TProcessDataDO> list(Map<String, Object> map){
		return tProcessDataDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tProcessDataDao.count(map);
	}
	
	@Override
	public int save(TProcessDataDO tProcessData){
		return tProcessDataDao.save(tProcessData);
	}
	
	@Override
	public int update(TProcessDataDO tProcessData){
		return tProcessDataDao.update(tProcessData);
	}
	
	@Override
	public int remove(Integer id){
		return tProcessDataDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return tProcessDataDao.batchRemove(ids);
	}
	
}
