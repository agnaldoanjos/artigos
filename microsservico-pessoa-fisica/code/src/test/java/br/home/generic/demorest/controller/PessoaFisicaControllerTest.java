package br.home.generic.demorest.controller;

import br.home.generic.demorest.entity.PessoaFisica;
import br.home.generic.demorest.repository.PessoaFisicaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PessoaFisicaControllerTest {

    @InjectMocks
    private PessoaFisicaController pessoaFisicaController;

    @Mock
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreatePessoaFisica() {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setId(1L);
        pessoaFisica.setNome("João");
        pessoaFisica.setCpf("123.456.789-00");
        pessoaFisica.setDataNascimento(LocalDate.of(1990, 1, 1));

        when(pessoaFisicaRepository.save(any(PessoaFisica.class))).thenReturn(pessoaFisica);

        ResponseEntity<PessoaFisica> response = pessoaFisicaController.create(pessoaFisica);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(pessoaFisica.getId(), response.getBody().getId());
        assertEquals(pessoaFisica.getNome(), response.getBody().getNome());
        assertEquals(pessoaFisica.getCpf(), response.getBody().getCpf());
        assertEquals(pessoaFisica.getDataNascimento(), response.getBody().getDataNascimento());

        verify(pessoaFisicaRepository, times(1)).save(pessoaFisica);
    }

    // Implemente os testes unitários para os outros métodos CRUD (Read, Update, Delete)
}
