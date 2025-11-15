package br.fiap.TechPoint.web.dto;

import br.fiap.TechPoint.domain.Cliente;
import br.fiap.TechPoint.domain.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {
    private Long id;
    private Cliente cliente;
    private Produto produto;
    private Integer quantidade;
    private Double precoUnitario;
    private Double total;
    private LocalDate dataVenda;
}
