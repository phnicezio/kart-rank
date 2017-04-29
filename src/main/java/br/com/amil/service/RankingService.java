package br.com.amil.service;

import java.util.List;

import br.com.amil.entity.Piloto;
import br.com.amil.entity.Ranking;
import br.com.amil.utilities.Util;

/**
 * 
 * @author paulo
 *
 */
public class RankingService implements IRankingService {
	
	private Ranking ranking;
	private Util util;
	
	public RankingService() {
		ranking = new Ranking();
		util = new Util(getTamanhoDoMaiorItemDoCabecalho() + 5);
	}
	
	@Override
	public void exibirCabecalho() {
		StringBuilder header = new StringBuilder();
        
		System.out.println("Ranking");
		
		ranking.getItensCabecalho().forEach(itemCabecalho -> header.append(adicionarEspaco(itemCabecalho)));
		
		System.out.println(header.toString());
    }
	
	@Override
	public void exibirRanking(List<Piloto> pilotos) {
		int i = 0;
		
		for (Piloto p : pilotos) {
			System.out.println(
					 adicionarEspaco(Integer.toString(++i)) + 
					 adicionarEspaco(p.getCodigo()) + 
					 adicionarEspaco(p.getNome()) +
					 adicionarEspaco(Integer.toString(p.getTotalVoltasCompletadas())) +
					 adicionarEspaco(""+p.getTempoTotal()));
		}
	}
	
	private String adicionarEspaco(String str) {
		return util.adicionarEspaco(str);
    }

	private int getTamanhoDoMaiorItemDoCabecalho() {
		if (ranking.getItensCabecalho() != null) {
			return ranking.getItensCabecalho()
					.stream()
					.mapToInt(i -> i.length())
					.max()
					.getAsInt() + 5;
		}
		return 0;
	}
}
