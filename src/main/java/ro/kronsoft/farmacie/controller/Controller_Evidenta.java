package ro.kronsoft.farmacie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.kronsoft.farmacie.model.Evidenta;
import ro.kronsoft.farmacie.model.EvidentaPK;
import ro.kronsoft.farmacie.repository.EvidentaRepository;

@RestController
@RequestMapping("/api/v1/")
public class Controller_Evidenta {
	@Autowired
	private EvidentaRepository evidentaRepository;
	@GetMapping("/evidenta")
	public List<Evidenta> getStoc_detaliat() {
		return this.evidentaRepository.findAll();
	}
	@PostMapping("/evidenta")
	public Evidenta createStoc_detaliat(@RequestBody Evidenta evidenta) {
		return evidentaRepository.save(evidenta);

	}
}
