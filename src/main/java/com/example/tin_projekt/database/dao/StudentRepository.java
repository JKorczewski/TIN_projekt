package com.example.tin_projekt.database.dao;

import com.example.tin_projekt.database.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

    @Query("SELECT s FROM StudentEntity s")
    Optional<StudentEntity> findAllStudents();
}
