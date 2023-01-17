package com.example.tin_projekt.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(schema = "myDB", name = "Student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_Studenta")
    private Long id;
    @NotNull
    //@Max(value = 30)
    @Column(name="Imie")
    private String name;
    @NotNull
    //@Max(value = 30)
    @Column(name = "Nazwisko")
    private String surname;
    @NotNull
    @Column(name = "Saldo")
    private float balance;
    @NotNull
    //@Max(value = 11)
    //@Min(value = 11)
    @Pattern(regexp="[\\d]{11}")
    private String PESEL;
    @NotNull
    //@Max(value = 9)
    //@Min(value = 9)
    @Pattern(regexp="[\\d]{9}")
    @Column(name = "Numer_Telefonu")
    private String phoneNumber;
    @NotNull
    @Email
    @Column(name = "Email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "Id_Grupy", referencedColumnName = "Id_Grupy")
    private GroupEntity group;

    public StudentEntity(String name, String surname, float balance, String PESEL, String phoneNumber, String email, GroupEntity group) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.PESEL = PESEL;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.group = group;
    }
}
