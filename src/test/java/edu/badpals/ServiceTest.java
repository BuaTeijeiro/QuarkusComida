package edu.badpals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import edu.badpals.domain.Encargo;
import edu.badpals.domain.Item;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@QuarkusTest
public class ServiceTest {
    
    @PersistenceContext
    jakarta.persistence.EntityManager em;

    @Inject
    Service service;

    @Test
    void connectionDatabaseTest(){
        Item item = em.find(Item.class, "Arroz");
        assertNotNull(item);
        assertEquals("Arroz", item.nombre);
        assertEquals("Normal Item", item.tipo);
        assertEquals(10, item.quality);
        assertEquals(3, item.sell_in);

    }

    @Test
    void cargaItemTest_Exsite(){
        Item item = service.cargaItem("Arroz");
        assertNotNull(item);
        assertEquals("Arroz", item.nombre);
        assertEquals("Normal Item", item.tipo);
        assertEquals(10, item.quality);
        assertEquals(3, item.sell_in);
    }

    @Test
    void cargaItemTest_NoExiste(){
        Item item = service.cargaItem("Sal");
        assertNotNull(item);
        assertNull(item.nombre);
        assertNull(item.tipo);
        assertEquals(0, item.quality);
        assertEquals(0, item.sell_in);
    }

    @Test 
    void nuevoEncargoTest(){
        List<Encargo> encargosHarry = Encargo.findbyMago("Harry Potter");
        assertEquals(0, encargosHarry.size());

        Encargo encargo = new Encargo(3, "Harry Potter", "Pasta");
        service.registrarEncargo(encargo);

        encargosHarry = Encargo.findbyMago("Harry Potter");
        assertEquals(1, encargosHarry.size());

    }
}