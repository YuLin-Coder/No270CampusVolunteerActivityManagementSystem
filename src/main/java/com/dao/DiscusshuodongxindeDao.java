package com.dao;

import com.entity.DiscusshuodongxindeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusshuodongxindeVO;
import com.entity.view.DiscusshuodongxindeView;


/**
 * 活动心得评论表
 * 
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface DiscusshuodongxindeDao extends BaseMapper<DiscusshuodongxindeEntity> {
	
	List<DiscusshuodongxindeVO> selectListVO(@Param("ew") Wrapper<DiscusshuodongxindeEntity> wrapper);
	
	DiscusshuodongxindeVO selectVO(@Param("ew") Wrapper<DiscusshuodongxindeEntity> wrapper);
	
	List<DiscusshuodongxindeView> selectListView(@Param("ew") Wrapper<DiscusshuodongxindeEntity> wrapper);

	List<DiscusshuodongxindeView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusshuodongxindeEntity> wrapper);
	
	DiscusshuodongxindeView selectView(@Param("ew") Wrapper<DiscusshuodongxindeEntity> wrapper);
	

}
