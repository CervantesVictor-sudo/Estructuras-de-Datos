package Pruebas;

public class PrebasExamen2 {

    public static int misterio(int[] lista, int i){
        if (i == lista.length) {
            return 0;
        }
        return lista[i] + misterio(lista, i + 1);
    }

    public static void main(String[] args) {
        
        int[] lista = {3,1,4};

        //System.out.println(lista.length);
        System.out.println(lista[0]);
        System.out.println(lista[1]);
        System.out.println(lista[2]);
        //System.out.println(lista[3]);

        
        System.out.println(misterio(lista, 0));

    }
}
