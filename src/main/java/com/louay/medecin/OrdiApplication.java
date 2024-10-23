package com.louay.medecin;

import com.louay.medecin.entities.Specialite;
import com.louay.medecin.entities.Medecin;
import com.louay.medecin.entities.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class OrdiApplication implements CommandLineRunner {
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(OrdiApplication.class, args);

    }
    @Override
    public void run(String... args) throws Exception {

        repositoryRestConfiguration.exposeIdsFor(Medecin.class, Specialite.class);
    }


}