package com.banxue.projects.service.impl;

import org.springframework.stereotype.Service;

import com.banxue.projects.entity.ExperienceCenter;
import com.banxue.projects.mapper.ExperienceCenterMapper;
import com.banxue.projects.service.IExperienceCenterService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author feng
 * @since 2018-09-25
 */
@Service
public class ExperienceCenterServiceImpl extends ServiceImpl<ExperienceCenterMapper, ExperienceCenter> implements IExperienceCenterService {

	@Override
	public Integer getNextCenterNo() {
		return baseMapper.getNextCenterNo();
	}
	
}
