package com.louay.medecin.repos;

import com.louay.medecin.entities.Specialite;
import com.louay.medecin.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    List<Medecin> findByNomMedecin(String nom);
    List<Medecin> findByNomMedecinContains(String nom);

    @Query("select c from Medecin c where c.nomMedecin like %:nom and c.salaireMedecin > :salaire")
    List<Medecin> findByNomSalaire(@Param("nom") String nom, @Param("salaire") Double salaire);

    @Query("select c from Medecin c where c.specialiteMedecin = ?1")
    List<Medecin> findBySpecialiteMedecin(Specialite specialite);

    // Updated method
    @Query("select c from Medecin c where c.specialiteMedecin.idSpecialite = ?1") // Use idSpecialite here
    List<Medecin> findBySpecialiteIdMar(Long id);


    List<Medecin> findByOrderByNomMedecinAsc();

    @Query("select c from Medecin c order by c.nomMedecin ASC, c.salaireMedecin DESC")
    List<Medecin> trierMedecinsNomsSalaire();
    List<Medecin> findBySpecialiteMedecinIdSpecialite(Long idSpecialite);

}
