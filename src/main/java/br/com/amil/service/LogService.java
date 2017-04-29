package br.com.amil.service;

import java.util.List;

import br.com.amil.dao.ILogDAO;
import br.com.amil.dao.LogDAO;

/**
 * 
 * @author paulo
 *
 */
public class LogService implements ILogService {
	
	private ILogDAO logDAO = new LogDAO();

	@Override
	public List<String> loadLog() {
		return logDAO.load();
	}
}
