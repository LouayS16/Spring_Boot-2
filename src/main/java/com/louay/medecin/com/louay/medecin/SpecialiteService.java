package com.louay.medecin.com.louay.medecin;

import com.louay.medecin.entities.Specialite;
import com.louay.medecin.repos.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpecialiteService {

    @Autowired
    private SpecialiteRepository specialiteRepository;

    public List<Specialite> getAllSpecialites() {
        return specialiteRepository.findAll();
    }

    public Specialite getSpecialiteById(Long id) {
        return specialiteRepository.findById(id).orElseThrow(() -> new RuntimeException("Specialite not found"));
    }

    public Specialite createSpecialite(Specialite marque) {
        return specialiteRepository.save(marque);
    }

    public Specialite updateSpecialite(Long id, Specialite updatedSpecialite) {
        Specialite marque = getSpecialiteById(id);
        marque.setNomSpecialite(updatedSpecialite.getNomSpecialite());
        marque.setDescriptionSpecialite(updatedSpecialite.getDescriptionSpecialite());
        return specialiteRepository.save(marque);
    }

    public void deleteSpecialite(Long id) {
        specialiteRepository.deleteById(id);
    }
}
