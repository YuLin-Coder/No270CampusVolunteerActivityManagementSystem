package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuodongtongzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuodongtongzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuodongtongzhiView;


/**
 * 活动通知
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface HuodongtongzhiService extends IService<HuodongtongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongtongzhiVO> selectListVO(Wrapper<HuodongtongzhiEntity> wrapper);
   	
   	HuodongtongzhiVO selectVO(@Param("ew") Wrapper<HuodongtongzhiEntity> wrapper);
   	
   	List<HuodongtongzhiView> selectListView(Wrapper<HuodongtongzhiEntity> wrapper);
   	
   	HuodongtongzhiView selectView(@Param("ew") Wrapper<HuodongtongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongtongzhiEntity> wrapper);
   	

}

