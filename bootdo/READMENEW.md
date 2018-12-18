# kxbootdo 是在bootdo基础上进行第二次开发

1. 分词api参考：http://www.pullword.com/


2. 具体需求
a.根据筛选条件进行查询，查询条件为(时间，问，答，关键词)
    数据显示出来，支持分页
b.系统每天统计一次，词频出现的次数，写入到表中(这个是定时任务)
c.可以对任意两天，或者多天的条件进行查询(然后对比，每天词频增减数量)
d.可以对某一个时间数据进行筛选，得出的数据  通过图表分析出来(可以参考echart)

3. 表结构
目前数据是存在t_qa表中 
表结构如下：
CREATE TABLE `t_qa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) DEFAULT NULL COMMENT '根据title和source_from生成的唯一标识',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `pub_date` datetime DEFAULT NULL COMMENT '提问日期',
  `content` varchar(500) DEFAULT NULL COMMENT '提问内容',
  `source` varchar(10) DEFAULT NULL COMMENT '来源，上证(sh),深圳(sz)',
  `stock` varchar(50) DEFAULT NULL COMMENT '股票名称',
  `code` varchar(20) DEFAULT NULL COMMENT '股票代码',
  `qa` char(1) DEFAULT '0' COMMENT '0,提问，1回答',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=1438459 DEFAULT CHARSET=utf8;

分词主要是对 上面表中 content字段 进行统计分析，
