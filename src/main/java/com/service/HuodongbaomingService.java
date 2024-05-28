package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuodongbaomingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuodongbaomingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuodongbaomingView;


/**
 * 活动报名
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface HuodongbaomingService extends IService<HuodongbaomingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongbaomingVO> selectListVO(Wrapper<HuodongbaomingEntity> wrapper);
   	
   	HuodongbaomingVO selectVO(@Param("ew") Wrapper<HuodongbaomingEntity> wrapper);
   	
   	List<HuodongbaomingView> selectListView(Wrapper<HuodongbaomingEntity> wrapper);
   	
   	HuodongbaomingView selectView(@Param("ew") Wrapper<HuodongbaomingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongbaomingEntity> wrapper);
   	

}

