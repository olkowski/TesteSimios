package br.com.ml.testesimios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.com.ml.testesimios.service.SimionServiceImpl;

public class TestaSimioTest {


	@Test
	public void testSimio() {

		String[] dna = { "ATGCGA", "CAATGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };

		try {
			assertEquals(new SimionServiceImpl().isSimian(dna),true);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testHumano() {

		String[] dna = { "ATGCGA", "CATTGC", "TTATGT", "AGATTG", "CTCCTA", "TCACTG" };

		try {
			assertEquals(new SimionServiceImpl().isSimian(dna),false);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

}
