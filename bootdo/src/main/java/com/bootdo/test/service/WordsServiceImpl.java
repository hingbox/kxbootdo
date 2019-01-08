package com.bootdo.test.service;

import com.bootdo.test.domain.Words;
import com.bootdo.test.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.test.service
 * @ClassName: WordsServiceImpl
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2019/1/8 10:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/8 10:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class WordsServiceImpl {
    @Autowired
    private WordsRepository wordsRepository;

    public void save(Words words) {
        wordsRepository.save(words);
    }
}