package br.com.ml.testesimios.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SimionServiceImpl implements SimionService {

	private static final List<String> SIMIAN_DNA = Arrays.asList("AAAA", "TTTT", "CCCC", "GGGG");

	@Override
	public boolean isSimian(String[] dnas) throws Exception {
		if (dnas == null) {
			throw new Exception("DNA deve deve ser enviado");
		}
		dnas = validarCubo(dnas);

		int tamanho = dnas[0].length();

		String[] colunas = new String[tamanho];

		for (int i = 0; i < dnas.length; i++) {
			String dna = dnas[i];
			if (contains(dna)) {
				return true;
			}
			log.info("linha " + i + ": " + dna);

			for (int y = 0; y < dna.length(); y++) {

				String coluna = colunas[y] == null ? "" : colunas[y];
				colunas[y] = coluna += dna.toCharArray()[y];
				if (contains(coluna)) {
					return true;
				}

			}

		}

		return false;
	}

	private boolean contains(String valor) {
		for (String simian : SIMIAN_DNA) {
			if (valor.contains(simian)) {
				return true;
			}
		}
		return false;
	}

	private String[] validarCubo(String[] dnas) throws Exception {
		String[] dnasNew = new String[dnas.length];
		if (dnas == null || dnas[0].replaceAll("\"", "").length() != dnas.length) {
			throw new Exception("DNA inválido");
		}

		for (int i = 0; i < dnas.length; i++) {
			if (dnas[i].length() != dnas[0].length()) {				
				throw new Exception("DNA inválido");
			}
			dnasNew[i] = dnas[i];

		}
		return dnasNew;
	}

}
