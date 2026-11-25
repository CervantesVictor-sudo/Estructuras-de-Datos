
public class Ejercicio4 {
    
    //Ambos metodos van dentro de la clase de Grafo.  

    public ArregloEstatico ordenTopologico() {
        int cantidadVertices = vertices.cantidad();
        
        ArregloEstatico visitados = new ArregloEstatico(cantidadVertices);

        visitados.llenar(false, cantidadVertices);

        PilaEstatica pilaResultado = new PilaEstatica(cantidadVertices);

        int indiceVertice = 0;

        while (indiceVertice < cantidadVertices) {

            boolean verticeYaVisitado = (boolean) visitados.valor(indiceVertice);

            if (verticeYaVisitado == false) {
                dfsOrdenTopologico(indiceVertice, visitados, pilaResultado);
            }
            indiceVertice = indiceVertice + 1;
        }

        ArregloEstatico arregloOrdenTopologico = new ArregloEstatico(cantidadVertices);

        while (pilaResultado.vacia() == false) {
            Object verticeEnOrden = pilaResultado.sacar();
            arregloOrdenTopologico.insertar(verticeEnOrden);
        }

        return arregloOrdenTopologico;
    }

        
    private void dfsOrdenTopologico(int indiceVertice, ArregloEstatico visitados, PilaEstatica pilaResultado) {

        visitados.modifica(indiceVertice, true);

        int cantidadVertices = vertices.cantidad();

        int indiceDestino = 0;

        while (indiceDestino < cantidadVertices) {

            Object pesoArista = aristas.valor(indiceVertice, indiceDestino);

            if (pesoArista != null && pesoArista != (Object) 0) {
                boolean destinoVisitado = (boolean) visitados.valor(indiceDestino);

                if (destinoVisitado == false) {
                    dfsOrdenTopologico(indiceDestino, visitados, pilaResultado);
                }
            }

            indiceDestino = indiceDestino + 1;
        }

        Vertice verticeActual = (Vertice) vertices.valor(indiceVertice);

        pilaResultado.meter(verticeActual);
    }

}
