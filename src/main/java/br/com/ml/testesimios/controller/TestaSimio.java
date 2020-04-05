package br.com.ml.testesimios.controller;

import java.math.BigDecimal;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ml.testesimios.dao.SimioDAOImpl;
import br.com.ml.testesimios.model.Simian;
import br.com.ml.testesimios.service.SimionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestaSimio {

	@Autowired
	private SimionService service;

	@Autowired
	private SimioDAOImpl dao;

	@RequestMapping(value = "/simian", method = RequestMethod.POST)
	public ResponseEntity<Object> simian(String[] dna) {
		System.out.println(dna.toString());

		StringBuilder str = new StringBuilder();
		for (String var : dna) {
			str.append(var).append(",");
		}

		try {
			if (service.isSimian(dna)) {
				dao.saveAndFlush(new Simian(str.toString(), "S"));
				return new ResponseEntity<>(HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		dao.saveAndFlush(new Simian(str.toString(), "N"));
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);

	}

	@ResponseBody
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public String stats() throws JSONException {

		JSONObject jsonObject = new JSONObject();

		BigDecimal simios = new BigDecimal(dao.getTotalSimios());
		jsonObject.put("count_mutant_dna", simios);

		BigDecimal humanos = new BigDecimal(dao.getTotalHumanos());
		jsonObject.put("count_human_dna", humanos);

		BigDecimal percentual = new BigDecimal(0);
		if (simios.intValue() != 0 && humanos.intValue() != 0) {

			BigDecimal total = humanos.add(simios);
			percentual = (simios.multiply(new BigDecimal(100))).divide(total);
		} 
		if(humanos.intValue() == 0){
			percentual = new BigDecimal(100);
		}
		jsonObject.put("ratio", percentual);

		return jsonObject.toString();
	}
}
