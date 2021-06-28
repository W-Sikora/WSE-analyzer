package pl.wsikora.wseanalyzer.controllers.api.statement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.price.Price;

@RestController
@RequestMapping(value = "/api/v1/balance_sheets")
public class BalanceSheetController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAll() {
        throw new IllegalArgumentException("not implemented yet");
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getOne(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Price price) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Price price) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

}
