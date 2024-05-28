package com.dao;

import com.entity.HuodongtongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuodongtongzhiVO;
import com.entity.view.HuodongtongzhiView;


/**
 * 活动通知
 * 
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface HuodongtongzhiDao extends BaseMapper<HuodongtongzhiEntity> {
	
	List<HuodongtongzhiVO> selectListVO(@Param("ew") Wrapper<HuodongtongzhiEntity> wrapper);
	
	HuodongtongzhiVO selectVO(@Param("ew") Wrapper<HuodongtongzhiEntity> wrapper);
	
	List<HuodongtongzhiView> selectListView(@Param("ew") Wrapper<HuodongtongzhiEntity> wrapper);

	List<HuodongtongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongtongzhiEntity> wrapper);
	
	HuodongtongzhiView selectView(@Param("ew") Wrapper<HuodongtongzhiEntity> wrapper);
	

}
