package Examen_Extraordinario.Ejercicio_3;

public class Cliente {

    private String nombre;
    private String telefono;
    private String correo;

    public Cliente() {
    }

    public Cliente(String nombreCliente, String telefonoCliente, String correoCliente) {
        nombre = nombreCliente;
        telefono = telefonoCliente;
        correo = correoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreCliente) {
        nombre = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefonoCliente) {
        telefono = telefonoCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correoCliente) {
        correo = correoCliente;
    }

    public String toString() {
        return nombre;
    }

}
