package herramientas.Ordenamiento;

import edlineal.ArregloEstatico;

public class GnomeSort {
    public static void gnomeSort(ArregloEstatico arreglo) {

        int cantidadElementos = arreglo.cantidad();
        int indiceActual = 0;

        while (indiceActual < cantidadElementos) {
            if (indiceActual == 0) {
                indiceActual = indiceActual + 1;
            } else {
                int valorActual = (int) arreglo.valor(indiceActual);
                int valorAnterior = (int) arreglo.valor(indiceActual - 1);

                if (valorActual >= valorAnterior) {
                    indiceActual = indiceActual + 1;
                } else {
                    arreglo.modifica(indiceActual, valorAnterior);
                    arreglo.modifica(indiceActual - 1, valorActual);
                    indiceActual = indiceActual - 1;
                }
            }
        }
    }
}
