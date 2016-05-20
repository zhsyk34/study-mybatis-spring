package com.cat.zhsy.dao;

import java.util.Collection;
import java.util.Map;

public interface CommonDao<Entity> {

	int save(Entity entity);

	int deleteById(int id);

	int deleteByEntity(Entity entity);

	int deleteByIds(int[] ids);

	int deleteByEntitys(Collection<Entity> entities);

	int update(Entity entity);

	Entity findById(int id);

	Collection<Entity> findAll();

	Collection<Entity> findInterval(int offset, int limit);

	int count(Map<String, Object> map);

}
