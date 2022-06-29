package ro.kronsoft.farmacie.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.kronsoft.farmacie.model.StocDetPK;
import ro.kronsoft.farmacie.model.Stoc_detaliat;
@Repository

public interface Stoc_detaliatRepository extends JpaRepository<Stoc_detaliat, StocDetPK>  {
	
	

}
