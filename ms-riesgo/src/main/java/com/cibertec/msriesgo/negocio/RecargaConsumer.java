package com.cibertec.msriesgo.negocio;

import com.cibertec.msriesgo.dto.AnalisisResponse;
import com.cibertec.msriesgo.dto.RecargaMensaje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RecargaConsumer {

	private static final Logger log = LoggerFactory.getLogger(RecargaConsumer.class);
	public static final String COLA_GRUPO01 = "grupo01_Queue";

	private final RiesgoService riesgoService;

	public RecargaConsumer(RiesgoService riesgoService) {
		this.riesgoService = riesgoService;
	}

	@RabbitListener(queues = COLA_GRUPO01)
	public void procesarRecarga(RecargaMensaje mensaje) {
		log.info("Recarga recibida de la cola {}: id_recarga={}, monto={}", COLA_GRUPO01, mensaje.idRecarga(), mensaje.montoRecarga());
		AnalisisResponse resultado = riesgoService.analizarRecarga(mensaje);
		log.info("Analisis guardado: id_analisis={}, situacion={}", resultado.idAnalisis(), resultado.situacion());
	}
}
