package com.devsuperior.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

	private final WorkerRepository repository;
	
	public WorkerResource(WorkerRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		Optional<Worker> worker = repository.findById(id);
		if (worker.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(worker.get());
		}
		
	}
	
	
	
}
