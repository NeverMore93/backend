package com.peini.backend.service;

import com.peini.backend.dao.AccountDao;
import com.peini.backend.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("AccountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    @Override
    public User save(User user) {
        return accountDao.save(user);
    }
}
