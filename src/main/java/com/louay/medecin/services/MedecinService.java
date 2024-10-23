package com.louay.medecin.services;


import java.util.List;

import com.louay.medecin.entities.Specialite;
import org.springframework.data.domain.Page;

import com.louay.medecin.entities.Specialite;
import com.louay.medecin.entities.Medecin;
public interface MedecinService {
    Medecin saveMedecin(Medecin p);
    Medecin updateMedecin(Medecin p);
    void deleteMedecin(Medecin p);
    void deleteMedecinById(Long id);
    Medecin getMedecin(Long id);
    List<Medecin> getAllMedecins();
    Page<Medecin> getAllMedecinParPage(int page, int size);
    List<Medecin> findByNomMedecin(String nom);
    List<Medecin> findByNomMedecinContains(String nom);
    List<Medecin> findByNomSalaire(String nom, Double salaire);
    List<Medecin> findBySpecialiteMedecin(Specialite specialite);

    // Updated method
    List<Medecin> findBySpecialiteMedecinIdSpecialite(Long idSpecialite);

    List<Medecin> findBySpecialiteMedecinId(Long id);

    List<Medecin> findByOrderByNomMedecinAsc();
    List<Medecin> trierMedecinsNomssalaire();
    List<Specialite> getAllSpecialite();
}
