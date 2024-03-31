package org.pebiblioteca

import java.util.*

// Clase abstracta que define propiedades y métodos comunes a todos los elementos de una biblioteca
abstract class ElementoBiblioteca(
    private var id: UUID,
    private val titulo: String,
    private var estado: EstadoLibro = EstadoLibro.DISPONIBLE
) {
    fun getId(): UUID = id
    fun getEstado(): EstadoLibro = estado
    fun getTitulo(): String = titulo

    // Método para modificar el id del elemento
    fun modificarId(nuevoid: UUID){
        id = nuevoid
    }

    // Método para modificar el estado del elemento
    fun modificarEstado(nuevoEstado: EstadoLibro) {
        estado = nuevoEstado
    }
}