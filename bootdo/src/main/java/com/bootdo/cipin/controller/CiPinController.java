package com.bootdo.cipin.controller;

import com.bootdo.cipin.domain.CipinDO;
import com.bootdo.cipin.service.CipinService;
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
 * @Package: com.bootdo.cipin.controller
 * @ClassName: CipinController
 * @Description: 此类暂时未用到
 * @Author: hingbox@163.com
 * @CreateDate: 2018/12/20 17:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/20 17:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/cipin/cipin")
public class CipinController {
	@Autowired
	private CipinService cipinService;
	
	@GetMapping()
	@RequiresPermissions("cipin:cipin:cipin")
	String Cipin(){
	    return "cipin/cipin/cipin";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("cipin:cipin:cipin")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CipinDO> cipinList = cipinService.list(query);
		int total = cipinService.count(query);
		PageUtils pageUtils = new PageUtils(cipinList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("cipin:cipin:add")
	String add(){
	    return "cipin/cipin/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("cipin:cipin:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		CipinDO cipin = cipinService.get(id);
		model.addAttribute("cipin", cipin);
	    return "cipin/cipin/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("cipin:cipin:add")
	public R save( CipinDO cipin){
		if(cipinService.save(cipin)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("cipin:cipin:edit")
	public R update( CipinDO cipin){
		cipinService.update(cipin);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("cipin:cipin:remove")
	public R remove( Integer id){
		if(cipinService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("cipin:cipin:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		cipinService.batchRemove(ids);
		return R.ok();
	}
	
}
