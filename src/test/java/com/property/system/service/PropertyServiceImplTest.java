package com.property.system.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.property.system.converter.PropertyConverter;
import com.property.system.entity.PropertyEntity;
import com.property.system.model.PropertyDTO;
import com.property.system.repository.PropertyRepository;

@ExtendWith(MockitoExtension.class)
class PropertyServiceImplTest {

	@InjectMocks
	PropertyServiceImpl service;

	@Mock
	PropertyRepository repo;
	@Mock
	PropertyConverter converter;

	@Test
	@DisplayName("test for save property")
	void testSavePropertySuccess() {
		PropertyDTO dto = new PropertyDTO();
		dto.setTitle("first");

		PropertyEntity entity = new PropertyEntity();
		entity.setTitle("first");

		PropertyEntity savedentity = new PropertyEntity();
		savedentity.setTitle("first");
		savedentity.setId(1);

		PropertyDTO dto1 = new PropertyDTO();
		dto1.setTitle("first");
		dto1.setId(1);

		Mockito.when(converter.convertDTOtoEntity(Mockito.any())).thenReturn(entity);
		Mockito.when(repo.save(Mockito.any())).thenReturn(savedentity);
		Mockito.when(converter.convertEntityToDTO(Mockito.any())).thenReturn(dto1);

		PropertyDTO saved = service.saveProperty(dto);
		Assertions.assertEquals(1, saved.getId());
		Assertions.assertEquals(dto.getTitle(), saved.getTitle());

	}

	@Test
	@DisplayName("test for get all props")
	void testGetAllProperties() {

		List<PropertyEntity> savedEntities = new ArrayList<>();
		PropertyEntity e1 = new PropertyEntity();
		e1.setTitle("first");
		savedEntities.add(e1);

		PropertyDTO dto1 = new PropertyDTO();
		dto1.setTitle("first");

		Mockito.when(repo.findAll()).thenReturn(savedEntities);
		Mockito.when(converter.convertEntityToDTO(Mockito.any())).thenReturn(dto1);

		List<PropertyDTO> savedprops = service.getAllProperties();
		Assertions.assertEquals(savedprops.get(0).getTitle(), savedEntities.get(0).getTitle());
		Assertions.assertEquals(savedprops.size(), 1);

	}

	@Test
	void testUpdateProperty() {

		PropertyDTO newdto = new PropertyDTO();
		newdto.setId(1);
		newdto.setTitle("new value");

		PropertyEntity savedEntity = new PropertyEntity();
		savedEntity.setTitle("old value");
		savedEntity.setId(0);
		Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.of(savedEntity));
		Mockito.when(converter.convertEntityToDTO(savedEntity)).thenReturn(newdto);

		PropertyDTO Updatedvalue = service.updateProperty(newdto, 1);
		Assertions.assertEquals(newdto.getId(), Updatedvalue.getId());
	}
}
