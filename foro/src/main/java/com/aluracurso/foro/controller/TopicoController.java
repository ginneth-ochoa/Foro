package com.aluracurso.foro.controller;

import com.aluracurso.foro.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    //obtener
        @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopicos datosRegistroTopicos){
            topicoRepository.save(new Topico (datosRegistroTopicos));

    }

    //listar
    @GetMapping
    public Page<DatosListadoTopico> listarTopicos(@PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }

    // obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopico> obtenerTopico(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            return ResponseEntity.ok(new DatosListadoTopico(topicoOptional.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //actualizar
    /*@PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }*/

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if (optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            topico.actualizarDatos(datosActualizarTopico);
            return ResponseEntity.ok().body("Tópico actualizado exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico no encontrado.");
        }
    }

    @DeleteMapping("/topicos/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            topicoRepository.deleteById(id);
        } else {
            // Manejar el caso en el que el tópico no exista
            throw new ResourceNotFoundException("Tópico no encontrado con el ID: " + id);
        }
    }
}
