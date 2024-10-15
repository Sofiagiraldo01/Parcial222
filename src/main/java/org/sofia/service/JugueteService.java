package org.sofia.service;

import org.sofia.entity.Juguete;
import org.sofia.repository.JugueteRepository;

import java.util.List;

public class JugueteService {

    private final JugueteRepository repository;

    public JugueteService() {
        this.repository = new JugueteRepository();
    }

    public void crearProducto(Juguete producto) {
        repository.crear(producto);
    }

    public Juguete obtenerProducto(Long id) {
        return repository.leer(id);
    }

    public List<Juguete> obtenerTodosLosProductos() {
        return repository.leerTodos();
    }

    public void actualizarProducto(Juguete producto) {
        repository.actualizar(producto);
    }

    public void eliminarProducto(Long id) {
        repository.eliminar(id);
    }

    public void cerrar() {
        repository.cerrar();
    }
}
