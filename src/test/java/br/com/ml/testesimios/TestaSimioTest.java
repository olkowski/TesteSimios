package br.com.ml.testesimios;

import static org.junit.Assert.fail;

import org.junit.Test;

import br.com.ml.testesimios.service.SimionServiceImpl;

public class TestaSimioTest {


	@Test
	public void test() {
		// [{"key":"dna","value":" [\"ATGCGA\", \"CAGTGC\", \"TTATGT\",
		// \"AGAAGG\", \"CCCCTA\",
		// \"TCACTG\"]","description":"","type":"text","enabled":true}]
		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };

		try {
			new SimionServiceImpl().isSimian(dna);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fail("Not yet implemented");
	}

}
