package com.paygo.recargas.client;

import com.paygo.recargas.dto.TarjetaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-tarjetas", url = "${feign.tarjetas.url}")
public interface TarjetaClient {

    @GetMapping("/tarjetas/{id}")
    TarjetaDTO obtenerTarjetaPorId(@PathVariable("id") Long id);
}
