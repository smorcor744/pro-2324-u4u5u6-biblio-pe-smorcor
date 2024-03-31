package org.pebiblioteca

// Clase que gestiona los préstamos de la biblioteca
interface IGestorPrestamos {
    fun registrarPrestamo(prestamo: Prestamo)
    fun registrarDevolucion(prestamo: Prestamo)
    fun consultarHistorial()
    fun consultarHistorialPrestamosEspecificoLibro(libro: ElementoBiblioteca): List<Prestamo>
    fun consultarHistorialPrestamosEspecificoUsuario(usuario: Usuario): List<Prestamo>
}