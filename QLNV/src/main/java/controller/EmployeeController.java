package controller;

import model.dao.EmployeeDAO;
import model.dao.EmployeeDAOImpl;
import model.entity.Employee;
import model.service.EmployeeService;
import model.service.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "Employee", value = "/EmployeeController")
public class EmployeeController extends HttpServlet {
    public static EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    public static EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showEmployees(request, response);
        }
        switch (action) {
            case "add":
                response.sendRedirect("views/addEmployee.jsp");
//                request.getRequestDispatcher("views/addEmployee.jsp").forward(request,response);
                break;
            case "delete":
                int idDel= Integer.parseInt(request.getParameter("id"));
                employeeDAO.delete(idDel);
                showEmployees(request,response);
                break;
            case "edit":
                int idEdit = Integer.parseInt(request.getParameter("id"));
                Employee employee = employeeService.findById(idEdit);
                request.setAttribute("employee",employee);
                request.getRequestDispatcher("views/editEmployee.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
//        System.out.println(action);
        if (action == null) {
            showEmployees(request, response);
        }
        switch (action) {
            case "add":
                Employee employee = new Employee();
                employee.setName(request.getParameter("em_name"));
                employee.setPhone(request.getParameter("em_phone"));
                employee.setAddress(request.getParameter("em_address"));
                Date date_ = Date.valueOf(request.getParameter("em_birthday"));
                employee.setBirthday(date_);
                employee.setGender(Boolean.parseBoolean(request.getParameter("em_gender")));
                employee.setSalary(Integer.parseInt(request.getParameter("em_salary")));
                employeeService.save(employee);
                showEmployees(request,response);
//                System.out.println("ok ko?");
                break;
            case "edit":
                int idEdit = Integer.parseInt(request.getParameter("em_id"));
                Employee emp =  employeeService.findById(idEdit);
                emp.setName(request.getParameter("em_name"));
                emp.setPhone(request.getParameter("em_phone"));
                emp.setAddress(request.getParameter("em_address"));
                emp.setBirthday(Date.valueOf(request.getParameter("em_birthday")));
                emp.setGender(Boolean.parseBoolean(request.getParameter("em_gender")));
                emp.setSalary(Integer.parseInt(request.getParameter("em_salary")));
                employeeService.save(emp);
                showEmployees(request,response);
                break;
        }
    }

    public static void showEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("views/employeeList.jsp").forward(request, response);
    }
}