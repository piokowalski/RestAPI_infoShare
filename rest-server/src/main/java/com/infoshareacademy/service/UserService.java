package com.infoshareacademy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class UserService {

    private Logger LOG = LoggerFactory.getLogger(UserService.class);

    public UserService() {
    }

    @GET
    @Path("/hello/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        LOG.info("Saying hello!");

        return Response.ok().build();
    }
}