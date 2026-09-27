package com.paygo.recargas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecargaRequest {
    private Long idTarjeta;
    private Double montoRecarga;
}
