package br.home.generic.demorest.controller;

import br.home.generic.demorest.entity.PessoaFisica;
import br.home.generic.demorest.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas-fisicas")
public class PessoaFisicaController {
    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @PostMapping
    public ResponseEntity<PessoaFisica> create(@RequestBody PessoaFisica pessoaFisica) {
        PessoaFisica savedPessoaFisica = pessoaFisicaRepository.save(pessoaFisica);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPessoaFisica);
    }

    @GetMapping
    public ResponseEntity<List<PessoaFisica>> readAll() {
        return ResponseEntity.ok(pessoaFisicaRepository.findAll());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PessoaFisica> readById(@PathVariable String cpf) {
        return pessoaFisicaRepository.findByCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<PessoaFisica> update(@PathVariable String cpf, @RequestBody PessoaFisica pessoaFisica) {
        if (!pessoaFisicaRepository.existsByCpf(cpf)) {
            return ResponseEntity.notFound().build();
        }
        PessoaFisica value = pessoaFisicaRepository.findByCpf(cpf).get();
        pessoaFisica.setId(value.getId());
        return ResponseEntity.ok(pessoaFisicaRepository.save(pessoaFisica));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf) {
        if (!pessoaFisicaRepository.existsByCpf(cpf)) {
            return ResponseEntity.notFound().build();
        }
        PessoaFisica value = pessoaFisicaRepository.findByCpf(cpf).get();
        pessoaFisicaRepository.deleteById(value.getId());
        return ResponseEntity.noContent().build();
    }
}
