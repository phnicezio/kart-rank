package br.com.amil.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.amil.builder.VoltaBuilder;
import br.com.amil.entity.Piloto;
import br.com.amil.entity.Volta;

/**
 * 
 * @author paulo
 *
 */
public class CorridaService implements ICorridaService {

	public static final String REGEX_ESPACO = "\\s+";
	
	private ILogService logService = new LogService();
	private IRankingService rankingService = new RankingService();
	private IPilotoService pilotoService = new PilotoService();
	private List<Piloto> pilotos = new ArrayList<>();
	
	@Override
	public List<Piloto> processar() {
		pilotos.clear();
		
		Map<String, Piloto> pilotosMap = construirCorrida();
		
		pilotos = mapToList(pilotosMap);
		
		return ordenarListaDePilotos();
	}

	private Map<String, Piloto> construirCorrida() {
		Map<String, Piloto> pilotosMap = new HashMap<>();
		
		List<String> listInput = logService.loadLog();
		
		listInput.stream().forEach(str -> {
			String[] strSplit = str.split(REGEX_ESPACO);
			Piloto piloto = getPiloto(strSplit);
			Volta volta = getVolta(strSplit);
			
			if (pilotosMap.containsKey(piloto.getCodigo())) {
				Piloto pilotoMap = pilotosMap.get(piloto.getCodigo()); 
				atualizarPiloto(volta, pilotoMap);

			} else {
				atualizarPiloto(volta, piloto);
				pilotosMap.put(piloto.getCodigo(), piloto);
			}
		});
		
		return pilotosMap;
	}
	
	private List<Piloto> mapToList(Map<String, Piloto> pilotosMap) {
		if (pilotosMap != null) {
			return pilotosMap.entrySet().stream()
					.map(x -> x.getValue())
	                .collect(Collectors.toList());
		}
		return Collections.<Piloto>emptyList();
	}
	
	@Override
	public void mostrarEntrada(List<Piloto> pilotos) {
		pilotos
		.stream()
		.forEach(p -> {
			System.out.println(p.getCodigo() + " - " + p.getNome());
			p.getListaVoltas().forEach(System.out::println);
		});
		
		System.out.println();
		System.out.println();
	}
	
	private List<Piloto> ordenarListaDePilotos() {
		Comparator<Piloto> byPilotoQuantidadeVolta = (p1, p2) -> Integer.compare(p1.getListaVoltas().size(), p2.getListaVoltas().size());
		Comparator<Piloto> byPilotoTempoTotal = (p1, p2) -> p1.getTempoTotal().compareTo(p2.getTempoTotal());
		
		return pilotos
			.stream()
			.sorted(byPilotoQuantidadeVolta.reversed().thenComparing(byPilotoTempoTotal))
			.collect(Collectors.toList());
	}
	
	@Override
	public void mostrarResultado(List<Piloto> pilotos) {
		rankingService.exibirCabecalho();
		rankingService.exibirRanking(pilotos);
	}
	
	private void atualizarPiloto(Volta volta, Piloto pilotoMap) {
		pilotoMap.getListaVoltas().add(volta);
		pilotoMap.setTempoTotal(addTempoVolta(pilotoMap.getTempoTotal(), volta));
	}
	
	private LocalTime addTempoVolta(LocalTime tempoTotal, Volta volta) {
		return tempoTotal
				.plusHours(volta.getTempo().getHour())
				.plusMinutes(volta.getTempo().getMinute())
				.plusSeconds(volta.getTempo().getSecond())
				.plusNanos(volta.getTempo().getNano());
	}
	
	private Piloto getPiloto(String[] strSplit) {
		Piloto piloto = new Piloto();
		piloto.setCodigo(strSplit[1]);
		piloto.setNome(strSplit[3]);
		return piloto;
	}
	
	private Volta getVolta(String[] strSplit) {
		return new VoltaBuilder()
				.numero(strSplit[4])
				.tempo(strSplit[5])
				.velocidadeMedia(strSplit[6])
				.build();
	}
	
	@Override
	public void mostrarMelhorVoltaDaCorrida(List<Piloto> pilotos) {
		Volta volta = obtemMelhorVoltaDaCorrida(pilotos);
		System.out.println("Tempo da melhor volta : " + volta.getTempo());
	}
	
	@Override
	public Volta obtemMelhorVoltaDaCorrida(List<Piloto> pilotos) {
		List<Volta> voltas = new ArrayList<>();
		pilotos.forEach(piloto -> 
			voltas.add(pilotoService.obtemMelhorVoltaDoPiloto(piloto))
		);
		
		Comparator<Volta> byTempo = (v1, v2) -> v1.getTempo().compareTo(v2.getTempo());
		
		return voltas.stream().max(byTempo.reversed()).get();
	}

}
