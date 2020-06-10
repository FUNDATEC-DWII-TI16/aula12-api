package com.hexsel.demoapi.model;

public class Usuario {

	private Long id;

	private String nome;

	private Boolean ativo;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.ativo = ativo;
	}

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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
