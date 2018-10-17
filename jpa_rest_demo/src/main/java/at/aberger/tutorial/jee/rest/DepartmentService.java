package at.aberger.tutorial.jee.rest;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.aberger.tutorial.jee.dao.DepartmentDao;
import at.aberger.tutorial.jee.model.Department;

@Path("/dept")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})

@Transactional
public class DepartmentService {
	@Inject private DepartmentDao dao;
	
	@GET
	public List<Department> findAll() {
		return dao.findAll();
	}
}
