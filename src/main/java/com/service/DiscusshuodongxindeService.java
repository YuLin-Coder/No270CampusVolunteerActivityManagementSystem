package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusshuodongxindeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusshuodongxindeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusshuodongxindeView;


/**
 * 活动心得评论表
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface DiscusshuodongxindeService extends IService<DiscusshuodongxindeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusshuodongxindeVO> selectListVO(Wrapper<DiscusshuodongxindeEntity> wrapper);
   	
   	DiscusshuodongxindeVO selectVO(@Param("ew") Wrapper<DiscusshuodongxindeEntity> wrapper);
   	
   	List<DiscusshuodongxindeView> selectListView(Wrapper<DiscusshuodongxindeEntity> wrapper);
   	
   	DiscusshuodongxindeView selectView(@Param("ew") Wrapper<DiscusshuodongxindeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusshuodongxindeEntity> wrapper);
   	

}

