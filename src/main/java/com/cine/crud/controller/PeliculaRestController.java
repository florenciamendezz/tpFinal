package com.cine.crud.controller;

import com.cine.crud.modelo.Pelicula;
import com.cine.crud.servicio.PeliculaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaRestController {

    private final PeliculaServicio servicio;

    public PeliculaRestController(PeliculaServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Pelicula> listar() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Pelicula obtener(@PathVariable int id) {
        return servicio.obtenerPorId(id);
    }
}
