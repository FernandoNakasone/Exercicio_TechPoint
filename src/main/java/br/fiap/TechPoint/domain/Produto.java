package br.fiap.TechPoint.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "techpoint_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "estoque", nullable = false)
    private Integer estoque;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
