package com.jaying.mapper;

import com.jaying.entity.FlightEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FlightMapper {
	/**
	 * 查询
	 * 1. 查询所有
	 * 2.
	 */
	List<FlightEntity> getByFlightAll();

	/**
	 *
	 * @param id
	 * @return
	 */
	FlightEntity getByIdFlight(Integer id);

	/**
	 *
	 * @param flightEntity
	 * @return
	 */
	int insertFlight(FlightEntity flightEntity);

	int updateFlight(FlightEntity flightEntity);

	int deleteByIdFlight(Integer id);

	/**
	 * 多条件查询 map集合传递参数
	 * parameterMap.put()
	 * key = company
	 * value = "company10"
	 * key = departure_airport
	 * value = "departure_airport2"
	 * key = arrive_airport
	 * value = "arrive_airport2"
	 * @param parameterMap
	 * @return
	 */
	List<FlightEntity> getByIdFlightParameterMap(Map<String, String> parameterMap);

	List<FlightEntity> getByIdFlightParameter(@Param("company") String company,
											  @Param("departureAirport") String departureAirport,
											  @Param("arriveAirport") String arriveAirport);

	List<FlightEntity> getByIdFlightPoJo(FlightEntity flightEntity);
}
