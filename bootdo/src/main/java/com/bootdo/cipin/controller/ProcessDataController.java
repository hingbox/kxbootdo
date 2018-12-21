package com.bootdo.cipin.controller;

import com.bootdo.cipin.domain.ProcessDataDO;
import com.bootdo.cipin.service.ProcessDataService;
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
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-21 15:13:16
 */
 
@Controller
@RequestMapping("/cipin/qa/processData")
public class ProcessDataController {
	@Autowired
	private ProcessDataService processDataService;
	
	@GetMapping()
	@RequiresPermissions("system:processData:processData")
	String ProcessData(){
	    return "system/processData/processData";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:processData:processData")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProcessDataDO> processDataList = processDataService.list(query);
		int total = processDataService.count(query);
		PageUtils pageUtils = new PageUtils(processDataList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:processData:add")
	String add(){
	    return "system/processData/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:processData:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ProcessDataDO processData = processDataService.get(id);
		model.addAttribute("processData", processData);
	    return "system/processData/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:processData:add")
	public R save( ProcessDataDO processData){
		if(processDataService.save(processData)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:processData:edit")
	public R update( ProcessDataDO processData){
		processDataService.update(processData);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:processData:remove")
	public R remove( Integer id){
		if(processDataService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:processData:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		processDataService.batchRemove(ids);
		return R.ok();
	}
	
}
