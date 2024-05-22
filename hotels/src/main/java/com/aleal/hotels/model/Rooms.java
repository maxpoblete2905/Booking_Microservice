package com.aleal.hotels.model;

import lombok.Data;

@Data
public class Rooms {
    private long roomId;
    private long hotelId;
    private String roomName;
    private String roomAvailable;
}
