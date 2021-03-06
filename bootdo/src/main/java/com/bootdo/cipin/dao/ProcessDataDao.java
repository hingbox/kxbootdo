package com.bootdo.cipin.dao;

import com.bootdo.cipin.domain.ProcessDataDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-22 21:14:14
 */
@Mapper
public interface ProcessDataDao {

	ProcessDataDO get(Integer id);
	
	List<ProcessDataDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProcessDataDO processData);
	
	int update(ProcessDataDO processData);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
