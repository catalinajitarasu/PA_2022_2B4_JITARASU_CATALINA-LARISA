package com.example.laborator11.controllers;

import com.example.laborator11.entity.Person;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RestClient {
    private static final String GET_ALL_USERS_API="http://localhost:8050/person/list";
    private static final String CREATE_USER_API="http://localhost:8050/person/add";
    private static final String UPDATE_USER_API="http://localhost:8050/person/update";
    private static final String DELETE_USER_API="http://localhost:8050/person/delete";
    private static final String CREATE_FRIENDS_USER_API="http://localhost:8050/person/add_friend";
    private static final String GET_USER_FRIENDS_API="http://localhost:8050/person/friends";
    private static final String GET_POPULAR_USER_API="http://localhost:8050/k-most-popular";

    static RestTemplate restTemplate=new RestTemplate();
    public static void main(String[] args){
        callGetAllUsersApi();
        callCreateUserApi();
        callUpdateUserApi();
        callDeleteUserApi();
    }

    private static void callGetAllUsersApi(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
        ResponseEntity<String> result=restTemplate.exchange(GET_ALL_USERS_API, HttpMethod.GET,entity,String.class);
        System.out.println(result);

    }

    private static void callCreateUserApi(){
        Person person=new Person("Ana");
        ResponseEntity<Person> personCreate=restTemplate.postForEntity(CREATE_USER_API,person, Person.class);
        System.out.println(personCreate.getBody());
    }

    private static void callUpdateUserApi(){
        Map<String,Integer> param=new HashMap<>();
        param.put("id",2);
        Person updatePerson=new Person("Catalina");
        ResponseEntity<Person> personUpdate=restTemplate.postForEntity(UPDATE_USER_API,updatePerson, Person.class);
        System.out.println(personUpdate);
    }

    private static void callDeleteUserApi(){
        Map<String,Integer> param=new HashMap<>();
        param.put("id",2);
        restTemplate.delete(DELETE_USER_API,param);
    }
}
