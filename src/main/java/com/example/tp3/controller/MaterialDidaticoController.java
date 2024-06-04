package com.example.tp3.controller;

import com.example.tp3.model.MaterialDidatico;
import com.example.tp3.service.MaterialDidaticoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materiais")
public class MaterialDidaticoController {

    private final MaterialDidaticoService materialDidaticoService;

    public MaterialDidaticoController(MaterialDidaticoService materialDidaticoService) {
        this.materialDidaticoService = materialDidaticoService;
    }

    @PostMapping
    public ResponseEntity<MaterialDidatico> createMaterialDidatico(@RequestBody MaterialDidatico materialDidatico) {
        MaterialDidatico createdMaterial = materialDidaticoService.save(materialDidatico);
        return ResponseEntity.ok(createdMaterial);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDidatico> getMaterialDidaticoById(@PathVariable String id) {
        Optional<MaterialDidatico> material = materialDidaticoService.findById(id);
        return material.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MaterialDidatico>> getAllMateriaisDidaticos() {
        List<MaterialDidatico> materiais = materialDidaticoService.findAll();
        return ResponseEntity.ok(materiais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialDidatico> updateMaterialDidatico(@PathVariable String id, @RequestBody MaterialDidatico materialDetails) {
        Optional<MaterialDidatico> material = materialDidaticoService.findById(id);
        if (material.isPresent()) {
            MaterialDidatico updatedMaterial = material.get();
            updatedMaterial.setTitulo(materialDetails.getTitulo());
            updatedMaterial.setDescricao(materialDetails.getDescricao());
            materialDidaticoService.save(updatedMaterial);
            return ResponseEntity.ok(updatedMaterial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterialDidatico(@PathVariable String id) {
        materialDidaticoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
