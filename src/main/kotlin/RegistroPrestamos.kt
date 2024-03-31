package org.pebiblioteca

/**
 * Clase encargada de llevar lo
 * @property historial Es el historial de los préstamos.
 */
class RegistroPrestamos:IGestorPrestamos{
    private val prestamos:MutableList<Prestamo> = mutableListOf()
    private val historial: MutableList<Prestamo> = mutableListOf()

    override fun registrarPrestamo(prestamo: Prestamo) {
        prestamos.add(prestamo)
        historial.add(prestamo)
    }

    override fun registrarDevolucion(prestamo: Prestamo) {
        prestamos.remove(prestamo)
        historial.add(prestamo)
    }

    override fun consultarHistorial() {
        println(historial)
    }

    override fun consultarHistorialPrestamosEspecificoLibro(libro: ElementoBiblioteca): List<Prestamo> {
        return historial.filter { it.libro == libro }

    }
    override fun consultarHistorialPrestamosEspecificoUsuario(usuario: Usuario): List<Prestamo> {
        return historial.filter { it.usuario == usuario }
    }
}