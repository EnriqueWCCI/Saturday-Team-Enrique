package com.teameanrique.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    @Autowired
    private PublisherRepository repository;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPublishers() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOnePublisher(@PathVariable long id) {
        Optional<Publisher> pubOptional = repository.findById(id);
        if (pubOptional.isPresent()) {
            return new ResponseEntity<>(pubOptional.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Publisher with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/new")
    public Publisher addNewPublisher(@RequestBody Publisher newPublisher) {
        return repository.save(newPublisher);
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deletePublisher(@PathVariable long id) {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return new ResponseEntity<>("Publisher deleted successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Publisher with ID " + id + " not found.", HttpStatus.NOT_FOUND);
            }
            }

    
}
