package io.instacode.university.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/foo")
class FooController {

    @GetMapping("/{name}")
    public String sayHi(@PathVariable("name") String name){
        return "Hi! This is my friend, " + name +"!";
    }
}
