package com.louay.medecin.com.louay.medecin;

import com.louay.medecin.entities.Medecin;
import com.louay.medecin.repos.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedecinService {

    @Autowired
    private MedecinRepository medecinRepository;

    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    public Medecin getMedecinById(Long id) {
        return medecinRepository.findById(id).orElseThrow(() -> new RuntimeException("PC not found"));
    }

    public Medecin createMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    public Medecin updateMedecin(Long id, Medecin updatedMedecin) {
        Medecin medecin = getMedecinById(id);
        medecin.setNomMedecin(updatedMedecin.getNomMedecin());
        medecin.setPrixMedecin(updatedMedecin.getPrixMedecin());
        medecin.setDescriptionMedecin(updatedMedecin.getDescriptionMedecin());
        medecin.setDateNaissance(updatedMedecin.getDateNaissance());
        medecin.setSpecialiteMedecin(updatedMedecin.getSpecialiteMedecin());
        return medecinRepository.save(medecin);
    }

    public void deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
    }
}
