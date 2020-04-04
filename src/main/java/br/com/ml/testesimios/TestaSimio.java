package br.com.ml.testesimios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ml.testesimios.service.SimionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestaSimio {
	
	@Autowired
	private SimionService service;

	@RequestMapping(value = "/simian", method = RequestMethod.POST)
	public ResponseEntity<Object> simian(String[] dna) {
		System.out.println(dna.toString());
		try {
			if (service.isSimian(dna)) {
				return new ResponseEntity<>(HttpStatus.OK);
			} 
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);

	}
}
