package registros.escuela;

import EntradaSalida.Salida;
import edlineal.ArregloDinamico;

public class ControlCargas2 {
    protected ArregloDinamico listadoCargasAlumnos;
    protected ArregloDinamico listadoAsignaturasDisponibles;
    
    public ControlCargas2(){
        listadoCargasAlumnos = new ArregloDinamico();
        listadoAsignaturasDisponibles = new ArregloDinamico();

    }
    
    public boolean agregaraAsignaturaListado(Asignatura asignatura){
        Asignatura asignaturaBuscada = (Asignatura) listadoAsignaturasDisponibles.buscar(asignatura);
        if(asignaturaBuscada != null){// ya existe, no puedo agregarlo
            return false;
        }else{ //no existe, puedo agregarlo
            int retorno=listadoAsignaturasDisponibles.insertar(asignatura);
            if(retorno>=0){ //si pudo
                return true;
            }else{
                return false;
            }
        }
    }

    //Creamos una carga de alumno con los datos del encabezado
    public boolean agregarCargaAlumno(String fecha, Alumno alumno){
        //calcular el folio
        int folioNuevo=listadoCargasAlumnos.cantidad()+1;
        //creamos la instancia de la carga
        CargaAlumno2 cargaNueva = new CargaAlumno2(folioNuevo, alumno ,fecha);
        int retorno=listadoCargasAlumnos.insertar(cargaNueva);
        if(retorno >= 0){ //si pudo meterla
            return true;
        }else{
            return false;
        }
    }

    public boolean agregarAsigCargaAlumno(int folio, String clave, double calif, Maestro maestro){
        //buscando la posicion del folio en el listaod de cargas
        CargaAlumno2 cargaAumnoCompleto = (CargaAlumno2)listadoCargasAlumnos.buscar(folio);
        if(cargaAumnoCompleto != null){// si existe esta carga, puedo agreagarle2
            return cargaAumnoCompleto.agregarMateriaCursada(clave, listadoAsignaturasDisponibles, calif, maestro);
        }else{// no existe
            return false;
        }
    }

    public boolean imprimirCargaAlumno(int folio){
        CargaAlumno2 cargaAlumnoCompleto = (CargaAlumno2)listadoCargasAlumnos.buscar(folio);
        //primero hay que extraer la carga
        if(cargaAlumnoCompleto != null){
            cargaAlumnoCompleto.imprimirKardex();
            return true;
        }else{
            return false;
        }
    }

    public void imprmirCargaAlumnos(){
        // Recorremos todo el arreglo del listado de cargas
        listadoCargasAlumnos.iniciarIterador();
        while(listadoCargasAlumnos.iteradorNulo() == false){
            CargaAlumno2 cargaTep = (CargaAlumno2)listadoCargasAlumnos.obtenerDato();
            cargaTep.imprimirKardex();
            Salida.terminal("\n");
            listadoCargasAlumnos.moverIterador();
        }
    }

    
}
