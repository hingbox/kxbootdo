# kxbootdo 是在bootdo基础上进行第二次开发

1. 分词api参考：http://www.pullword.com/

可以调用这个接口：http://123.206.46.153:7911/wordcloud/ 
请求方式 post请求 参数 json格式 
请求参数示例：
{
	"content":"安迪苏(600299)近期国内猪肉价格持续低迷，而且这种情况有分析认为将要持续二年左右时间，请问董秘这种情况对公司产品销量会产生多大影响？是否意味着公司产品价格也将继续在低位震荡？另外国际市场是否也存在相类似情况。谢谢！"

}
返回结果示例：
{
  "aggs_result": [
    {
      "name": "名词",
      "value": 16
    },
    {
      "name": "动词",
      "value": 14
    },
    {
      "name": "未知",
      "value": 3
    },
    {
      "name": "数词",
      "value": 3
    },
    {
      "name": "连词",
      "value": 2
    }
  ],
  "detail_result": {
    "代词": [
      {
        "name": "这种",
        "value": 2
      }
    ],
    "副词": [
      {
        "name": "将要",
        "value": 1
      }
    ],
    "动词": [
      {
        "name": "是否",
        "value": 2
      },
      {
        "name": "持续",
        "value": 2
      },
      {
        "name": "继续",
        "value": 1
      },
      {
        "name": "存在",
        "value": 1
      },
      {
        "name": "分析",
        "value": 1
      }
    ],
    "名词": [
      {
        "name": "情况",
        "value": 3
      },
      {
        "name": "公司",
        "value": 2
      },
      {
        "name": "低位",
        "value": 1
      },
      {
        "name": "价格",
        "value": 1
      },
      {
        "name": "谢谢",
        "value": 1
      }
    ],
    "处所词": [
      {
        "name": "国内",
        "value": 1
      }
    ],
    "数词": [
      {
        "name": "600299",
        "value": 1
      },
      {
        "name": "二年",
        "value": 1
      },
      {
        "name": "左右",
        "value": 1
      }
    ],
    "时间词": [
      {
        "name": "近期",
        "value": 1
      }
    ],
    "未知": [
      {
        "name": "安迪苏",
        "value": 1
      },
      {
        "name": "董秘",
        "value": 1
      },
      {
        "name": "多大",
        "value": 1
      }
    ],
    "连词": [
      {
        "name": "而且",
        "value": 1
      },
      {
        "name": "另外",
        "value": 1
      }
    ]
  },
  "error": false,
  "info": "",
  "result": [
    {
      "flag": "名词",
      "name": "情况",
      "value": 3
    },
    {
      "flag": "代词",
      "name": "这种",
      "value": 2
    },
    {
      "flag": "名词",
      "name": "公司",
      "value": 2
    },
    {
      "flag": "动词",
      "name": "持续",
      "value": 2
    },
    {
      "flag": "动词",
      "name": "是否",
      "value": 2
    },
    {
      "flag": "名词",
      "name": "价格",
      "value": 1
    },
    {
      "flag": "未知",
      "name": "多大",
      "value": 1
    },
    {
      "flag": "动词",
      "name": "意味着",
      "value": 1
    },
    {
      "flag": "动词",
      "name": "类似",
      "value": 1
    },
    {
      "flag": "连词",
      "name": "而且",
      "value": 1
    },
    {
      "flag": "动词",
      "name": "分析",
      "value": 1
    },
    {
      "flag": "动词",
      "name": "存在",
      "value": 1
    },
    {
      "flag": "动词",
      "name": "继续",
      "value": 1
    },
    {
      "flag": "动词",
      "name": "震荡",
      "value": 1
    },
    {
      "flag": "名词",
      "name": "产品",
      "value": 1
    },
    {
      "flag": "名词",
      "name": "低位",
      "value": 1
    },
    {
      "flag": "数词",
      "name": "600299",
      "value": 1
    },
    {
      "flag": "处所词",
      "name": "国内",
      "value": 1
    },
    {
      "flag": "名词",
      "name": "猪肉",
      "value": 1
    },
    {
      "flag": "名词",
      "name": "产品价格",
      "value": 1
    },
    {
      "flag": "未知",
      "name": "董秘",
      "value": 1
    },
    {
      "flag": "名词",
      "name": "销量",
      "value": 1
    },
    {
      "flag": "名词",
      "name": "国际",
      "value": 1
    },
    {
      "flag": "名词",
      "name": "谢谢",
      "value": 1
    },
    {
      "flag": "动词",
      "name": "低迷",
      "value": 1
    },
    {
      "flag": "数词",
      "name": "左右",
      "value": 1
    },
    {
      "flag": "动词",
      "name": "认为",
      "value": 1
    },
    {
      "flag": "副词",
      "name": "将要",
      "value": 1
    },
    {
      "flag": "名词",
      "name": "时间",
      "value": 1
    },
    {
      "flag": "名词",
      "name": "市场",
      "value": 1
    },
    {
      "flag": "时间词",
      "name": "近期",
      "value": 1
    },
    {
      "flag": "动词",
      "name": "影响",
      "value": 1
    },
    {
      "flag": "连词",
      "name": "另外",
      "value": 1
    },
    {
      "flag": "未知",
      "name": "安迪苏",
      "value": 1
    },
    {
      "flag": "数词",
      "name": "二年",
      "value": 1
    },
    {
      "flag": "动词",
      "name": "请问",
      "value": 1
    },
    {
      "flag": "名词",
      "name": "产生",
      "value": 1
    }
  ]
}

2. 具体需求
a.根据筛选条件进行查询，查询条件为(时间，问，答，关键词)数据显示出来，支持分页 这个需求是查询原始数据
b.系统每天统计一次，词频出现的次数(按照日期，提问方式)，写入到表中(这个是定时任务,很耗工作量)
c.可以对任意两天，或者多天的条件进行查询(然后对比，每天词频增减数量，耗工作量)
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



4. 2018-12-20 新加了一个测试模块  模块包名cipin
5. 2018-12-21 
    新添加了一张表 t_cipin 用户存放词频信息
    表结构如下：
    SET FOREIGN_KEY_CHECKS=0;
    -- ----------------------------
    -- Table structure for `t_cipin`
    -- ----------------------------
    DROP TABLE IF EXISTS `t_cipin`;
    CREATE TABLE `t_cipin` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `content` text COMMENT '内容',
      `pub_date` varchar(30) DEFAULT NULL COMMENT '发布日期',
      `create_date` datetime DEFAULT NULL COMMENT '创建时间',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
    
    将每天查询的数据 分词之后 存到上面表中
    
