package com.bootdo.test.controller;

import com.bootdo.test.domain.Words;
import com.bootdo.test.service.WordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.api
 * @ClassName: TestMongodbController
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2019/1/6 22:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/6 22:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RestController
@RequestMapping("/test")
public class TestMongodbController {
//    @Autowired
//    private OrderServiceImpl orderService;
    @Autowired
    private WordsServiceImpl wordsService;

    /**
     * 保存
     * @param order
     * @return
     */
    //@PostMapping
//    @RequestMapping("/saveOrder")
//    @ResponseBody
//    public String saveOrder(@RequestBody Map<String, String> order){
//        String name = order.get("name");
//        Order o = new Order();
//        o.setName(name);
//        orderService.save(o);
//        return order.toString();
//    }

    /**
     * 按照id查找
     * @param
     * @return
     */
//    @RequestMapping(value = "/findOrderById", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String findOrderById(@RequestBody Map<String, Object> reqMap){
//        String id = reqMap.get("id").toString();
//        return JSON.toJSONString(orderService.findOrderById(id));
//    }

    /**
     * 查找全部
     * @return
     */
//    @RequestMapping("/findAll")
//    @ResponseBody
//    public String findAll(){
//        return JSON.toJSONString(orderService.findAll());
//    }

    /**
     * 修改
     * @param id
     * @param name
     * @return
     */
//    @PutMapping("/{id}")
//    @ResponseBody
//    public String updateName(@PathVariable(value = "id") String id,@RequestParam("name") String name){
//        return orderService.updateNameById(id,name)+"";
//    }

//    /**
//     * 删除
//     * @param id
//     * @return
//     */
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") String id){
//        orderService.deleteById(id);
//        return "删除成功！";
//    }

    /**
     * 保存
     * @param
     * @return
     */
    //@PostMapping
    @RequestMapping("/saveWords")
    @ResponseBody
    public String saveWords(@RequestBody Words words){
        wordsService.save(words);
        return words.toString();
    }

}