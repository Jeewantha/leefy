/**
 * 
 */
package com.jeesoft.business.beans.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author Jeewantha
 *
 */
public class CustomeBeanFactoryPostProcessor implements
		BeanFactoryPostProcessor {
	

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 */
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {

		System.out.println("Bean Factory Processor is at work...@@@@@@@@@@@@@@@@@@@@");
		
	}

}
