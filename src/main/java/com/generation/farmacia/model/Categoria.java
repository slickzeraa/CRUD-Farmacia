package com.generation.farmacia.model;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity //indica que essa classe no meu Java é uma Entidade ou seja um tabela no meu banco de dados... para diferenciar de uma classe normal, feita com JPA e hibernate
@Table(name = "tb_categorias")
public class Categoria {

	@Id // indica que vai ser minha chave primária da minha tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // vai gerar minha chave primária com Autoincrement no meu banco de dados
	private Long id;
	
	@Schema(example = "Classe de remédio Antibiótico")
	@NotBlank(message= "O atributo tipo é de prenchimento obrigatório") // Not null no banco de dados
	@Size(min = 5, max = 100, message = "O atributo tipo tem no mínimo 5 caracteres e no máximo 100 caracteres.")
	private String tipo;
	
	@NotBlank(message= "O atributo descricao é de prenchimento obrigatório") // Not null no banco de dados
	@Size(min = 10, max = 1000, message = "O atributo descricao tem no mínimo 10 caracteres e no máximo 1000 caracteres.")
	private String descricao;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	public Categoria(Long id, String tipo, String descricao, LocalDateTime data) {
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.data = data;
	}
	
	public Categoria() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	
	
}
