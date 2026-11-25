package Examen_Extraordinario.Ejercicio_3;

import edlineal.ArregloDinamico;

public class Sucursal {

    private String nombre;
    private String direccion;
    private ArregloDinamico listaAparatos;

    public Sucursal() {
        listaAparatos = new ArregloDinamico();
    }

    public Sucursal(String nombreSucursal, String direccionSucursal) {
        nombre = nombreSucursal;
        direccion = direccionSucursal;
        listaAparatos = new ArregloDinamico();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreSucursal) {
        nombre = nombreSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccionSucursal) {
        direccion = direccionSucursal;
    }

    public ArregloDinamico getListaAparatos() {
        return listaAparatos;
    }
    
    public String toString() {
        return nombre;
    }

    public void setListaAparatos(ArregloDinamico nuevaLista) {
        listaAparatos = nuevaLista;
    }

    public void agregarAparato(Aparato nuevoAparato) {
        if (nuevoAparato == null) {
            return;
        }
        listaAparatos.insertar(nuevoAparato);
    }

    public Aparato buscarAparatoPorDescripcion(String descripcionBuscada) {
        if (descripcionBuscada == null) {
            return null;
        }

        listaAparatos.iniciarIterador();

        while (listaAparatos.iteradorNulo() == false) {
            Object valorActual = listaAparatos.obtenerDato();
            Aparato aparatoActual = (Aparato) valorActual;

            if (aparatoActual.getDescripcion() != null
                    && aparatoActual.getDescripcion().equalsIgnoreCase(descripcionBuscada)) {
                return aparatoActual;
            }

            listaAparatos.moverIterador();
        }

        return null;
    }

    public boolean eliminarAparatoPorDescripcion(String descripcionBuscada) {
        Aparato aparatoEncontrado = buscarAparatoPorDescripcion(descripcionBuscada);

        if (aparatoEncontrado == null) {
            return false;
        }

        listaAparatos.eliminar(aparatoEncontrado);
        return true;
    }

}
