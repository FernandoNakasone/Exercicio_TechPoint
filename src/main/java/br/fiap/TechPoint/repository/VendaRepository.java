package br.fiap.TechPoint.repository;

import br.fiap.TechPoint.domain.Cliente;
import br.fiap.TechPoint.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    public List<Venda> findByClienteId(Long clienteId);

}
