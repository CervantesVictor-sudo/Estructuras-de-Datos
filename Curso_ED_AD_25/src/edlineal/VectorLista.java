package edlineal;

public interface VectorLista extends Lista {
    public boolean lleno();
    
    public Object valor(int indice);
    public boolean modifica(int indice, Object valor);
    public int tamanio();
}