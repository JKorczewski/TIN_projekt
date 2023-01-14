package com.example.tin_projekt.database.dao;

import com.example.tin_projekt.database.entity.GroupEntity;
import com.example.tin_projekt.database.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<GroupEntity, Long> {
}
