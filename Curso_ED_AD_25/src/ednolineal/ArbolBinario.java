package ednolineal;

import edlineal.NodoDoble;
import EntradaSalida.Entrada;
import EntradaSalida.Salida;

public class ArbolBinario {
    protected NodoDoble raiz;

    public ArbolBinario(){
        raiz = null;
    }

    public void crearArbol(){
        Salida.terminal("Dame la raiz: ");
        String datoRaiz = Entrada.terminalCadenas();
        NodoDoble nuevoNodo = new NodoDoble(datoRaiz);
        raiz = nuevoNodo;   
        crearArbol(raiz);
    }

    public void crearArbol(NodoDoble subRaiz){
        //hijo izquierdo
        Salida.terminal("El nodo "+subRaiz.getDato() +" tiene hijo izquierdo? [S/N]");
        String respuesta = Entrada.terminalCadenas();
        if (respuesta.equalsIgnoreCase("s")) {
            //TIENE HIJO IZQUIERDO
            Salida.terminal("Dame el hijo izquierdo: ");
            String datoHI = Entrada.terminalCadenas();

            NodoDoble hijoNuevo = new NodoDoble(datoHI);
            subRaiz.setLigaIzq(hijoNuevo);
            crearArbol(hijoNuevo); //subRaiz.getLigaIzq()
        }
        //hijo derecho
        Salida.terminal("El nodo "+subRaiz.getDato() +" tiene hijo derecho? [S/N]");
        respuesta = Entrada.terminalCadenas();
        if (respuesta.equalsIgnoreCase("s")) {
            //TIENE HIJO DERECHO
            Salida.terminal("Dame el hijo derecho: ");
            String datoHD = Entrada.terminalCadenas();

            NodoDoble hijoNuevo = new NodoDoble(datoHD);
            subRaiz.setLigaDer(hijoNuevo);
            crearArbol(hijoNuevo); //subRaiz.getLigaDer()

        }

    }

    public void inorden(){
        inorden(raiz);
    }

    public void preorden(){
        preorden(raiz);
    }

    public void postorden(){
        postorden(raiz);
    }


        private void inorden(NodoDoble subRaiz){
            //IRD
            if (subRaiz!=null) {
                inorden(subRaiz.getLigaIzq());
                Salida.terminal(subRaiz.getDato()+ " ");
                inorden(subRaiz.getLigaDer());   
            }
        }

        private void preorden(NodoDoble subRaiz){
            if (subRaiz!=null) {
                Salida.terminal(subRaiz.getDato()+ " ");
                preorden(subRaiz.getLigaIzq());
                preorden(subRaiz.getLigaDer());   
            }
        }

        private void postorden(NodoDoble subRaiz){
            if (subRaiz!=null) {
                postorden(subRaiz.getLigaIzq());
                postorden(subRaiz.getLigaDer());   
                Salida.terminal(subRaiz.getDato()+ " ");
            }
        }
    

}
