package com.notsocomplex.singleton;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = SpringSingletonTest.class)
@Configuration
@ComponentScan(basePackages = "com.notsocomplex.singleton")
public class SpringSingletonTest {

	@Autowired
	private SpringSingleton injectedSingleton;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void testSpringBeanIsSingleton() throws Exception {
				
		SpringSingleton firstCallSingleton = applicationContext.getBean(SpringSingleton.class);
		SpringSingleton secondCallSingleton = applicationContext.getBean(SpringSingleton.class);		
		SpringSingleton thirdCallSingleton = applicationContext.getBean("springSingleton", SpringSingleton.class);
		
		Assert.assertTrue(injectedSingleton == firstCallSingleton);
		Assert.assertTrue(injectedSingleton == secondCallSingleton);
		Assert.assertTrue(injectedSingleton == thirdCallSingleton);
		Assert.assertTrue(firstCallSingleton == secondCallSingleton);
		Assert.assertTrue(firstCallSingleton == thirdCallSingleton);
		Assert.assertTrue(secondCallSingleton == thirdCallSingleton);
		
		Assert.assertEquals(injectedSingleton, firstCallSingleton);
		Assert.assertEquals(injectedSingleton, secondCallSingleton);
		Assert.assertEquals(injectedSingleton, thirdCallSingleton);
		Assert.assertEquals(firstCallSingleton, secondCallSingleton);
		Assert.assertEquals(firstCallSingleton, thirdCallSingleton);
		Assert.assertEquals(secondCallSingleton, thirdCallSingleton);		
	}
	
}