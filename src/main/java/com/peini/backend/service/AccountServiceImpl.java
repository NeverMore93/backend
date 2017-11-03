package com.peini.backend.service;

import com.peini.backend.dao.AccountDao;
import com.peini.backend.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("AccountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Resource
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public User save(User user) {
        return accountDao.save(user);
    }

    @Override
    public User getUserByEmail(String email) {

        return accountDao.findByRegisterEmail(email);
    }

    @Override
    public User getUserByUserName(String userName) {
        return accountDao.findByUserName(userName);
    }

    @Override
    public List<User> getAllUsers() {
        return accountDao.findAll();
    }

}
