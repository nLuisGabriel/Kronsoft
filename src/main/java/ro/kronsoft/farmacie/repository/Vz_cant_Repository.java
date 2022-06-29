package ro.kronsoft.farmacie.repository;






import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.kronsoft.farmacie.model.Vz_cant;
import ro.kronsoft.farmacie.model.Vz_cant_PK;

@Repository
public interface Vz_cant_Repository extends JpaRepository<Vz_cant, Vz_cant_PK> {

	
}
