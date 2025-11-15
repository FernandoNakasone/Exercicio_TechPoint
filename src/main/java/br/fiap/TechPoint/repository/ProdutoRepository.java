package br.fiap.TechPoint.repository;

import br.fiap.TechPoint.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
