package com.bootdo.process.service;

import com.bootdo.process.domain.TProcessDataDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-21 16:09:46
 */
public interface TProcessDataService {
	
	TProcessDataDO get(Integer id);
	
	List<TProcessDataDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TProcessDataDO tProcessData);
	
	int update(TProcessDataDO tProcessData);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
