package com.property.system.converter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.property.system.entity.PropertyEntity;
import com.property.system.model.PropertyDTO;

@ExtendWith(MockitoExtension.class)

class PropertyConverterTest {

	@InjectMocks
	private PropertyConverter converter;

	@Test
	void testConvertDTOtoEntity_Success() {
		PropertyDTO dto = new PropertyDTO();
		dto.setAddress("aaa");
		dto.setDescription("b");
		PropertyEntity entity = converter.convertDTOtoEntity(dto);
		Assertions.assertEquals(dto.getAddress(), entity.getAddress());
		Assertions.assertEquals(dto.getDescription(), entity.getDescription());
	}

	@Test
	void testConvertEntityToDTO_Success() {
		PropertyEntity entity = new PropertyEntity();
		entity.setAddress("aaa");
		entity.setDescription("b");
		PropertyDTO dto = converter.convertEntityToDTO(entity);
		Assertions.assertEquals(dto.getAddress(), entity.getAddress());
		Assertions.assertEquals(dto.getDescription(), entity.getDescription());
	}

}
