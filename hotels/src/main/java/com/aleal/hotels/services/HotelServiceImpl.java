package com.aleal.hotels.services;

import java.util.*;

import com.aleal.hotels.model.HotelRooms;
import com.aleal.hotels.model.Rooms;
import com.aleal.hotels.services.client.RoomsFeingclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aleal.hotels.dao.IHotelDao;
import com.aleal.hotels.model.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelDao hotelDao;

    @Autowired
    private RoomsFeingclient roomsFeingclient;

//	@Autowired
//	private RestTemplate clientRest;

	@Override
	public List<Hotel> search() {
		return (List<Hotel>) hotelDao.findAll();
	}

	@Override
	public HotelRooms searchHotelById(long hotelId) {
		HotelRooms hotelrooms = new HotelRooms();
		Optional<Hotel> hotel = hotelDao.findById(hotelId);

		List<Rooms> rooms = roomsFeingclient.searchByHotelId(hotelId);

		hotelrooms.setHotelId((int) hotel.get().getHotelId());
		hotelrooms.setHotelName(hotel.get().getHotelName());
		hotelrooms.setHotelAddress(hotel.get().getHotelAddress());
		hotelrooms.setRooms(rooms);
		return hotelrooms;
	}

	@Override
	public HotelRooms searchHotelwithoutRooms(long hotelId) {
		HotelRooms hotelrooms = new HotelRooms();
		Optional<Hotel> hotel = hotelDao.findById(hotelId);

		hotelrooms.setHotelId((int) hotel.get().getHotelId());
		hotelrooms.setHotelName(hotel.get().getHotelName());
		hotelrooms.setHotelAddress(hotel.get().getHotelAddress());
		return hotelrooms;
	}

	//	@Override
	//	public HotelRooms searchHotelById(long hotelId) {
	//		HotelRooms hotelrooms = new HotelRooms();
	//		Optional<Hotel> hotel = hotelDao.findById(hotelId);
	//
	//		if (!hotel.isPresent()) {
	//			// Manejo del caso donde el hotel no está presente
	//			return null;
	//		}
	//
	//		Map<String, Long> pathVariables = new HashMap<>();
	//		pathVariables.put("id", hotelId);
	//		List<Rooms> rooms = Arrays.asList(Objects.requireNonNull(
	//				clientRest.getForObject("http://localhost:8081/rooms/{id}", Rooms[].class, pathVariables)
	//		));
	//		hotelrooms.setHotelId((int) hotel.get().getHotelId());
	//		hotelrooms.setHotelName(hotel.get().getHotelName());
	//		hotelrooms.setHotelAddress(hotel.get().getHotelAddress());
	//		hotelrooms.setRooms(rooms);
	//		return hotelrooms;
	//	}

}
