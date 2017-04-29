package br.com.amil;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.amil.entity.Piloto;
import br.com.amil.entity.Volta;
import br.com.amil.service.CorridaService;
import br.com.amil.service.ICorridaService;
import br.com.amil.service.IPilotoService;
import br.com.amil.service.PilotoService;


/**
 * 
 * @author paulo
 *
 */
public class CorridaTest {
	
	private ICorridaService corridaService = new CorridaService();
	private IPilotoService pilotoService = new PilotoService();
	
	private List<Piloto> pilotos;
	
	@Before
	public void init() {
		pilotos = corridaService.processar();
	}
	
	@Test
	public void testMelhorVoltaDoPiloto() {
		// Descobrir a melhor volta de cada piloto
		// 038 - F.MASSA - Número da volta : 3 - Tempo da melhor volta : 00:01:02.000000769
		
		Piloto piloto = new Piloto();
		piloto.setCodigo("038");
		piloto.setNome("F.MASSA");

		LocalTime tempoDaMelhorVoltaDoMassa = LocalTime.of(0, 1, 2, 769);
		
		Optional<Piloto> pilotoEncontrado = pilotos.stream().filter(p -> p.equals(piloto)).findFirst();
		
		Volta melhorVoltaDoPiloto = null;
		
		if (pilotoEncontrado.isPresent()) {
			melhorVoltaDoPiloto = pilotoService.obtemMelhorVoltaDoPiloto(pilotoEncontrado.get());
		}
		
		Assert.assertNotNull(melhorVoltaDoPiloto);
		Assert.assertEquals(tempoDaMelhorVoltaDoMassa, melhorVoltaDoPiloto.getTempo());
	}
	
	@Test
	public void testMelhorVoltaDaCorrida() {
		// Descobrir a melhor volta da corrida:
		// Tempo da melhor volta : 00:01:02.000000769

		LocalTime tempoDaMelhorVoltaDaCorrida = LocalTime.of(0, 1, 2, 769);
		
		Volta melhorVoltaDaCorrida = corridaService.obtemMelhorVoltaDaCorrida(pilotos);
		
		Assert.assertNotNull(melhorVoltaDaCorrida);
		Assert.assertEquals(tempoDaMelhorVoltaDaCorrida, melhorVoltaDaCorrida.getTempo());
	}
	
	
		
}
