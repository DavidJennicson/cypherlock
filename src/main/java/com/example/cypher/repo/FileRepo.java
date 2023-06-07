package com.example.cypher.repo;

import com.example.cypher.ent.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<FileEntity,Long> {
}
