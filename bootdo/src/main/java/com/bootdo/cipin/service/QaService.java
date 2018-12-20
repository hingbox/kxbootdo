package com.bootdo.cipin.service;

import com.bootdo.cipin.domain.QaDO;

import java.util.List;
import java.util.Map;


/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.service
 * @ClassName: vcc
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018-12-20 13:34:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2018-12-20 13:34:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface QaService {
	
	QaDO get(Integer id);
	
	List<QaDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(QaDO qa);
	
	int update(QaDO qa);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
