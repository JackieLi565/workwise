package com.workwise.jobservice.repository;

import java.sql.SQLException;
import java.util.Map;

public interface DAO<T> {
    T findById(String id) throws SQLException;
    Map<String, T> findAll() throws SQLException;
    void insert(T entity) throws SQLException;
    void delete(T entity) throws SQLException;
    void update(T entity) throws SQLException;
}
