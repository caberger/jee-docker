package at.aberger.tutorial.jee.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import at.aberger.tutorial.jee.dao.EmployeeDao;
import at.aberger.tutorial.jee.model.Department;
import at.aberger.tutorial.jee.model.Employee;

class EmployeeServiceTest {
	@Mock
	private static Logger log;	
	@Mock
	EmployeeDao dao;
	@InjectMocks
	EmployeeService empSrv;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		log = Logger.getLogger(getClass().getSimpleName());
	}
	@Test
	void testFindAll() {
		final String name = "Joe Sixpack";
		final BigDecimal commission = new BigDecimal(1000);
		final BigDecimal salary = new BigDecimal(2000);
		final Date hireDate = new Date(System.currentTimeMillis());
		final String job = "trainer";
		final int number = 1;
		Employee emp = new Employee();
		Department dep = new Department();
		emp.setName(name);
		emp.setCommission(commission);
		emp.setDepartment(dep);
		emp.setHireDate(hireDate);
		emp.setName(name);
		emp.setJob(job);
		emp.setNumber(number);
		emp.setSalary(salary);
		when(dao.findAll()).thenReturn(Arrays.asList(emp));
		List<Employee> emps = empSrv.findAll();
		assertEquals(1, emps.size());
		assertSame(dep, emp.getDepartment());
		assertEquals(hireDate, emp.getHireDate());
		assertEquals(job, emp.getJob());
		assertEquals(name, emp.getName());
		assertEquals(commission, emp.getCommission());
		assertTrue(number == emp.getNumber());
		assertEquals(salary, emp.getSalary());
	}

}
