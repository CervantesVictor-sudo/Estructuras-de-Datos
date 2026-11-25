package ednolineal;

import EntradaSalida.Salida;
import edlineal.ArregloEstatico;
import edlineal.PilaEstatica;

public class Grafo {
    protected ArregloEstatico vertices;
    protected Tabla2D aristas;

    public Grafo(int numVertices){
        vertices = new ArregloEstatico(numVertices);
        aristas = new Tabla2D(numVertices, numVertices);
    }

    public Grafo(int numVertices, Object valorInicial){
        vertices = new ArregloEstatico(numVertices);
        aristas = new Tabla2D(numVertices, numVertices, valorInicial);
    }

    public boolean agregarVertice(Object valor){
        //validar que no exista un vertice al momento de crear uno nuevo
        int indiceBusqueda = (int)vertices.buscar(valor);
        if(indiceBusqueda == -1){
            //primero crear un vertice
            Vertice verticeNuevo = new Vertice();
            verticeNuevo.setDescripcion(valor);
            verticeNuevo.setNumVertice(vertices.cantidad());
            // despues meterlo en el arreglo
            int retorno = vertices.insertar(verticeNuevo);
            if(retorno < 0){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    
    public boolean agregarArista(Object origen, Object destino, Double peso){
        // checo que los 2 vertices existan
        int indiceOrigen = (int)vertices.buscar(origen);
        int indiceDestino = (int)vertices.buscar(destino);
        
        if ( indiceOrigen >= 0 && indiceDestino >= 0 ){
            // si existen, los uno en la matriz
            //asignamos el peso o valor de 1 en la fila y columna correspondiente
            int fila = ((Vertice)vertices.valor(indiceOrigen)).getNumVertice();
            int columna = ((Vertice)vertices.valor(indiceDestino)).getNumVertice();
            return aristas.modifica(fila, columna, peso);
    
        } else {
            return false;
        }
        // si existen, los uno en la matriz        
    }

    public boolean agregarArista(Object origen, Object destino){    
        return agregarArista(origen, destino, 1.0);   // valor por defecto del peso
    }

    public void imprimirGrafo(){

        for (int cadaVertice = 0; cadaVertice < vertices.cantidad(); cadaVertice++) {
            Vertice verticeActual = (Vertice)vertices.valor(cadaVertice);

            Salida.terminal(verticeActual.getDescripcion() + " (" + cadaVertice + ") \n");   
        }
        Salida.terminal("\n");
        aristas.imprimirMatriz();
    }



    public ArregloEstatico recorridoEnProfundidad(Object origen){
        //1. Partir de un nodo origen, marcarlo y enpilarlo
        ArregloEstatico marcados = new ArregloEstatico(vertices.tamanio());
        PilaEstatica pila = new PilaEstatica(vertices.tamanio());
        ArregloEstatico recorrido = new ArregloEstatico(vertices.tamanio());

        int indiceOrigen = (int) vertices.buscar(origen);
        if (indiceOrigen >= 0) {
            marcados.llenar(false, marcados.tamanio());
            Vertice verticeOrigen = (Vertice) vertices.valor(indiceOrigen);
            
            // Marcar el vértice origen y empilarlo
            marcados.modifica(verticeOrigen.getNumVertice(), true);
            pila.meter(verticeOrigen);
            
            while(pila.vacia() == false){
                Vertice actual = (Vertice) pila.sacar();
                recorrido.insertar(actual.getDescripcion());
                // 3 Los elementos adyacentes el nodo acabado de procesar y que no están marcados, enpilarlos y marcarlos 
                marcarYEnpilarAdyacentes(actual, marcados, pila);
            }
        } else {
            // Retornar arreglo vacío en lugar de null
            Salida.terminal("Vértice '" + origen + "' no encontrado en el grafo.\n");
        }
        return recorrido;
    }

    private void marcarYEnpilarAdyacentes(Vertice actual, ArregloEstatico marcados, PilaEstatica pila){
        for(int cadaDestino = 0; cadaDestino < aristas.obtenerColumnas(); cadaDestino++){
            Double peso = (Double) aristas.valor(actual.getNumVertice(), cadaDestino);

            if(peso != 0 && peso != null && (boolean) marcados.valor(cadaDestino) == false){
                marcados.modifica(cadaDestino, true);
                Vertice destino = (Vertice) vertices.valor(cadaDestino);
                pila.meter(destino);
            }
            
        }
    }

    //public Object eliminarVetice(Object valor){
        
    //}

}