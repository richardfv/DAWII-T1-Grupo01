package com.paygo.recargas.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaDTO {
    @JsonProperty("id_tarjeta")
    @JsonAlias("idTarjeta")
    private Long idTarjeta;

    @JsonProperty("nom_titular")
    @JsonAlias("nomTitular")
    private String nomTitular;

    @JsonProperty("saldo_asignado")
    @JsonAlias("saldoAsignado")
    private Double saldoAsignado;

    @JsonProperty("saldo_disponible")
    @JsonAlias("saldoDisponible")
    private Double saldoDisponible;
}
