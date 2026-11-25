package ExamenPrimerParcial;

import EntradaSalida.Archivos.ArchivoTexto;
import EntradaSalida.Salida;
import java.util.Scanner;


public class PrincipalExamen {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner obj = new Scanner(System.in);

        Salida.terminal("\n¿Deseas que la entrada sea un archivo de texto o deseas ingresar tu propia entrada manualmente?");
        Salida.terminal("\nArchivo [1] --- Entrada Manual [2]\n\n");
        Salida.terminal("Opcion selleccionada: ");
        opcion = obj.nextInt();
        Salida.terminal("\n\n");


        if ((opcion == 1) || (opcion == 2)) { //compara que se haya seleccionado la opcion correcta del menú.
            if (opcion == 1) { //Invoca que pueda leer un archivo.
                Salida.terminal("Ruta del archivo: ");
                String ruta = obj.nextLine();
                ArchivoTexto.leer(ruta);
            }else{ //Seria como si hubiera seleccionado la opcion 2, invoca la entrada manual.
                Salida.terminal("Ingresa tu entrada manual: ");
                String entradaManual = obj.nextLine();
            }
        }else{ //No se seleccionó ni la opcion 1 ni la opcion 2.
            Salida.terminal("Opcion invalida, vuelva a intentarlo.\n\n");
        }

        obj.close();
    }
}
