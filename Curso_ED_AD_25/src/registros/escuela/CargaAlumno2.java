package registros.escuela;

import EntradaSalida.Salida;
import edlineal.ArregloDinamico;

public class CargaAlumno2 {
    protected int folio;
    protected String fecha;
    protected Alumno alumno;
    protected ArregloDinamico asignaturaCursadas;
    protected ArregloDinamico calificaciones;
    protected ArregloDinamico maestros;
    protected double promedio;
    
    public CargaAlumno2(int folio, Alumno alumno, String fecha){
        this.folio=folio;
        this.alumno=alumno;
        this.fecha=fecha;
        asignaturaCursadas=new ArregloDinamico();
        calificaciones=new ArregloDinamico();
        maestros=new ArregloDinamico();
        promedio=0.0;

    }
    public boolean agregarMateriaCursada(String claveAsignatura, ArregloDinamico listadoAsignatura, double calif, Maestro maestro){
        Asignatura asignaturaTemp = (Asignatura)listadoAsignatura.buscar(claveAsignatura);
       if(asignaturaTemp!=null){ //se encuentra
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
        double suma = 0.0;
        int contador = 0;
        calificaciones.iniciarIterador();
        while(calificaciones.iteradorNulo()==false){
            double calif = (double)calificaciones.obtenerDato();
            suma = suma+calif;
            contador++;
            calificaciones.moverIterador();
        }
        if(contador > 0){
            return suma / contador;
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

        asignaturaCursadas.iniciarIterador();
        calificaciones.iniciarIterador();
        maestros.iniciarIterador();

        while(asignaturaCursadas.iteradorNulo() == false){
            //Sacar una asignatura cursada
            Asignatura asigTemp=(Asignatura)asignaturaCursadas.obtenerDato();
            // sacar la calificacion 
            double califTemp=(double)calificaciones.obtenerDato();
            //sacar el maestro
            Maestro maestroTemp=(Maestro)maestros.obtenerDato();
            Salida.terminal(asigTemp.getClave()+ "\t\t\t\t"+ asigTemp.getNombre()+"\t\t\t\t"+califTemp+"\t\t\t\t"+maestroTemp+"\n");
            asignaturaCursadas.moverIterador();
            calificaciones.moverIterador();
            maestros.moverIterador();
        }

        //Imprimimos al pie de pagina
        Salida.terminal("\t\t\t\t\t\t\t\t\t\t\t\tpromedio: " + promedio());
    }

    @Override
    public String toString(){
        return folio+"";
    }
}
