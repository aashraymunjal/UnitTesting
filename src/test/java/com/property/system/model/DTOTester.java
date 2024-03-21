package com.property.system.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

import com.property.system.entity.PropertyEntity;

@ExtendWith(MockitoExtension.class)
class DTOTester {

	@Test
	public void testMyBean() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(PropertyEntity.class);
		beanTester.testBean(PropertyDTO.class);
	}

}
