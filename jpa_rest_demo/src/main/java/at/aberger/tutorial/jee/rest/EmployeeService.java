package at.aberger.tutorial.jee.rest;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import at.aberger.tutorial.jee.dao.EmployeeDao;

@Path("/emp")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})

@Transactional
public class EmployeeService {
	@Inject Logger log;
	@Inject EmployeeDao dao;
	
	@GET
	public Response findAll() {
		log.debug("findAll...");
		//return Response.status(Status.GONE).build();
		return Response.ok(dao.findAll()).build();
	}

}
