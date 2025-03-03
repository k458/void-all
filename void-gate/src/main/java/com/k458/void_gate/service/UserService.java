package com.k458.void_gate.service;

import com.k458.void_gate.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService{

    private final RestTemplate restTemplate = new RestTemplate();

    public List<User> getAllUsers() {
        String url = "http://void-db-users:8080/users/all";
        ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);
        return Arrays.asList(response.getBody());
    }

    public User getUserById(Long id) {
        String url = "http://void-db-users:8080/users/"+id;
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        if (response.getStatusCode() == HttpStatus.OK) return response.getBody();
        return null;
    }

    public User updateUser(User u) {
        String url = "http://void-db-users:8080/users";
        HttpEntity<User> request = new HttpEntity<>(u);
        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.PUT, request, User.class);
        return response.getBody();
    }

    public User createUser(User u) {
        String url = "http://void-db-users:8080/users";
        HttpEntity<User> request = new HttpEntity<>(u);
        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.POST, request, User.class);
        return response.getBody();
    }

    public void deleteUser(Long id) {
        String url = "http://void-db-users:8080/users/{id}";
        restTemplate.delete(url, id);
    }
}
