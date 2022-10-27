# mybatis
https://mybatis.org/mybatis-3/

MyBatis is a first class persistence framework with support for custom SQL, stored procedures and advanced mappings. MyBatis eliminates almost all of the JDBC code and manual setting of parameters and retrieval of results. MyBatis can use simple XML or Annotations for configuration and map primitives, Map interfaces and Java POJOs (Plain Old Java Objects) to database records.

## Maven Dependencies
```xml
<dependency>
	<groupId>org.mybatis</groupId>
	<artifactId>mybatis</artifactId>
	<version>3.4.5</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.18</version>
</dependency>
```

## XML Configuration
Store the database connection information `mybatis-config.xml`
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
		PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
		"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<environments default="development">
		<environment id="development">
			<transactionManager type="JDBC"/>
			<dataSource type="POOLED">
				<property name="driver" value="com.mysql.cj.jdbc.Driver"/>
				<property name="url" value="jdbc:mysql://127.0.0.1:3306/mayikt?serverTimezone=GMT%2B8"/>
				<property name="username" value="root"/>
				<property name="password" value="root"/>
			</dataSource>
		</environment>
	</environments>
	<mappers>
		<mapper resource="mybatis/userMaaper.xml"/>
	</mappers>
</configuration>
```

## Mapper
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
		PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="userMapper">
	<select id="getByUsers" resultType="com.mayikt.entity.UserEntity">
		select * from mayikt_users
	</select>
</mapper>
```

## Testing
```java
package com.jaying.test;

import com.mayikt.entity.UserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author JayingYoung
 * @ClassName Test01
 */
public class Test01 {
	public static void main(String[] args) throws IOException {
		// 1.read mybatis configuration file: mybatis-config.xml
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<UserEntity> userEntitys = sqlSession.selectList("getByUsers", UserEntity.class);
		System.out.println(userEntitys);
		sqlSession.close();
	}
}
```

## Mapper Interface
```java
package com.jaying.mapper;

import com.jaying.entity.UserEntity;

import java.util.List;

/**
 * @author JayingYoung
 * @ClassName Test01
 */
public interface FlightMapper {
	List<FlightEntity> getByFlightAll();

```

## Service
```java
package com.jaying.service;

import com.jaying.entity.FlightEntity;
import com.jaying.mapper.FlightMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author JayingYoung
 * @ClassName Test01
 */
public class FlightService {
    private FlightMapper flightMapper;

    public FlightService() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        flightMapper = sqlSession.getMapper(FlightMapper.class);
//        sqlSession.close();
    }


}
```


## mysql output log
```xml
<settings>
	<setting name="logImpl" value="STDOUT_LOGGING" />
</settings>
```