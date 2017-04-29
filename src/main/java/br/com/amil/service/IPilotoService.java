package br.com.amil.service;

import java.util.List;

import br.com.amil.entity.Piloto;
import br.com.amil.entity.Volta;

public interface IPilotoService {

	public void mostrarMelhorVoltaDosPilotos(List<Piloto> pilotos);

	public Volta obtemMelhorVoltaDoPiloto(Piloto piloto);

	public void mostrarVelocidadeMediaDosPilotos(List<Piloto> pilotos);
	
}
