package com.backend.mapeamento.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    boolean existsByEmailIgnoreCase(String email);

    Optional<Login> findByEmailIgnoreCase(String email);
}
