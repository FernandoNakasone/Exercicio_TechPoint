package br.fiap.TechPoint.service;

import br.fiap.TechPoint.domain.Cliente;
import br.fiap.TechPoint.domain.Venda;
import br.fiap.TechPoint.repository.ClienteRepository;
import br.fiap.TechPoint.repository.VendaRepository;
import br.fiap.TechPoint.web.dto.ClienteRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;
    private VendaRepository vendaRepository;

    public ClienteService(ClienteRepository clienteRepository, VendaRepository vendaRepository) {
        this.clienteRepository = clienteRepository;
        this.vendaRepository = vendaRepository;
    }

    public Cliente salvar(ClienteRequest requisicao) {
        Cliente cliente = new Cliente();

        cliente.setId(requisicao.getId());
        cliente.setNome(requisicao.getNome());
        cliente.setEmail(requisicao.getEmail());
        cliente.setTelefone(requisicao.getTelefone());

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente buscar(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Venda> listarVendaCliente(Long id){
        return vendaRepository.findByClienteId(id);
    }

}
