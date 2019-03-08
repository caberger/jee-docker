package at.aberger.tutorial.jee.rest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import at.aberger.tutorial.jee.dao.DepartmentDao;
import at.aberger.tutorial.jee.model.Department;

public class DepartmentServiceTest {
	@Mock
	EntityManager entityManager;
	@Mock
	TypedQuery<Department> query;

	@Mock
    private DepartmentDao daoMock;
	
	@InjectMocks
	private DepartmentService departmentService;
	
	private Department department;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		department = new Department();
	}
	@Test
	public void testConventions() {
		assertNull(department.getName());
		assertNull(department.getLocation());
		assertEquals((short)0, department.getNumber());
	}
	@Test
	public void testFindAll() {
		when(daoMock.findAll()).thenReturn(Arrays.asList(department));
		List<Department> departments = departmentService.findAll();
		assertEquals(1, departments.size());
	}
}
