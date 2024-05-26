package com.aleal.hotels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
