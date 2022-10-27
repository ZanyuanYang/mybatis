package com.jaying.test;

import com.jaying.entity.FlightEntity;
import com.jaying.service.FlightService;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {
	public static void main(String[] args) throws IOException {
		FlightService flightService = new FlightService();

		// get
//		List<FlightEntity> flightEntity = flightService.getByFlightAll();
//		FlightEntity getByIdFlight = flightService.getByIdFlight(2);

		// insert
//		FlightEntity flightEntity = new FlightEntity("10", "10", "10", "1", new Date(), new Date(), "1", 0);
//		int result = flightService.insertFlight(flightEntity);
//		System.out.println(result);

		// update
//		FlightEntity flightEntity = new FlightEntity(1, "101", "101", "101", "11", new Date(), new Date(), "11", 1);
//		int result = flightService.updateFlight(flightEntity);

		// delete
//		int result = flightService.deleteByIdFlight(1);
//		System.out.println(result);



//		Map<String, String> parameterMap = new HashMap<>();
//		parameterMap.put("company", "company2");
//		parameterMap.put("departureAirport", "departure_airport2");
//		parameterMap.put("arriveAirport", "arrive_airport2");
//		List<FlightEntity> flightEntitys = flightService.getByIdFlightParameterMap(parameterMap);
//		System.out.println(flightEntitys);

//		List<FlightEntity> flightEntitys = flightService.getByIdFlightParameter("company2", "departure_airport2", "arrive_airport2");
//		System.out.println(flightEntitys);

		FlightEntity flightEntity = new FlightEntity();
		flightEntity.setCompany("");
		flightEntity.setDepartureAirport("departure_airport2");
		flightEntity.setArriveAirport("arrive_airport2");
		List<FlightEntity> flightEntitys = flightService.getByIdFlightPoJo(flightEntity);
		System.out.println(flightEntitys);
	}
}
