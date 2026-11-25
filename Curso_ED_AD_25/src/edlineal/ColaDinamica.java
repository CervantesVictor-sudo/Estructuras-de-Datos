package edlineal;

public class ColaDinamica implements Lote{
    protected ArregloDinamico cola;

    public ColaDinamica(){
        cola = new ArregloDinamico();
    }
    
    public boolean vacia(){
        return cola.vacia();
    }

    public boolean llena(){ //No nos interesa saber si esta llena por ser lista ligada
        return true;        //pero lo dejamos aqui ya que implementamos la interfaz "lote"
    }

    public boolean meter(Object valor){
        int retorno = cola.insertar(valor);
        if (retorno >= 0) { //Hubo ÉXITO
            return true;
        } else { //Hubo ERROR
            return false;
        }
    }

    public Object sacar(){
        return cola.eliminar(cola);
    }

    public void mostrar(){
        cola.imprimir();
    }
    
    public Object verUltimo(){
        return cola.verUltimo();
    }

    //aqui empiezan los metodos nuevos, ningun metodo de aqui es existente de pilaEstatica
    public Object verPrimero(){
        return cola.verPrimero();
    }
    
}
