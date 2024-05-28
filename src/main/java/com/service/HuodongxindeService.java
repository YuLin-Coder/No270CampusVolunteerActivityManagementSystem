package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuodongxindeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuodongxindeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuodongxindeView;


/**
 * 活动心得
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface HuodongxindeService extends IService<HuodongxindeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongxindeVO> selectListVO(Wrapper<HuodongxindeEntity> wrapper);
   	
   	HuodongxindeVO selectVO(@Param("ew") Wrapper<HuodongxindeEntity> wrapper);
   	
   	List<HuodongxindeView> selectListView(Wrapper<HuodongxindeEntity> wrapper);
   	
   	HuodongxindeView selectView(@Param("ew") Wrapper<HuodongxindeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongxindeEntity> wrapper);
   	

}

