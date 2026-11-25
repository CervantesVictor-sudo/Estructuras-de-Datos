package edlineal;

//Si quieres heradar, piensa dos cosas:
//1. Lo que quieres heredar "Es un"
//2. Lo que quieres heredar "Se comporta como un"

public class PilaEstatica implements Lote{
    protected ArregloEstatico pila;

    public PilaEstatica(int tamanio) {
        pila = new ArregloEstatico(tamanio);
    }

    public boolean vacia() {
        return pila.vacia();
    }

    public boolean llena() {
        return pila.lleno();
    }

    public boolean meter(Object valor) {
        int retorno = pila.insertar(valor);
        if (retorno >= 0) { //Hubo ÉXITO
            return true;
        } else { //Hubo ERROR
            return false;
        }
    }

    public Object sacar() {
        return pila.eliminar();
    }
    
    //Éste método solo es simbolico.
    public void mostrar() {
        pila.imprimir();
    }

    public Object verUltimo() {
        return pila.verUltimo();
    }
}
