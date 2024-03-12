package br.com.fiap.oasisclinic.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.budgetbuddy.model.Agendamento;
import br.com.fiap.budgetbuddy.repository.AgendamentoRepository;

@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired 
    AgendamentoControllerRepository repository;

    @GetMapping
    public List<Agendamento> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = CREATED)
    public Agendamento create(@RequestBody Agendamento agendamento) { 
        log.info("cadastrando agendamento " + agendamento);
        repository.save(agendamento);
        return agendamento;
    }

    @GetMapping("{id}")
    public ResponseEntity<Agendamento> show(@PathVariable Long id) {
        log.info("buscar agendamento por id {} ", id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok) 
                .orElse(ResponseEntity.notFound().build());

      
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        log.info("Apagando agendamento com id {} ", id);

        verifyIfExists(id);

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        log.info("atualizando agendamento com id {} para {}", id, agendamento);

        verifyIfExists(id);

        agendamento.setId(id);

        repository.save(agendamento);
        return ResponseEntity.ok(agendamento);

    }

    private void verifyIfExists(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe agendamento com o id informado"));
    }



}
