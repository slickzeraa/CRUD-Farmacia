package com.generation.farmacia.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.generation.farmacia.model.Categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity //indica que essa classe no meu Java é uma Entidade ou seja um tabela no meu banco de dados... para diferenciar de uma classe normal, feita com JPA e hibernate
@Table(name = "tb_produtos")
public class Produto {

	@Id // indica que vai ser minha chave primária da minha tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // vai gerar minha chave primária com Autoincrement no meu banco de dados
	private Long id;
	
	@NotBlank(message= "O atributo nome é de prenchimento obrigatório") // Not null no banco de dados
	@Size(min = 3, max = 100, message = "O atributo nome tem no mínimo 5 caracteres e no máximo 100 caracteres.")
	private String nome;
	
	@NotBlank(message= "O atributo descricao é de prenchimento obrigatório") // Not null no banco de dados
	@Size(min = 10, max = 1000, message = "O atributo descricao tem no mínimo 10 caracteres e no máximo 1000 caracteres.")
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "Preço é obrigatório!")
	@Positive(message = "O preço deve ser maior do que zero!")
	private BigDecimal preco;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
