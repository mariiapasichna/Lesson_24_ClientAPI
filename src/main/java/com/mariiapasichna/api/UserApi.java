package com.mariiapasichna.api;

import com.mariiapasichna.Main;
import com.mariiapasichna.model.User;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UserApi {
    private static UserApi instance;
    private WebTarget target = getWebTarget();

    public static synchronized UserApi getInstance() {
        if (instance == null) {
            instance = new UserApi();
        }
        return instance;
    }

    private UserApi() {
    }

    private WebTarget getWebTarget() {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        return client.target(Main.URL);
    }

    public Response testCreate(User user) {
        return target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON), Response.class);
    }

    public Response testGetList() {
        return target.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
    }

    public Response testGet(String id) {
        return target.path(id).request().accept(MediaType.APPLICATION_JSON).get(Response.class);
    }

    public Response testUpdate(User user) {
        return target.request().put(Entity.entity(user, MediaType.APPLICATION_JSON), Response.class);
    }

    public Response testDeleteAll(String path) {
        return target.path(path).request().delete(Response.class);
    }

    //From the Jersey client API, the SyncInvoker class doesn't support a delete method with entity body as its argument.
    //Exception in thread "main" java.lang.IllegalStateException: Entity must be null for http method DELETE.
    public Response testDelete(User user) {
        return target.request().method("DELETE", Entity.entity(user, MediaType.APPLICATION_JSON), Response.class);
    }
}