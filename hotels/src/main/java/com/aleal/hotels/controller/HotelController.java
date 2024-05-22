package com.aleal.hotels.controller;

import java.util.List;
import com.aleal.hotels.config.HotelsServiceConfigurations;
import com.aleal.hotels.model.HotelRooms;
import com.aleal.hotels.model.PropertiesHotels;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.services.IHotelService;

@RestController
public class HotelController {
	
	@Autowired
	private IHotelService service;

	@Autowired
	private HotelsServiceConfigurations configHotels;

	@GetMapping("hotels")
	public List<Hotel> search(){
		return (List<Hotel>) this.service.search();	
	}

	@GetMapping("hotels/{hotelId}")
	public HotelRooms searchHotelById(@PathVariable Long hotelId){
		return  this.service.searchHotelById(hotelId);
	}

	@GetMapping("/hotels/read/properties")
	public String getPropertiesHotels() throws JsonProcessingException {
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesHotels propHotels = new PropertiesHotels(configHotels.getMsg(), configHotels.getBuildVersion(),
				configHotels.getMailDetails());
   		String jsonString = owj.writeValueAsString(propHotels);
		   return jsonString;
    }
}
