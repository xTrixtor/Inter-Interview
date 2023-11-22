package com.interview.Endpoints;

import com.interview.DataStore.KeycloakService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/keycloak")
public class KeycloakController {
    @Autowired
    KeycloakService keycloakService;
    @GetMapping("/userTest")
    @RolesAllowed("Interview_User")
    public String UserRoleTest(){
        return "Du bist ein User!";
    }
    @GetMapping("/adminTest")
    @RolesAllowed("Interview_Admin")
    public String AdminRoleTest(){
        return "Du bist ein Admin!";
    }

    @GetMapping("/test")
    public String GetTokenTest(){
        keycloakService.GetToken();
        return "hadlf";
    }
}
