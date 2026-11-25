package ednolineal;

import EntradaSalida.Salida;

public class Tabla2D{
    protected int renglones;
    protected int columnas;
    protected Object datos[][];

    //1. Constructor
    public Tabla2D(int rengl, int colum) {
        renglones = rengl;
        columnas = colum;
        datos = new Object[renglones][columnas];
    }

    //2. Constructor con valor (el valor es el contenido con que se debe inicializar la matriz)
    public Tabla2D(int rengl, int colum, Object valor) {
        renglones = rengl;
        columnas = colum;
        datos = new Object[renglones][columnas];
        llenar(valor);
    }

    //3. Metodo que permite colocar un nombre a las columnas y a las filas

    //4. Leer un elemento de la matriz
    public Object valor (int fila, int col){
        if (indicesValido(fila, col) == true) {
            return datos[fila][col];
        }else{
          return null;
        }
    }

    //5. Cambiar algun elemento
    public boolean modifica(int fila, int col, Object valor){
        if (indicesValido(fila, col) == true) {
            datos[fila][col]=valor;
            return true;
        }else{
            return false;
        }
    }

    //Metodo que valida las dimensiones indicadad x, y
    public boolean indicesValido(int x, int y){
        if( (x>=0 && x<renglones) && (y>=0 && y<columnas)) {
            return true;
        } else{
            return false;
        }
    }

    //6. Obtener el numero de elementos en renglones y columnas.
    public int obtenerRenglones() {
        return renglones;
    }
    public int obtenerColumnas() {
        return columnas;
    }

    public void imprimirMatriz(){
        for (int cadaFila = 0;cadaFila < renglones; cadaFila++){
            for(int cadaCol = 0;cadaCol < columnas; cadaCol++){// las filas, un arreglo
                Salida.terminal(datos[cadaFila][cadaCol]+" ");
            }
            Salida.terminal("\n");//ajustar la matriz con un salto de linea
        }
    }

    //7. Imprimir los datos de la matriz en formato de renglon por renglon.
    public void imprimirXRenglones(){
        Salida.terminal("["); //Corchete inicial de las rebanadas
        //R = Renglones
            for (int cadaRebanadaR = 0; cadaRebanadaR < renglones; cadaRebanadaR ++){
            Salida.terminal("["); //Corchete inicial de las columnas

            //Cada rebanada va a contener una matriz
            for (int cadaColumna = 0; cadaColumna < columnas; cadaColumna++) { //Las columnas, de un arreglo
                
                if (cadaColumna==columnas-1) { //Cuando SI es el ultimo
                        Salida.terminal(datos[cadaRebanadaR][cadaColumna] + "");
                } else { //NO es el ultimo
                        Salida.terminal(datos[cadaRebanadaR][cadaColumna] + ",");
                }
            }

            Salida.terminal("]"); //Corchete final de las columnas

            if (cadaRebanadaR==renglones-1){
                Salida.terminal("");
            } else {
                Salida.terminal(","); //El separador de rebanadas
            }
        }
        Salida.terminal("]"); //Corchete final de las rebanadas
    }

    //8. Imprimir los datos de la matriz en formato de columna por columna.
    public void imprimirXColumna(){
        Salida.terminal("["); //Corchete inicial de las rebanadas
        //C = Columnas
        for (int cadaRebanadaC = 0; cadaRebanadaC < columnas; cadaRebanadaC ++){
            Salida.terminal("["); //Corchete inicial de los renglones

            //Cada rebanada va a contener una matriz
            for (int cadaRenglon = 0; cadaRenglon < renglones; cadaRenglon++) { //Los renglones, de un arreglo
                
                if (cadaRenglon==renglones-1) { //Cuando SI es el ultimo
                        Salida.terminal(datos[cadaRenglon][cadaRebanadaC] + "");
                } else { //NO es el ultimo
                        Salida.terminal(datos[cadaRenglon][cadaRebanadaC] + ",");
                }
            }

            Salida.terminal("]"); //Corchete final de los renglones

            if (cadaRebanadaC==columnas-1){
                Salida.terminal("");
            } else {
                Salida.terminal(","); //El separador de rebanadas
            }
        }
        Salida.terminal("]"); //Corchete final de las rebanadas
    }

    //9. Hacer la transpuesta de la matriz
    

    //10. Inicializa los elementos de la matriz
    public void llenar (Object valor) {
        //Asumo que solo hay un arreglo con renglones
        for (int cadaRenglon = 0; cadaRenglon < renglones; cadaRenglon++){
            //Asumo que solo hay un renglon con muchas columnas
            for (int cadaCol = 0; cadaCol < columnas; cadaCol++){
                datos[cadaRenglon] [cadaCol] = valor;
            }
        }
    }

    //11. Generar y regresar una copia de la matriz original.
    public Tabla2D copiar() {
        Tabla2D copia = new Tabla2D(renglones, columnas);
        
        for (int copiaReng = 0; copiaReng < renglones; copiaReng++) {
            for (int copiaColum = 0; copiaColum < columnas; copiaColum++) {
                copia.datos[copiaReng][copiaColum] = datos[copiaReng][copiaColum];
            }
        }
        return copia;
    }

    //12. Metodo que compara si dos matrices son iguales.
    public boolean esIgual(Tabla2D matriz2){
        if (renglones != matriz2.renglones || columnas != matriz2.columnas) {
            return false; //No pueden ser iguales ya que tienen diferente tamaño.
        }

        for (int copiaReng = 0; copiaReng < renglones; copiaReng++) {
            for (int copiaColum = 0; copiaColum < columnas; copiaColum++) {
                if (!datos[copiaReng][copiaColum].equals(matriz2.datos[copiaReng][copiaColum])){
                    return false; //Algun elemento encontrado es diferente de otro.
                }
            }
        }
        return true;
    }
    
}
