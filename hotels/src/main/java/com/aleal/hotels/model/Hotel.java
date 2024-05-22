package com.aleal.hotels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="hotel_id")
	private long hotelId;
	
	@Column(name="hotel_name")
	private String hotelName;
	
	@Column(name="hotel_address")
	private String hotelAddress;


}
