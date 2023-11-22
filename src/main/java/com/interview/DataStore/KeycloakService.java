package com.interview.DataStore;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

@Service
public class KeycloakService {
    public String GetToken(){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl =
                "http://localhost:8080/realms/inter/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("client_id", "inter-client");
        map.add("username", "real_master");
        map.add("password", "superSecretPassword");

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(map, headers);

        var response = restTemplate.postForEntity(resourceUrl, request, KeycloakLoginResponse.class);
        return "";
    }
}

record KeycloakLoginRequest(String username, String password){}
class KeycloakLoginResponse{

}