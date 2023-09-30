package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.services.TrocaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/troca")
public class TrocaController {

    private TrocaRepository repository;

    @GetMapping
public ResponseEntity getProducts() {
    return ResponseEntity.ok("Deu ok");
}


}
