package com.mariiapasichna;

import com.mariiapasichna.api.UserApi;
import com.mariiapasichna.model.User;

public class Main {

    public static final String URL = "http://localhost:" + System.getProperty("config") + "/Lesson_24_mariiapasichna/database";
    public static final String PATH = "clear";

    public static void main(String[] args) {
        UserApi.testDeleteAll(PATH);
        UserApi.testCreate(new User("Alex", 22));
        UserApi.testCreate(new User("Ben", 33));
        UserApi.testCreate(new User("Bill", 44));
        UserApi.testCreate(new User("Poll", 55));
        UserApi.testGetList();
        UserApi.testGet("31");
        UserApi.testUpdate(new User(7, "Poll", 100));
    }
}