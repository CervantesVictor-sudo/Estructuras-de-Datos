package Examen_Extraordinario.Ejercicio_3;

public class Aparato {

    private String descripcion;
    private String marca;
    private int anioFabricacion;
    private String desperfecto;
    private String estadoActual;
    private Cliente cliente;
    private Tecnico tecnico;

    public Aparato() {
    }

    public Aparato(String descripcionAparato, String marcaAparato, int anioAparato, String desperfectoAparato,
                   String estadoAparato, Cliente clienteAparato, Tecnico tecnicoAparato) {

        descripcion = descripcionAparato;
        marca = marcaAparato;
        anioFabricacion = anioAparato;
        desperfecto = desperfectoAparato;
        estadoActual = estadoAparato;
        cliente = clienteAparato;
        tecnico = tecnicoAparato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcionAparato) {
        descripcion = descripcionAparato;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marcaAparato) {
        marca = marcaAparato;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioAparato) {
        anioFabricacion = anioAparato;
    }

    public String getDesperfecto() {
        return desperfecto;
    }

    public void setDesperfecto(String desperfectoAparato) {
        desperfecto = desperfectoAparato;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoAparato) {
        estadoActual = estadoAparato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente clienteAparato) {
        cliente = clienteAparato;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnicoAparato) {
        tecnico = tecnicoAparato;
    }

    public String toString() {
        return descripcion;
    }

}
