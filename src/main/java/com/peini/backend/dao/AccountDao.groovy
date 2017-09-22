package com.peini.backend.dao

import com.peini.backend.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountDao extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByUserName(String userName);
}
