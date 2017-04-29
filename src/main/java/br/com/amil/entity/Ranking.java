package br.com.amil.entity;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author paulo
 *
 */
public class Ranking {

	private List<String> itensCabecalho = Arrays.asList("Posição Chegada", 
			"Código Piloto", 
			"Nome Piloto",
			"Qtde Voltas Completadas", 
			"Tempo Total de Prova");

	public List<String> getItensCabecalho() {
		return itensCabecalho;
	}

	public void setItensCabecalho(List<String> itensCabecalho) {
		this.itensCabecalho = itensCabecalho;
	}
	
}
