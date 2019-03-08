package at.aberger.tutorial.jee.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

import at.aberger.tutorial.jee.model.Employee;

class EmployeeDaoTest {
	@Mock
	EntityManager entityManager;
	@Mock
	TypedQuery<Employee> query;
	
	@InjectMocks
	EmployeeDao dao;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindAll() {
		Employee emp = new Employee();
		when(entityManager.createQuery(anyString(), eq(Employee.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(Arrays.asList(emp));
		List<Employee> emps = dao.findAll();
		assertNotNull(emps);
		assertEquals(1, emps.size());
		assertSame(emps.get(0), emp);
	}
}
