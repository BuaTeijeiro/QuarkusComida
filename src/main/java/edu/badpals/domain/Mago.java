package edu.badpals.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="t_magos")
public class Mago extends PanacheEntityBase{
    @Id
    @Column(name="nombre")
    String nombre;

    public Mago(String nombre) {
        this.nombre = nombre;
    }

    public Mago() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
