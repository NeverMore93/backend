package com.peini.backend.dao;

import com.peini.backend.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AccountDao extends  CrudRepository<User, Long>{

    User save(User user);

}
