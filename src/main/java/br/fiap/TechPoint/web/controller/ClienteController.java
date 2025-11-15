package br.fiap.TechPoint.web.controller;

import br.fiap.TechPoint.domain.Cliente;
import br.fiap.TechPoint.domain.Venda;
import br.fiap.TechPoint.service.ClienteService;
import br.fiap.TechPoint.web.dto.ClienteRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody ClienteRequest requisicao) {
        return service.salvar(requisicao);
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @GetMapping("/{id}/venda")
    public List<Venda> listarVendas(@PathVariable Long id){
        return service.listarVendaCliente(id);
    }
}
