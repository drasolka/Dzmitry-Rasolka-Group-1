package com.epam.mentoring.ddd.dao;

import java.io.Serializable;

public interface GenericDao<T, ID extends Serializable> {

	void create(T entity);

	T findByID(Integer id);

	T update(T entity);

	void delete(T entity);

}
