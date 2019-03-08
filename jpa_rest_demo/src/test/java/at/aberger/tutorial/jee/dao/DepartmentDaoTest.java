package at.aberger.tutorial.jee.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import at.aberger.tutorial.jee.model.Department;

public class DepartmentDaoTest {
	@Mock
	EntityManager entityManager;
	@Mock
	TypedQuery<Department> query;
	
	@InjectMocks
	DepartmentDao dao;

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("initmocks...");
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testFindAll() {
		when(entityManager.createQuery("select d from Department d", Department.class)).thenReturn(query);

		final String city = "Example City";
		final String name = "fitness";
		short number = 1;
		Department dept = new Department();
		dept.setNumber(number);
		dept.setName(name);
		dept.setLocation(city);
		when(query.getResultList()).thenReturn(Arrays.asList(dept));
		List<Department> depts = dao.findAll();
		assertNotNull(depts);
		assertSame(dept, depts.get(0));
		assertEquals(number, dept.getNumber());
		assertEquals(name, dept.getName());
		assertEquals(city, dept.getLocation());
	}
}
