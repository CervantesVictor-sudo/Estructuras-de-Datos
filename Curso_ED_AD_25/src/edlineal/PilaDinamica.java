package edlineal;

public class PilaDinamica implements Lote{
    protected ArregloDinamico pila;

    public PilaDinamica(){
        pila = new ArregloDinamico();
    }

    @Override
    public boolean vacia(){
        return pila.vacia();
    }

    public boolean llena(){ //No nos interesa saber si esta llena por ser lista ligada
        return true;        //pero lo dejamos aqui ya que implementamos la interfaz "lote"
    }

    @Override
    public boolean meter(Object valor){
        int retorno = pila.insertar(valor);
        if (retorno >= 0) { //Hubo ÉXITO
            return true;
        } else { //Hubo ERROR
            return false;
        }
    }

    @Override
    public Object sacar(){
        return pila.eliminar(pila);
    }

    @Override
    public void mostrar(){
        pila.imprimir();
    }
    
    @Override
    public Object verUltimo(){
        return pila.verUltimo();
    }

    //aqui empiezan los metodos nuevos, ningun metodo de aqui es existente de pilaEstatica
    public Object verPrimero(){
        return pila.verPrimero();
    }

    public void imprimirIO(){
        
    }
}
