package com.paygo.recargas.service;

import com.paygo.recargas.client.TarjetaClient;
import com.paygo.recargas.config.RabbitMQConfig;
import com.paygo.recargas.dto.RecargaRequest;
import com.paygo.recargas.dto.TarjetaDTO;
import com.paygo.recargas.entity.Recarga;
import com.paygo.recargas.repository.RecargaRepository;
import feign.FeignException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecargaService {

    @Autowired
    private RecargaRepository recargaRepository;

    @Autowired
    private TarjetaClient tarjetaClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Recarga registrar(RecargaRequest request) {
        // Comunicación síncrona con OpenFeign
        TarjetaDTO tarjeta;
        try {
            tarjeta = tarjetaClient.obtenerTarjetaPorId(request.getIdTarjeta());
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("La tarjeta con id " + request.getIdTarjeta() + " no existe");
        } catch (FeignException e) {
            throw new RuntimeException("Error al comunicarse con el servicio de tarjetas: " + e.getMessage());
        }

        if (tarjeta == null) {
            throw new RuntimeException("La tarjeta con id " + request.getIdTarjeta() + " no existe");
        }

        // Crear la recarga con el saldo disponible obtenido del servicio de tarjetas
        Recarga recarga = new Recarga();
        recarga.setIdTarjeta(request.getIdTarjeta());
        recarga.setSaldoDisponible(tarjeta.getSaldoDisponible());
        recarga.setMontoRecarga(request.getMontoRecarga());
        recarga.setFechaRecarga(LocalDateTime.now()); // Fecha generada automáticamente

        Recarga guardada = recargaRepository.save(recarga);

        // Publicar mensaje asíncrono a la cola apellido_Queue (Pregunta 2)
        rabbitTemplate.convertAndSend(RabbitMQConfig.COLA_APELLIDO, guardada);

        return guardada;
    }

    public List<Recarga> listarTodas() {
        return recargaRepository.findAll();
    }
}
