package edu.badpals.domain;

import org.junit.jupiter.api.Test;

import edu.badpals.Service;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@QuarkusTest
public class EncargoTest {
     @PersistenceContext
    jakarta.persistence.EntityManager em;

    @Inject
    Service service;

    @Test
    void findbyMagoTest_Hermione(){
        List<Encargo> encargosHermione = Encargo.findbyMago("Hermione");
        assertEquals(2, encargosHermione.size());
    }

}
