package at.aberger.tutorial.jee.rest;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import at.aberger.tutorial.jee.dao.DepartmentDao;

@Path("/dept")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})

@Transactional
public class DepartmentEntpoint {
	@Inject Logger log;
	@Inject DepartmentDao dao;
	
	@GET
	public Response findAll() {
		log.debug("findAll...");
		return Response.ok(dao.findAll()).build();
	}
}
