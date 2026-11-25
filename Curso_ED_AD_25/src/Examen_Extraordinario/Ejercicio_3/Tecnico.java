package Examen_Extraordinario.Ejercicio_3;

public class Tecnico {

    private String nombre;
    private String especialidad;

    public Tecnico() {
    }

    public Tecnico(String nombreTecnico, String especialidadTecnico) {
        nombre = nombreTecnico;
        especialidad = especialidadTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreTecnico) {
        nombre = nombreTecnico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidadTecnico) {
        especialidad = especialidadTecnico;
    }

    public String toString() {
        return nombre;
    }

}
