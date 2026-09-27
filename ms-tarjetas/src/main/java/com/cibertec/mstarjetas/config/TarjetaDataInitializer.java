package com.cibertec.mstarjetas.config;

import com.cibertec.mstarjetas.entidades.Tarjeta;
import com.cibertec.mstarjetas.repositorio.TarjetaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TarjetaDataInitializer implements CommandLineRunner {

	private final TarjetaRepository tarjetaRepository;

	public TarjetaDataInitializer(TarjetaRepository tarjetaRepository) {
		this.tarjetaRepository = tarjetaRepository;
	}

	@Override
	public void run(String... args) {
		if (tarjetaRepository.count() == 0) {
			List<Tarjeta> semillas = List.of(
					Tarjeta.builder()
							.nomTitular("Richard Falcon")
							.saldoAsignado(1500.0)
							.saldoDisponible(1000.0)
							.build(),
					Tarjeta.builder()
							.nomTitular("Juan Perez")
							.saldoAsignado(800.0)
							.saldoDisponible(500.0)
							.build(),
					Tarjeta.builder()
							.nomTitular("Maria Lopez")
							.saldoAsignado(2000.0)
							.saldoDisponible(1800.0)
							.build()
			);

			tarjetaRepository.saveAll(semillas);
		}
	}
}
