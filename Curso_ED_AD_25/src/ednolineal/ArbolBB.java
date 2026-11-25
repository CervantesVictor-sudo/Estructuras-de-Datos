package ednolineal;

import edlineal.NodoDoble;
import herramientas.genericas.UtileriasObjetos;

//ArbolBB = Arbol Binario de Busqueda
public class ArbolBB extends ArbolBinario{

    public boolean insertar(Object dato){
        if (raiz==null) {
            NodoDoble nodoNuevo = new NodoDoble(dato);
            raiz = nodoNuevo;
            return true;
        } else{
            return insertar(dato, raiz);
        }
    }

    private boolean insertar(Object dato, NodoDoble subRaiz){
        int resComp = UtileriasObjetos.compararO(dato, subRaiz.getDato());
        if (resComp < 0) { // es mas chico el dato que la subraiz
            if (subRaiz.getLigaIzq() == null) { //no tiene hijo izquierdo, lo insertamos ahi
                NodoDoble nodoNuevo = new NodoDoble(dato);
                subRaiz.setLigaIzq(nodoNuevo);
                return true;
            } else{// si tiene hijo izquierdo
                return insertar(dato, subRaiz.getLigaIzq());
            }
        } else if (resComp > 0){ //es mas grande el dato que la subraiz
            if (subRaiz.getLigaDer() == null) { //no tiene hijo derecho, lo insertamos ahi
                NodoDoble nodoNuevo = new NodoDoble(dato);
                subRaiz.setLigaDer(nodoNuevo);
                return true;
            }else{
                 return insertar(dato, subRaiz.getLigaDer());//si tiene hijo derecho
            }
        } else{
            return false; //es igual y no se puede insertar, caso base
        }
    }

    public Object buscar(Object dato){
        return buscar(dato, raiz);
    }

    private Object buscar(Object dato, NodoDoble subRaiz){
        if (subRaiz != null) {// no es nula la subraiz
            int resComp = UtileriasObjetos.compararO(dato, subRaiz.getDato());
            if (resComp < 0) { // es menor
                return buscar(dato,subRaiz.getLigaIzq());
            } else if(resComp > 0){ //es mayor
                return buscar(dato, subRaiz.getLigaDer());
            } else{//es igual
                return subRaiz.getDato();
            }
        } else{// no existe
            return false;
        }
    }

    public boolean eliminar(Object dato){
        //return eliminar(dato, raiz);
        return true;
    }

    

}
