package com.jaying.service;

import com.jaying.entity.FlightEntity;
import com.jaying.mapper.FlightMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author jayingyoung
 */
public class FlightService {
	private FlightMapper flightMapper;
	private SqlSession sqlSession;

	public FlightService() throws IOException {
		// 通过无参构造方法 初始化mybatis
		// 1.读取加载mybatis-config.xml
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 2.获取到sqlSession
		sqlSession = sqlSessionFactory.openSession();
		flightMapper= sqlSession.getMapper(FlightMapper.class);

//		sqlSession.close();
	}

	public List<FlightEntity> getByFlightAll(){
		return flightMapper.getByFlightAll();
	}

	public FlightEntity getByIdFlight(Integer id){
		return flightMapper.getByIdFlight(id);
	}

	public int insertFlight(FlightEntity flightEntity){
		int result = flightMapper.insertFlight(flightEntity);
		// 需要提交事务
		sqlSession.commit();
		return result;
	}

	public int deleteByIdFlight(Integer id){
		int result = flightMapper.deleteByIdFlight(id);
		// 需要提交事务
		sqlSession.commit();
		return result;
	}

	public int updateFlight(FlightEntity flightEntity){
		int result = flightMapper.updateFlight(flightEntity);
		// 需要提交事务
		sqlSession.commit();
		return result;
	}

	public List<FlightEntity> getByIdFlightParameterMap(Map<String, String> parameterMap){
		return flightMapper.getByIdFlightParameterMap(parameterMap);
	}

	public List<FlightEntity> getByIdFlightParameter(String company, String departureAirport, String arriveAirport){
		return flightMapper.getByIdFlightParameter(company, departureAirport, arriveAirport);
	}

	public List<FlightEntity> getByIdFlightPoJo(FlightEntity flightEntity){
		return flightMapper.getByIdFlightPoJo(flightEntity);
	}
}
