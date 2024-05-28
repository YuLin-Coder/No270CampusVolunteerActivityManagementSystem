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


import com.dao.HuodongxinxiDao;
import com.entity.HuodongxinxiEntity;
import com.service.HuodongxinxiService;
import com.entity.vo.HuodongxinxiVO;
import com.entity.view.HuodongxinxiView;

@Service("huodongxinxiService")
public class HuodongxinxiServiceImpl extends ServiceImpl<HuodongxinxiDao, HuodongxinxiEntity> implements HuodongxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongxinxiEntity> page = this.selectPage(
                new Query<HuodongxinxiEntity>(params).getPage(),
                new EntityWrapper<HuodongxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongxinxiEntity> wrapper) {
		  Page<HuodongxinxiView> page =new Query<HuodongxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuodongxinxiVO> selectListVO(Wrapper<HuodongxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuodongxinxiVO selectVO(Wrapper<HuodongxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuodongxinxiView> selectListView(Wrapper<HuodongxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongxinxiView selectView(Wrapper<HuodongxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
