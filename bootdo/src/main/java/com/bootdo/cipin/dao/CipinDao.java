package com.bootdo.cipin.dao;

import com.bootdo.cipin.domain.CipinDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-21 13:30:49
 */
@Mapper
public interface CipinDao {

	CipinDO get(Integer id);
	
	List<CipinDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CipinDO cipin);
	
	int update(CipinDO cipin);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
