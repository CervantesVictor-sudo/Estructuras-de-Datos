package edlineal;

//Esta clase se crea con el proposito de regresar doble variable en algun metodo,
//en este caso, regresará "posActual" y "anterior" para el metodo "buscarElementos".
public class DatoBusqueda {
    protected Nodo posActual;
    protected Nodo anterior;

    public Nodo getPosActual() {
        return posActual;
    }
    public void setPosActual(Nodo posActual) {
        this.posActual = posActual;
    }
    public Nodo getAnterior() {
        return anterior;
    }
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
