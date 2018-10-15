package com.banxue.projects.web;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banxue.projects.entity.ExperienceCenter;
import com.banxue.projects.service.IExperienceCenterService;
import com.banxue.utils.Constants;
import com.banxue.utils.Query;
import com.banxue.utils.R;
import com.banxue.utils.log.FileLog;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author feng
 * @since 2018-09-25
 */
@Controller
@RequestMapping("/experienceCenter")
public class ExperienceCenterController {
	
	@Autowired
	private IExperienceCenterService experienceCenterService;
	
	/**
	 * 访问 list页面
	 * @return
	 */
	@GetMapping("/list")
	public String listPage() {
		return "experienceCenter/list";
	}
	/**
	 * 获取list数据
	 * @return
	 */
	@PostMapping("/list")
	@ResponseBody
	public R listData(Integer page, Integer limit) {
		try {
			Page<ExperienceCenter> pagel = new Page<>(page, limit);
			pagel = experienceCenterService.selectPage(pagel);
			
			return R.ok().put("data", pagel.getRecords()).put("count", pagel.getTotal());
		} catch (Exception e) {
			FileLog.errorLog(e);
			return R.error();
		}
		
	}
	
	/**
	 * 添加
	 * @return
	 */
	@GetMapping("add")
	@ResponseBody
	public R add() {
		try {
			ExperienceCenter entity = new ExperienceCenter();
			entity.setCenterNo(experienceCenterService.getNextCenterNo().toString());
			entity.setCenterState(Constants.STATE_AVAILABLE);
			entity.setCreateTime(new Date());
			entity.setUpdateTime(new Date());
			entity.setIsDel(Constants.NO);
			entity.setRemark(StringUtils.EMPTY);
			experienceCenterService.insert(entity);
			return R.ok();
		} catch (Exception e) {
			FileLog.errorLog(e);
			return R.error();
		}
	}

}
