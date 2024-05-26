package com.aleal.reservations.controllerIntegrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

    String expectedJson = "{\n" +
            "  \"msg\": \"Welcome to the Reservations Hotels applications\",\n" +
            "  \"buildVersion\": \"1\",\n" +
            "  \"mailDetails\": {\n" +
            "    \"hostName\": \"prod-max.poblete2905@gmail.com\",\n" +
            "    \"port\": \"7410\",\n" +
            "    \"from\": \"prod-max.poblete2905@gmail.com\",\n" +
            "    \"subject\": \"Your Reservations is ready\"\n" +
            "  }\n" +
            "}";

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testSearchEndpoint() throws Exception {
        mockMvc.perform(get("/reservations"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPropertiesReservationsEndpoint() throws Exception {
        mockMvc.perform(get("/reservations/read/properties"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.parseMediaType("text/plain;charset=UTF-8")))
                .andExpect(content().json(expectedJson));
    }

}
