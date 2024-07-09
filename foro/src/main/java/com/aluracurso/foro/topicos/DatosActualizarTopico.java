package com.aluracurso.foro.topicos;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(Long id, String titulo, String mensaje, String autor, String curso) {
}
