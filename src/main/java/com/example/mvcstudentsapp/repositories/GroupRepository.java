package com.example.mvcstudentsapp.repositories;

import com.example.mvcstudentsapp.entities.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group,Long> {
}
