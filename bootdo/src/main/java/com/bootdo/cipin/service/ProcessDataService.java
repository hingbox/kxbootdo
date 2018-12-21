package com.bootdo.cipin.service;


import com.bootdo.cipin.domain.ProcessDataDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-21 15:13:16
 */
public interface ProcessDataService {
	
	ProcessDataDO get(Integer id);
	
	List<ProcessDataDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProcessDataDO processData);
	
	int update(ProcessDataDO processData);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
