package com.example.mvcstudentsapp.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="group_t")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String groupName;

    @OneToMany(mappedBy = "group")
    private Set<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Group id=" + id +
                ", groupName='" + groupName;
    }
}
