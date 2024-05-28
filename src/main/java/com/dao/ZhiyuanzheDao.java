package com.dao;

import com.entity.ZhiyuanzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhiyuanzheVO;
import com.entity.view.ZhiyuanzheView;


/**
 * 志愿者
 * 
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface ZhiyuanzheDao extends BaseMapper<ZhiyuanzheEntity> {
	
	List<ZhiyuanzheVO> selectListVO(@Param("ew") Wrapper<ZhiyuanzheEntity> wrapper);
	
	ZhiyuanzheVO selectVO(@Param("ew") Wrapper<ZhiyuanzheEntity> wrapper);
	
	List<ZhiyuanzheView> selectListView(@Param("ew") Wrapper<ZhiyuanzheEntity> wrapper);

	List<ZhiyuanzheView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanzheEntity> wrapper);
	
	ZhiyuanzheView selectView(@Param("ew") Wrapper<ZhiyuanzheEntity> wrapper);
	

}
