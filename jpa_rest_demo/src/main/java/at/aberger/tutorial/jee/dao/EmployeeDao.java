package at.aberger.tutorial.jee.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import at.aberger.tutorial.jee.database.Database;
import at.aberger.tutorial.jee.model.Employee;

@Named
public class EmployeeDao {
	@Inject @Database
	private EntityManager em;
	
	public List<Employee> findAll() {
		return em.createQuery("select e from Employee e join fetch e.department", Employee.class).getResultList();
	}
}
