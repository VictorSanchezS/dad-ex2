package com.sanchez.infraccionservice.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfraccionDTO {
	private int id;
	private String dni;
	private Date fecha;
	private String tipoInfraccion;
	private String descripcion;
	private BigDecimal montoMulta;
	private Boolean activo;
}
