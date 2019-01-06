package com.bootdo.cipin.service;

import com.bootdo.cipin.domain.TotalContentDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-22 21:02:32
 */
public interface TotalContentService {
	
	TotalContentDO get(Integer id);
	
	List<TotalContentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TotalContentDO totalContent);
	
	int update(TotalContentDO totalContent);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
