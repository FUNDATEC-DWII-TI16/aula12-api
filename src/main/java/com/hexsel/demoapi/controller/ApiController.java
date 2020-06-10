package com.hexsel.demoapi.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hexsel.demoapi.model.Usuario;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ApiController {

	@GetMapping("")
	public String index() {
		return "Demo API - Usuarios - FUNDATEC - DWII";
	}

	private static List<Usuario> usuariosDoBanco = List.of(
			new Usuario(10L, "Usuario 10", true),
			new Usuario(11L, "Usuario 11", false),
			new Usuario(12L, "Usuario 12", true),
			new Usuario(13L, "Usuario 13", true),
			new Usuario(14L, "Usuario 14", false),
			new Usuario(15L, "Usuario 15", false),
			new Usuario(16L, "Usuario 16", true),
			new Usuario(17L, "Usuario 17", true),
			new Usuario(18L, "Usuario 18", false),
			new Usuario(19L, "Usuario 19", true));

	@GetMapping("/usuarios/demorado/{id}")
	public Usuario usuarioByIdDemorado(@PathVariable("id") Long id) throws InterruptedException {

		Thread.sleep(5000);

		return usuarioById(id);
	}

	@GetMapping("/usuarios")
	public List<Usuario> usuarios() {
		return usuariosDoBanco;
	}

	@GetMapping("/usuarios/{id}")
	public Usuario usuarioById(@PathVariable("id") Long id) {
		return usuariosDoBanco.stream().filter(f -> f.getId().equals(id)).findFirst().orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
	}

	@GetMapping("/serverError")
	public void error() {
		throw new RuntimeException("Erro no servidor");
	}

	@PostMapping("/usuarios")
	public String alteraUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioDoBanco = usuariosDoBanco.stream().filter(f -> f.getId().equals(usuario.getId())).findFirst().orElse(null);

		usuarioDoBanco.setNome(usuario.getNome());
		usuarioDoBanco.setAtivo(usuario.getAtivo());

		return "ok";

	}

}