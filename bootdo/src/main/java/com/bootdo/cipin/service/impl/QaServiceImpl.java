package com.bootdo.cipin.service.impl;

import com.bootdo.cipin.dao.QaDao;
import com.bootdo.cipin.domain.QaDO;
import com.bootdo.cipin.service.QaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.service.impl
 * @ClassName: vcc
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018-12-20 13:34:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2018-12-20 13:34:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@Service
public class QaServiceImpl implements QaService {
	@Autowired
	private QaDao qaDao;
	
	@Override
	public QaDO get(Integer id){
		return qaDao.get(id);
	}
	
	@Override
	public List<QaDO> list(Map<String, Object> map){
		return qaDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return qaDao.count(map);
	}
	
	@Override
	public int save(QaDO qa){
		return qaDao.save(qa);
	}
	
	@Override
	public int update(QaDO qa){
		return qaDao.update(qa);
	}
	
	@Override
	public int remove(Integer id){
		return qaDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return qaDao.batchRemove(ids);
	}
	
}
