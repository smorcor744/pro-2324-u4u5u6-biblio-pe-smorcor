package org.pebiblioteca

/**
 * Clase encargada de gestionar la biblioteca
 **/
class GestorBiblioteca(private val catalogo: Catalogo) {

    //Lista que se encarga de almacenar los Préstamos
    private val registroPrestamos: RegistroPrestamos = RegistroPrestamos()

    // Método para agregar un libro al catálogo
    fun agregarLibro(libro: ElementoBiblioteca) {
        val id = UtilidadesBiblioteca.generarIdentificadorUnico()
        libro.modificarId(id)
        catalogo.agregarElemento(libro)
    }

    //Eliminar un libro del catálogo.
    fun eliminarLibro(libro: ElementoBiblioteca) {
        catalogo.eliminarElemento(libro)
    }

    // Método para realizar un préstamo
    fun prestarLibro(libro: ElementoBiblioteca, usuario: Usuario) {
        if (libro is Prestable && libro.getEstado() == EstadoLibro.DISPONIBLE ) {
            libro.prestar()
            usuario.agregarPerstamos(libro)
            registroPrestamos.registrarPrestamo(Prestamo(libro, usuario))
            println("El libro '${libro.getTitulo()}' ha sido prestado a ${usuario.nombre}")
        } else {
            println("El libro '${libro.getTitulo()}' no está disponible para préstamo")
        }
    }

    //Devolver un libro (cambia el estado del libro a disponible).
    fun devolverLibro(libro: ElementoBiblioteca, usuario: Usuario) {
        if (libro is Prestable && usuario.librosPrestados.contains(libro)) {
            libro.devolver()

            usuario.eliminarPerstamos(libro)
            RegistroPrestamos().registrarDevolucion(Prestamo(libro,usuario))//Devuelve el libro y lo añade al historial
            println("El libro '${libro.getTitulo()}' ha sido devuelto por ${usuario.nombre}")
        } else {
            println("El usuario ${usuario.nombre} no tiene prestado el libro '${libro.getTitulo()}'")
        }
    }

    // Método para consultar el catálogo y retornar una lista de elementos según el criterio seleccionado
    fun consultarCatalogo(criterio: String): List<ElementoBiblioteca> {
        return when (criterio.lowercase()) {
            "todos" -> catalogo.obtenerElementos()
            "disponibles" -> catalogo.filtrarPorCriterio { it.getEstado() == EstadoLibro.DISPONIBLE }
            "prestados" -> catalogo.filtrarPorCriterio { it.getEstado() == EstadoLibro.PRESTADO }
            else -> {
                println("Opción no válida (Todos, Disponibles, Prestados)")
                emptyList()
            }
        }
    }



}