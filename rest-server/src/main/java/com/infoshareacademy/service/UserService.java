package com.infoshareacademy.service;

import com.infoshareacademy.model.Credentials;
import com.infoshareacademy.model.User;
import com.infoshareacademy.model.UserStore;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response.Status;
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

    @Inject
    private UserStore userStore;

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

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@QueryParam("id") Integer id) {

        LOG.info("Querying user id {}", id);

        User user = userStore.getBase().get(id);
        if (user == null) {
            LOG.warn("No user found");
            return Response.status(Status.NOT_FOUND).build();
        }

        LOG.info("User found: {}", user);
        return Response.ok(user).build();
    }

    @GET
    @Path("/login")
    @Produces(MediaType.TEXT_HTML)
    public Response showLoginForm() {
        String form = "<form action=\"authenticate\" method=\"post\">\n"
            + "  Login: <input type=\"text\" name=\"login\"/><br/>\n"
            + "  Password: <input type=\"password\" name=\"pass\"/><br/>\n"
            + "  <input type=\"Submit\" value=\"GO\"/>\n"
            + "</form>";

        return Response.ok(form).build();
    }

    @POST
    @Path("/authenticate")
    public Response authenticateForm(
        @FormParam("login") String username,
        @FormParam("pass") String password
    ) {
        // LOGOWANIE HASLA TO ZLY POMYSL !!!
        LOG.info("Sent form with the details: username {}, password {}", username, password);

        boolean userExists = userStore.getBase().values().stream()
            .map(User::getCredentials)
            .anyMatch(c -> c.getUser().equals(username)
                && c.getPassword().equals(password));

        if (userExists) {
            LOG.info("User found!");
            return Response.ok().build();
        }

        LOG.warn("User not found :-C");
        return Response.status(Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("/authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticate(Credentials credentials) {
        String username = credentials.getUser();
        String password = credentials.getPassword();
        return authenticateForm(username, password);
    }

    @POST
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {

        int newId = userStore.getNextId();

        userStore.add(new User(
            user.getName(),
            user.getSurname(),
            newId,
            user.getCredentials()
        ));

        return getUsers();
    }

    @PUT
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {

        LOG.info("Updating user with id {}", user.getId());

        if (userStore.getBase().containsKey(user.getId())) {
            userStore.getBase().put(user.getId(), user);
            return getUser(user.getId());
        }

        LOG.warn("User not found :-C");
        return Response.status(Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@QueryParam("id") Integer id) {
        LOG.info("Removing user with id {}", id);

        if (userStore.getBase().containsKey(id)) {
            userStore.getBase().remove(id);

            LOG.info("User successfully removed");
            return getUsers();
        }

        LOG.warn("User not found");
        return Response.status(Status.NOT_FOUND).build();
    }
}
