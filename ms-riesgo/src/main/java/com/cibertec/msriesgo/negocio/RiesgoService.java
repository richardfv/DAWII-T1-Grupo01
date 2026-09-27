package com.cibertec.msriesgo.negocio;

import com.cibertec.msriesgo.dto.AnalisisResponse;
import com.cibertec.msriesgo.dto.RecargaMensaje;
import com.cibertec.msriesgo.entidades.Analisis;
import com.cibertec.msriesgo.repositorio.AnalisisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RiesgoService {

	private static final String APROBADA = "Aprobada";
	private static final String OBSERVADA = "Observada";
	private static final double UMBRAL = 0.70;

	private final AnalisisRepository analisisRepository;

	public RiesgoService(AnalisisRepository analisisRepository) {
		this.analisisRepository = analisisRepository;
	}

	@Transactional
	public AnalisisResponse analizarRecarga(RecargaMensaje mensaje) {
		Analisis analisis = Analisis.builder()
				.idRecarga(mensaje.idRecarga())
				.idTarjeta(mensaje.idTarjeta())
				.saldoDisponible(mensaje.saldoDisponible())
				.montoRecarga(mensaje.montoRecarga())
				.fechaRecarga(mensaje.fechaRecarga())
				.situacion(evaluarSituacion(mensaje.montoRecarga(), mensaje.saldoDisponible()))
				.build();

		Analisis guardado = analisisRepository.save(analisis);
		return mapToResponse(guardado);
	}

	public List<AnalisisResponse> listarAnalisis() {
		return analisisRepository.findAll().stream()
				.map(this::mapToResponse)
				.toList();
	}

	private String evaluarSituacion(Double montoRecarga, Double saldoDisponible) {
		double monto = montoRecarga == null ? 0.0 : montoRecarga;
		double saldo = saldoDisponible == null ? 0.0 : saldoDisponible;
		double limite = saldo * UMBRAL;
		return monto > limite ? OBSERVADA : APROBADA;
	}

	private AnalisisResponse mapToResponse(Analisis analisis) {
		return new AnalisisResponse(
				analisis.getIdAnalisis(),
				analisis.getIdRecarga(),
				analisis.getIdTarjeta(),
				analisis.getSaldoDisponible(),
				analisis.getMontoRecarga(),
				analisis.getFechaRecarga(),
				analisis.getSituacion()
		);
	}
}
