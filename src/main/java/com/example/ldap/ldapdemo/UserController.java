package com.example.ldap.ldapdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserServcie userServcie;

    @GetMapping(value = "/")
    public String greetings() {
        return "Hello Welcome to LDAP Security Module";
    }



    @GetMapping(value = "/users")
    public List<String> userList(@RequestParam(required = false) String name) {
//        if(StringUtils.hasText(name)) {
//            return userServcie.searchByNameName(name);
//        }
        return userServcie.findAll();
    }

    @GetMapping(value = "/users/{userid}")
    public List<String> getUser(@PathVariable String userid) throws JsonProcessingException {
          return userServcie.findUser(userid);
    }
}

