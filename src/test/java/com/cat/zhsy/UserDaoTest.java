package com.cat.zhsy;

import java.util.ArrayList;
import java.util.List;

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
	public void save() {
		User user = new User();
		user.setName("test");
		int result = userDao.save(user);
		System.out.println(result);
	}

	@Test
	public void saves() {
		List<User> users = new ArrayList<>();
		User user = null;
		for (int i = 1; i < 5; i++) {
			user = new User();
			user.setName("name" + i);
			users.add(user);
		}

		int result = userDao.saves(users);
		System.out.println(result);
	}

	@Test
	public void del() {
		int result = userDao.deleteById(7);
		System.out.println(result);
	}

	@Test
	public void delBatch() {
		int[] ids = { 1, 2, 5 };
		int result = userDao.deleteByIds(ids);
		System.out.println(result);
	}

	@Test
	public void update() {
		User user = userDao.findById(3);
		user.setName("new name");
		int result = userDao.update(user);
		System.out.println(result);
	}

	@Test // TODO
	public void updates() {
		User user = userDao.findById(3);
		user.setName("new name");
		int result = userDao.update(user);
		System.out.println(result);
	}

	@Test
	public void find() {
		User user = userDao.findById(3);
		System.out.println(user);
	}

	@Test
	public void findAll() {
		List<User> users = (List<User>) userDao.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void findInterval() {
		List<User> users = (List<User>) userDao.findInterval(0, 2);
		for (User user : users) {
			System.out.println(user);
		}
	}
}
