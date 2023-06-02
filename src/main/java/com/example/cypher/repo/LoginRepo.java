package com.example.cypher.repo;

import com.example.cypher.ent.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepo extends JpaRepository<UserEntity,Long> {
    @Query("SELECT u.password FROM UserEntity u WHERE u.username = :username")
    String findPasswordByUsername(@Param("username") String username);
}
