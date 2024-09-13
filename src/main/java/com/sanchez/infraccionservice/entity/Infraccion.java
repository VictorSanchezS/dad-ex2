package com.sanchez.infraccionservice.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "infracciones")
public class Infraccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 8)
	private String dni;
	
	@Column(nullable = false)
	private Date fecha;
	
	@Column(name = "tipo_infraccion",nullable = false, length = 20)
	private String tipoInfraccion;
	
	@Column(nullable = false, length = 200)
	private String ubicacion;
	
	@Column(nullable = true, length = 255)
	private String descripcion;
	
	@Column(name = "monto_multa", nullable = false, precision = 8, scale = 2)
	private BigDecimal montoMulta;
	
	@Column(nullable = false)
	private Boolean activo;
	
	@Column(name = "created_at", nullable = false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
}
