package ro.kronsoft.farmacie.controller;



import java.util.HashMap;
import java.util.List;
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
import ro.kronsoft.farmacie.model.StocDetPK;
import ro.kronsoft.farmacie.model.Stoc_detaliat;
import ro.kronsoft.farmacie.repository.Stoc_detaliatRepository;


@RestController
@RequestMapping("/api/v1/")
public class Controller_Stoc {

	@Autowired

	private Stoc_detaliatRepository detaliiStocRepository;

	@GetMapping("/stoc_detaliat")
	public List<Stoc_detaliat> getStoc_detaliat() {
		return this.detaliiStocRepository.findAll();
	}

	@GetMapping("/stoc_detaliat/{produs}/{producator}/{tip_stoc}/{categorie}/{vechimeStoc}/{furnizor_Nume}/{bbd}/{sc_cant}/{pret_achizite}/{pret_unitar}/{val_pret_achizitie}")
	public ResponseEntity<Stoc_detaliat> updateStoc(@PathVariable(value = "produs") String produs,
			@PathVariable(value = "producator") String producator, @PathVariable(value = "tip_stoc") String tip_stoc,
			@PathVariable(value = "categorie") String categorie, @PathVariable(value = "vechimeStoc") String vechimeStoc,
			@PathVariable(value = "furnizor_nume") String furnizor_Nume, @PathVariable(value = "bbd") String bbd,
			@PathVariable(value = "sc_cant") String sc_cant,
			@PathVariable(value = "pret_achizitie") String pret_achizite,
			@PathVariable(value = "pret_unitar") String pret_unitar,
			@PathVariable(value = "val_pret_achizitie") String val_pret_achizitie

	) throws ResourceNotFoundException {

		StocDetPK stocID = new StocDetPK(produs, producator, tip_stoc, categorie, vechimeStoc, furnizor_Nume, bbd,
				sc_cant, pret_achizite, pret_unitar, val_pret_achizitie);
		Stoc_detaliat Stoc = detaliiStocRepository.findById(stocID)
				.orElseThrow(() -> new ResourceNotFoundException("Stoc not found :: " + stocID));
		return ResponseEntity.ok().body(Stoc);
	}

	@PostMapping("/stoc_detaliat")
	public Stoc_detaliat createStoc_detaliat(@RequestBody Stoc_detaliat detalii) {
		return this.detaliiStocRepository.save(detalii);

	}
	
	

	@PutMapping("/stoc_detaliat/{produs}/{producator}/{tip_stoc}/{categorie}/{vechimeStoc}/{furnizor_Nume}/{bbd}/{sc_cant}/{pret_achizite}/{pret_unitar}/{val_pret_achizitie}")
	public ResponseEntity<Stoc_detaliat> updateStoc(@PathVariable(value = "produs") String produs,
			@PathVariable(value = "producator") String producator, @PathVariable(value = "tip_stoc") String tip_stoc,
			@PathVariable(value = "categorie") String categorie, @PathVariable(value = "vechimeStoc") String vechimeStoc,
			@PathVariable(value = "furnizor_nume") String furnizor_Nume, @PathVariable(value = "bbd") String bbd,
			@PathVariable(value = "sc_cant") String sc_cant,
			@PathVariable(value = "pret_achizitie") String pret_achizite,
			@PathVariable(value = "pret_unitar") String pret_unitar,
			@PathVariable(value = "val_pret_achizitie") String val_pret_achizitie,
			@RequestBody Stoc_detaliat stoc_detalii) throws ResourceNotFoundException {
		StocDetPK stocID = new StocDetPK(produs, producator, tip_stoc, categorie, vechimeStoc, furnizor_Nume, bbd,
				sc_cant, pret_achizite, pret_unitar, val_pret_achizitie);
		Stoc_detaliat Stoc = detaliiStocRepository.findById(stocID)
				.orElseThrow(() -> new ResourceNotFoundException("Stoc not found :: " + stocID));
		Stoc.setCod(stoc_detalii.getCod());
		Stoc.setCodCAS(stoc_detalii.getCodCAS());
		Stoc.setProdus(stoc_detalii.getProdus());
		Stoc.setBBD(stoc_detalii.getBBD());
		Stoc.setCategorie(stoc_detalii.getCategorie());
		Stoc.setFurnizor_Nume(stoc_detalii.getFurnizor_Nume());
		Stoc.setPret_Achizite(stoc_detalii.getPret_Achizite());
		Stoc.setPret_unitar(stoc_detalii.getPret_unitar());
		Stoc.setProducator(stoc_detalii.getProducator());
		Stoc.setSc_cant(stoc_detalii.getSc_cant());
		Stoc.setTip_stoc(stoc_detalii.getTip_stoc());
		Stoc.setVal_pret_achizitie(stoc_detalii.getVal_pret_achizitie());
		Stoc.setVechimeStoc(stoc_detalii.getVechimeStoc());
		

		final Stoc_detaliat updatedStoc = detaliiStocRepository.save(Stoc);
		return ResponseEntity.ok(updatedStoc);

	}

	@DeleteMapping("/stoc_detaliat/{produs}/{producator}/{tip_stoc}/{categorie}/{vechimeStoc}/{furnizor_Nume}/{bbd}/{sc_cant}/{pret_achizite}/{pret_unitar}/{val_pret_achizitie}")
	public Map<String, Boolean> deleteStoc(@PathVariable(value = "produs") String produs,
			@PathVariable(value = "producator") String producator, @PathVariable(value = "tip_stoc") String tip_stoc,
			@PathVariable(value = "categorie") String categorie, @PathVariable(value = "vechimeStoc") String vechimeStoc,
			@PathVariable(value = "furnizor_nume") String furnizor_Nume, @PathVariable(value = "bbd") String bbd,
			@PathVariable(value = "sc_cant") String sc_cant,
			@PathVariable(value = "pret_achizitie") String pret_achizite,
			@PathVariable(value = "pret_unitar") String pret_unitar,
			@PathVariable(value = "val_pret_achizitie") String val_pret_achizitie)
			throws ResourceNotFoundException {
		StocDetPK stocID = new StocDetPK(produs, producator, tip_stoc, categorie, vechimeStoc, furnizor_Nume, bbd,
				sc_cant, pret_achizite, pret_unitar, val_pret_achizitie);
		Stoc_detaliat stoc = detaliiStocRepository.findById(stocID)
				.orElseThrow(() -> new ResourceNotFoundException("Stoc Not Found:: " + stocID));

		detaliiStocRepository.delete(stoc);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
