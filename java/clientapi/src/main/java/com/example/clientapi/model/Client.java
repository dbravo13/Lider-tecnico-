package com.example.clientapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String documento; 

    @Column(nullable = false, unique = true)
    private String email;



    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Transient
    private Integer edad;
}
