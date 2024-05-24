package com.aleal.rooms.controller;

import java.util.List;

import com.aleal.rooms.config.RoomsConfigurations;
import com.aleal.rooms.model.PropertiesRooms;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.rooms.model.Room;
import com.aleal.rooms.services.IRoomService;

@RestController
public class RoomController {

	@Autowired
	private IRoomService service;

	@Autowired
	private RoomsConfigurations configRooms;

	private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

	@GetMapping("rooms")
	public List<Room> search(){
		logger.info("inicio metodo search rooms");

		return (List<Room>) this.service.search();
	}

	@GetMapping("rooms/{id}")
	public List<Room> searchRoomsByHotels(@PathVariable() Long id) {
		logger.info("inicio metodo searchRoomsByHotels");
		return this.service.searchRoomsByHotelsId(id);
	}


	@GetMapping("/rooms/read/properties")
	public String getPropertiesHotels() throws JsonProcessingException {
		logger.info("inicio metodo getPropertiesHotels");
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesRooms propReservations = new PropertiesRooms(
				configRooms.getMsg(),
				configRooms.getBuildVersion(),
				configRooms.getMailDetails());
		String jsonString = owj.writeValueAsString(propReservations);
		return jsonString;
	}
}
