package edlineal;

import EntradaSalida.Salida;

public class ArregloDinamico implements Lista{
    protected Nodo primero;
    protected Nodo ultimo;
    protected Nodo posicion;

    public ArregloDinamico(){
        primero = null;
        ultimo = null;
        posicion = null;
    }

    @Override
    public boolean vacia(){
        if (primero == null){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public Integer insertar(Object valor){ //a)
        if (vacia()==true){
            Nodo nuevoNodo = new Nodo(valor); //paso1
            primero = nuevoNodo; //paso2
            ultimo = nuevoNodo;
        }else { //b) y c)
            Nodo nuevoNodo = new Nodo(valor); //paso1
            ultimo.setLigaDer(nuevoNodo); //paso2
            ultimo = nuevoNodo; //paso3
        }
        return 1;
    }

    @Override
    public Integer insertarInicio(Object valor){
        if (vacia() == true){ //a)
            Nodo nuevoNodo = new Nodo(valor);
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        }else { //b) y c)
            Nodo nuevoNodo = new Nodo(valor);
            nuevoNodo.setLigaDer(primero);
            primero = nuevoNodo;
        }
        return 1;
    }

    @Override
    public void imprimir(){
        Salida.terminal("[");
        Nodo posicion = primero;
        while (posicion != ultimo) {
            Salida.terminal(posicion.getDato() + ", ");
            posicion = posicion.getLigaDer();
        }
        if (ultimo!=null){
            Salida.terminal(ultimo.getDato()+"");
        }
        Salida.terminal("]");
    }

    @Override
    public Object eliminarInicio(){
        if (vacia() == true){
            return null;
        }else if (primero == ultimo){
            Object respaldo = primero.getDato();
            primero = null;
            ultimo = null;
            return respaldo;
        }else {
            Object respaldo = primero.getDato();
            primero = primero.getLigaDer();
            return respaldo;
        }
    }

    @Override
    public Object verUltimo(){
        if (ultimo == null){
            return null;
        }else{
            return ultimo.getDato();
        }
    }

    @Override
    public Object verPrimero(){
        if(vacia()==true){
            return null;
        }else{
            return primero.getDato();
        }
    }

    @Override
    public Object buscar(Object valor){
        DatoBusqueda resultadoBusqueda = buscarNodo(valor);

        if (resultadoBusqueda.getPosActual() != null){//SI está
            return resultadoBusqueda.getPosActual().getDato();
        }else{ //NO está
            return null;
        }
    }

    private DatoBusqueda buscarNodo(Object valor){
        Nodo posActual = primero;
        Nodo anterior = primero;

        while (posActual != null && valor.toString().equalsIgnoreCase(posActual.getDato().toString())==false){
            anterior = posActual;
            posActual = posActual.getLigaDer(); //i=i+1
        }
        DatoBusqueda respuesta = new DatoBusqueda();
        respuesta.setAnterior(anterior);
        respuesta.setPosActual(posActual);
        return respuesta;
        /*if (posActual != null){ //Si está
            respuesta.setAnterior(anterior);
            respuesta.setPosActual(posActual);
            return respuesta;
        }else{ //NO está
            respuesta.setAnterior(anterior);
            respuesta.setPosActual(posActual);
            return respuesta;
        }*/
    }

    @Override
    public Object eliminar(Object valor){
        if (vacia()==true) { //b)
            return null;
        }else{ //Hay algo
            DatoBusqueda busqueda = buscarNodo(verUltimo());
            if (primero == ultimo) {
                Object respaldo = busqueda.getPosActual().getDato();
                //Object respaldo = ultimo.getDato();
                primero = null;
                ultimo = null;
                return respaldo;
            }else{ //a) y d)
                Object respaldo = busqueda.getPosActual().getDato();
                Nodo anterior = busqueda.getAnterior();
                anterior.setLigaDer(null);
                ultimo = anterior;
                return respaldo;
            }
        }
    }

    @Override
    public int cantidad(){
        this.iniciarIterador();
        int contador = 0;
        while(iteradorNulo() == false){
            contador = contador + 1;
            moverIterador();
        }
        return contador;
    }

    @Override
    public Object eliminar(){
        return null;
    }

    public void iniciarIterador(){
        posicion = primero;
    }

    public boolean iteradorNulo(){
        if (posicion == null) {
            return true;
        }else {
            return false;
        }
    }

    public Object obtenerDato(){
        if (iteradorNulo() == true){
            return null;
        }else{
            return posicion.getDato();
        }
    }

    public void moverIterador(){
        if(iteradorNulo() != true){
            posicion = posicion.getLigaDer();
        }
    }

    /*Practica11
    public void imprimirIo(){ //imprimir inverso
        Nodo posActual = ultimo;
        Nodo anterior = ultimo;
        
        Salida.terminal("[");
        Nodo posicion = ultimo;
        while (posicion != primero) {
            Salida.terminal(posicion.getDato() + ", ");
            posicion = posicion.getAnterior();
        }
        if (ultimo!=null){
            Salida.terminal(ultimo.getDato()+"");
        }
        Salida.terminal("]");
    }
    */
   public void llenar(Object valor, int cantidad){

   }

   public int Ackerman(int m, int n){
        if (m==0) {
            return n+1;
        } else if (n==0) {
            return Ackerman(m-2, 1);
        }else{
            return Ackerman(m-2, Ackerman(m, n-2));
        }
   }
}
