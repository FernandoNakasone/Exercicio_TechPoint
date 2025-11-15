package br.fiap.TechPoint.service;

import br.fiap.TechPoint.domain.Produto;
import br.fiap.TechPoint.repository.ProdutoRepository;
import br.fiap.TechPoint.repository.VendaRepository;
import br.fiap.TechPoint.web.dto.ProdutoRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    ProdutoRepository produtoRepository;
    VendaRepository vendaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, VendaRepository vendaRepository) {
        this.produtoRepository = produtoRepository;
        this.vendaRepository = vendaRepository;
    }

    public Produto salvar(ProdutoRequest requisicao) {
        Produto produto = new Produto();

        produto.setIdProduto(requisicao.getId());
        produto.setNome(requisicao.getNome());
        produto.setPreco(requisicao.getPreco());
        produto.setEstoque(requisicao.getEstoque());

        return produtoRepository.save(produto);
    }

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto buscar(Long id){
        return produtoRepository.findById(id).orElse(null);
    }
}
