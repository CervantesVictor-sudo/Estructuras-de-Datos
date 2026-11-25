package edlineal;

public class NodoDoble {
    protected Object dato;
    protected NodoDoble ligaDer;
    protected NodoDoble ligaIzq ;

    public NodoDoble (Object dato){
        this.dato = dato;
        this.ligaDer = null;
        this.ligaIzq = null;
    }

    public Object getDato() {
        return dato;
    }
    public void setDato(Object dato) {
        this.dato = dato;
    }
    public NodoDoble getLigaDer() {
        return ligaDer;
    }
    public void setLigaDer(NodoDoble ligaDer) {
        this.ligaDer = ligaDer;
    }
    public NodoDoble getLigaIzq() {
        return ligaIzq;
    }
    public void setLigaIzq(NodoDoble ligaIzq) {
        this.ligaIzq = ligaIzq;
    }

    //Regresa el identificador único de ésta clase
    public String toString(){
        return dato.toString();
    }
}
