package ro.kronsoft.farmacie.controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.kronsoft.farmacie.exceptions.ResourceNotFoundException;
import ro.kronsoft.farmacie.model.IntrareMedicament;
import ro.kronsoft.farmacie.model.Intrari_PK;
import ro.kronsoft.farmacie.repository.IntrareMedicamentRepository;


@RestController
@RequestMapping("/api/v1")
public class IntrareMedicamentController {
	@Autowired
	private IntrareMedicamentRepository intrareMedicamentRepository;

	@GetMapping("/intrari_medicamente")
	public ArrayList<IntrareMedicament> getAllIntrariMedicamente() {
		return (ArrayList<IntrareMedicament>) this.intrareMedicamentRepository.findAll();
	}

	@GetMapping("/intrari_medicamente/{produs}/{bbd}/{lot}/{numar_doc_intrare}/{data_doc_intrare}/{cantitate}")
	public ResponseEntity<IntrareMedicament> getIntrareMedicamentById(@PathVariable(value = "produs") String produs,
			@PathVariable(value = "bbd") LocalDate bbd, @PathVariable(value = "lot") String lot,
			@PathVariable(value = "numar_doc_intrare") long numar_doc_intrare,
			@PathVariable(value = "data_doc_intrare") LocalDate data_doc_intrare,
			@PathVariable(value = "cantitate") int cantitate) throws ResourceNotFoundException {
		Intrari_PK pk = new Intrari_PK(produs, bbd, lot, numar_doc_intrare, data_doc_intrare, cantitate);
		IntrareMedicament intrareMedicament = intrareMedicamentRepository.findById(pk)
				.orElseThrow(() -> new ResourceNotFoundException("intrareMedicament not found for this id :: " + pk));
		return ResponseEntity.ok().body(intrareMedicament);
	}

	@PostMapping("/intrari_medicamente")
	public IntrareMedicament createIntrareMedicament(@RequestBody IntrareMedicament intrareMedicament) {
		return intrareMedicamentRepository.save(intrareMedicament);
	}

	@PutMapping("/intrari_medicamente/{produs}/{bbd}/{lot}/{numar_doc_intrare}/{data_doc_intrare}/{cantitate}")
	public ResponseEntity<IntrareMedicament> updateIntrareMedicament(@PathVariable(value = "produs") String produs,
			@PathVariable(value = "bbd") LocalDate bbd, @PathVariable(value = "lot") String lot,
			@PathVariable(value = "numar_doc_intrare") long numar_doc_intrare,
			@PathVariable(value = "data_doc_intrare") LocalDate data_doc_intrare,
			@PathVariable(value = "cantitate") int cantitate, @RequestBody IntrareMedicament im)
			throws ResourceNotFoundException {
		Intrari_PK pk = new Intrari_PK(produs, bbd, lot, numar_doc_intrare, data_doc_intrare, cantitate);
		IntrareMedicament intrareMedicament = intrareMedicamentRepository.findById(pk)
				.orElseThrow(() -> new ResourceNotFoundException("IntrareMedicament not found for this id :: " + pk));
		intrareMedicament.setNumeFurnizor(im.getNumeFurnizor());
		intrareMedicament.setAgentFurnizor(im.getAgentFurnizor());
		intrareMedicament.setProdus(im.getProdus());
		intrareMedicament.setCodCas(im.getCodCas());
		intrareMedicament.setBBD(im.getBBD());
		intrareMedicament.setLot(im.getLot());
		intrareMedicament.setNumarDocIntrare(im.getNumarDocIntrare());
		intrareMedicament.setDataDocIntrare(im.getDataDocIntrare());
		intrareMedicament.setNumeMoneda(im.getNumeMoneda());
		intrareMedicament.setPretAchizitieValuta(im.getPretAchizitieValuta());
		intrareMedicament.setCantitate(im.getCantitate());
		intrareMedicament.setValoareAchizitieDiscountat(im.getValoareAchizitieDiscountat());
		intrareMedicament.setValoareDiscountAchizitie(im.getValoareDiscountAchizitie());
		intrareMedicament.setPretAchizitie(im.getPretAchizitie());
		final IntrareMedicament updateintrareMedicament = intrareMedicamentRepository.save(intrareMedicament);
		return ResponseEntity.ok(updateintrareMedicament);
	}

	@DeleteMapping("/intrari_medicamente/{produs}/{bbd}/{lot}/{numar_doc_intrare}/{data_doc_intrare}/{cantitate}")
	public Map<String, Boolean> deleteIntrareMedicament(@PathVariable(value = "produs") String produs,
			@PathVariable(value = "bbd") LocalDate bbd, @PathVariable(value = "lot") String lot,
			@PathVariable(value = "numar_doc_intrare") long numar_doc_intrare,
			@PathVariable(value = "data_doc_intrare") LocalDate data_doc_intrare,
			@PathVariable(value = "cantitate") int cantitate) throws ResourceNotFoundException {
		Intrari_PK pk = new Intrari_PK(produs, bbd, lot, numar_doc_intrare, data_doc_intrare, cantitate);
		IntrareMedicament employee = intrareMedicamentRepository.findById(pk)
				.orElseThrow(() -> new ResourceNotFoundException("IntrareMedicament not found for this id :: " + pk));

		intrareMedicamentRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
