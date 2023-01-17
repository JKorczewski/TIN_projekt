package com.example.tin_projekt.database.entity;

import com.example.tin_projekt.database.entity.groupSubject.GroupSubjectEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    @NotNull
    @Column(name = "Numer_Grupy")
    private Integer groupNumber;
    @NotNull
    //@Max(value = 30, message = "Max value = 30")
    @Column(name = "Opiekun")
    private String attendant;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<StudentEntity> studentList;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<GroupSubjectEntity> groupSubjectList;

    public GroupEntity(Integer groupNumber, String attendant) {
        this.groupNumber = groupNumber;
        this.attendant = attendant;
    }
}
