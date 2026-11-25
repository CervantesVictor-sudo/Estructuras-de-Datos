package Examen_Extraordinario.Ejercicio_5;

import ednolineal.Tabla2D;
import edlineal.ArregloEstatico;
import EntradaSalida.Salida;

public class CiudadRutasDijkstra {

    public static void mostrarGrafo(ArregloEstatico nombresComunidades, Tabla2D matrizPesos) {

        int totalComunidades = nombresComunidades.cantidad();

        Salida.terminal("Comunidades:\n");
        mostrarComunidadesRecursivo(nombresComunidades, 0, totalComunidades);

        Salida.terminal("\n\nMatriz de adyacencia:\n");
        matrizPesos.imprimirMatriz();
        Salida.terminal("\n");
    }

    private static void mostrarComunidadesRecursivo(ArregloEstatico nombresComunidades, int indiceActual, int totalComunidades) {

        String nombre = (String) nombresComunidades.valor(indiceActual);
        int numeroVisible = indiceActual + 1;
        
        Salida.terminal(numeroVisible + " - " + nombre + "\n");
        
        if (indiceActual >= totalComunidades) {
            return;
        }

        mostrarComunidadesRecursivo(nombresComunidades, indiceActual + 1, totalComunidades);
    }

    public static void calcularRuta(Tabla2D matrizPesos, ArregloEstatico nombresComunidades, int numeroOrigen, int numeroDestino) {

        int totalComunidades = nombresComunidades.cantidad();
        double infinito = 999999.0;

        ArregloEstatico distancias = new ArregloEstatico(totalComunidades);
        ArregloEstatico visitados = new ArregloEstatico(totalComunidades);
        ArregloEstatico anteriores = new ArregloEstatico(totalComunidades);

        distancias.llenar(infinito, totalComunidades);
        visitados.llenar(false, totalComunidades);
        anteriores.llenar(-1, totalComunidades);

        int indiceOrigen = numeroOrigen - 1;
        int indiceDestino = numeroDestino - 1;

        distancias.modifica(indiceOrigen, 0.0);
        anteriores.modifica(indiceOrigen, -1);

        dijkstraRecursivo(matrizPesos, distancias, visitados, anteriores, infinito);

        Double distanciaFinal = (Double) distancias.valor(indiceDestino);

        if (distanciaFinal >= infinito) {
            Salida.terminal("\nNo existe ruta entre esas comunidades\n");
        } else {
            Salida.terminal("\nDistancia minima desde " + numeroOrigen + " a " + numeroDestino + " = " + distanciaFinal + "\n");
            Salida.terminal("Ruta: ");
            imprimirRutaRecursiva(indiceDestino, anteriores, nombresComunidades);
            Salida.terminal("\n");
        }
    }

    private static void dijkstraRecursivo(Tabla2D matrizPesos, ArregloEstatico distancias, ArregloEstatico visitados,
                                                                        ArregloEstatico anteriores, double infinito) {

        int indiceMinimo = buscarMinimoNoVisitado(distancias, visitados, 0, -1, infinito);

        if (indiceMinimo == -1) {
            return;
        }

        visitados.modifica(indiceMinimo, true);

        relajarVecinos(matrizPesos, distancias, visitados, anteriores, indiceMinimo, 0);

        dijkstraRecursivo(matrizPesos, distancias, visitados, anteriores, infinito);
    }

    private static int buscarMinimoNoVisitado(ArregloEstatico distancias, ArregloEstatico visitados,
                                                int indiceActual, int indiceMejor, double infinito) {

        int totalVertices = distancias.cantidad();

        if (indiceActual >= totalVertices) {
            return indiceMejor;
        }

        Double distanciaActual = (Double) distancias.valor(indiceActual);
        boolean yaVisitado = (boolean) visitados.valor(indiceActual);

        if (yaVisitado == false && distanciaActual < infinito) {
            if (indiceMejor == -1) {
                indiceMejor = indiceActual;
            } else {
                Double distanciaMejor = (Double) distancias.valor(indiceMejor);
                if (distanciaActual < distanciaMejor) {
                    indiceMejor = indiceActual;
                }
            }
        }

        return buscarMinimoNoVisitado(distancias, visitados, indiceActual + 1, indiceMejor, infinito);
    }

    private static void relajarVecinos(Tabla2D matrizPesos, ArregloEstatico distancias, ArregloEstatico visitados,
                                                    ArregloEstatico anteriores, int indiceActual, int indiceVecino) {

        int totalVertices = matrizPesos.obtenerColumnas();

        if (indiceVecino >= totalVertices) {
            return;
        }

        Double peso = (Double) matrizPesos.valor(indiceActual, indiceVecino);

        if (peso != null && peso > 0) {
            boolean vecinoVisitado = (boolean) visitados.valor(indiceVecino);

            if (vecinoVisitado == false) {
                Double distanciaActual = (Double) distancias.valor(indiceActual);
                Double distanciaVecino = (Double) distancias.valor(indiceVecino);
                Double nuevaDistancia = distanciaActual + peso;

                if (nuevaDistancia < distanciaVecino) {
                    distancias.modifica(indiceVecino, nuevaDistancia);
                    anteriores.modifica(indiceVecino, indiceActual);
                }
            }
        }

        relajarVecinos(matrizPesos, distancias, visitados, anteriores, indiceActual, indiceVecino + 1);
    }

    private static void imprimirRutaRecursiva(int indiceActual, ArregloEstatico anteriores,ArregloEstatico nombresComunidades) {

        int indicePadre = (Integer) anteriores.valor(indiceActual);

        if (indicePadre == -1) {
            String nombre = (String) nombresComunidades.valor(indiceActual);
            Salida.terminal("" + nombre);
        } else {
            imprimirRutaRecursiva(indicePadre, anteriores, nombresComunidades);
            String nombre = (String) nombresComunidades.valor(indiceActual);
            Salida.terminal(" -> " + nombre);
        }
    }
}