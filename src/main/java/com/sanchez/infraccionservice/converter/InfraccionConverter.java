package com.sanchez.infraccionservice.converter;

import org.springframework.stereotype.Component;

import com.sanchez.infraccionservice.dto.InfraccionDTO;
import com.sanchez.infraccionservice.entity.Infraccion;

@Component
public class InfraccionConverter extends AbstractConverter<Infraccion, InfraccionDTO>{

	@Override
	public InfraccionDTO fromEntity(Infraccion entity) {
		if(entity == null) return null;
		return InfraccionDTO.builder()
				.id(entity.getId())
				.dni(entity.getDni())
				.fecha(entity.getFecha())
				.tipoInfraccion(entity.getTipoInfraccion())
				.descripcion(entity.getDescripcion())
				.montoMulta(entity.getMontoMulta())
				.activo(entity.getActivo())
				.build();
	}

	@Override
	public Infraccion fromDTO(InfraccionDTO dto) {
		if(dto == null) return null;
		return Infraccion.builder()
				.id(dto.getId())
				.dni(dto.getDni())
				.fecha(dto.getFecha())
				.tipoInfraccion(dto.getTipoInfraccion())
				.descripcion(dto.getDescripcion())
				.montoMulta(dto.getMontoMulta())
				.activo(dto.getActivo())
				.build();
	}

}
