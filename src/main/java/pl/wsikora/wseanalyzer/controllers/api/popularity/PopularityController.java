package pl.wsikora.wseanalyzer.controllers.api.popularity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.dividend.Dividend;
import pl.wsikora.wseanalyzer.model.popularity.Popularity;

@RestController
@RequestMapping(value = "/api/v1/popularities")
public class PopularityController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAll() {
        throw new IllegalArgumentException("not implemented yet");
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getOne(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Popularity popularity) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Popularity popularity) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

}
