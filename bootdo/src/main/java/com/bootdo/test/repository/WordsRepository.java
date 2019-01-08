package com.bootdo.test.repository;

import com.bootdo.test.domain.Words;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.test.repository
 * @ClassName: WordsRepository
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2019/1/8 10:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/8 10:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Repository
public interface WordsRepository extends MongoRepository<Words,String> {
}