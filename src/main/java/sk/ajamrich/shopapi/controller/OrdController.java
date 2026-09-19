package sk.ajamrich.shopapi.controller;

import sk.ajamrich.shopapi.entity.Ord;
import sk.ajamrich.shopapi.repository.OrdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import java.util.List;

@RestController
@RequestMapping("/api/ord")
@CrossOrigin(origins = "*")
public class OrdController {

    @Autowired
    private OrdRepository ordRepository;

    @GetMapping
    public List<Ord> search(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo
    ) {
        return ordRepository.search(search, dateFrom, dateTo);
    }

    @PostMapping
    public ResponseEntity<Ord> create(@RequestBody Ord ord) {
        Ord saved = ordRepository.save(ord);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ordRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}