package Pruebas;

import EntradaSalida.*;
import ednolineal.ArbolBB;

public class PruebaABB {
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB();

        arbol.insertar(15);
        arbol.insertar(10);
        arbol.insertar(17);
        arbol.insertar(16);
        arbol.insertar(20);
        arbol.insertar(12);
        arbol.insertar(5);
        arbol.insertar(3);
        arbol.insertar(6);
        arbol.insertar(6);
        arbol.insertar(11);
        arbol.insertar(11);

        Salida.terminal("\nEl arbol es: \n");
        arbol.inorden();
        Salida.terminal("\n\n");
        Salida.terminal("Buscando 12: " + arbol.buscar(12)+"\n");
        Salida.terminal("Buscando 30: " + arbol.buscar(30)+"\n");
    }
}
