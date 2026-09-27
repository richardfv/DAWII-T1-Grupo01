package com.cibertec.msriesgo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record RecargaMensaje(
		@JsonProperty("id_recarga")
		@JsonAlias("idRecarga")
		Long idRecarga,

		@JsonProperty("id_tarjeta")
		@JsonAlias("idTarjeta")
		Long idTarjeta,

		@JsonProperty("saldo_disponible")
		@JsonAlias("saldoDisponible")
		Double saldoDisponible,

		@JsonProperty("monto_recarga")
		@JsonAlias("montoRecarga")
		Double montoRecarga,

		@JsonProperty("fecha_recarga")
		@JsonAlias("fechaRecarga")
		LocalDateTime fechaRecarga
) {
}
