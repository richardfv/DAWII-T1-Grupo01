package com.cibertec.msriesgo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record AnalisisResponse(
		@JsonProperty("id_analisis")
		Long idAnalisis,

		@JsonProperty("id_recarga")
		Long idRecarga,

		@JsonProperty("id_tarjeta")
		Long idTarjeta,

		@JsonProperty("saldo_disponible")
		Double saldoDisponible,

		@JsonProperty("monto_recarga")
		Double montoRecarga,

		@JsonProperty("fecha_recarga")
		LocalDateTime fechaRecarga,

		@JsonProperty("situacion")
		String situacion
) {
}
