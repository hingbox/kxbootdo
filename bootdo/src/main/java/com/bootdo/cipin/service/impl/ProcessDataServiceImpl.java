package com.bootdo.cipin.service.impl;

import com.bootdo.cipin.dao.ProcessDataDao;
import com.bootdo.cipin.domain.ProcessDataDO;
import com.bootdo.cipin.service.ProcessDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class ProcessDataServiceImpl implements ProcessDataService {
	@Autowired
	private ProcessDataDao processDataDao;
	
	@Override
	public ProcessDataDO get(Integer id){
		return processDataDao.get(id);
	}
	
	@Override
	public List<ProcessDataDO> list(Map<String, Object> map){
		return processDataDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return processDataDao.count(map);
	}
	
	@Override
	public int save(ProcessDataDO processData){
		return processDataDao.save(processData);
	}
	
	@Override
	public int update(ProcessDataDO processData){
		return processDataDao.update(processData);
	}
	
	@Override
	public int remove(Integer id){
		return processDataDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return processDataDao.batchRemove(ids);
	}
	
}
