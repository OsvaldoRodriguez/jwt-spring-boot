package com.example.auth.repository;

import com.example.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;

public interface UsuarioRepository implements JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
}
