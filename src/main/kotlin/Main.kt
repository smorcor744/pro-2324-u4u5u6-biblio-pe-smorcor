package org.pebiblioteca

/**
 * Funcion encargada de gestionar un meno con todas las opciones del gestor de biblioteca
 * @property biblioteca Biblioteca para gestionar.
 * @property libro Libro que se quiere gestionar.
 * @property usuario Usuario que quiere realizar una accion.
 */
fun menuUsuario(biblioteca: GestorBiblioteca,libro: ElementoBiblioteca,usuario: Usuario){
    println("Que quieres hacer:\n1.Agregar un libro\n2.Eliminar un libro\n3.Prestar un libro\n4.Devolver un libro\n5.Consultar el catalogo")
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
                println("Que elementos quieres ver:\nTodos\nDisponibles\nPrestados")
                biblioteca.consultarCatalogo(criterio = readln() )
                verificar = true

            }


            else -> print("Opción no valida(1,2,3,4,5)")
        }
    }
}

fun main() {
    // Crear instancias de varios usuarios
    val usuario1 = Usuario(UtilidadesBiblioteca.generarIdentificadorUnico(), "Juan")
    val usuario2 = Usuario(UtilidadesBiblioteca.generarIdentificadorUnico(), "María")

    // Crear instancia del catálogo utilizando GestorElementos
    val catalogo = Catalogo()

    // Crear instancia del gestor de biblioteca pasando el catálogo
    val gestorBiblioteca = GestorBiblioteca(catalogo)

    // Crear instancias de libros y revistas
    val libro1 = Libro(UtilidadesBiblioteca.generarIdentificadorUnico(), "Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico")
    val libro2 = Libro(UtilidadesBiblioteca.generarIdentificadorUnico(), "1984", "George Orwell", 1949, "Ciencia ficción")
    val revista1 = Revista(UtilidadesBiblioteca.generarIdentificadorUnico(), "National Geographic", "National Geographic Society", "Cultura general")

    // Agregar libros y revistas al catálogo a través del GestorBiblioteca
    gestorBiblioteca.agregarLibro(libro1)
    gestorBiblioteca.agregarLibro(libro2)
    gestorBiblioteca.agregarLibro(revista1)

    // Realizar operaciones de préstamo y devolución
    gestorBiblioteca.prestarLibro(libro1, usuario1)
    gestorBiblioteca.prestarLibro(libro2, usuario2)
    gestorBiblioteca.devolverLibro(libro1, usuario1)
    gestorBiblioteca.prestarLibro(revista1, usuario1)

    // Mostrar el estado actual del catálogo
    val catalogoEstado = gestorBiblioteca.consultarCatalogo("Todos")
    println("Estado actual del catálogo:")
    catalogoEstado.forEach { println(it.getTitulo()) }
}
