package com.bootdo.cipin.service.impl;

import com.bootdo.cipin.dao.TotalContentDao;
import com.bootdo.cipin.domain.TotalContentDO;
import com.bootdo.cipin.service.TotalContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class TotalContentServiceImpl implements TotalContentService {
	@Autowired
	private TotalContentDao totalContentDao;
	
	@Override
	public TotalContentDO get(Integer id){
		return totalContentDao.get(id);
	}
	
	@Override
	public List<TotalContentDO> list(Map<String, Object> map){
		return totalContentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return totalContentDao.count(map);
	}
	
	@Override
	public int save(TotalContentDO totalContent){
		return totalContentDao.save(totalContent);
	}
	
	@Override
	public int update(TotalContentDO totalContent){
		return totalContentDao.update(totalContent);
	}
	
	@Override
	public int remove(Integer id){
		return totalContentDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return totalContentDao.batchRemove(ids);
	}
	
}
