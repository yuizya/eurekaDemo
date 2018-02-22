package com.itmuch.cloud.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.itmuch.cloud.entity.User;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	@Autowired
	private UserMapper target;
	@Test
	public void testFetchUserByUsername() {
		User user = target.fetchUserByUsername("user1");
		System.out.println(user);
		assertEquals("张三", target.fetchUserByUsername("user1").getName());
	}
	@Test
	public void testFetchUserById() {
		Long id=1L;
		User user = target.fetchUserById(id);
		System.out.println(user);
	}

}
