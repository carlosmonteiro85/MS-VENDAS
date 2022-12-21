package com.prototype.core.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class MapperConverter {
	
	@Autowired
	ModelMapper modelMapper;
	
	public <D, E> D entidadeToDto(E entidade, Class<D> dto) {
		return modelMapper.map(entidade, dto);
	}
	
	public <E, D> E dtoToentidade(D dto, Class<E> entidade) {
		return modelMapper.map(dto, entidade);
	}
	
	public <D, E> void copy(D dto, E entidade) {
		modelMapper.map(dto, entidade);
	}
	
	public <D, E> List<D> colectionDto(List<E> listEntities, Class<D> dtoClass ){
		return listEntities.stream().map(l -> entidadeToDto(l, dtoClass)).collect(Collectors.toList());
	}
	
	public <E, D> List<E> colectionEntity(List<D> listDto, Class<E> entityClass ){
		return listDto.stream().map(l -> dtoToentidade(l, entityClass)).collect(Collectors.toList());
	}
	

	public <D, E> Page<D> colectionPageDto(Page<E> entities, Class<D> dtoClass ){
		return entities.map(o -> modelMapper.map(o, dtoClass));
	}
	
	public <E, D> Page<E> colectionPageEntity(Page<D> classDto, Class<E> entityClass ){
		return classDto.map(o -> modelMapper.map(o, entityClass));
	}
}
