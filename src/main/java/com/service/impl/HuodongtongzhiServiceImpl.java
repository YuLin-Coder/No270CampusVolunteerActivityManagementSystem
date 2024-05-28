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


import com.dao.HuodongtongzhiDao;
import com.entity.HuodongtongzhiEntity;
import com.service.HuodongtongzhiService;
import com.entity.vo.HuodongtongzhiVO;
import com.entity.view.HuodongtongzhiView;

@Service("huodongtongzhiService")
public class HuodongtongzhiServiceImpl extends ServiceImpl<HuodongtongzhiDao, HuodongtongzhiEntity> implements HuodongtongzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongtongzhiEntity> page = this.selectPage(
                new Query<HuodongtongzhiEntity>(params).getPage(),
                new EntityWrapper<HuodongtongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongtongzhiEntity> wrapper) {
		  Page<HuodongtongzhiView> page =new Query<HuodongtongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuodongtongzhiVO> selectListVO(Wrapper<HuodongtongzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuodongtongzhiVO selectVO(Wrapper<HuodongtongzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuodongtongzhiView> selectListView(Wrapper<HuodongtongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongtongzhiView selectView(Wrapper<HuodongtongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
