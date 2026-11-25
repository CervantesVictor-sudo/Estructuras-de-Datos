package Pruebas;

import EntradaSalida.Salida;
import ednolineal.ArbolExpresiones;

public class PruebaArbolExp {
    public static void main(String[] args) {
        ArbolExpresiones arbol = new ArbolExpresiones();
        arbol.crearArbolPosfija("abcd-*49^/+");
        Salida.terminal("El arbol es: \n");
        arbol.inorden();
        Salida.terminal("\n");
        arbol.postorden();
        Salida.terminal("\n");
        arbol.preorden();
        Salida.terminal("\n");

    }
}
