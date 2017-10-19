package com.peini.backend.dao

import com.peini.backend.entity.User
import lombok.extern.slf4j.Slf4j
import org.apache.ibatis.annotations.Mapper
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
@Mapper
@Slf4j
@Component
interface AccountDao extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByUserName(String userName);
}
