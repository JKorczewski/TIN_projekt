package com.example.tin_projekt.database.entity;

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
    private Long id;
    @Column(name="Imie")
    private String name;
    @Column(name = "Nazwisko")
    private String surname;
    @Column(name = "Saldo")
    private float balance;
    private String PESEL;
    @Column(name = "Numer_Telefonu")
    private Integer phoneNumber;
    @Column(name = "Email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Grupy", referencedColumnName = "Id_Grupy")
    private GroupEntity group;
}
