package model.service;

import model.dao.EmployeeDAO;
import model.dao.EmployeeDAOImpl;
import model.entity.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public List findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public boolean save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Employee findById(Integer integer) {
        return employeeDAO.findById(integer);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeDAO.findByName(name);
    }

    @Override
    public void delete(Integer integer) {
        employeeDAO.delete(integer);
    }
}
