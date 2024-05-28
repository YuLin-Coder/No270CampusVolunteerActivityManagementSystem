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


import com.dao.ZhiyuanzheDao;
import com.entity.ZhiyuanzheEntity;
import com.service.ZhiyuanzheService;
import com.entity.vo.ZhiyuanzheVO;
import com.entity.view.ZhiyuanzheView;

@Service("zhiyuanzheService")
public class ZhiyuanzheServiceImpl extends ServiceImpl<ZhiyuanzheDao, ZhiyuanzheEntity> implements ZhiyuanzheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiyuanzheEntity> page = this.selectPage(
                new Query<ZhiyuanzheEntity>(params).getPage(),
                new EntityWrapper<ZhiyuanzheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiyuanzheEntity> wrapper) {
		  Page<ZhiyuanzheView> page =new Query<ZhiyuanzheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhiyuanzheVO> selectListVO(Wrapper<ZhiyuanzheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhiyuanzheVO selectVO(Wrapper<ZhiyuanzheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhiyuanzheView> selectListView(Wrapper<ZhiyuanzheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiyuanzheView selectView(Wrapper<ZhiyuanzheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
