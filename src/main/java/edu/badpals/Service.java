package edu.badpals;

import java.util.Optional;

import java.util.List;
import edu.badpals.domain.Encargo;
import edu.badpals.domain.Item;
import edu.badpals.domain.Mago;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class Service {
    public Service(){}

    public Item cargaItem(String nombre){
        Optional<Item> item = Item.findByIdOptional(nombre);
        return item.isPresent()? item.get() : new Item();
    }

    public Mago cargaMago(String nombre){
        Optional<Mago> mago = Mago.findByIdOptional(nombre);
        return mago.isPresent()? mago.get() : new Mago();
    }

    public List<Encargo> encargos(String nombre){
        return Encargo.findbyMago(nombre);
    }

    @Transactional
    public Encargo registrarEncargo(@Valid Encargo encargo) {
        Encargo newEncargo = null;
        Optional<Mago> mago = Mago.findByIdOptional(encargo.getMago());
        Optional<Item> item = Item.findByIdOptional(encargo.getItem());
        if (mago.isPresent() && item.isPresent()){
            newEncargo = encargo;
            newEncargo.persist();
        }
        return newEncargo;
    }
}
