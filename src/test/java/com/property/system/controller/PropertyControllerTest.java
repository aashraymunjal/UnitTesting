package com.property.system.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.property.system.model.PropertyDTO;
import com.property.system.service.PropertyService;

@ExtendWith(MockitoExtension.class)
class PropertyControllerTest {

	@InjectMocks // creates proxy object and inject it in test file
	private PropertyController controller;

	@Mock
	private PropertyService service;

	@Test
	@DisplayName("Test success scene for saving property")
	void testSaveProperty() {

		PropertyDTO property = new PropertyDTO();
		property.setDescription("yolo");

		Mockito.when(service.saveProperty(property)).thenReturn(property);

		ResponseEntity<PropertyDTO> response = controller.saveProperty(property);
		Assertions.assertNotNull(response.getBody().getDescription());
		Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
	}

	@Test
	@DisplayName("fetching all properties test")
	void testGetProperties() {
		List<PropertyDTO> savedList = new ArrayList<>();
		PropertyDTO test1 = new PropertyDTO();
		savedList.add(test1);
		Mockito.when(service.getAllProperties()).thenReturn(savedList);

		ResponseEntity<List<PropertyDTO>> response = controller.getAllProperties();
		Assertions.assertNotNull(response.getBody());
		Assertions.assertEquals(1, response.getBody().size());
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());

	}

	@Test
	@DisplayName("test for delete mapping")
	void testDeleteProperty() {
		PropertyDTO property = new PropertyDTO();
		property.setId(1);

		Mockito.doNothing().when(service).deleteProperty(property.getId());

		ResponseEntity res = controller.delete(property.getId());
		Assertions.assertNull(res.getBody());
		Assertions.assertEquals(HttpStatus.OK.value(), res.getStatusCodeValue());

	}

	@Test
	@DisplayName("test for update mapping")
	void testUpdateMethod() {
		PropertyDTO dto = new PropertyDTO();
		dto.setDescription("another");
		dto.setId(1);

		PropertyDTO newDTO = new PropertyDTO();
		newDTO.setId(1);
		newDTO.setDescription("changed");

		Mockito.when(service.updateProperty(newDTO, 1)).thenReturn(newDTO);

		ResponseEntity<PropertyDTO> res = controller.updateRepo(newDTO, dto.getId());
		Assertions.assertEquals("changed", res.getBody().getDescription());
		Assertions.assertEquals(1, res.getBody().getId());
		Assertions.assertEquals(HttpStatus.MOVED_PERMANENTLY.value(), res.getStatusCodeValue());
		

	}

}
