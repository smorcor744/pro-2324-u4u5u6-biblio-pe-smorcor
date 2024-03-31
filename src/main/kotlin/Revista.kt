package org.pebiblioteca
import java.util.*

/**
 * Data class encargada de almacenar la información necesaria de un libro
 * @property id Id del libro.
 * @property titulo Titulo del libro.
 * @property autor Autor del libro.
 * @property tematica Tematica del libro.
 * @property estado Estado del libro.

 */
class Revista(
    private var id: UUID,
    private val titulo: String,
    private var autor: String,
    private val tematica: String,
    private var estado: EstadoLibro = EstadoLibro.DISPONIBLE
): ElementoBiblioteca(id, titulo, estado) {
    // Métodos públicos para acceder a las propiedades de manera controlada
    fun getAutor(): String = autor
    fun getTematica(): String = tematica

}
