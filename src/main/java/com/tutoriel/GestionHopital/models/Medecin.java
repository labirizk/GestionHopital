package com.tutoriel.GestionHopital.models;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="medecin")

public class Medecin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long Id;
	@Column(name = "Nom")
	private String Nom;
	@Column(name = "Specialite")
	private String Specialite;
	

	//FK de Medecin s'affiche dans la table RendezVous
	
	@OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
	private Collection<RendezVous> lesRendezVous;
	
	
	@JsonIgnore
	public Collection<RendezVous> getLesRendezVous() {
		return lesRendezVous;
	}
	
	
	
	public Medecin(String nom, String specialite) {

		this.Nom = nom;
		this.Specialite = specialite;
	}
	
	


	public Medecin() {
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		this.Id = id;
	}



	public String getNom() {
		return Nom;
	}



	public void setNom(String nom) {
		this.Nom = nom;
	}



	public String getSpecialite() {
		return Specialite;
	}



	public void setSpecialite(String specialite) {
		this.Specialite = specialite;
	}

	

}
