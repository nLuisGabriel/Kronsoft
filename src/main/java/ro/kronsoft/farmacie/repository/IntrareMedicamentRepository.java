package ro.kronsoft.farmacie.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.kronsoft.farmacie.model.IntrareMedicament;
import ro.kronsoft.farmacie.model.Intrari_PK;




@Repository
public interface IntrareMedicamentRepository extends JpaRepository<IntrareMedicament,Intrari_PK>{

}
