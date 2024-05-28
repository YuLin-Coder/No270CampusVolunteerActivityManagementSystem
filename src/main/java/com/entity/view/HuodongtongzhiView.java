package com.entity.view;

import com.entity.HuodongtongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 活动通知
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@TableName("huodongtongzhi")
public class HuodongtongzhiView  extends HuodongtongzhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuodongtongzhiView(){
	}
 
 	public HuodongtongzhiView(HuodongtongzhiEntity huodongtongzhiEntity){
 	try {
			BeanUtils.copyProperties(this, huodongtongzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
