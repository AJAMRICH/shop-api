package sk.ajamrich.shopapi.controller;

import sk.ajamrich.shopapi.entity.Ord;
import sk.ajamrich.shopapi.repository.OrdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ord")
@CrossOrigin(origins = "*")
public class OrdController {

    @Autowired
    private OrdRepository ordRepository;

    @GetMapping
    public List<Ord> getAll() {
        return ordRepository.findAll();
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