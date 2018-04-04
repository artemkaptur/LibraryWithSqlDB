package by.htp.library.dao.impl;

import static by.htp.library.dao.impl.util.DBConnectionHelper.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.bean.Employee;
import by.htp.library.dao.EmployeeDAO;

public class EmployeeDaoDBImpl implements EmployeeDAO {

	private static final String SQL_SELECT_EMPLOYEES = "SELECT * FROM employees";
	private static final String SQL_SELECT_EMPLOYEES_BY_SURNAME = "SELECT * FROM employees WHERE surname = ";

	public void create(Employee entity) {

	}

	public Employee read(int id) {

		return null;
	}

	public List<Employee> readAll() {

		List<Employee> employees = new ArrayList<>();
		Connection connection = connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_EMPLOYEES);

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setSurname(rs.getString("surname"));
				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
		return employees;
	}

	public List<Employee> readBySurname(String surname) {

		List<Employee> employees = new ArrayList<>();
		Connection connection = connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_EMPLOYEES_BY_SURNAME + "'" + surname + "'");

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setSurname(rs.getString("surname"));
				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
		return employees;
	}

	public void update(Employee entity) {

	}

	public void delete(int id) {

	}

}
