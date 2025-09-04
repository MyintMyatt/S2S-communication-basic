package com.example.S2S_Communication.controller;


import com.example.S2S_Communication.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    @Qualifier("web-client")
    private Service service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object object) {
        return ResponseEntity.ok(service.post(object));
    }

    @PutMapping("/{id}/")
    public ResponseEntity<?> put(@PathVariable(name = "id") String id,@RequestBody Object obj) {
        return ResponseEntity.ok(service.put(id,obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(service.delete(id));
    }


}
