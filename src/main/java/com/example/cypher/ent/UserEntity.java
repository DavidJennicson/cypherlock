package com.example.cypher.ent;
import jakarta.persistence.*;
import com.example.cypher.enc.SHA512;

import java.security.NoSuchAlgorithmException;

@Entity
@Table(name = "userdata")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public UserEntity(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public UserEntity()
    {
        this.id =id;
        this.username=username;
        this.password=password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = SHA512.encryptSHA512(password);
    }
}
