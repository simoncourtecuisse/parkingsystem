package com.parkit.parkingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;

public class ParkingSpotTest {

	@Test
	public void getId() {
		ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
		assertEquals(1, parkingSpot.getId());
	}

	@Test
	public void setId() {
		ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
		parkingSpot.setId(111);
		assertEquals(111, parkingSpot.getId());
	}

	@Test
	public void getParkingType() {
		ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
		assertEquals(ParkingType.CAR, parkingSpot.getParkingType());
	}

	@Test
	public void setParkingType() {
		ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
		parkingSpot.setParkingType(ParkingType.BIKE);
		assertEquals(ParkingType.BIKE, parkingSpot.getParkingType());
	}

	@Test
	public void isAvailable() {
		ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, true);
		assertTrue(parkingSpot.isAvailable());
	}

	@Test
	public void setAvailable() {
		ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, true);
		parkingSpot.setAvailable(false);
		assertFalse(parkingSpot.isAvailable());
	}

	@Test
	public void equalsTrue() {
		ParkingSpot parkingSpot1 = new ParkingSpot(1, ParkingType.CAR, false);
		assertEquals(parkingSpot1, parkingSpot1);
	}

	@Test
	public void equalsFalse1() {
		ParkingSpot parkingSpot1 = new ParkingSpot(1, ParkingType.CAR, false);
		Object obj = new Object();
		assertNotEquals(parkingSpot1, obj);
	}

	@Test
	public void equalsFalse2() {
		ParkingSpot parkingSpot1 = new ParkingSpot(1, ParkingType.CAR, false);
		ParkingSpot parkingSpot2 = new ParkingSpot(2, ParkingType.CAR, false);
		assertNotEquals(parkingSpot1, parkingSpot2);
	}

	@Test
	public void hashCodeTest() {
		ParkingSpot parkingSpot1 = new ParkingSpot(1, ParkingType.CAR, false);
		ParkingSpot parkingSpot2 = new ParkingSpot(1, ParkingType.CAR, false);
		assertTrue(parkingSpot1.equals(parkingSpot2) && parkingSpot2.equals(parkingSpot1));
		assertTrue(parkingSpot1.hashCode() == parkingSpot2.hashCode());
	}

}
