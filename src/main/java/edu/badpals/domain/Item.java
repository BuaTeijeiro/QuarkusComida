package edu.badpals.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="t_items")
public class Item extends PanacheEntityBase{
    @Id
    @Column(name="nombre")
    public String nombre;

    @Column(name="tipo")
    public String tipo;

    @Column(name="quality")
    public int quality;

    @Column(name="sell_in")
    public int sell_in;

    public Item(){}

    public Item(String nombre, String tipo, int quality, int sell_in) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.quality = quality;
        this.sell_in = sell_in;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getSell_in() {
        return sell_in;
    }

    public void setSell_in(int sell_in) {
        this.sell_in = sell_in;
    }

}
