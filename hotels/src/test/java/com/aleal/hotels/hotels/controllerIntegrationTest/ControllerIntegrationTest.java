package com.aleal.hotels.hotels.controllerIntegrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.*;

import com.aleal.hotels.model.HotelRooms;
import com.aleal.hotels.model.Rooms;
import com.aleal.hotels.controller.HotelController;
import com.aleal.hotels.services.HotelServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private HotelServiceImpl hotelService;

    @InjectMocks
    private HotelController hotelController;

    @Before
    public void setUp() {
        HotelRooms hotel = new HotelRooms();
        hotel.setHotelId(2);
        hotel.setHotelName("Hotel Transilvania");
        hotel.setHotelAddress("Calle transilvania 444");

        Rooms room = new Rooms();
        room.setRoomId(3);
        room.setHotelId(2);
        room.setRoomName("Pieza 101");
        room.setRoomAvailable("No");

        List<Rooms> rooms = new ArrayList<>();
        rooms.add(room);
        hotel.setRooms(rooms);

        when(hotelService.searchHotelById(2)).thenReturn(hotel);
    }

    @Test
    public void testSearchEndpoint() throws Exception {
        mockMvc.perform(get("/hotels"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetPropertiesReservationsEndpoint() throws Exception {
        mockMvc.perform(get("/hotels/read/properties"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.parseMediaType("text/plain;charset=UTF-8"))
                );
    }

    @Test
    public void testSearchHotelById() throws Exception {
        mockMvc.perform(get("/hotels/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.hotelId").value(2))
                .andExpect(jsonPath("$.hotelName").value("Hotel Transilvania"))
                .andExpect(jsonPath("$.hotelAddress").value("Calle transilvania 444"))
                .andExpect(jsonPath("$.rooms[0].roomId").value(3))
                .andExpect(jsonPath("$.rooms[0].hotelId").value(2))
                .andExpect(jsonPath("$.rooms[0].roomName").value("Pieza 101"))
                .andExpect(jsonPath("$.rooms[0].roomAvailable").value("No"));
    }

}
