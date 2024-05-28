package com.entity.view;

import com.entity.HuodongxindeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 活动心得
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@TableName("huodongxinde")
public class HuodongxindeView  extends HuodongxindeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuodongxindeView(){
	}
 
 	public HuodongxindeView(HuodongxindeEntity huodongxindeEntity){
 	try {
			BeanUtils.copyProperties(this, huodongxindeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
