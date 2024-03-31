package org.pebiblioteca

/**
 * Data class encargada de almacenar la información necesaria de un libro
 * @property id Id del usuario.
 * @property nombre Nombre del usuario.
 * @property librosPrestados Listas de libros que se le a prestado al usuario.
 */
data class Usuario(
    val id: Int,
    val nombre: String,
    val librosPrestados: MutableList<Libro> = mutableListOf()
)