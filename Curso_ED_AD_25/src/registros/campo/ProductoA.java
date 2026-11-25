package registros.campo;

public class ProductoA {
    protected String clave;
    protected String descripcion;
    protected String tipo;
    
    public ProductoA(String clave, String descripcion, String tipo) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return clave;
    }
}
