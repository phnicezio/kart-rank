package br.com.amil.facade;

import java.util.List;

import br.com.amil.entity.Piloto;
import br.com.amil.service.CorridaService;
import br.com.amil.service.ICorridaService;
import br.com.amil.service.IPilotoService;
import br.com.amil.service.PilotoService;

/**
 * 
 * @author paulo
 *
 */
public class CorridaMain {
	
	public static void main(String[] args) {
		ICorridaService corridaService = new CorridaService();
		IPilotoService pilotoService = new PilotoService();
		
		List<Piloto> pilotos = corridaService.processar();
		
		if (!pilotos.isEmpty()) {
			corridaService.mostrarResultado(pilotos);
			
			System.out.println("\n\n" + "Descobrir a melhor volta de cada piloto:");
			pilotoService.mostrarMelhorVoltaDosPilotos(pilotos);
			
			System.out.println("\n\n" + "Descobrir a melhor volta da corrida:");
			corridaService.mostrarMelhorVoltaDaCorrida(pilotos);
			
			System.out.println("\n\n" + "Calcular a velocidade média de cada piloto durante toda corrida:");
			pilotoService.mostrarVelocidadeMediaDosPilotos(pilotos);
		}
	}
	
}
