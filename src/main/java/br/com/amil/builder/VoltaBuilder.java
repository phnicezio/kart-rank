package br.com.amil.builder;

import java.time.LocalTime;

import br.com.amil.entity.Volta;

/**
 * 
 * @author paulo
 *
 */
public class VoltaBuilder {
	
	private static final String DOIS_PONTOS = ":";
	private static final String PONTO = ".";
	private static final String HIFEN = "-";
	
	private int numero;
	private LocalTime tempo;
	private double velocidadeMedia;

	public VoltaBuilder numero(String numero) {
		this.numero = Integer.parseInt(numero);
		return this;
	}

	public VoltaBuilder tempo(String tempo) {
		String[] split = tempo.split(DOIS_PONTOS);
		int minutos = Integer.parseInt(split[0]);
		
		String[] split2 = split[1].replace(PONTO, HIFEN).split(HIFEN);
		int segundos = Integer.parseInt(split2[0]);
		int nanoSegundos = Integer.parseInt(split2[1]);
		
		LocalTime tempoDaVolta = LocalTime.of(0, minutos, segundos, nanoSegundos);
		
		this.tempo = tempoDaVolta;
		return this;
	}
	
	public VoltaBuilder velocidadeMedia(String velocidadeMedia) {
		this.velocidadeMedia = Double.parseDouble(velocidadeMedia.replace(",", PONTO));
		return this;
	}
	
	public Volta build() {
		return new Volta(numero, tempo, velocidadeMedia);
	}
	
}
