package com.parkit.parkingsystem.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputReaderUtilTest {

	private static InputReaderUtil inputReaderUtil;

	@BeforeEach
	private void setUpPerTest() {
		inputReaderUtil = new InputReaderUtil();
	}

	@Test
	public void readSelectionTestOK() {
		ByteArrayInputStream input = new ByteArrayInputStream("1\n".getBytes());

		Scanner scan = new Scanner(input);
		inputReaderUtil.setScan(scan);

		assertEquals(inputReaderUtil.readSelection(), 1);
	}

	@Test

	public void readSelectionTestKO() {

		ByteArrayInputStream input = new ByteArrayInputStream("Bonjour\n".getBytes());

		Scanner scan = new Scanner(input);
		inputReaderUtil.setScan(scan);

		assertEquals(inputReaderUtil.readSelection(), -1);
	}

	@Test
	public void readVehicleNumberTest() throws Exception {
		ByteArrayInputStream input = new ByteArrayInputStream("123\n".getBytes());
		Scanner scan = new Scanner(input);
		inputReaderUtil.setScan(scan);

		assertEquals(inputReaderUtil.readVehicleRegistrationNumber(), "123");

	}

	@Test
	public void readVehicleNumberTestException() {

		ByteArrayInputStream input = new ByteArrayInputStream("\n".getBytes());
		Scanner scan = new Scanner(input);
		inputReaderUtil.setScan(scan);
		assertThrows(IllegalArgumentException.class, () -> inputReaderUtil.readVehicleRegistrationNumber());
		// assertThrows()(inputReaderUtil.readVehicleRegistrationNumber().trim().length(
		// ), 0));

	}

}
