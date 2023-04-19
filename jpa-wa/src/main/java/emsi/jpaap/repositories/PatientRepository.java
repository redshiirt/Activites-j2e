
//interface qui se base sur spring data (class)


package emsi.jpaap.repositories;

import emsi.jpaap.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
// le type de l'id est LONG
public interface PatientRepository extends JpaRepository<Patient,Long> {
    public  List<Patient> findByMalade(boolean m);
    Page<Patient> findByMalade(boolean m, Pageable pageable);
     List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);
     List<Patient> findBydatenaissanceBetweenAndMaladeIsTrueOrNomLike(Date d1, Date d2,String mc);
     @Query("select p from Patient p where p.nom like :x and p.score<:y ")
     List<Patient> chercherPatient (@Param("x") String nom,@Param("y")int scoreMin);

}
