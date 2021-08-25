package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.wsikora.wseanalyzer.model.EntityClass;
import pl.wsikora.wseanalyzer.services.CrudService;

import java.net.URI;
import java.util.List;

public abstract class CrudController<T extends EntityClass> {

    private final CrudService<T> service;

    protected CrudController(CrudService<T> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getSingle(@PathVariable long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T t) {
        T createdT = service.create(t);
        return ResponseEntity.created(makeNewUri(t))
                .body(createdT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable long id, @RequestBody T t) {
        return ResponseEntity.ok(service.update(id, t));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

    private URI makeNewUri(T t) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(t.getId())
                .toUri();
    }

}
