package br.com.amil.service;

import java.util.List;

import br.com.amil.entity.Piloto;

public interface IRankingService {

	public void exibirCabecalho();
	
	public void exibirRanking(List<Piloto> pilotos);
	
}
