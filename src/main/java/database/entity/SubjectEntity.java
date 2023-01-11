package database.entity;

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

}
