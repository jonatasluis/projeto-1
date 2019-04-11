package com.projeto1.dto;

import java.io.Serializable;

import com.projeto1.domain.Produto;

public class ProdutoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double preco;
	
	public ProdutoDTO() {
		// TODO Auto-generated constructor stub
	} {}

	
	public ProdutoDTO(Produto obj) {
		id = obj.getId();
		nome= obj.getNome();
		preco = obj.getPreco();
	}


	public Integer getId() {
		return id;
	}



	public String getNome() {
		return nome;
	}



	public Double getPreco() {
		return preco;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

}
