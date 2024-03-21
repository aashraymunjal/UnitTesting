package com.property.system.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.system.converter.PropertyConverter;
import com.property.system.entity.PropertyEntity;
import com.property.system.model.PropertyDTO;
import com.property.system.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository repo;
	@Autowired
	PropertyConverter converting;

	@Override
	public PropertyDTO saveProperty(PropertyDTO property) {
		PropertyEntity pe = converting.convertDTOtoEntity(property);
		pe = repo.save(pe);
		PropertyDTO dto = converting.convertEntityToDTO(pe);
		return dto;
	}

	@Override
	public List<PropertyDTO> getAllProperties() {
		List<PropertyEntity> list = repo.findAll();
		List<PropertyDTO> list1 = new ArrayList<>();
		for (PropertyEntity pe : list) {
			PropertyDTO dto = converting.convertEntityToDTO(pe);
			list1.add(dto);
		}
		return list1;
	}

	@Override
	public PropertyDTO updateProperty(PropertyDTO dto, int PropertyId) {
		PropertyDTO UpdatedDTO = new PropertyDTO();
		Optional<PropertyEntity> entity = repo.findById(PropertyId);
		if (entity.isPresent()) {
			PropertyEntity pe = entity.get();
			pe.setTitle(dto.getTitle());
			pe.setAddress(dto.getAddress());
			pe.setDescription(dto.getDescription());
			pe.setOnwerName(dto.getOnwerName());
			pe.setOwnerEmail(dto.getOwnerEmail());
			pe.setPrice(dto.getPrice());
			pe.setId(dto.getId());
			repo.save(pe);

			UpdatedDTO = converting.convertEntityToDTO(pe);
		}
		return UpdatedDTO;
	}

	@Override
	public void deleteProperty(int id) {
		repo.deleteById(id);

	}

}
