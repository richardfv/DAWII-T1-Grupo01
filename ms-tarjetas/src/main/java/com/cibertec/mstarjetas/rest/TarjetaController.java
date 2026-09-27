package com.cibertec.mstarjetas.rest;

import com.cibertec.mstarjetas.dto.TarjetaRequest;
import com.cibertec.mstarjetas.dto.TarjetaResponse;
import com.cibertec.mstarjetas.negocio.TarjetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {

	private final TarjetaService tarjetaService;

	public TarjetaController(TarjetaService tarjetaService) {
		this.tarjetaService = tarjetaService;
	}

	@GetMapping
	public List<TarjetaResponse> listarTarjetas() {
		return tarjetaService.listarTarjetas();
	}

	@GetMapping("/{id}")
	public TarjetaResponse obtenerPorId(@PathVariable Long id) {
		return tarjetaService.obtenerPorId(id);
	}

	@PostMapping
	public ResponseEntity<TarjetaResponse> registrarTarjeta(@RequestBody TarjetaRequest request) {
		TarjetaResponse response = tarjetaService.registrarTarjeta(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
