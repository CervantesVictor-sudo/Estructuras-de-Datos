package Pruebas;

import EntradaSalida.Salida;
import ednolineal.Tabla3D;

public class PruebaTabla3D {
    public static void main(String[] args) {
        Tabla3D cubo = new Tabla3D(2, 2, 2);

        cubo.llenar(5);

        cubo.imprimirXColumna();

        Salida.terminal("\n\n");

        cubo.modifica(1, 1, 1, 3);

        cubo.imprimirXColumna();
    }
}
