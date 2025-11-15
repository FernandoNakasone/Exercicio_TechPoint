package br.fiap.TechPoint.web.controller;

import br.fiap.TechPoint.domain.Venda;
import br.fiap.TechPoint.repository.VendaRepository;
import br.fiap.TechPoint.service.VendaService;
import br.fiap.TechPoint.web.dto.VendaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {
    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @PostMapping
    public Venda criar(@RequestBody VendaDTO requisicao) {
        return service.criar(requisicao);
    }

    @GetMapping
    public List<Venda> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Venda buscar(@PathVariable Long id) {
        return service.buscar(id);
    }
}
