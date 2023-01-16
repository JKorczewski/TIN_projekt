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
@Table(name = "Przedmiot")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_Przedmiotu")
    private Long id;
    @Column(name = "Nazwa_Przedmiotu")
    private String subjectName;
    @Column(name = "Skrot")
    private String abbreviation;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<GroupSubjectEntity> groupSubjectList;

    public SubjectEntity(String subjectName, String abbreviation) {
        this.subjectName = subjectName;
        this.abbreviation = abbreviation;
    }
}
