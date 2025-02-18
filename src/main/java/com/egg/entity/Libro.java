package com.egg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_libro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    @Id
    @Column(name = "isbn")
    private Long isbn;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "ejemplares")
    private Integer ejemplares;
    @Column(name = "alta")
    private boolean alta;
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

}
