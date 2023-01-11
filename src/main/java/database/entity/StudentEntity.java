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
@Table(name = "Student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_Studenta")
    private long id;
    @Column(name="Imie")
    private String name;
    @Column(name = "Nazwisko")
    private String surname;
    @Column(name = "Saldo")
    private float saldo;
    private String PESEL;
    @Column(name = "Numer_Telefonu")
    private Integer phoneNumber;
    @Column(name = "Email")
    private String email;
}
