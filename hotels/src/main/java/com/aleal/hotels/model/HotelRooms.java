package com.aleal.hotels.model;
import lombok.Data;

import java.util.List;

@Data
public class HotelRooms {
    private int hotelId;
    private String hotelName;
    private String hotelAddress;
    private List<Rooms> rooms;
}
