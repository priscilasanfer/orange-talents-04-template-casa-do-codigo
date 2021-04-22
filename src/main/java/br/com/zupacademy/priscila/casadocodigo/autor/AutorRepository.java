package br.com.zupacademy.priscila.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    boolean existsAutorByEmail(String email);
    Optional<Autor> findByEmail(String email);
}
