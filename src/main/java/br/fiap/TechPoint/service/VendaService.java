package br.fiap.TechPoint.service;

import br.fiap.TechPoint.domain.Venda;
import br.fiap.TechPoint.repository.ClienteRepository;
import br.fiap.TechPoint.repository.ProdutoRepository;
import br.fiap.TechPoint.repository.VendaRepository;
import br.fiap.TechPoint.web.dto.VendaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    VendaRepository vendaRepository;
    ClienteRepository clienteRepository;
    ProdutoRepository produtoRepository;

    public VendaService(VendaRepository vendaRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public Venda criar(VendaDTO vendaDTO){
        var cliente = clienteRepository.findById(vendaDTO.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        var produto = produtoRepository.findById(vendaDTO.getProduto().getIdProduto())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (vendaDTO.getQuantidade() > produto.getEstoque()) {
            throw new RuntimeException("Estoque insuficiente!");
        }

        produto.setEstoque(produto.getEstoque() - vendaDTO.getQuantidade());
        produtoRepository.save(produto);

        Venda venda = new Venda();
        venda.setId(vendaDTO.getId());
        venda.setCliente(vendaDTO.getCliente());
        venda.setProduto(vendaDTO.getProduto());
        venda.setQuantidade(vendaDTO.getQuantidade());
        venda.setPrecoUnitario(produto.getPreco());
        venda.setTotal(produto.getPreco() * vendaDTO.getQuantidade());
        venda.setDataVenda(vendaDTO.getDataVenda());

        return vendaRepository.save(venda);
    }

    public List<Venda> listar(){
        return vendaRepository.findAll();
    }

    public Venda buscar(Long id){
        return vendaRepository.findById(id).orElse(null);
    }

}
