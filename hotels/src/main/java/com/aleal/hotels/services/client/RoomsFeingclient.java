package com.aleal.hotels.services.client;

import com.aleal.hotels.model.Rooms;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("rooms")
public interface RoomsFeingclient {

    @RequestMapping(method = RequestMethod.GET, value = "rooms/{id}",  consumes = "applications/json")
    public List<Rooms> searchByHotelId(@PathVariable Long id);

}

