package com.cibertec.mstarjetas.entidades;

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

@Entity
@Table(name = "tarjetas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarjeta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tarjeta")
	private Long idTarjeta;

	@Column(name = "nom_titular", nullable = false, length = 120)
	private String nomTitular;

	@Column(name = "saldo_asignado", nullable = false)
	private Double saldoAsignado;

	@Column(name = "saldo_disponible", nullable = false)
	private Double saldoDisponible;
}
