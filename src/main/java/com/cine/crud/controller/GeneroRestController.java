package com.cine.crud.controller;

import com.cine.crud.modelo.Genero;
import com.cine.crud.servicio.GeneroServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroRestController {

    private final GeneroServicio servicio;

    public GeneroRestController(GeneroServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Genero> listar() {
        return servicio.obtenerTodos();
    }
}
