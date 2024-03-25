package com.workwise.candidateservice.repository;

import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> findById(String id) throws SQLException;
    Map<String, T> findAll() throws SQLException;
    void insert(T entity) throws SQLException;
    void delete(T entity) throws SQLException;
    void update(T entity) throws SQLException;
}
