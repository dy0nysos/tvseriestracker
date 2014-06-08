package src.tool;

import org.springframework.context.ApplicationContext;

public class BeanProvider {
	public static ApplicationContext applicationContext;
	
	public static Object getBean(String beanName){
		return applicationContext.getBean(beanName);
	}
}
