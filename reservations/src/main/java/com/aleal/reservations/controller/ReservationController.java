package com.aleal.reservations.controller;

import java.util.List;

import com.aleal.reservations.config.ReservationsConfigurations;
import com.aleal.reservations.model.PropertiesReservations;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.reservations.model.Reservation;
import com.aleal.reservations.services.IReservationService;

@RestController
public class ReservationController {
	
	@Autowired
	private IReservationService service;

	@Autowired
	private ReservationsConfigurations configReservations;

	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

	@GetMapping("reservations")
	public List<Reservation> search(){
		logger.info("inicio metodo search reservations");
		return (List<Reservation>) this.service.search();
	}

	@GetMapping("/reservations/read/properties")
	public String getPropertiesReservations() throws JsonProcessingException {
		logger.info("inicio metodo getPropertiesReservations");
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesReservations propReservations = new PropertiesReservations(configReservations.getMsg(), configReservations.getBuildVersion(),
				configReservations.getMailDetails());
		String jsonString = owj.writeValueAsString(propReservations);
		return jsonString;
	}

}
