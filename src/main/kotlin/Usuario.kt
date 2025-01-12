package org.pebiblioteca

import java.util.*

/**
 * Data class encargada de almacenar la información necesaria de un libro
 * @property id Id del usuario.
 * @property nombre Nombre del usuario.
 * @property librosPrestados Listas de libros que se le a prestado al usuario.
 */
class Usuario(
    val id: UUID,
    val nombre: String,
    val librosPrestados: MutableList<ElementoBiblioteca> = mutableListOf()
){
    fun agregarPerstamos(libro: ElementoBiblioteca){
        librosPrestados.add(libro)
    }
    fun eliminarPerstamos(libro: ElementoBiblioteca){
        librosPrestados.remove(libro)
    }
    fun consultarPerstamos(): List<ElementoBiblioteca> {
        return librosPrestados.toList()
    }

    override fun toString(): String {
        return "Usuario(id:$id, nombre:$nombre, libros prestados:$librosPrestados)"
    }

}