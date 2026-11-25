package edlineal;

public class Nodo {
    protected Object dato;
    protected Nodo ligaDer;
    
    public Nodo(Object dato) {
        this.dato = dato;
        this.ligaDer = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(Nodo ligaDer) {
        this.ligaDer = ligaDer;
    }

    //Regresa el identificador único de ésta clase
    public String toString(){
        return dato.toString();
    }
}
