package br.fiap.TechPoint.web.controller;

import br.fiap.TechPoint.domain.Produto;
import br.fiap.TechPoint.service.ProdutoService;
import br.fiap.TechPoint.web.dto.ProdutoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto create(@RequestBody ProdutoRequest requisicao){
        return service.salvar(requisicao);
    }

    @GetMapping
    public List<Produto> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id){
        return service.buscar(id);
    }

}
