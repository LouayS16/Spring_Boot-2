package com.louay.medecin.Controllers;

import com.louay.medecin.com.louay.medecin.SpecialiteService;
import com.louay.medecin.entities.Specialite;
import com.louay.medecin.entities.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/specialites")
public class SpecialiteController {

    @Autowired
    private SpecialiteService specialiteService;

    @GetMapping
    public List<Specialite> getAllSpecialites() {
        return specialiteService.getAllSpecialites();
    }
    @GetMapping("/{id}")
    public Specialite getSpecialiteById(@PathVariable Long id) {
        return specialiteService.getSpecialiteById(id);
    }
    @PostMapping
    public Specialite createSpecialite(@RequestBody Specialite specialite) {
        return specialiteService.createSpecialite(specialite);
    }
    @PutMapping("/{id}")
    public Specialite updateSpecialite(@PathVariable Long id, @RequestBody Specialite updatedSpecialite) {
        return specialiteService.updateSpecialite(id, updatedSpecialite);
    }
    @DeleteMapping("/{id}")
    public void deleteSpecialite(@PathVariable Long id) {
        specialiteService.deleteSpecialite(id);
    }
}
