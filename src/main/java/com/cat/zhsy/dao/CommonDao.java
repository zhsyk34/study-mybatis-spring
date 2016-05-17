package com.cat.zhsy.dao;

import java.util.Collection;

public interface CommonDao<Entity> {

	int save(Entity entity);

	int deleteById(int id);

	int deleteByIds(int[] ids);

	int update(Entity entity);

	Entity findById(int id);

	Collection<Entity> findAll();

	Collection<Entity> findInterval(int offset, int limit);

}
