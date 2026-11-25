package Pruebas;

import EntradaSalida.Salida;
import edlineal.ColaEstatica;

public class PruebaCola {
    public static void main(String[] args) {
        ColaEstatica colaNC = new ColaEstatica(5);
        ColaEstatica colaC = new ColaEstatica(6);

        //Cola NO Circular
        colaNC.meter("S");
        colaNC.meter("A");
        colaNC.meter("F");
        colaNC.meter("S");
        Salida.terminal("\nCola No Circular--------------------------------\n");

        colaNC.mostrar();
        Salida.terminal("\n\n");
        Salida.terminal("Sacando: " + colaNC.sacar() + "\n\n");

        colaNC.mostrar();
        Salida.terminal("\n\n");

        //Cola Circular
        Salida.terminal("\nCola Circular--------------------------------\n");
        colaC.meter("G");
        colaC.meter("N");
        colaC.meter("A");
        colaC.meter("Z");
        colaC.meter("M");
        colaC.meter("T");
    
        colaC.mostrar();
        Salida.terminal("\n\n");

        Salida.terminal("Sacando: " + colaC.sacar() + "\n\n");
        Salida.terminal("Sacando: " + colaC.sacar() + "\n\n");

        colaC.mostrar();
        Salida.terminal("\n\n");

        colaC.meter("R");
        Salida.terminal("Metiendo: " + colaC.verUltimo() + "\n\n");

        colaC.mostrar();
        Salida.terminal("\n\n");
    }
}
