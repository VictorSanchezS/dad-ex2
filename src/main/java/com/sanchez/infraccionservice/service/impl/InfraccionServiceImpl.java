package com.sanchez.infraccionservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchez.infraccionservice.entity.Infraccion;
import com.sanchez.infraccionservice.exceptions.GeneralServiceException;
import com.sanchez.infraccionservice.exceptions.NoDataFoundException;
import com.sanchez.infraccionservice.exceptions.ValidateServiceException;
import com.sanchez.infraccionservice.repository.InfraccionRepository;
import com.sanchez.infraccionservice.service.InfraccionService;
import com.sanchez.infraccionservice.validator.InfraccionValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InfraccionServiceImpl implements InfraccionService{
	
	@Autowired
	private InfraccionRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Infraccion> findAll(Pageable page) {
		try {
			return repository.findAll(page).toList();
		}catch(NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Infraccion> findByDni(String dni, Pageable page) {
		try {
			return repository.findByDniContaining(dni, page);
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(),e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Infraccion findById(int id) {
		try {
			Infraccion infraccion = repository.findById(id).orElseThrow(()->new NoDataFoundException("No existe un registro con ese ID"));
			return infraccion;
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public Infraccion save(Infraccion infraccion) {
		try {
			InfraccionValidator.save(infraccion);
			//if(repository.findByDni(infraccion.getDni()) != null) {
				//throw new ValidateServiceException("Ya existe un registro con este DNI"+infraccion.getDni());
			//}
			infraccion.setActivo(true);
			Infraccion registro = repository.save(infraccion);
			return registro;
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public Infraccion update(Infraccion infraccion) {
		try {
			InfraccionValidator.save(infraccion);
			Infraccion registro = repository.findById(infraccion.getId()).orElseThrow(()->new NoDataFoundException("No existe un registro con ese ID"));
			registro.setDni(infraccion.getDni());
			registro.setTipoInfraccion(infraccion.getTipoInfraccion());
			registro.setUbicacion(infraccion.getUbicacion());
			registro.setDescripcion(infraccion.getDescripcion());
			registro.setMontoMulta(infraccion.getMontoMulta());
			registro.setActivo(infraccion.getActivo());
			repository.save(registro);
			return registro;
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		try {
			Infraccion registro = repository.findById(id).orElseThrow(()-> new NoDataFoundException("No existe un registro con ese ID"));
			repository.delete(registro);
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	
}
