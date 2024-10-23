package com.louay.medecin.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpecialite;

    private String nomSpecialite;
    private String descriptionSpecialite;
    @JsonIgnore
    @OneToMany(mappedBy = "specialiteMedecin", cascade = CascadeType.ALL)
    private List<Medecin> medecins;

    // Getters and Setters
    public Long getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(Long idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public String getNomSpecialite() {
        return nomSpecialite;
    }

    public void setNomSpecialite(String nomSpecialite) {
        this.nomSpecialite = nomSpecialite;
    }

    public String getDescriptionSpecialite() {
        return descriptionSpecialite;
    }

    public void setDescriptionSpecialite(String SpecialitedescriptionMarque) {
        this.descriptionSpecialite = descriptionSpecialite;
    }

    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }
}
