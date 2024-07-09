package com.aluracurso.foro.topicos;

import com.aluracurso.foro.curso.DatosCurso;
import com.aluracurso.foro.respuesta.DatosRespuesta;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DatosRegistroTopicos(

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotBlank
        String fechaCreacion,

        @NotBlank
        String status,


        @NotBlank
        String autor,

        @NotBlank
        String curso,

        List<String> respuestas
) {
}
