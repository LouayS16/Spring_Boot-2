package com.louay.medecin;

import com.louay.medecin.com.louay.medecin.SpecialiteService;
import com.louay.medecin.com.louay.medecin.MedecinService;
import com.louay.medecin.entities.Specialite;
import com.louay.medecin.entities.Medecin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")  // This tells Spring Boot to use application-test.properties
@Transactional  // Rollback the changes after each test to keep the database clean
public class MedecinServiceIntegrationTest {

    @Autowired
    private MedecinService medecinService;

    @Autowired
    private SpecialiteService marqueService;

    private Specialite marque;
    private Medecin medecin;

    @BeforeEach
    public void setUp() {
        marque = new Specialite();
        marque.setNomSpecialite("Test Specialite");
        marque.setDescriptionSpecialite("This is a test description");
        marque = marqueService.createSpecialite(marque);

        medecin = new Medecin();
        medecin.setNomMedecin("Test PC");
        medecin.setPrixMedecin(1000.0);
        medecin.setDescriptionMedecin("Test PC description");
        medecin.setSpecialiteMedecin(marque);
        medecin.setDateNaissance(new java.util.Date());
    }

    @Test
    public void testCreateMedecin() {
        Medecin createdMedecin = medecinService.createMedecin(medecin);

        assertNotNull(createdMedecin);
        assertEquals("Test PC", createdMedecin.getNomMedecin());
        Assertions.assertEquals(marque.getIdSpecialite(), createdMedecin.getSpecialiteMedecin().getIdSpecialite());
    }

    @Test
    public void testFindAllMedecins() {
        medecinService.createMedecin(medecin);

        List<Medecin> medecins = medecinService.getAllMedecins();

        assertFalse(medecins.isEmpty());
        assertEquals("Test PC", medecins.get(0).getNomMedecin());
    }

    @Test
    public void testUpdateMedecin() {
        Medecin createdMedecin = medecinService.createMedecin(medecin);
        createdMedecin.setNomMedecin("Updated PC");

        Medecin updatedMedecin = medecinService.updateMedecin(createdMedecin.getIdMedecin(), createdMedecin);

        assertEquals("Updated PC", updatedMedecin.getNomMedecin());
    }


}
