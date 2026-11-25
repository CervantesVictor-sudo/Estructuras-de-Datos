package registros.escuela;

import edlineal.ArregloEstatico;
import EntradaSalida.Salida;

public class ControlCargas {
    protected ArregloEstatico listadoCargasAlumnos;
    protected ArregloEstatico listadoAsignaturasDisponibles;
    public ControlCargas(int cuantosalumnos,int cuantasMaterias){
        listadoCargasAlumnos=new ArregloEstatico(cuantosalumnos);
        listadoAsignaturasDisponibles=new ArregloEstatico(cuantasMaterias);

    }
    
    public boolean agregaraAsignaturaListado(Asignatura asignatura){
        int indiceBusqueda=(int)listadoAsignaturasDisponibles.buscar(asignatura);
        if(indiceBusqueda>=0){// ya existe
            return false;

        }else{
            int retorno=listadoAsignaturasDisponibles.insertar(asignatura);
            if(retorno>=0){
                return true;
            }else{
                return false;
            }
        }


    }
    //Creamos una carga de alumno con los datos del encabezado
    public boolean agregarCargaAlumno(String fecha, Alumno alumno,int numMaterias){
        //calcular el folio
        int folioNuevo=listadoCargasAlumnos.cantidad()+1;
        //creamos la instancia de la carga
        CargaAlumno cargaNueva=new CargaAlumno(folioNuevo, alumno ,fecha, numMaterias);
        int retorno=listadoCargasAlumnos.insertar(cargaNueva);
        if(retorno>=0){
            return true;
        }else{
            return false;
        }
        
    }
    public boolean agregarAsigCargaAlumno(int folio, String clave,double calif, Maestro maestro){
        //buscando la posicion del folio en el listaod de cargas
        int indiceCarga=(int)listadoCargasAlumnos.buscar(folio);
        if(indiceCarga>=0){// si exoste este folio, puedo agreagarle asi
         CargaAlumno carga=(CargaAlumno)listadoCargasAlumnos.valor(indiceCarga);
         return carga.agregarMateriaCursada(clave, listadoAsignaturasDisponibles, calif,maestro);
        }else{// no existe
        return false;
        }
        
    }
    public boolean imprimirCargaAlumno(int folio){
        int indiceFolio=(int)listadoCargasAlumnos.buscar(folio);
        //primero hay que extraer la carga
        CargaAlumno carga=(CargaAlumno)listadoCargasAlumnos.valor(indiceFolio);
        carga.imprimirKardex();
        if(indiceFolio>=0){
            return true;

        }else{
            return false;
        }
    
    
    }
    public void imprmirCargaAlumnos(){
        // Recorremos todo el arreglo del listado de cargas
        for(int cadaCarga=0;cadaCarga<listadoCargasAlumnos.cantidad();cadaCarga++){
            CargaAlumno cargaTep=(CargaAlumno)listadoCargasAlumnos.valor(cadaCarga);
            cargaTep.imprimirKardex();
            Salida.terminal("\n");
        }
        

    }

}
