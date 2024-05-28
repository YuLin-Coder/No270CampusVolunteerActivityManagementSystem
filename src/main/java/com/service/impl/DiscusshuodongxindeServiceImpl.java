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


import com.dao.DiscusshuodongxindeDao;
import com.entity.DiscusshuodongxindeEntity;
import com.service.DiscusshuodongxindeService;
import com.entity.vo.DiscusshuodongxindeVO;
import com.entity.view.DiscusshuodongxindeView;

@Service("discusshuodongxindeService")
public class DiscusshuodongxindeServiceImpl extends ServiceImpl<DiscusshuodongxindeDao, DiscusshuodongxindeEntity> implements DiscusshuodongxindeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusshuodongxindeEntity> page = this.selectPage(
                new Query<DiscusshuodongxindeEntity>(params).getPage(),
                new EntityWrapper<DiscusshuodongxindeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusshuodongxindeEntity> wrapper) {
		  Page<DiscusshuodongxindeView> page =new Query<DiscusshuodongxindeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusshuodongxindeVO> selectListVO(Wrapper<DiscusshuodongxindeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusshuodongxindeVO selectVO(Wrapper<DiscusshuodongxindeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusshuodongxindeView> selectListView(Wrapper<DiscusshuodongxindeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusshuodongxindeView selectView(Wrapper<DiscusshuodongxindeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
