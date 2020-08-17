package com.hexsel.demoapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexsel.demoapi.model.JogoMegaFundatec;

@CrossOrigin
@RestController
@RequestMapping("megafundatec")
public class MegaFundatecController {

	private static List<JogoMegaFundatec> jogos = new ArrayList<JogoMegaFundatec>();

	@GetMapping()
	public List<JogoMegaFundatec> listarJogos() {
		return jogos;
	}

	@PostMapping()
	public void cadastrarJogo(@RequestBody JogoMegaFundatec jogo) {
		jogos.add(jogo);
	}

}