package com.cibertec.mstarjetas.negocio;

import com.cibertec.mstarjetas.dto.TarjetaRequest;
import com.cibertec.mstarjetas.dto.TarjetaResponse;
import com.cibertec.mstarjetas.entidades.Tarjeta;
import com.cibertec.mstarjetas.repositorio.TarjetaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TarjetaService {

	private final TarjetaRepository tarjetaRepository;

	public TarjetaService(TarjetaRepository tarjetaRepository) {
		this.tarjetaRepository = tarjetaRepository;
	}

	public List<TarjetaResponse> listarTarjetas() {
		return tarjetaRepository.findAll().stream()
				.map(this::mapToResponse)
				.toList();
	}

	public TarjetaResponse obtenerPorId(Long id) {
		Tarjeta tarjeta = tarjetaRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarjeta no encontrada con id: " + id));
		return mapToResponse(tarjeta);
	}

	public TarjetaResponse registrarTarjeta(TarjetaRequest request) {
		Tarjeta tarjeta = Tarjeta.builder()
				.nomTitular(request.nomTitular())
				.saldoAsignado(request.saldoAsignado())
				.saldoDisponible(request.saldoDisponible())
				.build();

		Tarjeta guardada = tarjetaRepository.save(tarjeta);
		return mapToResponse(guardada);
	}

	private TarjetaResponse mapToResponse(Tarjeta tarjeta) {
		return new TarjetaResponse(
				tarjeta.getIdTarjeta(),
				tarjeta.getNomTitular(),
				tarjeta.getSaldoAsignado(),
				tarjeta.getSaldoDisponible()
		);
	}
}
