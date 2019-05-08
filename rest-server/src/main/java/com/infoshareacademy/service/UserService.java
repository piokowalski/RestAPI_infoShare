package com.infoshareacademy.service;

import com.infoshareacademy.model.User;
import com.infoshareacademy.model.UserStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.ArrayList;

@Path("/")
public class UserService {

    private static final Logger LOG =
            LoggerFactory.getLogger(UserService.class);

    @Context
    private UriInfo uriInfo;

    @Inject
    private UserStore userStore;

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

    @GET
    @Path("/browser")
    @Produces(MediaType.TEXT_PLAIN)
    public Response showWebBrowser(@HeaderParam("user-agent") String details){

        LOG.info("Your browser is {}", details);

        return Response.ok("You're currently using " + details).build();
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<User> users = new ArrayList<>(userStore.getBase().values());

        if (users.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(users).build();
    }
}