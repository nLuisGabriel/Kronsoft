package ro.kronsoft.farmacie.controller;


import java.time.LocalDate;
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
import ro.kronsoft.farmacie.model.Vz_cant;
import ro.kronsoft.farmacie.model.Vz_cant_PK;
import ro.kronsoft.farmacie.repository.Vz_cant_Repository;

@RestController
@RequestMapping("/api/v1/")
public class Controller_vz_cant {
	@Autowired
	private Vz_cant_Repository detaliiVz_cant;
	@GetMapping("/vz_cant")
	public List<Vz_cant> getVz_cant() {
		return this.detaliiVz_cant.findAll();
	}
	@GetMapping("/vz_cant/{data}/{produs}")
	public ResponseEntity<Vz_cant> updateCustomers(@PathVariable(value = "data")  LocalDate data,@PathVariable(value = "produs")  String produs) throws ResourceNotFoundException {
		Vz_cant_PK VzId = new Vz_cant_PK(produs,data);
		Vz_cant vz_cant = detaliiVz_cant.findById(VzId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + VzId));
        return ResponseEntity.ok().body(vz_cant);
    }
	@PostMapping("/vz_cant")
	public Vz_cant createIntrari_detaliate(@RequestBody Vz_cant detalii) {
		return this.detaliiVz_cant.save(detalii);

	}
	@PostMapping("/vz_cant2")
	public Vz_cant createIntrari_detaliate2(@RequestBody Vz_cant detalii) {
		if(detaliiVz_cant.findById(detalii.obtineCheie()).isPresent()==false) {
			return detaliiVz_cant.save(detalii);
		}
		return null;
	}
	
	@PutMapping("/vz_cant/{data}/{produs}")
	public ResponseEntity<Vz_cant> updateCustomers(@PathVariable(value = "data")  LocalDate data,@PathVariable(value = "prodsus")  String produs,
			@RequestBody Vz_cant Vz_cantDetails) throws ResourceNotFoundException {
		Vz_cant_PK VzId = new Vz_cant_PK(produs,data);
		Vz_cant vz_cant = detaliiVz_cant.findById(VzId)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found :: " + VzId));
		vz_cant.setProdus(Vz_cantDetails.getProdus());
		vz_cant.setTotal_OutD_Cant(Vz_cantDetails.getTotal_OutD_Cant());
		vz_cant.setTotal_OutD_Val_Vanzare_FTVA(Vz_cantDetails.getTotal_OutD_Val_Vanzare_FTVA());
		vz_cant.setData(Vz_cantDetails.getData());

		final Vz_cant updatedVz_cant = detaliiVz_cant.save(vz_cant);
		return ResponseEntity.ok(updatedVz_cant);

	}
	@DeleteMapping("/vz_cant/{data}/{produs}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "data")  LocalDate data,@PathVariable(value = "prodsus")  String produs)
         throws ResourceNotFoundException {
		Vz_cant_PK VzId = new Vz_cant_PK(produs,data);
        Vz_cant vz_cant = detaliiVz_cant.findById( VzId)
       .orElseThrow(() -> new ResourceNotFoundException("Not Found:: " + VzId));

        detaliiVz_cant.delete(vz_cant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
