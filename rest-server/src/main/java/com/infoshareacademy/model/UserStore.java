package com.infoshareacademy.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class UserStore {

    private Logger LOG = LoggerFactory.getLogger(UserStore.class);

    private Map<Integer, User> base;

    public Map<Integer, User> getBase() {
        return base;
    }

    public UserStore() {
        LOG.info("initializing user store");
        base = new HashMap<Integer, User>();

        User user1 = new User("Adam", "Iksinski", 1,
                new Credentials("adam", "haslo123"));

        User user2 = new User("Karol", "Ygrekowski", 2,
                new Credentials("karoly", "123456"));

        base.put(user1.getId(), user1);
        base.put(user2.getId(), user2);
    }

    public void add(User user) {
        LOG.info("Adding to store: " + user.toString());
        base.put(user.getId(), user);
    }
}
