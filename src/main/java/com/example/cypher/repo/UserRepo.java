package com.example.cypher.repo;


import com.example.cypher.ent.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {
    @Query("SELECT u.id FROM UserEntity u WHERE u.username = :username")
    String findIdByUsername(@Param("username") String username);
}
