package com.cine.crud.servicio;

import com.cine.crud.modelo.Usuario;
import com.cine.crud.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Intentando loguear usuario: {}", username);
        Usuario usuario = usuarioRepositorio.findByUsername(username);

        if (usuario == null) {
            logger.error("Usuario no encontrado en BD: {}", username);
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        logger.info("Usuario encontrado: {}", usuario.getUsername());
        logger.info("Contraseña en BD: {}", usuario.getPassword());
        logger.info("Rol en BD: {}", usuario.getRol());

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRol())
                .build();
    }
}
