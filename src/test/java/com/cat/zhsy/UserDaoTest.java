package com.cat.zhsy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cat.zhsy.dao.UserDao;
import com.cat.zhsy.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class UserDaoTest {

	@Resource
	private UserDao userDao;

	@Test
	public void save() throws Exception {
		System.out.println(userDao);
		User user = new User();
		user.setName("16:31");
		user.setAge(32);
		int result = userDao.save(user);
		System.out.println(result);
	}

	@Test
	public void saves() {
		List<User> users = new ArrayList<>();
		User user;
		for (int i = 1; i < 5; i++) {
			user = new User();
			user.setName("name" + i);
			user.setAge(new Random().nextInt(100));
			users.add(user);
		}

		int result = userDao.saves(users);
		System.out.println(result);
	}

	@Test
	public void update() throws Exception {
		User user = userDao.findById(3);
		user.setAge(1111);
		user.setName("update_one");
		int result = userDao.update(user);
		System.out.println(result);
	}

	// TODO
	@Test
	public void updates() throws Exception {
		List<User> userList = new ArrayList<>();
		for (int i = 1; i < 3; i++) {
			User user = userDao.findById(i);
			if (user == null) {
				continue;
			}
			user.setName("name" + i);
			user.setAge(55);
			userList.add(user);
		}
		userList.forEach((user) -> System.out.println(user));

		System.out.println("begin update batch...");
		int result = userDao.updates(userList);
		System.out.println(result);
	}

	@Test
	public void deleteById() throws Exception {
		int result = userDao.deleteById(2);
		System.out.println(result);
	}

	@Test
	public void deleteByIds() throws Exception {
		int[] ids = { 3, 5, 6 };
		int result = userDao.deleteByIds(ids);
		System.out.println(result);
	}

	@Test
	public void findById() throws Exception {
		User user = userDao.findById(1);
		System.out.println(user);
	}

	@Test
	public void findAll() throws Exception {
		Collection<User> userList = userDao.findAll();
		userList.forEach(user -> System.out.println(user));
	}

	@Test
	public void findInterval() throws Exception {
		Collection<User> userList = userDao.findInterval(0, 3);
		userList.forEach(user -> System.out.println(user));
	}

	// #自动添加引号 $直接输出...
	@Test
	public void count() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("name like", "%4%");// ..
		map.put("age > ", 31);
		int count = userDao.count(map);

		System.out.println("count: " + count);
	}

}