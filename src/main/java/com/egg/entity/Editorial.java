package com.egg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_editorial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editorial")
    private Long idEditorial;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "alta")
    private boolean alta;
}
