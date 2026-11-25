package MOM;

import EntradaSalida.Salida;
import edlineal.ArregloEstatico;
import ednolineal.Tabla2D;

public class ModeloMOMJugador {

    protected ArregloEstatico listaEstados;
    protected ArregloEstatico listaObservaciones;

    // Vector inicial
    protected ArregloEstatico vectorInicial;

    // Matriz de transicion A
    protected Tabla2D matrizTransicion;
    // Matriz de emision B
    protected Tabla2D matrizEmision;

    protected int cantidadEstados;
    protected int cantidadObservaciones;

    public ModeloMOMJugador() {
        cantidadEstados = 4;
        cantidadObservaciones = 5;

        listaEstados = new ArregloEstatico(cantidadEstados);
        listaObservaciones = new ArregloEstatico(cantidadObservaciones);

        vectorInicial = new ArregloEstatico(cantidadEstados);
        matrizTransicion = new Tabla2D(cantidadEstados, cantidadEstados);
        matrizEmision = new Tabla2D(cantidadEstados, cantidadObservaciones);

        inicializarEstadosYObservaciones();
        inicializarVectorInicial();
        inicializarMatrizTransicion();
        inicializarMatrizEmision();
    }

    private void inicializarEstadosYObservaciones() {
        // Estados ocultos (condicion fisica del jugador)
        listaEstados.insertar("Descansado");
        listaEstados.insertar("Fatigado");
        listaEstados.insertar("Lesion leve");
        listaEstados.insertar("Lesion grave");

        // Observaciones (actividad visible del jugador)
        listaObservaciones.insertar("Partido completo");
        listaObservaciones.insertar("Pocos minutos");
        listaObservaciones.insertar("Entrena suave");
        listaObservaciones.insertar("Fisioterapia");
        listaObservaciones.insertar("No entrena");
    }

    private void inicializarVectorInicial() {
        // vector = [0.50, 0.30, 0.15, 0.05]
        vectorInicial.insertar((double) 0.50);
        vectorInicial.insertar((double) 0.30);
        vectorInicial.insertar((double) 0.15);
        vectorInicial.insertar((double) 0.05);
    }

    private void inicializarMatrizTransicion() {

        // Estado oculto 0: Descansado
        matrizTransicion.modifica(0, 0, (double) 0.50);
        matrizTransicion.modifica(0, 1, (double) 0.30);
        matrizTransicion.modifica(0, 2, (double) 0.15);
        matrizTransicion.modifica(0, 3, (double) 0.05);

        // Estado oculto 1: Fatigado
        matrizTransicion.modifica(1, 0, (double) 0.30);
        matrizTransicion.modifica(1, 1, (double) 0.30);
        matrizTransicion.modifica(1, 2, (double) 0.25);
        matrizTransicion.modifica(1, 3, (double) 0.15);

        // Estado oculto 2: Lesion leve
        matrizTransicion.modifica(2, 0, (double) 0.10);
        matrizTransicion.modifica(2, 1, (double) 0.30);
        matrizTransicion.modifica(2, 2, (double) 0.40);
        matrizTransicion.modifica(2, 3, (double) 0.20);

        // Estado oculto 3: Lesion grave
        matrizTransicion.modifica(3, 0, (double) 0.05);
        matrizTransicion.modifica(3, 1, (double) 0.15);
        matrizTransicion.modifica(3, 2, (double) 0.30);
        matrizTransicion.modifica(3, 3, (double) 0.50);
    }

    private void inicializarMatrizEmision() {

        // Estado 0: Descansado
        matrizEmision.modifica(0, 0, (double) 0.60);
        matrizEmision.modifica(0, 1, (double) 0.20);
        matrizEmision.modifica(0, 2, (double) 0.10);
        matrizEmision.modifica(0, 3, (double) 0.05);
        matrizEmision.modifica(0, 4, (double) 0.05);

        // Estado 1: Fatigado
        matrizEmision.modifica(1, 0, (double) 0.30);
        matrizEmision.modifica(1, 1, (double) 0.30);
        matrizEmision.modifica(1, 2, (double) 0.20);
        matrizEmision.modifica(1, 3, (double) 0.10);
        matrizEmision.modifica(1, 4, (double) 0.10);

        // Estado 2: Lesion leve
        matrizEmision.modifica(2, 0, (double) 0.10);
        matrizEmision.modifica(2, 1, (double) 0.20);
        matrizEmision.modifica(2, 2, (double) 0.30);
        matrizEmision.modifica(2, 3, (double) 0.25);
        matrizEmision.modifica(2, 4, (double) 0.15);

        // Estado 3: Lesion grave
        matrizEmision.modifica(3, 0, (double) 0.00);
        matrizEmision.modifica(3, 1, (double) 0.05);
        matrizEmision.modifica(3, 2, (double) 0.15);
        matrizEmision.modifica(3, 3, (double) 0.50);
        matrizEmision.modifica(3, 4, (double) 0.30);
    }

