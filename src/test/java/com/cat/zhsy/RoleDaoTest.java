package com.cat.zhsy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cat.zhsy.dao.RoleDao;
import com.cat.zhsy.entity.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class RoleDaoTest {

	@Resource
	private RoleDao roleDao;

	@Test
	public void save() throws Exception {
		Role role = new Role();
		role.setName("undefine");
		int result = roleDao.save(role);
		System.out.println(result);
	}

	@Test
	public void saves() {
		List<Role> roles = new ArrayList<>();
		Role role;
		for (int i = 1; i < 5; i++) {
			role = new Role();
			role.setName("role_name" + i);
			roles.add(role);
		}

		int result = roleDao.saves(roles);
		System.out.println(result);
	}

	@Test
	public void update() throws Exception {
		Role role = roleDao.findById(2);
		role.setName("Super Gamer");
		int result = roleDao.update(role);
		System.out.println(result);
	}

	// TODO
	@Test
	public void updates() throws Exception {
		List<Role> userList = new ArrayList<>();
		for (int i = 1; i < 3; i++) {
			Role role = roleDao.findById(i);
			if (role == null) {
				continue;
			}
			role.setName("name" + i);
			userList.add(role);
		}
		userList.forEach((role) -> System.out.println(role));

		System.out.println("begin update batch...");
		int result = roleDao.updates(userList);
		System.out.println(result);
	}

	@Test
	public void deleteById() throws Exception {
		int result = roleDao.deleteById(7);
		System.out.println(result);
	}

	@Test
	public void deleteByIds() throws Exception {
		int[] ids = { 9, 10 };
		int result = roleDao.deleteByIds(ids);
		System.out.println(result);
	}

	@Test
	public void findById() throws Exception {
		Role role = roleDao.findById(1);
		System.out.println(role);
	}

	@Test
	public void findAll() throws Exception {
		Collection<Role> userList = roleDao.findAll();
		userList.forEach(role -> System.out.println(role));
	}

	@Test
	public void findInterval() throws Exception {
		Collection<Role> userList = roleDao.findInterval(0, 3);
		userList.forEach(role -> System.out.println(role));
	}

	// #自动添加引号 $直接输出...
	@Test
	public void count() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("name like", "%name%");// ..
		map.put("id > ", 5);
		map.put("id < ", "11");
		int count = roleDao.count(map);

		System.out.println("count: " + count);
	}

}