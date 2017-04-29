package br.com.amil.service;

import java.util.List;

import br.com.amil.entity.Piloto;
import br.com.amil.entity.Volta;

public interface ICorridaService {

	public List<Piloto> processar();
	
	public void mostrarEntrada(List<Piloto> pilotos);
	
	public void mostrarResultado(List<Piloto> pilotos);

	public void mostrarMelhorVoltaDaCorrida(List<Piloto> pilotos);

	public Volta obtemMelhorVoltaDaCorrida(List<Piloto> pilotos);
	
}
