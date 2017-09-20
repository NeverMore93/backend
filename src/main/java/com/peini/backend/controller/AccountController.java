package com.peini.backend.controller;

import com.peini.backend.entity.User;
import com.peini.backend.service.AccountService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class AccountController {
    @Resource
    AccountService accountService;
    //test/id
    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET)
    public String test(@PathVariable("id") Integer id){
        return id+"";
    }

    //test?id={id}
    @GetMapping("/test")
    public String test2(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "test";
    }

    @PostMapping("/registered")
    public User registered(@RequestBody @Validated User user) {
        System.out.print(user.toString());
        return accountService.save(user);
    }
}
