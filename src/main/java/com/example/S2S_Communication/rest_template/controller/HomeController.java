package com.example.S2S_Communication.rest_template.controller;


import com.example.S2S_Communication.rest_template.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest-template")
public class HomeController {

    @Autowired
    private RestTemplateService service;

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
