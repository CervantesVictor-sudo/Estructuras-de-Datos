package MOM;

import EntradaSalida.Entrada;
import EntradaSalida.Salida;

public class PrincipalMOMJugador {

    public static void main(String[] args) {
        ModeloMOMJugador modelo = new ModeloMOMJugador();
        boolean seguirEjecutando = true;

        while (seguirEjecutando) {
            mostrarMenu();
            Salida.terminal("Elige una opcion: ");
            int opcionElegida = leerEntero();

            if (opcionElegida == 1) {
                modelo.imprimirModelo();

            } else if (opcionElegida == 2) {
                PreguntasMOMJugador.preguntaTipoA(modelo);

            } else if (opcionElegida == 3) {
                PreguntasMOMJugador.preguntaTipoB(modelo);

            } else if (opcionElegida == 4) {
                PreguntasMOMJugador.preguntaTipoC(modelo);

            } else if (opcionElegida == 5) {
                PreguntasMOMJugador.preguntaTipoD(modelo);

            } else if (opcionElegida == 6) {
                seguirEjecutando = false;
                Salida.terminal("Saliendo del programa...\n");

            } else {
                Salida.terminal("Opcion no valida.\n");
            }

            Salida.terminal("\n");
        }
    }

    private static void mostrarMenu() {
        Salida.terminal("----------MENU MOM JUGADOR----------\n");
        Salida.terminal("1) Mostrar informacion completa del modelo\n");
        Salida.terminal("2) Pregunta (a): inicio en estado fisico especifico\n");
        Salida.terminal("3) Pregunta (b): actividad en ese estado\n");
        Salida.terminal("4) Pregunta (c): estar en cierto estado fisico\n");
        Salida.terminal("5) Pregunta (d): secuencia de estados fisicos\n");
        Salida.terminal("6) Salir\n");
    }

    private static int leerEntero() {
        String textoLeido = Entrada.terminalCadenas();
        int valorEntero = 0;

        try {
            valorEntero = Integer.parseInt(textoLeido);
        } catch (NumberFormatException excepcion) {
            valorEntero = 0;
        }

        return valorEntero;
    }
}
