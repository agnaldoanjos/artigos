package br.home.generic.demorest.repository;

import br.home.generic.demorest.entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    boolean existsByCpf(String cpf);
    Optional<PessoaFisica> findByCpf(String id);
}
