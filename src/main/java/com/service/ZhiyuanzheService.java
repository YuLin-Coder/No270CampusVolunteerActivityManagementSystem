package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhiyuanzheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhiyuanzheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhiyuanzheView;


/**
 * 志愿者
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface ZhiyuanzheService extends IService<ZhiyuanzheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiyuanzheVO> selectListVO(Wrapper<ZhiyuanzheEntity> wrapper);
   	
   	ZhiyuanzheVO selectVO(@Param("ew") Wrapper<ZhiyuanzheEntity> wrapper);
   	
   	List<ZhiyuanzheView> selectListView(Wrapper<ZhiyuanzheEntity> wrapper);
   	
   	ZhiyuanzheView selectView(@Param("ew") Wrapper<ZhiyuanzheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiyuanzheEntity> wrapper);
   	

}

