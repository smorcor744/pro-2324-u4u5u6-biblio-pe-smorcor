package org.pebiblioteca

import java.util.*

/**
 * Data class encargada de almacenar la información necesaria de un libro
 * @property id Id del libro.
 * @property titulo Titulo del libro.
 * @property autor Autor del libro.
 * @property anioPublicacion Año de publicación del libro.
 * @property tematica Tematica del libro.
 * @property estado Estado del libro.

 */
class Libro(
    private var id: UUID,
    private val titulo: String,
    private var autor: String,
    private val anioPublicacion: Int,
    private val tematica: String,
    private var estado: EstadoLibro = EstadoLibro.DISPONIBLE
){
    // Métodos públicos para acceder a las propiedades de manera controlada
    fun getId(): UUID = id
    fun getTitulo(): String = titulo
    fun getAutor(): String = autor
    fun getAnioPublicacion(): Int = anioPublicacion
    fun getTematica(): String = tematica
    fun getEstado(): EstadoLibro = estado

    // Método para modificar el estado del libro
    fun modificarEstado(nuevoEstado: EstadoLibro) {
        estado = nuevoEstado
    }
    // Método para modificar el id del libro
    fun modificarId(nuevoid: UUID){
        id = nuevoid
    }

}
