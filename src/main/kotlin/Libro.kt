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
data class Libro(
    var id: UUID,
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int,
    val tematica: String,
    var estado: EstadoLibro = EstadoLibro.DISPONIBLE
)
