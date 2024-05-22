package com.aleal.rooms.services;

import java.util.List;

import com.aleal.rooms.model.Room;

public interface IRoomService {
	
	List<Room> search();

	List<Room> searchRoomsByHotelsId(long id);
}
