package com.coe692.workwise.dao;

import com.coe692.workwise.exception.NoDataException;

import java.sql.SQLException;
import java.util.Map;

public interface DAO<T> {
    T findById(String id) throws SQLException, NoDataException;

    // return an empty map if there is no data
    Map<String, T> findAll() throws SQLException;
    void insert(T entity) throws SQLException;
    void delete(T entity) throws SQLException;
    void update(T entity) throws SQLException;
}
