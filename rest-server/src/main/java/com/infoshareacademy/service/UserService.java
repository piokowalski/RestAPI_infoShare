package com.infoshareacademy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/")
public class UserService {

    private static final Logger LOG =
            LoggerFactory.getLogger(UserService.class);

    @Context
    private UriInfo uriInfo;


    public UserService() {
    }

    @GET
    @Path("/hello/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @HeaderParam("hello{name}")
    public Response sayHello(@PathParam("name") String name) {
        LOG.info("Saying hello to {}!", name);

        LOG.info("Absolute path: {}", uriInfo.getAbsolutePath());
        LOG.info("Path: {}", uriInfo.getPath());
        LOG.info("Query parameters: {}", uriInfo.getQueryParameters());
        LOG.info("Path parameters: {}", uriInfo.getPathParameters());


        return Response.ok("Hello, dear "+name+"!").build();
    }
}