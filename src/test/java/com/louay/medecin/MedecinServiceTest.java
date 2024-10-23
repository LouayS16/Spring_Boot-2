package com.louay.medecin;

import com.louay.medecin.com.louay.medecin.MedecinService;
import com.louay.medecin.entities.Medecin;
import com.louay.medecin.repos.MedecinRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

public class MedecinServiceTest {

    @Mock
    private MedecinRepository medecinRepository;

    @InjectMocks
    private MedecinService medecinService;

    private Medecin medecin;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        medecin = new Medecin();
        medecin.setIdMedecin(1L);
        medecin.setNomMedecin("Test PC");
        medecin.setPrixMedecin(1000.0);
        medecin.setDescriptionMedecin("Test Description");
    }

    @Test
    public void testGetMedecinById_Success() {
        when(medecinRepository.findById(1L)).thenReturn(Optional.of(medecin));

        Medecin foundMedecin = medecinService.getMedecinById(1L);

        assertNotNull(foundMedecin);
        assertEquals(1L, foundMedecin.getIdMedecin());
        assertEquals("Test PC", foundMedecin.getNomMedecin());
        verify(medecinRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreateMedecin_Success() {
        when(medecinRepository.save(any(Medecin.class))).thenReturn(medecin);

        Medecin createdMedecin = medecinService.createMedecin(medecin);

        assertNotNull(createdMedecin);
        assertEquals("Test PC", createdMedecin.getNomMedecin());
        verify(medecinRepository, times(1)).save(medecin);
    }

    @Test
    public void testUpdateMedecin_Success() {
        Medecin updatedMedecin = new Medecin();
        updatedMedecin.setNomMedecin("Updated PC");
        updatedMedecin.setPrixMedecin(1500.0);

        when(medecinRepository.findById(1L)).thenReturn(Optional.of(medecin));
        when(medecinRepository.save(any(Medecin.class))).thenReturn(updatedMedecin);

        Medecin result = medecinService.updateMedecin(1L, updatedMedecin);

        assertEquals("Updated PC", result.getNomMedecin());
        assertEquals(1500.0, result.getPrixMedecin());
        verify(medecinRepository, times(1)).findById(1L);
        verify(medecinRepository, times(1)).save(medecin);
    }

    @Test
    public void testDeleteMedecin_Success() {
        doNothing().when(medecinRepository).deleteById(1L);

        medecinService.deleteMedecin(1L);

        verify(medecinRepository, times(1)).deleteById(1L);
    }
}
