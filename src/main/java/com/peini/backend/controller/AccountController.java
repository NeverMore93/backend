package com.peini.backend.controller;

import com.peini.backend.entity.User;
import com.peini.backend.service.AccountService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class AccountController {
    @Resource
    private AccountService accountService;


//    test/id
    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET)
    public String test(@PathVariable("id") Integer id){
        return id+"";
    }

    //test?id={id}
    @GetMapping("/test")
    public String test2(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "test"+id;
    }

    @PostMapping("/registered")
    public User registered(@RequestBody @Validated User user) {
        Date date = new Date();
        user.setRegisteredDate(date);
        return accountService.save(user);
    }

    @PostMapping("/getUserByEmail/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return accountService.getUserByEmail(email);
    }


    @PostMapping("/getAllUsers")
    public List<User> getUserByEmail() {
        return accountService.getAllUsers();
    }

    @PostMapping("/getUserByUserName/{userName}")
    public User getUserByUserName(@PathVariable("userName") String userName) {
        return accountService.getUserByUserName(userName);
    }
}
