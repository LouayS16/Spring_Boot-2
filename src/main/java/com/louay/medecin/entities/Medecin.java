package com.louay.medecin.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;
    @NotNull
    @Size(min = 4,max = 15)
    private String nomMedecin;
    @Min(value = 10)
    @Max(value = 10000)
    private Double salaireMedecin;
    private String prenomMedecin;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateNaissance;

    @ManyToOne
    @JoinColumn(name = "specialite_id")
    private Specialite specialiteMedecin;

    // Getters and Setters
    public Long getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Long idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public Double getPrixMedecin() {
        return salaireMedecin;
    }

    public void setPrixMedecin(Double salaireMedecin) {
        this.salaireMedecin = salaireMedecin;
    }

    public String getDescriptionMedecin() {
        return prenomMedecin;
    }

    public void setDescriptionMedecin(String prenomMedecin) {
        this.prenomMedecin = prenomMedecin;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Specialite getSpecialiteMedecin() {
        return specialiteMedecin;
    }

    public void setSpecialiteMedecin(Specialite specialiteMedecin) {
        this.specialiteMedecin = specialiteMedecin;
    }
}

