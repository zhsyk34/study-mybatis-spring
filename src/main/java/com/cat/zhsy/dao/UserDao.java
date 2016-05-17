package com.cat.zhsy.dao;

import java.util.List;

import com.cat.zhsy.entity.User;

public interface UserDao extends CommonDao<User> {

	int saves(List<User> users);

	int updates(List<User> users);

}