package com.aleal.hotels.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rooms {
    private long roomId;
    private long hotelId;
    private String roomName;
    private String roomAvailable;
}
