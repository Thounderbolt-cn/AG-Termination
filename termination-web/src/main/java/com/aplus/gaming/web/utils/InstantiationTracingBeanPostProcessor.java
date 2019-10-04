package com.aplus.gaming.web.utils;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


/**
 * spring容器启动完毕之后，执行一些初始化的工作 
 * @author shanchanghai
 */
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

	/**
	 * 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
	 */
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
	      if (event.getApplicationContext().getParent() == null) {
	    	  
	      }
	  }
	
}
