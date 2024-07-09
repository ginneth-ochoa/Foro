package com.aluracurso.foro.curso;

import com.aluracurso.foro.topicos.Topico;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Curso")
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topico> topicos = new ArrayList<>();

    // Constructor por defecto
    public Curso() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Topico> getTopicoss() {
        return topicos;
    }

    public void setTopicoss(List<Topico> topicos) {
        this.topicos = topicos;
    }
}
