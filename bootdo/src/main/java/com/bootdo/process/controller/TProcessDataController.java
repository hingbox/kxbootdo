package com.bootdo.process.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.process.domain.TProcessDataDO;
import com.bootdo.process.service.TProcessDataService;
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
 * @date 2018-12-21 16:09:46
 */
 
@Controller
@RequestMapping("/process/tProcessData")
public class TProcessDataController {
	@Autowired
	private TProcessDataService tProcessDataService;
	
	@GetMapping()
	@RequiresPermissions("process:tProcessData:tProcessData")
	String TProcessData(){
	    return "process/tProcessData/tProcessData";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("process:tProcessData:tProcessData")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TProcessDataDO> tProcessDataList = tProcessDataService.list(query);
		int total = tProcessDataService.count(query);
		PageUtils pageUtils = new PageUtils(tProcessDataList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("process:tProcessData:add")
	String add(){
	    return "process/tProcessData/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("process:tProcessData:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		TProcessDataDO tProcessData = tProcessDataService.get(id);
		model.addAttribute("tProcessData", tProcessData);
	    return "process/tProcessData/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("process:tProcessData:add")
	public R save( TProcessDataDO tProcessData){
		if(tProcessDataService.save(tProcessData)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("process:tProcessData:edit")
	public R update( TProcessDataDO tProcessData){
		tProcessDataService.update(tProcessData);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("process:tProcessData:remove")
	public R remove( Integer id){
		if(tProcessDataService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("process:tProcessData:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		tProcessDataService.batchRemove(ids);
		return R.ok();
	}
	
}
