package com.cat.zhsy;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cat.zhsy.dao.UserDao;
import com.cat.zhsy.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring.xml" })
public class UserDaoTest {

	@Resource
	private UserDao userDao;

	@Test
	public void testFind() {
		User user = userDao.find(1);
		System.out.println(user);
	}
}
