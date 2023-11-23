package com.interview.DataStore;

import com.interview.Endpoints.KeycloakController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

import java.util.Collections;

@Service
public class KeycloakService {

    public String getToken(KeycloakController.LoginRequest req) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl =
                "http://localhost:8080/realms/inter/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("client_id", "inter-interview-api");
        map.add("username", req.username());
        map.add("password", req.password());

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(map, headers);

        var response = restTemplate.postForEntity(resourceUrl, request, KeycloakLoginResponse.class);

        return response.getBody().access_token;
    }
    record KeycloakLoginResponse(String access_token, String refresh_token) {
    }

}

