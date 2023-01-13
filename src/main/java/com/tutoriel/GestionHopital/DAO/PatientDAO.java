package com.tutoriel.GestionHopital.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tutoriel.GestionHopital.models.Patient;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Long>{
	List<Patient> findByNumSecu(String NumSecu);
}
