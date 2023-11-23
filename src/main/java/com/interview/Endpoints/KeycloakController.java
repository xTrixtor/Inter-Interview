package com.interview.Endpoints;

import com.interview.DataStore.KeycloakService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/keycloak")
@CrossOrigin(maxAge = 3600)
public class KeycloakController {

    @Autowired
    KeycloakService keycloakService;
    @GetMapping("/userTest")
    @RolesAllowed("Interview_User")
    @SecurityRequirement(name = "bearerAuth")
    public String UserRoleTest(){
        return "Du bist ein User!";
    }
    @GetMapping("/adminTest")
    @RolesAllowed("Interview_Admin")
    @SecurityRequirement(name = "bearerAuth")
    public String AdminRoleTest(){
        return "Du bist ein Admin!";
    }

    @PostMapping("/login")
    public String GetTokenTest(@RequestBody LoginRequest loginRequest){
        return keycloakService.getToken(loginRequest);
    }
    public record LoginRequest(String username, String password){}
}
