package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public interface REST <T> {

    default URI makeNewUri(long id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

    @GetMapping
    ResponseEntity<List<T>> getPart(Pageable pageable);

    @GetMapping("/{id}")
    ResponseEntity<T> getSingle(@PathVariable long id);

    @PostMapping
    ResponseEntity<T> create(@RequestBody T t);

    @PutMapping("/{id}")
    ResponseEntity<T> update(@PathVariable long id, @RequestBody T t);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable long id);

}
