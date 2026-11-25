package edlineal;

import EntradaSalida.Salida;

public class ArregloEstatico implements VectorLista {
    protected int tamanio;
    protected int ultimo;
    protected Object datos[];

    public ArregloEstatico(int tam){
        tamanio = tam;
        ultimo = -1;
        datos = new Object[tam];
    }

    public boolean vacia() {
        if (ultimo == -1){
            return true;
        } else {
            return false;
        }
    }

    public boolean lleno(){
        if (ultimo == (tamanio - 1)){
            return true;
        } else {
            return false;
        }
    }

    public Integer insertar(Object objeto){
        if (lleno( ) == false){
            ultimo = ultimo+1;
            datos[ultimo] = objeto;
            return ultimo;
        }else{
            return -1;
        }
    }

    public Object buscar(Object valor){
        int posicionBusqueda = 0;
        while(posicionBusqueda <= ultimo && !valor.toString().equalsIgnoreCase(datos[posicionBusqueda].toString())){
            posicionBusqueda ++;
        }
        if (posicionBusqueda > ultimo){
            return -1;
        }else {
            return posicionBusqueda;
        }
    }

    public Object eliminar(){
        if (vacia() == false){
            Object valor = datos[ultimo];
            ultimo = ultimo - 1;
            return valor;
        } else {
            return null;
        }
    }

    public Object verUltimo(){
        if (vacia() == false) {
            return datos[ultimo];
        } else {
            return null;
        }
    }

    public Object eliminar(Object valor){
        int posicionEncontrado = (int)buscar(valor);
        if (posicionEncontrado >= 0) {
            Object eliminado = datos[posicionEncontrado];
            for (int cambio = posicionEncontrado; cambio <= (ultimo-1); cambio++) {
                datos [cambio]=datos[cambio+1];
            }
            ultimo--;
            return eliminado;
        } else {
            return null;
        }
    }

    public void imprimir() {
        Salida.terminal("[ ");
        for (int pocisionDato = 0; pocisionDato <= (ultimo - 1); pocisionDato++){
            Salida.terminal(datos[pocisionDato] + ", ");
        }
        if (vacia()==false) {
            Salida.terminal(datos[ultimo] + "");
        }
        Salida.terminal(" ]");
    }



    public Object valor(int indice){
        if (validarIndice(indice)==true){ // Es un indice valido
            return datos[indice];
        } else {    // No existe ese indice.
            return null;
        }
    }

    private boolean validarIndice(int indice){
        if(indice>=0 && indice<=ultimo){
            return true;
        } else {
            return false;
        }
    }

    public boolean modifica(int indice, Object valor){
        if(indice < 0 || indice > ultimo){
            return false;
        } 
        datos[indice] = valor;
        return true;
    }

    //Metodo que me regresa cuantos hay en un arreglo
    public int cantidad(){
        return ultimo + 1;
    }

    //Tamanio del arreglo
    public int tamanio(){
        return tamanio;
    }

    public Integer insertarInicio(Object valor){
        return 0;
    }

    public Object eliminarInicio(){
        return 0;
    }

    public Object verPrimero(){
        return null;
    }

    public void llenar(Object valor, int cantidad){
        int total = 0;
        if (cantidad > tamanio) {
            total = tamanio;
        }else{
            total = cantidad;
        }
        for (int pos=0; pos < total; pos++) {
            insertar(valor);
        }
    }

}