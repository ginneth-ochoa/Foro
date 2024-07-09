package com.aluracurso.foro.topicos;

import java.time.LocalDateTime;

public record DatosListadoTopico(Long id,String titulo, String mensaje, String fechaCreacion, String status, String autor, String curso) {

    public DatosListadoTopico(Topico topico) {
        this(   topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}