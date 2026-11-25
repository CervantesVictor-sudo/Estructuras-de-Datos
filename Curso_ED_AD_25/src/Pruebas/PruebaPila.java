package Pruebas;

import EntradaSalida.Salida;
import edlineal.PilaEstatica;

public class PruebaPila {
    public static void main(String[] args) {
        PilaEstatica pila = new PilaEstatica(5);

        pila.meter("A");
        pila.meter("Z");
        pila.meter("T");

        Salida.terminal("\n");
        
        pila.mostrar();
        
        Salida.terminal("\n");
        
        Salida.terminal("\n");
        Salida.terminal("Sacando: " + pila.sacar() + "\n");

        Salida.terminal("\n");

        pila.mostrar();
        Salida.terminal("\n");
        Salida.terminal("\n");
    }
}
