package com.cibertec.mstarjetas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TarjetaResponse(
		@JsonProperty("id_tarjeta")
		Long idTarjeta,

		@JsonProperty("nom_titular")
		String nomTitular,

		@JsonProperty("saldo_asignado")
		Double saldoAsignado,

		@JsonProperty("saldo_disponible")
		Double saldoDisponible
) {
}
