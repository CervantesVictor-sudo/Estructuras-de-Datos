package edlineal;

import EntradaSalida.Salida;

public class ColaEstatica implements Lote{
    protected Object datos[];
    protected int tamanio;
    protected int primero;
    protected int ultimo;


    public ColaEstatica(int tamanio) {
        this.tamanio = tamanio;
        primero = -1;
        ultimo = -1;
        datos = new Object[tamanio];
    }

    public boolean vacia(){
        if (primero == -1){
            return true;
        } else {
            return false;
        }
    }

    public boolean llena(){
        if ((primero == 0 && ultimo == (tamanio-1)) || (primero == ultimo + 1)){
            return true;
        } else {
            return false;
        }
    }

    public boolean meter(Object valor){
        if (llena()==false){
            if (vacia() == true) { //a
                primero = 0;
                ultimo = 0;
                datos[ultimo] = valor;
            }else if (ultimo == (tamanio-1)){ //d
                ultimo = 0;
                datos[ultimo] = valor; 
            }else { //b
                ultimo = ultimo + 1;
                datos[ultimo] = valor;
            }
            return true;
        } else {
            return false; //c
        }
    }

    public Object sacar(){
        Object respaldo = null;
        if (vacia()==false){
            if (primero == ultimo) { // d)
                respaldo = datos[primero];
                primero = -1;
                ultimo = -1;
            } else if (primero == (tamanio -1)) { // c)
                respaldo = datos[primero];
                primero = 0;
            } else { // b)
                respaldo = datos[primero];
                primero ++;
            }
            return respaldo;
        } else { // a)
            return null;
        }
    }

    public void mostrar(){
        if (primero <= ultimo) { //Impresion NO circular
            Salida.terminal("[");
            for (int pos = primero; pos < ultimo; pos++) {
                Salida.terminal(datos[pos] + ",");
            }
            Salida.terminal(datos[ultimo]+"");
            Salida.terminal("]");
        } else { //Impresion Circular
            Salida.terminal("[");
            int pos = primero;
            while (pos!=ultimo) {
                Salida.terminal(datos[pos] + ",");
                if (pos < (tamanio-1)){
                    pos++; //Avanza, mientras no llegue al ultimo
                } else {
                    pos = 0; //Vuelve al inicio
                }
            }
            Salida.terminal(datos[ultimo]+"");
            Salida.terminal("]");
        }
    }

    @Override //Poruqe todos los lotes lo tienen
    public Object verUltimo(){
        //SIEMPRE validar
        if (vacia() == false){
            return datos[ultimo];
        } else {
            return false;
        }
    }

    public Object verPrimero(){
        if (vacia() == false){
            return datos[primero];
        } else {
            return false;
        }
    }
    
}
