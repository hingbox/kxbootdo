package com.bootdo.cipin.dao;

import com.bootdo.cipin.domain.TotalContentDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-22 21:02:32
 */
@Mapper
public interface TotalContentDao {

	TotalContentDO get(Integer id);
	
	List<TotalContentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TotalContentDO totalContent);
	
	int update(TotalContentDO totalContent);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
