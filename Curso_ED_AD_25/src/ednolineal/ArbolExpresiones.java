package ednolineal;

import edlineal.PilaEstatica;
import herramientas.matematicas.ManipulacionExpresiones;
import edlineal.NodoDoble;

public class ArbolExpresiones extends ArbolBinario{
    public boolean crearArbolnfija(String infija){
    //1. pasar a infija
    //1.1 invocar al metodo crear arbol postfija
        return true;
    }

    public boolean crearArbolPosfija(String posfija){
        PilaEstatica pila = new PilaEstatica(posfija.length());
        for(int posicionDato=0; posicionDato<posfija.length();posicionDato++){
            //2. Tokenizar de izq a der
            char token = posfija.charAt(posicionDato);
            //3. si es operando, crear un nodo con el token y ponerlo en la pila
            if (ManipulacionExpresiones.esOperando(token)==true) {
                NodoDoble nodo = new NodoDoble(token);
                pila.meter(nodo);
            } else{// es operador
                //4. si es operador, sacar dos operandos de la pila(el primero es op2)
                //crear un nodo con ese token y enlazarlo con los dos operandos
                //y meterlo a la pila
                //5. la raiz del arbol esta en la pila
                NodoDoble nodoOp2 = (NodoDoble)pila.sacar();        
                NodoDoble nodoOp1 = (NodoDoble)pila.sacar();

                NodoDoble nodo = new NodoDoble(token);

                nodo.setLigaIzq(nodoOp1);
                nodo.setLigaDer(nodoOp2);

                pila.meter(nodo);
            }
        }
        // 5. la raiz del arbol esta en la pila
        raiz = (NodoDoble)pila.sacar();
        if (raiz==null) {
            return false;
        } else {
            return true;

        }

    }

    public boolean crearArbolPrefija(String prefija){
        return true;
    }
}