    public void imprimirModelo() {
        Salida.terminal("-------Modelo MOM del jugador de futbol-------\n");

        Salida.terminal("\nEstados ocultos (condicion fisica):\n");
        for (int indiceEstado = 0; indiceEstado < cantidadEstados; indiceEstado++) {
            String nombreEstado = (String) listaEstados.valor(indiceEstado);
            Salida.terminal((indiceEstado +1) + " -> " + nombreEstado + "\n");
        }

        Salida.terminal("\nObservaciones (actividad visible):\n");
        for (int indiceObservacion = 0; indiceObservacion < cantidadObservaciones; indiceObservacion++) {
            String nombreObservacion = (String) listaObservaciones.valor(indiceObservacion);
            Salida.terminal((indiceObservacion +1) + " -> " + nombreObservacion + "\n");
        }

        Salida.terminal("\nVector inicial π:\n");
        for (int indiceEstado = 0; indiceEstado < cantidadEstados; indiceEstado++) {
            Double objetoProbabilidad = (Double) vectorInicial.valor(indiceEstado);
            double probEstado = objetoProbabilidad;
            String nombreEstado = (String) listaEstados.valor(indiceEstado);
            Salida.terminal("P(estado inicial = " + nombreEstado + ") = " + probEstado + "\n");
        }

        Salida.terminal("\nMatriz de transicion A (filas = estado actual, columnas = estado siguiente):\n");
        matrizTransicion.imprimirMatriz();

        Salida.terminal("\nMatriz de emision B (filas = estado, columnas = observacion):\n");
        matrizEmision.imprimirMatriz();
    }

    // a) Probabilidad de que el escenario inicie en un estado especifico
    public double obtenerProbabilidadInicioEstado(int indiceEstado) {
        Double objetoProbabilidad = (Double) vectorInicial.valor(indiceEstado);
        double probabilidad = objetoProbabilidad;
        return probabilidad;
    }

    // b) Probabilidad de hacer una actividad especifica dado un estado fisico
    public double obtenerProbabilidadActividadDadoEstado(int indiceEstado, int indiceObservacion) {
        Double objetoProbabilidadEmision = (Double) matrizEmision.valor(indiceEstado, indiceObservacion);
        double probabilidad = objetoProbabilidadEmision;
        return probabilidad;
    }

    // c) Probabilidad de que el jugador este en cierto estado
    public double obtenerProbabilidadEstadoEnDia(int numeroDia, int indiceEstadoObjetivo) {
        ArregloEstatico distribucionActual = new ArregloEstatico(cantidadEstados);

        for (int indiceEstado = 0; indiceEstado < cantidadEstados; indiceEstado++) {
            Double objetoProbEstado = (Double) vectorInicial.valor(indiceEstado);
            distribucionActual.insertar(objetoProbEstado);
        }

        if (numeroDia <= 1) {
            Double objetoProbFinal = (Double) distribucionActual.valor(indiceEstadoObjetivo);
            double probabilidadDia1 = objetoProbFinal;
            return probabilidadDia1;
        }

        for (int numeroPaso = 2; numeroPaso <= numeroDia; numeroPaso++) {
            ArregloEstatico nuevaDistribucion = new ArregloEstatico(cantidadEstados);

            for (int indiceEstadoDestino = 0; indiceEstadoDestino < cantidadEstados; indiceEstadoDestino++) {
                double sumaProbabilidades = 0.0;

                for (int indiceEstadoOrigen = 0; indiceEstadoOrigen < cantidadEstados; indiceEstadoOrigen++) {
                    Double objetoProbEstadoOrigen = (Double) distribucionActual.valor(indiceEstadoOrigen);
                    double probEstadoOrigen = objetoProbEstadoOrigen;

                    Double objetoTransicion = (Double) matrizTransicion.valor(indiceEstadoOrigen, indiceEstadoDestino);
                    double probTransicion = objetoTransicion;

                    sumaProbabilidades = sumaProbabilidades + (probEstadoOrigen * probTransicion);
                }

                nuevaDistribucion.insertar((double)sumaProbabilidades);
            }

            distribucionActual = nuevaDistribucion;
        }

        Double objetoProbabilidadFinal = (Double) distribucionActual.valor(indiceEstadoObjetivo);
        double probabilidadFinal = objetoProbabilidadFinal;
        return probabilidadFinal;
    }

    // d) Probabilidad de una secuencia de estados
    public double obtenerProbabilidadSecuenciaEstados(ArregloEstatico arregloIndicesEstados) {
        int cantidadElementos = arregloIndicesEstados.cantidad();

        // Estado inicial
        Integer objetoEstadoInicial = (Integer) arregloIndicesEstados.valor(0);
        int indiceEstadoInicial = objetoEstadoInicial;

        Double objetoProbInicial = (Double) vectorInicial.valor(indiceEstadoInicial);
        double probabilidad = objetoProbInicial;

        // Multiplicar por las probabilidades de transicion
        for (int indicePosicion = 0; indicePosicion < (cantidadElementos - 1); indicePosicion++) {
            Integer objetoEstadoActual = (Integer) arregloIndicesEstados.valor(indicePosicion);
            Integer objetoEstadoSiguiente = (Integer) arregloIndicesEstados.valor(indicePosicion + 1);

            int indiceEstadoActual = objetoEstadoActual;
            int indiceEstadoSiguiente = objetoEstadoSiguiente;

            Double objetoTransicion = (Double) matrizTransicion.valor(indiceEstadoActual, indiceEstadoSiguiente);
            double probTransicion = objetoTransicion;

            probabilidad = probabilidad * probTransicion;
        }

        return probabilidad;
    }

    public String obtenerNombreEstado(int indiceEstado) {
        String nombreEstado = (String) listaEstados.valor(indiceEstado);
        return nombreEstado;
    }

    public String obtenerNombreObservacion(int indiceObservacion) {
        String nombreObservacion = (String) listaObservaciones.valor(indiceObservacion);
        return nombreObservacion;
    }

    public int getCantidadEstados() {
        return cantidadEstados;
    }

    public int getCantidadObservaciones() {
        return cantidadObservaciones;
    }

}