package com.SocialMediaApp.FriendsBook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;


@RestController
//@RequestMapping("/users")
public class UserService {

    @Autowired
    UserReporsitory userRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/users")
    public ResponseEntity getUsers() throws JsonProcessingException {

        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(objectMapper.writeValueAsString(users));
    }
//    @GetMapping("/users")
//    public List<User> getAll() {
//        return jdbcTemplate.query("SELECT id,username,password from User",
//                BeanPropertyRowMapper.newInstance(User.class));
//    }

    @GetMapping("/test")
    public String test(){
        return "TEST";
    }

}
