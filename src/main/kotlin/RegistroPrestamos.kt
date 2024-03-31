package org.pebiblioteca

/**
 * Clase encargada de llevar lo
 * @property historial Es el historial de los préstamos.
 */
class RegistroPrestamos{
    private val registrosPrestamos:MutableList<Prestamo> = mutableListOf()
    private val historial: MutableList<Prestamo> = mutableListOf()

    fun registrarPrestamo(prestamo: Prestamo){
        registrosPrestamos.add(prestamo)
        historial.add(prestamo)
    }
    fun devolverLibro(prestamo: Prestamo){
        registrosPrestamos.remove(prestamo)
        historial.add(prestamo)
    }
    fun consultarHistorialPrestamosEspecificoLibro(libro: Libro): List<Prestamo> {
        return historial.filter { it.libro == libro }

    }
    fun consultarHistorialPrestamosEspecificoUsuario(usuario: Usuario): List<Prestamo> {
        return historial.filter { it.usuario == usuario }
    }
}