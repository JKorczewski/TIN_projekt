package com.example.tin_projekt.database.entity.groupSubject;

import com.example.tin_projekt.database.entity.GroupEntity;
import com.example.tin_projekt.database.entity.StudentEntity;
import com.example.tin_projekt.database.entity.SubjectEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Grupa_Przedmiot")
public class GroupSubjectEntity {

    @EmbeddedId
    private GroupSubjectId groupSubjectId;
    @Column(name = "Dzien_Tygodnia")
    private String weekday;
    @Column(name = "Godzina")
    private String hour;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_grupy")
    GroupEntity group;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_przedmiotu")
    SubjectEntity subject;

}
