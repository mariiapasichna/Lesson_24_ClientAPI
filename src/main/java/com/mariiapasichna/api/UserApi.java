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
    static WebTarget getWebTarget() {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        return client.target(Main.URL);
    }

    public static void testCreate(User user) {
        WebTarget target = getWebTarget();
        Response response = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON), Response.class);
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    public static void testGetList() {
        WebTarget target = getWebTarget();
        String response = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(response);
    }

    public static void testGet(String id) {
        WebTarget target = getWebTarget();
        User user = target.path(id).request().accept(MediaType.APPLICATION_JSON).get(User.class);
        System.out.println(user);
    }

    public static void testUpdate(User user) {
        WebTarget target = getWebTarget();
        Response response = target.request().put(Entity.entity(user, MediaType.APPLICATION_JSON), Response.class);
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    public static void testDeleteAll(String path) {
        WebTarget target = getWebTarget();
        Response response = target.path(path).request().delete(Response.class);
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

//    public static void testDelete() {
//        WebTarget target = getWebTarget();
//        User user = new User(4,"Alexoff", 34);
//        Response response1 = target.path("4").request().get();
//        Response response = target.request().accept(MediaType.APPLICATION_JSON).delete();
//        System.out.println(response);
//    }
}