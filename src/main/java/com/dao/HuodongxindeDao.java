package com.dao;

import com.entity.HuodongxindeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuodongxindeVO;
import com.entity.view.HuodongxindeView;


/**
 * 活动心得
 * 
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface HuodongxindeDao extends BaseMapper<HuodongxindeEntity> {
	
	List<HuodongxindeVO> selectListVO(@Param("ew") Wrapper<HuodongxindeEntity> wrapper);
	
	HuodongxindeVO selectVO(@Param("ew") Wrapper<HuodongxindeEntity> wrapper);
	
	List<HuodongxindeView> selectListView(@Param("ew") Wrapper<HuodongxindeEntity> wrapper);

	List<HuodongxindeView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongxindeEntity> wrapper);
	
	HuodongxindeView selectView(@Param("ew") Wrapper<HuodongxindeEntity> wrapper);
	

}
