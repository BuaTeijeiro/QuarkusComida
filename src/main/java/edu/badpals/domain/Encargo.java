package edu.badpals.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="t_encargos")
public class Encargo extends PanacheEntityBase{
    @Id
    @Column(name="codigo")
    int codigo;

    @Column(name="mago")
    String mago;

    @Column(name="item")
    String item;

    public Encargo(int codigo, String mago, String item) {
        this.codigo = codigo;
        this.mago = mago;
        this.item = item;
    }

    public Encargo() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMago() {
        return mago;
    }

    public void setMago(String mago) {
        this.mago = mago;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public static List<Encargo> findbyMago(String name){
        List<Encargo> encargos = Encargo.listAll();
        return encargos.stream().filter(o -> o.getMago().equals(name)).toList();
    }
}
