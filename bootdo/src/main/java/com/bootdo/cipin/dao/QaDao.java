package com.bootdo.cipin.dao;

import com.bootdo.cipin.domain.QaDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.dao
 * @ClassName: vcc
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/12/20 14:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/20 14:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Mapper
public interface QaDao {

	QaDO get(Integer id);
	
	List<QaDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(QaDO qa);
	
	int update(QaDO qa);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
