package com.aleal.hotels.hotels.controllerIntegrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
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
        mockMvc.perform(get("/hotels/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.hotelId").exists())
                .andExpect(jsonPath("$.hotelName").exists())
                .andExpect(jsonPath("$.hotelAddress").exists())
                .andExpect(jsonPath("$.rooms").isArray())
                .andExpect(jsonPath("$.rooms[0].roomId").exists())
                .andExpect(jsonPath("$.rooms[0].hotelId").exists())
                .andExpect(jsonPath("$.rooms[0].roomName").exists())
                .andExpect(jsonPath("$.rooms[0].roomAvailable").exists());
    }

}
