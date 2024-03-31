package org.pebiblioteca

import java.util.*

open class GestorElementos<T : ElementoBiblioteca> {
    val elementos: MutableList<T> = mutableListOf()

    // Método para agregar elementos al gestor de elementos
    fun agregarElemento(elemento: T) {
        elementos.add(elemento)
    }

    // Método para eliminar elementos por identificador del gestor de elementos
    fun eliminarElemento(elemento: ElementoBiblioteca) {
        elementos.find { it.getId() == elemento.getId() }
        elemento.let { elementos.remove(it) }
    }

    // Método para retornar los elementos gestionados
    fun obtenerElementos(): List<T> {
        return elementos.toList()
    }

    // Método para buscar elementos por diversos criterios
    fun filtrarPorCriterio(criterio: (elemento: T) -> Boolean): List<T> {
        return elementos.filter(criterio)
    }
}
