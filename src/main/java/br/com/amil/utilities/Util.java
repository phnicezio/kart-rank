package br.com.amil.utilities;

public class Util {
	
	private int tamanhoDoEspacamento;
	
	public Util(int tamanhoDoEspacamento) {
		this.tamanhoDoEspacamento = tamanhoDoEspacamento;
	}
	
	public String adicionarEspaco(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < (tamanhoDoEspacamento - str.length()); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
	
}
