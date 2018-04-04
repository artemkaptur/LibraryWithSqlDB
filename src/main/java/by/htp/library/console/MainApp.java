package by.htp.library.console;

import static by.htp.library.console.util.OutputToConsole.*;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.bean.Employee;
import by.htp.library.dao.BookDAO;
import by.htp.library.dao.EmployeeDAO;
import by.htp.library.dao.impl.BookDaoDBImpl;
import by.htp.library.dao.impl.EmployeeDaoDBImpl;

public class MainApp {

	public static void main(String[] args) {

		BookDAO daoBook = new BookDaoDBImpl();
		List<Book> allBooks = daoBook.readAll();
		List<Book> booksByTitle = daoBook.readByTitle("Harry Potter");

		printList(allBooks);
		printList(booksByTitle);

		EmployeeDAO daoEmployee = new EmployeeDaoDBImpl();
		List<Employee> allEmployees = daoEmployee.readAll();
		List<Employee> employeesBySurame = daoEmployee.readBySurname("Dilinjer");

		printList(allEmployees);
		printList(employeesBySurame);

	}

}
