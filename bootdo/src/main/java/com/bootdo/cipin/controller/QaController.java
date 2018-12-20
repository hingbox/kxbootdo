package com.bootdo.cipin.controller;

import com.bootdo.cipin.domain.QaDO;
import com.bootdo.cipin.service.QaService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.controller
 * @ClassName: vcc
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/12/20 14:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/20 14:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
 
@Controller
@RequestMapping("/cipin/qa")
public class QaController {
	@Autowired
	private QaService qaService;
	
	@GetMapping()
	@RequiresPermissions("cipin:qa:qa")
	String Qa(){
	    return "cipin/qa/qa";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("cipin:qa:qa")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<QaDO> qaList = qaService.list(query);
		int total = qaService.count(query);
		PageUtils pageUtils = new PageUtils(qaList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("cipin:qa:add")
	String add(){
	    return "cipin/qa/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("cipin:qa:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		QaDO qa = qaService.get(id);
		model.addAttribute("qa", qa);
	    return "cipin/qa/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("cipin:qa:add")
	public R save( QaDO qa){
		if(qaService.save(qa)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("cipin:qa:edit")
	public R update( QaDO qa){
		qaService.update(qa);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("cipin:qa:remove")
	public R remove( Integer id){
		if(qaService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("cipin:qa:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		qaService.batchRemove(ids);
		return R.ok();
	}
	
}
