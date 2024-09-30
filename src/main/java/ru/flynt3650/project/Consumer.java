package ru.flynt3650.project;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // GET
        String getUrl = "https://reqres.in/api/users/2";
        String getResponse = restTemplate.getForObject(getUrl, String.class);
        System.out.println("Get response: " + getResponse);

        // POST
        String postUrl = "https://reqres.in/api/users";
        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "Test Name");
        jsonToSend.put("age", "30");
        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);
        String postResponse = restTemplate.postForObject(postUrl, request, String.class);
        System.out.println("Post response: " + postResponse);
    }
}