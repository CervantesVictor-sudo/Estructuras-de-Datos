package ednolineal;

import EntradaSalida.Salida;

public class Tabla3D {
    protected int filas;
    protected int columnas;
    protected int profundidad;
    protected Object datos[][][];

    public Tabla3D(int reng, int cols, int prof){
        filas = reng;
        columnas = cols;
        profundidad = prof;
        datos = new Object[filas][columnas][profundidad];
    }

    public Tabla3D(int reng, int cols, int prof, Object valor){
        filas = reng;
        columnas = cols;
        profundidad = prof;
        datos = new Object[filas][columnas][profundidad];
        llenar(0);
    }

    public boolean modifica(int x, int y, int z, Object valor){
        if (indicesValido(x, y, z) == true) {
            datos[x][y][z]=valor;
            return true;
        }else{
            return false;
        }
    }

    public Object valor (int x, int y, int z){
        if (indicesValido(x, y, z) == true) {
            return datos[x][y][z];
        }else{
          return null;
        }
    }

    //Llenar todo el cubo con un valor
    public void llenar (Object valor) {

        //Asumo que solo hay un arreglo con filas
        for (int cadaFila = 0; cadaFila < filas; cadaFila++){

            //Asumo que solo hay una fila con muchas columnas
            for (int cadaCol = 0; cadaCol < columnas; cadaCol++){

                //Asumo que solo hay un arreglo de profundidad
                for (int cadaProf = 0; cadaProf<profundidad; cadaProf++){
                    datos[cadaFila] [cadaCol] [cadaProf] = valor;
                }
            }
        }
    }

    //Metodo que valida las dimensiones indicadad x, y, z
    public boolean indicesValido(int x, int y, int z){
        if ((x>=0 && x<(filas) && (y>=0 && y<columnas) && (z>=0 && z<profundidad)) ){
            return true;
        } else{
            return false;
        }
    }

    public void imprimirXColumna(){
        Salida.terminal("["); //Corchete inicial de las rebanadas
        //C = Columnas
        for (int cadaRebanadaC = 0; cadaRebanadaC < columnas; cadaRebanadaC ++){
            Salida.terminal("["); //Corchete inicial de las filas

            //Cada rebanada va a contener una matriz
            for (int cadaFila = 0; cadaFila < filas; cadaFila++) { //Las filas, de un arreglo
                Salida.terminal("["); //Corchete inicial de la profundidad
                //Cada fila trae un arreglo, que es la profundidad

                //ColP = profundidad
                for (int cadaColP = 0; cadaColP < profundidad; cadaColP++) {
                    if (cadaColP==profundidad-1) { //Cuando SI es el ultimo
                        Salida.terminal(datos[cadaFila][cadaRebanadaC][cadaColP] + "");
                    } else { //NO es el ultimo
                        Salida.terminal(datos[cadaFila][cadaRebanadaC][cadaColP] + ",");
                    }
                }
                Salida.terminal("]"); //Corchete final de la profundidad
            }

            Salida.terminal("]"); //Corchete final de las filas

            if (cadaRebanadaC==columnas-1){
                Salida.terminal("");
            } else {
                Salida.terminal(","); //El separador de rebanadas
            }
        }
        Salida.terminal("]"); //Corchete final de las rebanadas
    }
}