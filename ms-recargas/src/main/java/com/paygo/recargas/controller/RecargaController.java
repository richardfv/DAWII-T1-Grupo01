package com.paygo.recargas.controller;

import com.paygo.recargas.dto.RecargaRequest;
import com.paygo.recargas.entity.Recarga;
import com.paygo.recargas.service.RecargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recargas")
public class RecargaController {

    @Autowired
    private RecargaService recargaService;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody RecargaRequest request) {
        try {
            Recarga recarga = recargaService.registrar(request);
            return new ResponseEntity<>(recarga, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Recarga>> listar() {
        return ResponseEntity.ok(recargaService.listarTodas());
    }
}
