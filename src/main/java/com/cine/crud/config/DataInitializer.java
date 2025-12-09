package com.cine.crud.config;

import com.cine.crud.modelo.Usuario;
import com.cine.crud.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public void run(String... args) throws Exception {
        logger.info("--- VERIFICANDO USUARIOS ---");
        Usuario admin = usuarioRepositorio.findByUsername("admin");

        if (admin == null) {
            admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword("admin"); // Contraseña plana para NoOpPasswordEncoder
            admin.setRol("ADMIN");
            usuarioRepositorio.save(admin);
            logger.info(">>> Usuario 'admin' creado con contraseña 'admin'");
        } else {
            logger.info(">>> Usuario 'admin' ya existe. Contraseña en BD: {}", admin.getPassword());
        }
        logger.info("----------------------------");
    }
}
