package pl.wsikora.wseanalyzer.controllers.api.price;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.dividend.Dividend;
import pl.wsikora.wseanalyzer.model.price.Price;

@RestController
@RequestMapping(value = "/api/v1/prices")
public class PriceController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAll() {
        throw new IllegalArgumentException("not implemented yet");
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getOne(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @GetMapping(path = "/industries/{industryId}", produces = "application/json")
    public ResponseEntity<?> getAllByIndustry(@PathVariable long industryId) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @GetMapping(path = "/activity_tags/{activityTagId}", produces = "application/json")
    public ResponseEntity<?> getAllByActivityTag(@PathVariable long activityTagId) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @GetMapping(path = "/stock_exchanges/{stockExchangeId}", produces = "application/json")
    public ResponseEntity<?> getAllByStockExchange(@PathVariable long stockExchangeId) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @GetMapping("/companies/{companyId}")
    public ResponseEntity<?> getAllByCompany(@PathVariable long companyId) {
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
