package com.cibertec.msriesgo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "analisis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Analisis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_analisis")
	private Long idAnalisis;

	@Column(name = "id_recarga", nullable = false)
	private Long idRecarga;

	@Column(name = "id_tarjeta", nullable = false)
	private Long idTarjeta;

	@Column(name = "saldo_disponible", nullable = false)
	private Double saldoDisponible;

	@Column(name = "monto_recarga", nullable = false)
	private Double montoRecarga;

	@Column(name = "fecha_recarga", nullable = false)
	private LocalDateTime fechaRecarga;

	@Column(name = "situacion", nullable = false, length = 20)
	private String situacion;
}
