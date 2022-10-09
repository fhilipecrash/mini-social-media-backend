package com.fhilipecrash.usersposts.controllers;

import com.fhilipecrash.usersposts.models.User;
import com.fhilipecrash.usersposts.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(params = "email")
    @ResponseStatus(code = HttpStatus.OK)
    public User getUsersByEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public User getUser(@PathVariable("id") int id) {
       return userService.getUser(id);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "User created")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "User updated")
    public void update(@PathVariable("id") int id, @RequestBody User user) {
        userService.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "User deleted")
    public void delete(@PathVariable("id") int id) {
        userService.delete(id);
    }

}
