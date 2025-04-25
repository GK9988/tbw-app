package org.garvk.movie_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping("/")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Hello From Movie Service!", HttpStatus.OK);
    }

}
