package com.entity.view;

import com.entity.HuodongxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 活动信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@TableName("huodongxinxi")
public class HuodongxinxiView  extends HuodongxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuodongxinxiView(){
	}
 
 	public HuodongxinxiView(HuodongxinxiEntity huodongxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, huodongxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
