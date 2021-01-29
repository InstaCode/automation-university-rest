package io.instacode.university.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/foo")
public class FooController {

    @GetMapping("/{name}")
    public String sayHi(@PathVariable("name") String name){
        return "Hi! This is my friend, " + name +"!";
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @GetMapping("/")
    public void error() {
    }
}
