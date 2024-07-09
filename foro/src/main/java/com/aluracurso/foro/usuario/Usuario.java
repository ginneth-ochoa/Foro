package com.aluracurso.foro.usuario;

import com.aluracurso.foro.topicos.Topico;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "perfil")
    private String perfil;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topico> topicos = new ArrayList<>();

    // Constructor por defecto
    public Usuario() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public List<Topico> getTopicoss() {
        return topicos;
    }

    public void setTopicoss(List<Topico> topicos) {
        this.topicos = topicos;
    }
}