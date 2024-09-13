package com.sanchez.infraccionservice.validator;

import java.math.BigDecimal;
import java.util.Date;

import com.sanchez.infraccionservice.entity.Infraccion;
import com.sanchez.infraccionservice.exceptions.ValidateServiceException;

public class InfraccionValidator {

	public static void save(Infraccion infraccion) {
		if(infraccion.getDni() == null || infraccion.getDni().isEmpty()) {
			throw new ValidateServiceException("El dni es requerido");
		}
		if(infraccion.getDni().length() != 8) {
			throw new ValidateServiceException("El dni debe ser de 8 digitos");
		}
		if(infraccion.getFecha() == null) {
			throw new ValidateServiceException("La fecha es requerida");
		}
		if(infraccion.getFecha().before(new Date())) {
			throw new ValidateServiceException("La fecha no puede ser en el pasado");
		}
		if(infraccion.getTipoInfraccion() == null || infraccion.getTipoInfraccion().isEmpty()) {
			throw new ValidateServiceException("El tipo de infraccion es requerido");
		}
		if(infraccion.getUbicacion() == null || infraccion.getUbicacion().isEmpty()) {
			throw new ValidateServiceException("La ubicacion es requerida");
		}
		if(infraccion.getMontoMulta() == null) {
			throw new ValidateServiceException("EL monto de la multa es requerido");
		}
		if(infraccion.getMontoMulta().compareTo(BigDecimal.ZERO) <= 0) {
			throw new ValidateServiceException("EL monto de la multa debe ser un valor positivo");
		}
	}
}