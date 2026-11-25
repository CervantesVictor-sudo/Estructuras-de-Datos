package herramientas.genericas;

public class UtileriasObjetos {
    public static int compararO(Object objeto1, Object objeto2){
        //Checamos si es numero o no
        if (objeto1 instanceof Number && objeto2 instanceof Number){
            //Compararlos como numeros
            double objeto1Numerico=Double.parseDouble(objeto1.toString()); //"parseDouble" convierte un numero a double
            double objeto2Numerico=Double.parseDouble(objeto2.toString());

            if (objeto1Numerico > objeto2Numerico) { //positivo
                return 1;
            } else if (objeto1Numerico < objeto2Numerico){ //negativo
                return -1;
            } else { //es igual
                return 0;
            }
        } else { //Cualquier objeto que no sea un numero
            //compararlos como cadena
            //Regresar positivo cuando el de la izquierda sea mayor
            //Regresar negativo cuando el de la izquierda sea menor
            //Regresar 0 si son iguales
            return objeto1.toString().compareToIgnoreCase(objeto2.toString());

        }
    }
}
