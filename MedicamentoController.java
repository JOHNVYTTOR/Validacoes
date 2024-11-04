package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Medicamento;
import com.example.demo.services.MedicamentoService;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping("/criar")
    public Medicamento criarMedicamento(@RequestBody Medicamento medicamento) {
        return medicamentoService.salvarMedicamento(medicamento);
    }

    @GetMapping
    public List<Medicamento> buscarTodos() {
        return medicamentoService.buscarTodosMedicamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> buscarPorId(@PathVariable Long id) {
        Medicamento medicamento = medicamentoService.buscarMedicamentoPorId(id);
        return medicamento != null ? ResponseEntity.ok(medicamento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedicamento(@PathVariable Long id) {
        medicamentoService.excluirMedicamento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> atualizarMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        Medicamento medicamentoAtualizado = medicamentoService.atualizarMedicamento(id, medicamento);
        return medicamentoAtualizado != null ? ResponseEntity.ok(medicamentoAtualizado) : ResponseEntity.notFound().build();
    }
}

