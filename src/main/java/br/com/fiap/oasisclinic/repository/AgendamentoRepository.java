package main.java.br.com.fiap.oasisclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.budgetbuddy.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Agendamento, Long> {}
