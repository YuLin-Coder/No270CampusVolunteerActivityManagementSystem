package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.HuodongbaomingDao;
import com.entity.HuodongbaomingEntity;
import com.service.HuodongbaomingService;
import com.entity.vo.HuodongbaomingVO;
import com.entity.view.HuodongbaomingView;

@Service("huodongbaomingService")
public class HuodongbaomingServiceImpl extends ServiceImpl<HuodongbaomingDao, HuodongbaomingEntity> implements HuodongbaomingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongbaomingEntity> page = this.selectPage(
                new Query<HuodongbaomingEntity>(params).getPage(),
                new EntityWrapper<HuodongbaomingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongbaomingEntity> wrapper) {
		  Page<HuodongbaomingView> page =new Query<HuodongbaomingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuodongbaomingVO> selectListVO(Wrapper<HuodongbaomingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuodongbaomingVO selectVO(Wrapper<HuodongbaomingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuodongbaomingView> selectListView(Wrapper<HuodongbaomingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongbaomingView selectView(Wrapper<HuodongbaomingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
