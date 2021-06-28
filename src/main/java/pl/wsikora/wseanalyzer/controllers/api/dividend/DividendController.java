package pl.wsikora.wseanalyzer.controllers.api.dividend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.dividend.Dividend;

@RestController
@RequestMapping(value = "/api/v1/dividends")
public class DividendController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAll() {
        throw new IllegalArgumentException("not implemented yet");
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getOne(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Dividend dividend) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Dividend dividend) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

}
