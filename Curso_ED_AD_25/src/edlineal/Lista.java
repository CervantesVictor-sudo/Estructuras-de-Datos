package edlineal;

public interface Lista {
    public boolean vacia();
    public Integer insertar(Object objeto);
    public Object buscar(Object valor);
    public Object eliminar(Object valor);
    public void imprimir();

    public int cantidad(); //Solo se agregó esto
    public Object eliminar(); //Sin argumentos
    public Object verUltimo();//No lo elimina, solo lo muestra 

    public Integer insertarInicio(Object valor);
    public Object eliminarInicio();
    public Object verPrimero();

    public void llenar(Object valor, int cantidad);

}