package com.mjovanc.reddit.controller;

import com.mjovanc.reddit.model.User;
import com.mjovanc.reddit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class RedditController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("add")
    public String addUser(@RequestParam String first, @RequestParam String last) {
        User user = new User();
        user.setFirstName(first);
        user.setLastName(last);
        userRepository.save(user);
        return "A new user has been added to the repo!";
    }

    @GetMapping("list")
    public Iterable<User> getUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Integer id) {
        return this.userRepository.findUserById(id);
    }
 }
