package ednolineal;

public class Vertice {
    protected Object descripcion;
    protected int numVertice;

    public Object getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(Object descripcion) {
        this.descripcion = descripcion;
    }
    public int getNumVertice() {
        return numVertice;
    }
    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }
    
    public String toString(){
        return descripcion.toString();
    }

}
