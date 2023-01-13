package com.tutoriel.GestionHopital.DAO;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tutoriel.GestionHopital.models.Medecin;

@Repository
public interface MedecinDAO extends CrudRepository<Medecin,Long> {
	
	List<Medecin> findByNom(String Nom);

}
