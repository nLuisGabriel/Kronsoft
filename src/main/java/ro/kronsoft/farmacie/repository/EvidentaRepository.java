package ro.kronsoft.farmacie.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ro.kronsoft.farmacie.model.Evidenta;
import ro.kronsoft.farmacie.model.EvidentaPK;

public interface EvidentaRepository extends JpaRepository<Evidenta, EvidentaPK>{

}
