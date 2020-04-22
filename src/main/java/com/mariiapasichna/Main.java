package com.mariiapasichna;

import com.mariiapasichna.api.UserApi;
import com.mariiapasichna.model.User;

import javax.ws.rs.core.Response;

public class Main {

    public static final String URL = "http://localhost:" + System.getProperty("config") + "/Lesson_24_mariiapasichna/database";
    public static final String PATH = "clear";

    public static void main(String[] args) {
        UserApi userApi = UserApi.getInstance();
        printResponse(userApi.testDeleteAll(PATH));
        printResponse(userApi.testCreate(new User("Alex", 22)));
        printResponse(userApi.testCreate(new User("Ben", 33)));
        printResponse(userApi.testCreate(new User("Bill", 44)));
        printResponse(userApi.testCreate(new User("Poll", 55)));
        printResponse(userApi.testGetList());
        printResponse(userApi.testGet("75"));
        printResponse(userApi.testUpdate(new User(75, "Poll", 100)));
        //printResponse(userApi.testDelete(new User(71, "Poll", 55)));
    }

    private static void printResponse(Response response) {
        System.out.println("Response code: " + response.getStatus() + ". Response body: " + response.readEntity(String.class));
    }
}