package MOM;

import EntradaSalida.Entrada;
import EntradaSalida.Salida;
import edlineal.ArregloEstatico;

public class PreguntasMOMJugador {

    // (a) ¿Cuál es la probabilidad de que el jugador inicie Descansado?
    public static void preguntaTipoA(ModeloMOMJugador modelo) {
        Salida.terminal("\nPregunta de tipo (a): Probabilidad de que el escenario inicie en un estado fisico especifico.\n");
        Salida.terminal("¿Cual es la probabilidad de que el jugador inicie Descansado?\n\n");

        int indiceDescansado = 0; // q0 = Descansado
        double probabilidad = modelo.obtenerProbabilidadInicioEstado(indiceDescansado);

        Salida.terminal("Respuesta: P(inicia Descansado) = " + probabilidad + "\n");
    }

    // (b) ¿Cuál es la probabilidad de que el jugador juegue partido completo si esta Descansado?
    public static void preguntaTipoB(ModeloMOMJugador modelo) {
        Salida.terminal("\nPregunta de tipo (b): Probabilidad de que el jugador haga cierta actividad en ese estado.\n");
        Salida.terminal("¿Cual es la probabilidad de que el jugador juegue partido completo si esta Descansado?\n\n");

        int indiceDescansado = 0;       // estado: Descansado
        int indicePartidoCompleto = 0;  // observacion: Partido completo

        double probabilidad = modelo.obtenerProbabilidadActividadDadoEstado(indiceDescansado, indicePartidoCompleto);

        Salida.terminal("Respuesta: P(Partido completo | Descansado) = " + probabilidad + "\n");
    }

    // (c) ¿Cuál es la probabilidad de que el jugador esté Fatigado?
    public static void preguntaTipoC(ModeloMOMJugador modelo) {
        Salida.terminal("\nPregunta de tipo (c): Probabilidad de que el jugador este en cierto estado fisico despues de la actividad.\n");
        Salida.terminal("¿Cual es la probabilidad de que el jugador este Fatigado?\n");

        Salida.terminal("Indica despues de cuantos dias quieres calcular la probabilidad (>=1): ");
        int numeroDia = leerEntero();

        int indiceFatigado = 1; // q1 = Fatigado

        double probabilidad = modelo.obtenerProbabilidadEstadoEnDia(numeroDia, indiceFatigado);

        Salida.terminal("Respuesta: P(estado = Fatigado en el dia " + numeroDia + ") = " + probabilidad + "\n");
    }

    // (d) ¿Cuál es la probabilidad de que la condicion del jugador sea
    public static void preguntaTipoD(ModeloMOMJugador modelo) {
        Salida.terminal("\nPregunta de tipo (d): Probabilidad de que se de una secuencia especifica de estados fisicos.\n");
        Salida.terminal("¿Cual es la probabilidad de que la condicion del jugador sea:\n");
        Salida.terminal("Descansado -> Fatigado -> Lesion leve?\n\n");

        ArregloEstatico arregloSecuenciaEstados = new ArregloEstatico(3);
        arregloSecuenciaEstados.insertar((int)0); // Descansado
        arregloSecuenciaEstados.insertar((int)1); // Fatigado
        arregloSecuenciaEstados.insertar((int)2); // Lesion leve

        double probabilidad = modelo.obtenerProbabilidadSecuenciaEstados(arregloSecuenciaEstados);

        Salida.terminal("Respuesta: P(Descansado -> Fatigado -> Lesion leve) = " + probabilidad + "\n");
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