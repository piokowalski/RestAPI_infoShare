package com.infoshareacademy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class UserService {

    private Logger LOG =
            LoggerFactory.getLogger(UserService.class);

    public UserService() {
    }

    @GET
    @Path("/hello/{name}")

    @Produces(MediaType.TEXT_PLAIN)
    @HeaderParam("hello{name}")
    public Response sayHello(
            @PathParam("name") String name) {
        LOG.info("Saying hello to {}!", name);


        return Response.ok("Hello, dear "+name).build();
    }
}