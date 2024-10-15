package org.sofia.entity;

import jakarta.persistence.*;

public class JugueteListener {

    @PrePersist
    public void prePersist(Juguete producto) {
        System.out.println("Producto a ser persistido: " + producto);
    }

    @PostPersist
    public void postPersist(Juguete producto) {
        System.out.println("Producto persistido: " + producto);
    }

    @PreUpdate
    public void preUpdate(Juguete producto) {
        System.out.println("Producto a ser actualizado: " + producto);
    }

    @PostUpdate
    public void postUpdate(Juguete producto) {
        System.out.println("Producto actualizado: " + producto);
    }

    @PreRemove
    public void preRemove(Juguete producto) {
        System.out.println("Producto a ser eliminado: " + producto);
    }

    @PostRemove
    public void postRemove(Juguete producto) {
        System.out.println("Producto eliminado: " + producto);
    }
}
