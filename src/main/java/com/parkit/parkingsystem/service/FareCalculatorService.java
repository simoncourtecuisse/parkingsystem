package com.parkit.parkingsystem.service;

import java.text.DecimalFormat;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;

public class FareCalculatorService {

	public void calculateFare(Ticket ticket, boolean alreadyExist) {
		if ((ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime()))) {
			throw new IllegalArgumentException("Out time provided is incorrect:" + ticket.getOutTime().toString());
		}

		/*
		 * int inHour = ticket.getInTime().getHours(); int outHour =
		 * ticket.getOutTime().getHours();
		 * 
		 * // TODO: Some tests are failing here. Need to check if this logic is correct
		 * int duration = outHour - inHour;
		 */
		long inMillis = ticket.getInTime().getTime();
		long outMillis = ticket.getOutTime().getTime();

		double duration = (outMillis - inMillis) / (1000.0 * 60.0 * 60.0); // 60.0 -> double
		DecimalFormat df = new DecimalFormat("#.###");
		// df.setRoundingMode(RoundingMode.DOWN);

		// double price = Double.parseDouble(df.format(calculatePrice(duration,
		// ticket)));
		double price = calculatePrice(duration, ticket, alreadyExist);
		price = Double.valueOf(df.format(price).replace(",", "."));
		if (duration <= 0.50) {
			ticket.setPrice(0.0);
		} else {
			ticket.setPrice(price);
		}

	}

	public double calculatePrice(double duration, Ticket ticket, boolean alreadyExist) {

		double price = 0.0;

		switch (ticket.getParkingSpot().getParkingType()) {
		case CAR: {
			if (alreadyExist == true) {
				price = duration * Double.valueOf(0.95) * Fare.CAR_RATE_PER_HOUR;
			} else {
				price = duration * Fare.CAR_RATE_PER_HOUR;
			}
			break;
		}
		case BIKE: {
			if (alreadyExist) {
				price = duration * Double.valueOf(0.95) * Fare.BIKE_RATE_PER_HOUR;
			} else {
				price = duration * Fare.BIKE_RATE_PER_HOUR;
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unkown Parking Type");
		}
		return price;
	}

}