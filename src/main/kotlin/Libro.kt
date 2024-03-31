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
): ElementoBiblioteca(id, titulo, estado),Prestable {
    // Métodos públicos para acceder a las propiedades de manera controlada
    fun getId(): UUID = id
    fun getAutor(): String = autor
    fun getAnioPublicacion(): Int = anioPublicacion
    fun getTematica(): String = tematica
    override fun prestar() {
        estado = EstadoLibro.PRESTADO
    }

    override fun devolver() {
        estado = EstadoLibro.DISPONIBLE

    }

}
