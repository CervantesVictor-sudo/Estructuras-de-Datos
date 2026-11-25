package Pruebas;

import registros.campo.Campesino;
import registros.campo.Cosecha;
import registros.campo.ProductoA;

public class PruebaCosechas {
    public static void main(String[] args) {
        Cosecha produccion = new Cosecha(4, 3, 2);

        Campesino camp1 = new Campesino("C01", "Juan", 'M', 40);
        Campesino camp2 = new Campesino("C02", "Pedro", 'M', 26);
        Campesino camp3 = new Campesino("C03", "Lupe", 'F', 20);
        Campesino camp4 = new Campesino("C04", "Jelipe", 'I', 41);

        ProductoA prod1 = new ProductoA("P01", "Maiz", "Azul");
        ProductoA prod2 = new ProductoA("P02", "Chile", "Pasilla");
        ProductoA prod3 = new ProductoA("P03", "Papa", "Peruana");

        produccion.agregarCampesino(camp1);
        produccion.agregarCampesino(camp2);
        produccion.agregarCampesino(camp3);

        produccion.agregarProducto(prod1);
        produccion.agregarProducto(prod2);
        produccion.agregarProducto(prod3);

        produccion.agregarMes("Enero");
        produccion.agregarMes("Febrero");
        produccion.agregarMes("Marzo");

        produccion.agregarToneladas("C01", "P03", "Enero", 30);
        produccion.agregarToneladas("C03", "P03", "Enero", 50);

        produccion.imprimirCosechas();
    }
}
