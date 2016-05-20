package com.cat.zhsy.dao;

import java.util.List;

import com.cat.zhsy.entity.Role;

public interface RoleDao extends CommonDao<Role> {

	int saves(List<Role> roles);

	int updates(List<Role> roles);

}