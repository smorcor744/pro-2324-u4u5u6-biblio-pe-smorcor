package org.pebiblioteca

/**
 * Clase encargada de crear objetos para el Registro de Préstamos
 * @property libro Libro que se a prestado.
 * @property usuario Usuario al que se le ha prestado.
 */
data class Prestamo(val libro: ElementoBiblioteca, val usuario: Usuario)

