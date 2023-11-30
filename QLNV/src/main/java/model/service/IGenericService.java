package model.service;

import model.entity.Employee;

import java.util.List;

public interface IGenericService<T,ID>{
    List<T> findAll();
    boolean save(T t);
    T findById(ID id);
    List<Employee> findByName(String name);
    void delete(ID id);
}
