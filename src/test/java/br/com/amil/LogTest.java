package br.com.amil;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.amil.dao.ILogDAO;
import br.com.amil.dao.LogDAO;


/**
 * 
 * @author paulo
 *
 */
public class LogTest {
	
	@Test
	public void testLog() {
		ILogDAO logDAO = new LogDAO();
		List<String> input = logDAO.load();
		Assert.assertNotNull(input);
		Assert.assertFalse(input.isEmpty());
    }
}
