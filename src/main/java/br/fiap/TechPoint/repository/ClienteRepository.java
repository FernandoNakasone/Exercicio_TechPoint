package br.fiap.TechPoint.repository;

import br.fiap.TechPoint.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>  {

}
