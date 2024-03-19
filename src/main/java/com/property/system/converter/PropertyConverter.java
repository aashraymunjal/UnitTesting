package com.property.system.converter;

import org.springframework.stereotype.Component;

import com.property.system.entity.PropertyEntity;
import com.property.system.model.PropertyDTO;

@Component
public class PropertyConverter {

	public PropertyEntity convertDTOtoEntity(PropertyDTO property) {
		PropertyEntity pe = new PropertyEntity();
		pe.setTitle(property.getTitle());
		pe.setAddress(property.getAddress());
		pe.setDescription(property.getDescription());
		pe.setOnwerName(property.getOnwerName());
		pe.setOwnerEmail(property.getOwnerEmail());
		pe.setPrice(property.getPrice());
		return pe;
	}

	public PropertyDTO convertEntityToDTO(PropertyEntity property) {
		PropertyDTO dto = new PropertyDTO();
		dto.setTitle(property.getTitle());
		dto.setAddress(property.getAddress());
		dto.setDescription(property.getDescription());
		dto.setOnwerName(property.getOnwerName());
		dto.setOwnerEmail(property.getOwnerEmail());
		dto.setPrice(property.getPrice());
		return dto;

	}
}
