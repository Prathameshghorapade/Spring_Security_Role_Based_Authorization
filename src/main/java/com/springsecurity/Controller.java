package com.springsecurity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {





    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String AdminEndPoint(){
        return "Hello Admin";
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String UserEndPoint(){
        return "Hello User";
    }
}
