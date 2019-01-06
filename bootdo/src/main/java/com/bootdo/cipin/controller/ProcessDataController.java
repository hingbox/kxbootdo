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
 * @date 2018-12-22 21:14:14
 */
 
@Controller
@RequestMapping("/process/processData")
public class ProcessDataController {
	@Autowired
	private ProcessDataService processDataService;
	
	@GetMapping()
	@RequiresPermissions("process:processData:processData")
	String ProcessData(){
	    return "process/processData/processData";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("process:processData:processData")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProcessDataDO> processDataList = processDataService.list(query);
		int total = processDataService.count(query);
		PageUtils pageUtils = new PageUtils(processDataList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("process:processData:add")
	String add(){
	    return "process/processData/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("process:processData:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ProcessDataDO processData = processDataService.get(id);
		model.addAttribute("processData", processData);
	    return "process/processData/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("process:processData:add")
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
	@RequiresPermissions("process:processData:edit")
	public R update( ProcessDataDO processData){
		processDataService.update(processData);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("process:processData:remove")
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
	@RequiresPermissions("process:processData:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		processDataService.batchRemove(ids);
		return R.ok();
	}
	
}
