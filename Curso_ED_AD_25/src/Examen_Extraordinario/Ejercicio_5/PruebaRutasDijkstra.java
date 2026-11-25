package Examen_Extraordinario.Ejercicio_5;

import ednolineal.Tabla2D;
import edlineal.ArregloEstatico;
import EntradaSalida.Entrada;
import EntradaSalida.Salida;

public class PruebaRutasDijkstra{

    public static void main(String[] args) {
        int cantidadComunidades = 7;

        Tabla2D matrizPesos = new Tabla2D(cantidadComunidades, cantidadComunidades, 0.0);
        ArregloEstatico nombresComunidades = new ArregloEstatico(cantidadComunidades);

        nombresComunidades.insertar("Pampas");
        nombresComunidades.insertar("Reginal");
        nombresComunidades.insertar("Perspiral");
        nombresComunidades.insertar("Romeral");
        nombresComunidades.insertar("Cacaxtla");
        nombresComunidades.insertar("Sansiro");
        nombresComunidades.insertar("Callerosa");

        matrizPesos.modifica(0, 1, 3.0);
        matrizPesos.modifica(1, 0, 3.0);

        matrizPesos.modifica(0, 2, 5.0);
        matrizPesos.modifica(2, 0, 5.0);

        matrizPesos.modifica(0, 5, 3.0);
        matrizPesos.modifica(5, 0, 3.0);

        matrizPesos.modifica(1, 3, 8.0);
        matrizPesos.modifica(3, 1, 8.0);

        matrizPesos.modifica(5, 1, 1.0);
        matrizPesos.modifica(1, 5, 1.0);

        matrizPesos.modifica(2, 4, 2.0);
        matrizPesos.modifica(4, 2, 2.0);

        matrizPesos.modifica(6, 0, 2.0);
        matrizPesos.modifica(0, 6, 2.0);

        matrizPesos.modifica(5, 4, 7.0);
        matrizPesos.modifica(4, 5, 7.0);

        matrizPesos.modifica(4, 3, 9.0);
        matrizPesos.modifica(3, 4, 9.0);

        matrizPesos.modifica(3, 0, 9.0);
        matrizPesos.modifica(0, 3, 9.0);

        matrizPesos.modifica(6, 4, 8.0);
        matrizPesos.modifica(4, 6, 8.0);

        CiudadRutasDijkstra.mostrarGrafo(nombresComunidades, matrizPesos);

        Salida.terminal("\n\nEscribe el numero de la comunidad origen: ");
        int numeroOrigen = -1;
        boolean origenValido = false;

        while (origenValido == false) {
            String entrada = Entrada.terminalCadenas();

            int numero = Integer.parseInt(entrada);

            if (numero >= 1 && numero <= cantidadComunidades) {
                numeroOrigen = numero;
                origenValido = true;
            } else {
                Salida.terminal("Numero fuera de rango, escribe de 1 a 7: ");
            }
        }

        Salida.terminal("Escribe el numero de la comunidad destino: ");
        int numeroDestino = -1;
        boolean destinoValido = false;

        while (destinoValido == false) {
            String entrada = Entrada.terminalCadenas();

            int numero = Integer.parseInt(entrada);

            if (numero >= 1 && numero <= cantidadComunidades) {
                numeroDestino = numero;
                destinoValido = true;
            } else {
                Salida.terminal("Numero fuera de rango, escribe de 1 a 7: ");
            }
        }

        CiudadRutasDijkstra.calcularRuta(matrizPesos, nombresComunidades, numeroOrigen, numeroDestino);
    }
}
