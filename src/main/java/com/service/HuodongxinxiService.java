package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuodongxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuodongxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuodongxinxiView;


/**
 * 活动信息
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface HuodongxinxiService extends IService<HuodongxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongxinxiVO> selectListVO(Wrapper<HuodongxinxiEntity> wrapper);
   	
   	HuodongxinxiVO selectVO(@Param("ew") Wrapper<HuodongxinxiEntity> wrapper);
   	
   	List<HuodongxinxiView> selectListView(Wrapper<HuodongxinxiEntity> wrapper);
   	
   	HuodongxinxiView selectView(@Param("ew") Wrapper<HuodongxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongxinxiEntity> wrapper);
   	

}

