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


import com.dao.HuodongxindeDao;
import com.entity.HuodongxindeEntity;
import com.service.HuodongxindeService;
import com.entity.vo.HuodongxindeVO;
import com.entity.view.HuodongxindeView;

@Service("huodongxindeService")
public class HuodongxindeServiceImpl extends ServiceImpl<HuodongxindeDao, HuodongxindeEntity> implements HuodongxindeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongxindeEntity> page = this.selectPage(
                new Query<HuodongxindeEntity>(params).getPage(),
                new EntityWrapper<HuodongxindeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongxindeEntity> wrapper) {
		  Page<HuodongxindeView> page =new Query<HuodongxindeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuodongxindeVO> selectListVO(Wrapper<HuodongxindeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuodongxindeVO selectVO(Wrapper<HuodongxindeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuodongxindeView> selectListView(Wrapper<HuodongxindeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongxindeView selectView(Wrapper<HuodongxindeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
