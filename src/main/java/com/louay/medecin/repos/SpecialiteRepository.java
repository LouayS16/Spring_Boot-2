package com.louay.medecin.repos;

import com.louay.medecin.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("http://localhost:4200/")
public interface SpecialiteRepository extends JpaRepository<Specialite, Long> {

}