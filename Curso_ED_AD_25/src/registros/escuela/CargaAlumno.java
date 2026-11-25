package registros.escuela;

import edlineal.ArregloEstatico;

import EntradaSalida.Salida;
public class CargaAlumno {
    protected int folio;
    protected String fecha;
    protected Alumno alumno;
    protected ArregloEstatico asignaturaCursadas;
    protected ArregloEstatico calificaciones;
    protected ArregloEstatico maestros;
    protected double promedio;
    
    public CargaAlumno(int folio, Alumno alumno, String fecha ,int numAsignaturas){
        this.folio=folio;
        this.alumno=alumno;
        this.fecha=fecha;
        asignaturaCursadas=new ArregloEstatico(numAsignaturas);
        calificaciones=new ArregloEstatico(numAsignaturas);
        maestros=new ArregloEstatico(numAsignaturas);
        promedio=0.0;

    }
    public boolean agregarMateriaCursada(String claveAsignatura,ArregloEstatico listadoAsignatura,double calif, Maestro maestro){
       int indiceBusqueda=(int) listadoAsignatura.buscar(claveAsignatura);
       if(indiceBusqueda>=0){ //se encuentra
        Asignatura asignaturaTemp=(Asignatura)listadoAsignatura.valor(indiceBusqueda);
        int retorno=asignaturaCursadas.insertar(asignaturaTemp);
        if(retorno<0){
            return false;
        }
        retorno=calificaciones.insertar(calif);
        retorno=maestros.insertar(maestro);
        if(retorno<0){
            return false;
        }
        return true;// si llegamos hasta aqui, significa que no hubo error 
       }else{// no c encuentra
        return false;
       }


    }

    public Double promedio(){
        double suma=0.0;
        for(int cadaCalif=0;cadaCalif<calificaciones.cantidad();cadaCalif++){
            suma=suma+ (double)calificaciones.valor(cadaCalif);
        }
        if(calificaciones.cantidad()>0){
            return suma/calificaciones.cantidad();
        }else{
            return null;
        }
    }
    public void imprimirKardex(){
        //Encabezado
        Salida.terminal("Folio: "+folio+"\t\t\t\t Fecha: "+fecha);
        Salida.terminal("Alumno: "+alumno.getNombre());
        //se imprime una sola vez el encabexado del detalle
        Salida.terminal("Clave asignatura \t\t\t\t Nombre asignatura \t\t\t\t Calificacion \t\t\t\t Maestro\n");
        //Detalle, como son varias materias, se ocupa hacer un ciclo
        for(int cadaMateria=0;cadaMateria<asignaturaCursadas.cantidad();cadaMateria++){
            //Sacar una asignatura cursada
            Asignatura asigTemp=(Asignatura)asignaturaCursadas.valor(cadaMateria);
            // sacar la calificacion 
            double califTemp=(double)calificaciones.valor(cadaMateria);
            //sacar el maestro
            Maestro maestroTemp=(Maestro)maestros.valor(cadaMateria);
            Salida.terminal(asigTemp.getClave()+ "\t\t\t\t"+ asigTemp.getNombre()+"\t\t\t\t"+califTemp+"\t\t\t\t"+maestroTemp+"\n");
            
        }
        //Imprimimos al pie de pagina
        Salida.terminal("\t\t\t\t\t\t\t\t\t\t\t\tpromedio: "+promedio());
    }
    @Override
    public String toString(){
        return folio+"";
    }
}
