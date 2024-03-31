package org.pebiblioteca

/**
 * Clase encargada de gestionar la biblioteca
 **/
class GestorBiblioteca {
    //Lista que se encarga de almacenar los libros
    private val catalogo: MutableList<Libro> = mutableListOf()
    //Lista que se encarga de almacenar los Préstamos
    private val registroPrestamos: RegistroPrestamos = RegistroPrestamos()

    // Método para agregar un libro al catálogo
    fun agregarLibro(libro: Libro) {
        val id = UtilidadesBiblioteca.generarIdentificadorUnico()
        libro.modificarId(id)
        catalogo.add(libro)
    }

    //Eliminar un libro del catálogo.
    fun eliminarLibro(libro: Libro) {
        catalogo.remove(libro)
    }

    // Método para realizar un préstamo
    fun prestarLibro(libro: Libro, usuario: Usuario) {
        if (libro.getEstado() == EstadoLibro.DISPONIBLE) {
            libro.modificarEstado(EstadoLibro.PRESTADO)
            usuario.agregarPerstamos(libro)
            registroPrestamos.registrarPrestamo(Prestamo(libro, usuario))
            println("El libro '${libro.getTitulo()}' ha sido prestado a ${usuario.nombre}")
        } else {
            println("El libro '${libro.getTitulo()}' no está disponible para préstamo")
        }
    }

    //Devolver un libro (cambia el estado del libro a disponible).
    fun devolverLibro(libro: Libro, usuario: Usuario) {
        if (usuario.librosPrestados.contains(libro)) {
            libro.modificarEstado(EstadoLibro.DISPONIBLE)

            usuario.eliminarPerstamos(libro)
            RegistroPrestamos().devolverLibro(Prestamo(libro,usuario))//Devuelve el libro y lo añade al historial
            println("El libro '${libro.getTitulo()}' ha sido devuelto por ${usuario.nombre}")
        } else {
            println("El usuario ${usuario.nombre} no tiene prestado el libro '${libro.getTitulo()}'")
        }
    }

    //Consultar disponibilidad de un libro.
    fun consultarDisponibilidad(libro: Libro) {
        val estado = if (libro.getEstado() == EstadoLibro.DISPONIBLE) "Disponible" else "Prestado"
        println("El libro '${libro.getTitulo()}' está $estado")
    }

    //Retornar los libros en función de su estado (todos, disponibles y prestados).
    fun consultarCatalogo() {
        println("Que libros quieres ver:\n1.Todos\n2.Disponibles\n3.Prestados")
        val option = readln()
        var verificar = false
        while (!verificar) {
            when (option) {
                "1" -> {
                    println(catalogo)
                    verificar = true

                }
                "2" -> {
                    catalogo.forEach { if( it.getEstado() == EstadoLibro.DISPONIBLE )println(it) }
                    verificar = true

                }
                "3" -> {
                    catalogo.forEach { if(it.getEstado() == EstadoLibro.PRESTADO)println(it) }
                    verificar = true

                }
                else -> print("Opción no valida(1,2,3)")
            }
        }
    }

}