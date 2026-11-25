package Pruebas;

import EntradaSalida.Salida;
import edlineal.ArregloEstatico;

public class PrincipalAE {
    public static void main(String nojala[]) {
        System.out.print("\033[H\033[2J");                      //LIMPIA LA TERMINAL

        ArregloEstatico miPrimerArreglo = new ArregloEstatico(6);

        miPrimerArreglo.insertar("A");
        miPrimerArreglo.insertar("S");
        miPrimerArreglo.insertar("M");
        miPrimerArreglo.insertar("P");
        miPrimerArreglo.insertar("N");

        miPrimerArreglo.imprimir();                                 //Imprime el arreglo
        
        Salida.terminal("\n");                              //Salto de linea

        Salida.terminal("Buscando: S -> " + miPrimerArreglo.buscar("S") + "\n");
        Salida.terminal("Buscando: H -> " + miPrimerArreglo.buscar("H") + "\n");

        Salida.terminal("Eliminando: S -> " + miPrimerArreglo.eliminar("S") + "\n");

        miPrimerArreglo.imprimir();
        Salida.terminal("\n");

    }
}
