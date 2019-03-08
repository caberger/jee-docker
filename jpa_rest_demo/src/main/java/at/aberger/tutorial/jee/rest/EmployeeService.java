package at.aberger.tutorial.jee.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.aberger.tutorial.jee.dao.EmployeeDao;
import at.aberger.tutorial.jee.model.Employee;

@Path("/emp")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})

@Transactional
public class EmployeeService {
	@Inject Logger log;
	@Inject EmployeeDao dao;
	
	@GET
	public List<Employee> findAll() {
		log.fine("findAll...");
		return dao.findAll();
	}
}
