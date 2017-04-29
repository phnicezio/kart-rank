package br.com.amil.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.DoubleStream;

import br.com.amil.entity.Piloto;
import br.com.amil.entity.Volta;
import br.com.amil.utilities.Util;

/**
 * 
 * @author paulo
 *
 */
public class PilotoService implements IPilotoService {
	
	private Util util;
	
	public PilotoService() {
		util = new Util(25);
	}

	@Override
	public void mostrarMelhorVoltaDosPilotos(List<Piloto> pilotos) {
		pilotos.forEach(piloto -> {
			Volta melhorVoltaDoPiloto = this.obtemMelhorVoltaDoPiloto(piloto);
			System.out.println(
					adicionarEspaco(piloto.getNome()) + 
					adicionarEspaco("Número da volta : " + melhorVoltaDoPiloto.getNumero()) + 
					adicionarEspaco("Tempo da melhor volta : " + melhorVoltaDoPiloto.getTempo()));
		});
	}
	
	@Override
	public Volta obtemMelhorVoltaDoPiloto(Piloto piloto) {
		Comparator<Volta> byTempo = (v1, v2) -> v1.getTempo().compareTo(v2.getTempo());
		return piloto.getListaVoltas()
			.stream()
			.max(byTempo.reversed())
			.get();
	}
	
	@Override
	public void mostrarVelocidadeMediaDosPilotos(List<Piloto> pilotos) {
		pilotos.forEach(piloto -> 
			System.out.println(
					adicionarEspaco(piloto.getNome()) + 
					adicionarEspaco("Velocidade Média : " + obtemVelocidadeMediaDoPiloto(piloto))));
	}
	
	private String obtemVelocidadeMediaDoPiloto(Piloto piloto) {
		DoubleStream doubleStream = piloto.getListaVoltas()
				.stream()
				.mapToDouble(v -> v.getVelocidadeMedia());
		
		double asDouble = doubleStream.average().getAsDouble();
		
		return String.format("%.3f", asDouble);
	}
	
	private String adicionarEspaco(String str) {
		return util.adicionarEspaco(str);
    }
}
