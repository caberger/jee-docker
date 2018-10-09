package at.aberger.tutorial.jee.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import at.aberger.tutorial.jee.model.Employee;

@Named
public class EmployeeDao {
	@PersistenceContext 
	EntityManager em;
	
	public List<Employee> findAll() {
		return em.createQuery("select e from Employee e join fetch e.department", Employee.class).getResultList();
	}

}
