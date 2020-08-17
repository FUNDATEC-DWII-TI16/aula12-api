package com.hexsel.demoapi.model;

import java.util.List;

public class JogoMegaFundatec {

	private List<Integer> dezenas;

	public JogoMegaFundatec() {

	}

	public JogoMegaFundatec(List<Integer> dezenas) {
		super();
		this.dezenas = dezenas;
	}

	public List<Integer> getDezenas() {
		return dezenas;
	}

	public void setDezenas(List<Integer> dezenas) {
		this.dezenas = dezenas;
	}

}
