package com.cibertec.mstarjetas.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public record TarjetaRequest(
		@JsonProperty("nom_titular")
		@JsonAlias("nomTitular")
		String nomTitular,

		@JsonProperty("saldo_asignado")
		@JsonAlias("saldoAsignado")
		Double saldoAsignado,

		@JsonProperty("saldo_disponible")
		@JsonAlias("saldoDisponible")
		Double saldoDisponible
) {
}
