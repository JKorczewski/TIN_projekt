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
}
