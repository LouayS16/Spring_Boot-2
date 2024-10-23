package com.louay.medecin.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.louay.medecin.entities.Medecin;
import com.louay.medecin.services.MedecinService;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/medecins")
public class MedecinController {

    @Autowired
    private MedecinService medecinService;

    @GetMapping
    public ResponseEntity<List<Medecin>> getAllMedecins(@RequestParam (name="page", defaultValue = "0") int page,
                                                   @RequestParam (name="size", defaultValue = "100") int size) {
        List<Medecin> medecins = medecinService.getAllMedecinParPage(page, size).getContent();
        return new ResponseEntity<>(medecins, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Medecin> getMedecinById(@PathVariable Long id) {
        Medecin medecin = medecinService.getMedecin(id);
        if (medecin == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if not found
        }
        return new ResponseEntity<>(medecin, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createMedecin(@Valid @RequestBody Medecin medecin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Print or log validation errors for debugging
            return ResponseEntity.badRequest().body(bindingResult.getFieldErrors());
        }
        Medecin createdMedecin = medecinService.saveMedecin(medecin);
        return new ResponseEntity<>(createdMedecin, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Medecin> updateMedecin(@PathVariable Long id, @Valid @RequestBody Medecin updatedMedecin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Return 400 if there are validation errors
        }
        updatedMedecin.setIdMedecin(id); // Ensure the ID is set for the update
        Medecin existingMedecin = medecinService.updateMedecin(updatedMedecin);
        if (existingMedecin == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if not found
        }
        return new ResponseEntity<>(existingMedecin, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedecin(@PathVariable Long id) {
        try {
            medecinService.deleteMedecinById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 for successful deletion
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if not found
        }
    }

    @RequestMapping(value="/prodsByName/{nom}",method = RequestMethod.GET)
    public List<Medecin> findByNomMedecinContains(@PathVariable("nom") String nom) {
        return medecinService.findByNomMedecinContains(nom);
    }
    @RequestMapping(value="/medecinsMar/{idSpecialite}",method = RequestMethod.GET)
    public List<Medecin> findBySpecialiteMedecin(@PathVariable("idSpecialite") Long idSpecialite) {

        return medecinService.findBySpecialiteMedecinIdSpecialite(idSpecialite);
    }

}