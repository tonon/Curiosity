package com.tonon.curiosity.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tonon.curiosity.robot.Curiosity;



@Path("/mars")
public class MessageRestService {

	@GET
	@Path("/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
	public Response printMessage(@PathParam("param")  String msg) {		

		Curiosity curiosity = new Curiosity();
		final String finalPos = curiosity.move(msg);

		 return Response.status(201).entity(finalPos).build();

	}
	
	
	

}
