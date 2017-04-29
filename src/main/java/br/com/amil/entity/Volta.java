package br.com.amil.entity;

import java.time.LocalTime;

/**
 * 
 * @author paulo
 *
 */
public class Volta {

	private int numero;
	private LocalTime tempo;
	private double velocidadeMedia;

	public Volta(int numero, LocalTime tempo, double velocidadeMedia) {
		super();
		this.numero = numero;
		this.tempo = tempo;
		this.velocidadeMedia = velocidadeMedia;
	}

	public Volta() {
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalTime getTempo() {
		return tempo;
	}

	public void setTempo(LocalTime tempo) {
		this.tempo = tempo;
	}

	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

	@Override
	public String toString() {
		return "Volta [numero=" + numero + ", tempo=" + tempo + ", velocidadeMedia=" + velocidadeMedia + "]";
	}

}
