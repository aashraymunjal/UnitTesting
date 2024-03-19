package com.property.system.service;

import java.util.List;

import com.property.system.model.PropertyDTO;

public interface PropertyService {

	public PropertyDTO saveProperty(PropertyDTO property);

	public List<PropertyDTO> getAllProperties();

	public PropertyDTO updateProperty(PropertyDTO dto, int PropertyId);

	public void deleteProperty(int id);
}
