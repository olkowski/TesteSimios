package br.com.ml.testesimios.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SimionServiceImpl implements SimionService {

	private static final List<String> SIMIAN_DNA =  Arrays.asList("A", "T", "C", "G");
	

	
	
	@Override
	public boolean isSimian(String[] dnas) throws Exception {
		System.out.println("oi");
		if (dnas == null) {
			throw new Exception("DNA deve deve ser enviado");
		}
		validarCubo(dnas);

		String[] colunas = new String[dnas[0].length()];

		for (int i = 0; i < dnas.length; i++) {
			String dna = dnas[i];
			if (SIMIAN_DNA.contains(dna)) {
				return true;
			}
			log.info("linha " + i + ": " + dna);

			for (int y = 0; y < dna.length(); y++) {
				String coluna = colunas[y] == null ? "" : colunas[y];
				coluna += dna.toCharArray()[y];
				if (SIMIAN_DNA.contains(dna)) {
					return true;
				}
				colunas[y] = coluna += dna.toCharArray()[y];
			}

		}


		return false;
	}

	private void validarCubo(String[] dnas) throws Exception {
		for (int i = 0; i < dnas.length; i++) {
			if (dnas[i].length() != dnas[0].length()) {
				throw new Exception("DNA inválido");
			}

		}
	}

}
