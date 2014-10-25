/**
 * 
 */
package com.jeesoft.business.beans.processors;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author Jeewantha
 *
 */
public class CustomeBeanFactoryPostProcessor implements
		BeanFactoryPostProcessor {
	
	private Logger log = Logger.getLogger(CustomeBeanFactoryPostProcessor.class); 
	

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 */
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		log.info("Calling the bean factory post processer!!!");

		log.info("Bean Factory Processor is at work...@@@@@@@@@@@@@@@@@@@@");
		log.info("Get the bean properties :");
		log.info("Bean Count : "+beanFactory.getBeanDefinitionCount());
		log.info("Beans : "+beanFactory.getBeanPostProcessorCount());
		
	}

}
