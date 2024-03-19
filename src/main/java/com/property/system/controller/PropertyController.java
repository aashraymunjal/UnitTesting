package com.property.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.property.system.model.PropertyDTO;
import com.property.system.service.PropertyService;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

	@Autowired
	private PropertyService service;

	@PostMapping("/properties")
	public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO property) {
		PropertyDTO dto = service.saveProperty(property);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	@GetMapping("/properties")
	public ResponseEntity<List<PropertyDTO>> getAllProperties() {
		List<PropertyDTO> list = service.getAllProperties();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PutMapping("/properties/{id}")
	public ResponseEntity<PropertyDTO> updateRepo(@RequestBody PropertyDTO dto, @PathVariable("id") int id) {
		service.updateProperty(dto, id);
		return new ResponseEntity<>(dto, HttpStatus.MOVED_PERMANENTLY);
	}

	@DeleteMapping("/properties/delete/{id}")
	public ResponseEntity delete(@PathVariable("id") int id) {
		service.deleteProperty(id);
		return new ResponseEntity(null, HttpStatus.OK);
	}

}
