package com.infoshareacademy.service;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Context
    private UriInfo uriInfo;

    public UserService() {
    }

    @GET
    @Path("/hello/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello(@PathParam("name") String name) {
        LOG.info("Saying hello to {}!", name);

        LOG.info("Absolute path: {}", uriInfo.getAbsolutePath());
        LOG.info("Path: {}", uriInfo.getPath());
        LOG.info("Query parameters: {}", uriInfo.getQueryParameters());
        LOG.info("Path parameters: {}", uriInfo.getPathParameters());

        return Response.ok("Hello my dear " + name).build();
    }

    @GET
    @Path("/browser")
    @Produces(MediaType.TEXT_PLAIN)
    public Response checkBrowser(@HeaderParam("user-agent") String details) {

        LOG.info("Your browser is {}", details);
        return Response.ok("Your browser is " + details).build();
    }

}
