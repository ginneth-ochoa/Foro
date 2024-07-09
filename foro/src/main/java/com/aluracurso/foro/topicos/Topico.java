package com.aluracurso.foro.topicos;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topico")
@Entity(name = "Topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    private String status;
    private String autor;
    private String curso;

    @ElementCollection
    @CollectionTable(name = "topico_respuesta", joinColumns = @JoinColumn(name = "topico_id"))
    @Column(name = "respuesta")
    private List<String> respuestas = new ArrayList<>();

    // Constructor por defecto
    public Topico() {
    }

    // Constructor con parámetros
    public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String status, String autor, String curso, List<String> respuestas) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = String.valueOf(fechaCreacion);
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.respuestas = respuestas;
    }

    public Topico(DatosRegistroTopicos datosRegistroTopicos) {

        this.titulo= datosRegistroTopicos.titulo();
        this.mensaje= datosRegistroTopicos.mensaje();
        this.fechaCreacion= datosRegistroTopicos.fechaCreacion();
        this.status=datosRegistroTopicos.status();
        this.autor= datosRegistroTopicos.autor();
        this.curso= datosRegistroTopicos.curso();
        this.respuestas=datosRegistroTopicos.respuestas();

    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<String> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", status='" + status + '\'' +
                ", autor='" + autor + '\'' +
                ", curso='" + curso + '\'' +
                ", respuestas=" + respuestas +
                '}';
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

        if
        (datosActualizarTopico.titulo() != null){
            this.titulo= datosActualizarTopico.titulo();
        }
        if
        (datosActualizarTopico.mensaje() != null){
            this.mensaje= datosActualizarTopico.mensaje();
        }
        if
        (datosActualizarTopico.autor() != null){
            this.autor= datosActualizarTopico.autor();
        }
        if
        (datosActualizarTopico.curso() != null){
            this.curso= datosActualizarTopico.curso();
        }

    }
}
