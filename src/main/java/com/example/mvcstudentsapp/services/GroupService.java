package com.example.mvcstudentsapp.services;

import com.example.mvcstudentsapp.entities.Group;
import com.example.mvcstudentsapp.entities.Student;
import com.example.mvcstudentsapp.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> listAllGroups(){
        return (List<Group>) groupRepository.findAll();
    }

    public Group save(Group group){
        return groupRepository.save(group);
    }

    // удаления по id
    public void deleteById(Long id) {
        // 1. найти для удаления
        Optional<Group> deleted = groupRepository.findById(id);
        // 2. если такой есть, то удалить его
        deleted.ifPresent(group -> groupRepository.delete(group));
    }

    public Optional<Group> getById(Long id){
        return groupRepository.findById(id);
    }
}
