package com.peini.backend.controller;

import com.peini.backend.entity.User;
import com.peini.backend.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Resource
    private AccountService accountService;

    @Resource(name="redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;


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

    @PostMapping("/login")
    public String login(String username, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        if (StringUtils.hasText(username) && StringUtils.hasText(password)) {
            try {
                currentUser.login(new UsernamePasswordToken(username, password));
            } catch (Exception e) {
                logger.error(e.getLocalizedMessage(), e);
                return "login";
            }
            return "redirect:index";
        } else {
            return "login";
        }
    }
}
