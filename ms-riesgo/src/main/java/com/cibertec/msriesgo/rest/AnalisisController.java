package com.cibertec.msriesgo.rest;

import com.cibertec.msriesgo.dto.AnalisisResponse;
import com.cibertec.msriesgo.negocio.RiesgoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analisis")
public class AnalisisController {

	private final RiesgoService riesgoService;

	public AnalisisController(RiesgoService riesgoService) {
		this.riesgoService = riesgoService;
	}

	@GetMapping
	public List<AnalisisResponse> listarAnalisis() {
		return riesgoService.listarAnalisis();
	}
}
