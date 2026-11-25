package edlineal;

import herramientas.enumerados.TipoOrden;
import herramientas.genericas.UtileriasObjetos;;

public class ArregloEstaticoOrd extends ArregloEstatico {

    protected TipoOrden orden; // ASC o DES

    public ArregloEstaticoOrd(int tamanio){   //manda a llamar al constructor maestro encontraddo en la clase "ArregloEstatico"
        super(tamanio);
        this.orden = TipoOrden.ASC;
    }

    public ArregloEstaticoOrd(int maximo, TipoOrden orden) {    // Constructor con tamaño y orden
        super(maximo);
        this.orden = orden;
    }

    @Override
    public Object buscar (Object valor) {
        int posicionBusqueda=0;
        while (posicionBusqueda <= ultimo && UtileriasObjetos.compararO(valor, datos[posicionBusqueda])>0) {
            posicionBusqueda ++;
        }
        if (posicionBusqueda > ultimo || UtileriasObjetos.compararO(valor, datos[posicionBusqueda])<0 ) {
            return (posicionBusqueda + 1) * (-1);
        } else {
            return posicionBusqueda + 1;
        }
    }

    @Override
    public Integer insertar(Object valor) {
        if (lleno() == false) { //Si hay espacio en el arreglo
            int posicion = (int)buscar(valor);
            if (posicion > 0 ) {    // existe, no podemos insertar
                return -1; //ERROR
            } else { // NO existe, se puede insertar
                posicion = posicion * (-1); //Convertirla a positiva
                for (int cadaCambio = (ultimo + 1); cadaCambio >= posicion; cadaCambio --) { //Este for es DESCENDENTE
                    datos[cadaCambio] = datos[cadaCambio - 1];
                }
                posicion = posicion - 1; //Se ajusta el indice
                datos[posicion] = valor;
                ultimo = ultimo + 1;
                return posicion;
            }
        } else { //no hay espacio en el arreglo
            return -1;
        }
    }
}
