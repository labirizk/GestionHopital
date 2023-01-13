package com.tutoriel.GestionHopital.models;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="consultation")
public class Consultation implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsulation;
    
    @Column(name = "Diagnostic")
    private String Diagnostic;
    
   
   @OneToOne(mappedBy = "Consultation", fetch = FetchType.LAZY)
   private RendezVous lesRendezVous;
   
  
   public Consultation(String diagnostic, RendezVous lesRendezVous) {
	
	this.Diagnostic = diagnostic;
	this.lesRendezVous = lesRendezVous;
}

public Consultation() {
		
	}
   
   	public Long getIdConsulation() {
        return idConsulation;
    }
    public void setIdConsulation(Long idConsulation) {
        this.idConsulation = idConsulation;
    }
    public String getDiagnostic() {
        return Diagnostic;
    }
    public void setDiagnostic(String diagnostic) {
        this.Diagnostic = diagnostic;
    }
    
    
}