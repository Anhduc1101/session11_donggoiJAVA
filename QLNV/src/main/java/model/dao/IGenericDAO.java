package model.dao;

import model.entity.Employee;

import java.util.List;

public interface IGenericDAO <T,ID>{
    List<T> findAll();
    boolean save(T t);
    T findById(ID id);
    List<Employee> findByName(String name);
    void delete(ID id);
}
