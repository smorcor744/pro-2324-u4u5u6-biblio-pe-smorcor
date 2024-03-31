package org.pebiblioteca

/**
 * Clase encargada de gestionar la biblioteca
 **/
class GestorBiblioteca{
    //Lista que se encarga de almacenar los libros
    private val catalogo: MutableList<Libro> = mutableListOf()
    //Lista que se encarga de almacenar los Préstamos
    private val registroPrestamos: MutableList<Prestamo> = mutableListOf()

    //Agregar un libro al catálogo.
    fun agregarLibro(libro: Libro) {
        catalogo.add(libro)
    }

    //Eliminar un libro del catálogo.
    fun eliminarLibro(libro: Libro) {
        catalogo.remove(libro)
    }

    //Registrar un préstamo (cambia el estado del libro a prestado si está disponible).
    fun prestarLibro(libro: Libro, usuario: Usuario) {
        if (libro.estado == EstadoLibro.DISPONIBLE) {
            libro.estado = EstadoLibro.PRESTADO
            usuario.librosPrestados.add(libro)
            registroPrestamos.add(Prestamo(libro,usuario))//Se añade al registro de préstamos
            println("El libro '${libro.titulo}' ha sido prestado a ${usuario.nombre}")
        } else {
            println("El libro '${libro.titulo}' no está disponible para préstamo")
        }
    }

    //Devolver un libro (cambia el estado del libro a disponible).
    fun devolverLibro(libro: Libro, usuario: Usuario) {
        if (usuario.librosPrestados.contains(libro)) {
            libro.estado = EstadoLibro.DISPONIBLE
            usuario.librosPrestados.remove(libro)
            println("El libro '${libro.titulo}' ha sido devuelto por ${usuario.nombre}")
        } else {
            println("El usuario ${usuario.nombre} no tiene prestado el libro '${libro.titulo}'")
        }
    }

    //Consultar disponibilidad de un libro.
    fun consultarDisponibilidad(libro: Libro) {
        val estado = if (libro.estado == EstadoLibro.DISPONIBLE) "Disponible" else "Prestado"
        println("El libro '${libro.titulo}' está $estado")
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
                    catalogo.forEach { if(it.estado == EstadoLibro.DISPONIBLE)println(it) }
                    verificar = true

                }
                "3" -> {
                    catalogo.forEach { if(it.estado == EstadoLibro.PRESTADO)println(it) }
                    verificar = true

                }
                else -> print("Opción no valida(1,2,3)")
            }
        }
    }

}