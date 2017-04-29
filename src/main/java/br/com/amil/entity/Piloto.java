package br.com.amil.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author paulo
 *
 */
public class Piloto {

	private String codigo;
	private String nome;
	private List<Volta> listaVoltas;
	private LocalTime tempoTotal;

	public Piloto() {
		this.listaVoltas = new ArrayList<>();
		tempoTotal = LocalTime.of(0, 0);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Volta> getListaVoltas() {
		return listaVoltas;
	}

	public void setListaVoltas(List<Volta> listaVoltas) {
		this.listaVoltas = listaVoltas;
	}
	
	public int getTotalVoltasCompletadas() {
		if (this.getListaVoltas() != null) {
			return this.getListaVoltas().size();
		}
		return 0;
	}
	
	public LocalTime getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(LocalTime tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piloto other = (Piloto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Piloto [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
