package com.cine.crud.repositorio;

import com.cine.crud.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
}
