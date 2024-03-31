package org.pebiblioteca
import java.util.UUID

/**
 * Clase encargada de implementar utilidades la biblioteca
 **/
class UtilidadesBiblioteca {
    companion object {
        // Lista para almacenar los UUID generados anteriormente
        private val uuidsGenerados: MutableSet<UUID> = mutableSetOf()

        // Función encargada de generar un ID único que no esté en la lista de UUIDs generados anteriormente
        fun generarIdentificadorUnico(): UUID {
            var uuid: UUID
            do {
                uuid = UUID.randomUUID()
            } while (uuidsGenerados.contains(uuid))
            uuidsGenerados.add(uuid)
            return uuid
        }
    }
}
