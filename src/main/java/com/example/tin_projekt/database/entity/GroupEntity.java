package com.example.tin_projekt.database.entity;

import com.example.tin_projekt.database.entity.groupSubject.GroupSubjectEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Grupa")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_Grupy")
    private Long id;
    @Column(name = "Numer_Grupy")
    private Integer groupNumber;
    @Column(name = "Opiekun")
    private String attendant;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<StudentEntity> students;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Set<GroupSubjectEntity> groupSubjectSet;

    public GroupEntity(Integer groupNumber, String attendant) {
        this.groupNumber = groupNumber;
        this.attendant = attendant;
    }
}
