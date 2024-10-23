package com.louay.medecin.services;


import java.util.List;

import com.louay.medecin.entities.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.louay.medecin.entities.Specialite;
import com.louay.medecin.entities.Medecin;
import com.louay.medecin.repos.SpecialiteRepository;
import com.louay.medecin.repos.MedecinRepository;
@Service

public class MedecinServiceImpl implements MedecinService{
    @Autowired
    MedecinRepository medecinRepository;
    @Autowired
    SpecialiteRepository specialiteRepository;
    @Override
    public Medecin saveMedecin(Medecin p) {
        return medecinRepository.save(p);
    }
    @Override
    public Medecin updateMedecin(Medecin p) {
        return medecinRepository.save(p);
    }
    @Override
    public void deleteMedecin(Medecin p) {
        medecinRepository.delete(p);
    }
    @Override
    public void deleteMedecinById(Long id) {
        medecinRepository.deleteById(id);
    }
    @Override
    public Medecin getMedecin(Long id) {
        return medecinRepository.findById(id).get();
    }
    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }
    @Override
    public Page<Medecin> getAllMedecinParPage(int page, int size) {
        return medecinRepository.findAll(PageRequest.of(page, size));
    }
    @Override
    public List<Medecin> findByNomMedecin(String nom) {

        return medecinRepository.findByNomMedecin(nom);
    }
    @Override
    public List<Medecin> findByNomMedecinContains(String nom) {

        return medecinRepository.findByNomMedecinContains(nom);
    }
    @Override
    public List<Medecin> findByNomSalaire(String nom, Double salaireAdoption) {

        return medecinRepository.findByNomSalaire(nom, salaireAdoption);
    }
    @Override
    public List<Medecin> findBySpecialiteMedecin(Specialite specialite) {

        return medecinRepository.findBySpecialiteMedecin(specialite);
    }

    @Override
    public List<Medecin> findBySpecialiteMedecinIdSpecialite(Long idSpecialite) {
        return medecinRepository.findBySpecialiteMedecinIdSpecialite(idSpecialite);
    }

    @Override
    public List<Medecin> findBySpecialiteMedecinId(Long id) {
        return medecinRepository.findBySpecialiteMedecinIdSpecialite(id); // Make sure this matches the repository
    }


    @Override
    public List<Medecin> findByOrderByNomMedecinAsc() {

        return medecinRepository.findByOrderByNomMedecinAsc();
    }
    @Override
    public List<Medecin> trierMedecinsNomssalaire() {

        return medecinRepository.trierMedecinsNomsSalaire();
    }
    @Override
    public List<Specialite> getAllSpecialite() {
        return specialiteRepository.findAll();
    }
}
