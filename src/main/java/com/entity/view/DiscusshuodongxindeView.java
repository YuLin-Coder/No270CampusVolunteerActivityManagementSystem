package com.entity.view;

import com.entity.DiscusshuodongxindeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 活动心得评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@TableName("discusshuodongxinde")
public class DiscusshuodongxindeView  extends DiscusshuodongxindeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusshuodongxindeView(){
	}
 
 	public DiscusshuodongxindeView(DiscusshuodongxindeEntity discusshuodongxindeEntity){
 	try {
			BeanUtils.copyProperties(this, discusshuodongxindeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
