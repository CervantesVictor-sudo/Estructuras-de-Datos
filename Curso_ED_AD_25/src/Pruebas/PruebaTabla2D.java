package Pruebas;

import EntradaSalida.Salida;
import ednolineal.Tabla2D;

public class PruebaTabla2D {
    public static void main(String[] args) {
        Tabla2D matriz = new Tabla2D(3, 2);

        matriz.llenar("A");

        matriz.imprimirXColumna();

        matriz.modifica(1, 1, 3);
        matriz.modifica(0, 0, 2);
        matriz.modifica(2, 1, 1);

        Salida.terminal("\n");
        matriz.imprimirXRenglones();

        Salida.terminal("\n\n");
        Salida.terminal("La tabla tiene " + matriz.obtenerRenglones() + " renglones y " + matriz.obtenerColumnas() + " columnas");
        Salida.terminal("\n");

        Tabla2D matriz2 = matriz.copiar();

        matriz2.imprimirXRenglones();

        Salida.terminal("\n");
        boolean SonIguales = matriz.esIgual(matriz2);
        System.out.println(SonIguales);

        matriz2.modifica(1, 1, "X");
        Salida.terminal("\n");
        SonIguales = matriz.esIgual(matriz2);
        System.out.println(SonIguales);



    }
}
