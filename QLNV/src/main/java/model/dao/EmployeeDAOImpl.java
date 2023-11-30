package model.dao;

import model.entity.Employee;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    public int limit=3;
    public int totalPage=0;
    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        Connection con = ConnectionDB.openCon();
        try {
            CallableStatement cs = con.prepareCall("call proc_show_employee()");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setPhone(rs.getString("phone"));
                employee.setAddress(rs.getString("address"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setGender(rs.getBoolean("gender"));
                employee.setSalary(rs.getInt("salary"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeCon(con);
        }
        return employees;
    }

    @Override
    public boolean save(Employee employee) {
        Connection con = ConnectionDB.openCon();
        CallableStatement cs = null;
        int check;
        try {
            if (employee.getId() == 0) {
                cs = con.prepareCall("call proc_add_employee(?,?,?,?,?,?)");
                cs.setString(1, employee.getName());
                cs.setString(2, employee.getPhone());
                cs.setString(3, employee.getAddress());
                cs.setDate(4, employee.getBirthday());
                cs.setBoolean(5, employee.isGender());
                cs.setInt(6, employee.getSalary());
            } else {
                cs = con.prepareCall("call proc_edit_employee(?,?,?,?,?,?,?)");
                cs.setString(1, employee.getName());
                cs.setString(2, employee.getPhone());
                cs.setString(3, employee.getAddress());
                cs.setDate(4, employee.getBirthday());
                cs.setBoolean(5, employee.isGender());
                cs.setInt(6, employee.getSalary());
                cs.setInt(7, employee.getId());
            }
            check = cs.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeCon(con);
        }
        return false;
    }

    @Override
    public Employee findById(Integer integer) {
        Employee employee = new Employee();
        Connection con = ConnectionDB.openCon();
        try {
            CallableStatement cs = con.prepareCall("call proc_find_employee_by_id(?)");
            cs.setInt(1, integer);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setPhone(rs.getString("phone"));
                employee.setAddress(rs.getString("address"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setGender(rs.getBoolean("gender"));
                employee.setSalary(rs.getInt("salary"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeCon(con);
        }
        return employee;
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> employees = new ArrayList<>();
        Connection con = ConnectionDB.openCon();
        try {
            CallableStatement cs = con.prepareCall("call proc_find_employee_by_name(?)");
            cs.setString(1, name);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setPhone(rs.getString("phone"));
                employee.setAddress(rs.getString("address"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setGender(rs.getBoolean("gender"));
                employee.setSalary(rs.getInt("salary"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeCon(con);
        }

        return employees;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = ConnectionDB.openCon();
        try {
            CallableStatement cs = connection.prepareCall("call proc_delete_employee(?)");
            cs.setInt(1, integer);
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeCon(connection);
        }
    }
}
