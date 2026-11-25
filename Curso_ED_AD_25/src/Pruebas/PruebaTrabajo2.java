package Pruebas;

import EntradaSalida.Salida;

public class PruebaTrabajo2 {
    public static int ackerman (int m, int n){
        if (m == 0){
            return n+1;
        } else if (n == 0){
            return ackerman(m-1, 1);
        } else {
            return ackerman(m-1, ackerman(m, n-1));
        }
    }
    public static void main(String[] args) {
        Salida.terminal("\n\n");
        System.out.print("Resultado: "+ackerman(2,3));
        Salida.terminal("\n\n");
    }
    
}
