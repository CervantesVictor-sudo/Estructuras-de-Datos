package edlineal;

public interface Lote {
    public boolean vacia();
    public boolean llena();
    public boolean meter(Object valor);
    public Object sacar();
    public void mostrar();
    public Object verUltimo();
}
