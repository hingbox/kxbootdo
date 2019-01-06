package com.bootdo.cipin.controller;

import com.bootdo.cipin.domain.TotalContentDO;
import com.bootdo.cipin.service.TotalContentService;
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
 * @date 2018-12-22 21:02:32
 */
 
@Controller
@RequestMapping("/system/totalContent")
public class TotalContentController {
	@Autowired
	private TotalContentService totalContentService;
	
	@GetMapping()
	@RequiresPermissions("system:totalContent:totalContent")
	String TotalContent(){
	    return "system/totalContent/totalContent";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:totalContent:totalContent")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TotalContentDO> totalContentList = totalContentService.list(query);
		int total = totalContentService.count(query);
		PageUtils pageUtils = new PageUtils(totalContentList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:totalContent:add")
	String add(){
	    return "system/totalContent/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:totalContent:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		TotalContentDO totalContent = totalContentService.get(id);
		model.addAttribute("totalContent", totalContent);
	    return "system/totalContent/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:totalContent:add")
	public R save( TotalContentDO totalContent){
		if(totalContentService.save(totalContent)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:totalContent:edit")
	public R update( TotalContentDO totalContent){
		totalContentService.update(totalContent);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:totalContent:remove")
	public R remove( Integer id){
		if(totalContentService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:totalContent:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		totalContentService.batchRemove(ids);
		return R.ok();
	}
	
}
