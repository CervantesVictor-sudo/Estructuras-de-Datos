package Pruebas;

import EntradaSalida.Salida;
import herramientas.matematicas.ManipulacionExpresiones;

public class PruebaPilaEA {
    public static void main(String[] args) {
        Salida.terminal("\nEvaluando...\n");
        Salida.terminal("9395-/42^*+: " + ManipulacionExpresiones.evaluarPostfija("9395-/42^*+") + "\n");
    }
}
