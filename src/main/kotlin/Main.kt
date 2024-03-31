package org.pebiblioteca


/**
 * Funcion encargada de gestionar un meno con todas las opciones del gestor de biblioteca
 * @property biblioteca Biblioteca para gestionar.
 * @property libro Libro que se quiere gestionar.
 * @property usuario Usuario que quiere realizar una accion.
 */
fun menuUsuario(biblioteca: GestorBiblioteca,libro: Libro,usuario: Usuario){
    println("Que quieres hacer:\n1.Agregar un libro\n2.Eliminar un libro\n3.Prestar un libro\n4.Devolver un libro\n5.Comprobar la disponibilidad\n6.Consultar el catalogo")
    val option = readln()
    var verificar = false
    while (!verificar) {
        when (option) {
            "1" -> {
                biblioteca.agregarLibro(libro)
                verificar = true

            }

            "2" -> {
                biblioteca.eliminarLibro(libro)
                verificar = true

            }

            "3" -> {
                biblioteca.prestarLibro(libro,usuario)
                verificar = true

            }
            "4" -> {
                biblioteca.devolverLibro(libro,usuario)
                verificar = true

            }
            "5" -> {
                biblioteca.consultarDisponibilidad(libro)
                verificar = true

            }
            "6" -> {
                biblioteca.consultarCatalogo()
                verificar = true

            }


            else -> print("Opción no valida(1,2,3,4,5,6)")
        }
    }
}


fun main() {
    //Instaciamos el gestor de biblioteca
    val gestorBiblioteca = GestorBiblioteca()
    //Instaciamos 3 libros
    val libro1 = Libro(UtilidadesBiblioteca.generarIdentificadorUnico(), "Cien años de soledad",  "Gabriel García Márquez",  1967,  "Realismo mágico")
    val libro2 = Libro( UtilidadesBiblioteca.generarIdentificadorUnico(),"1984",  "George Orwell",  1949,  "Ciencia ficción")
    val libro3 = Libro(UtilidadesBiblioteca.generarIdentificadorUnico(),"El principito",  "Antoine de Saint-Exupéry",  1943,  "Literatura infantil")
    println(libro3.id)
    //Agregamos al catálogo los 3 libros
    gestorBiblioteca.agregarLibro(libro1)
    gestorBiblioteca.agregarLibro(libro2)
    gestorBiblioteca.agregarLibro(libro3)
    println(libro3.id)


    //Instaciamos los 2 usuarios
    val usuario1 = Usuario( 1,"Juan")
    val usuario2 = Usuario(2,  "María")
    //Prestamos 2 libros y uno tiene que dar error
    gestorBiblioteca.prestarLibro(libro1, usuario1)
    gestorBiblioteca.prestarLibro(libro1, usuario2)
    //Devolvemos 2 libros y uno tiene que dar error
    gestorBiblioteca.devolverLibro(libro1,usuario1)
    gestorBiblioteca.devolverLibro(libro2,usuario2)
    //Consultamos la disponivilidad de los 3 libros
    gestorBiblioteca.consultarDisponibilidad(libro1)
    gestorBiblioteca.consultarDisponibilidad(libro2)
    gestorBiblioteca.consultarDisponibilidad(libro3)
    //Mostramos el menu con un libro y un usuario
    menuUsuario(gestorBiblioteca,libro3,usuario1)
}
