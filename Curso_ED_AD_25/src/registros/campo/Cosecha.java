package registros.campo;

import EntradaSalida.Salida;
import edlineal.ArregloEstatico;
import ednolineal.Tabla3D;

public class Cosecha {
    protected ArregloEstatico campesinos;
    protected ArregloEstatico productos;
    protected ArregloEstatico meses;
    protected Tabla3D toneladas;

    public Cosecha (int numCampesinos, int numProductos, int numMeses){
        campesinos = new ArregloEstatico(numCampesinos);
        productos = new ArregloEstatico(numProductos);
        meses = new ArregloEstatico(numMeses);
        toneladas = new Tabla3D(numCampesinos, numProductos, numMeses, 0.0);
    }

    public boolean agregarCampesino (Campesino campesino) {
        int indiceExistencia = (int)campesinos.buscar(campesino);

        if (indiceExistencia >= 0 ) { // No lo agrego porque ya existe
            return false;
        } else { //No existe, y lo podemos agregar
            int retorno = campesinos.insertar(campesino);

            if (retorno >= 0) { //ERROR
                return true;
            } else { //Funciona la insercion
                return false;
            }
        }
    }

    public boolean agregarProducto (ProductoA producto){
        int indiceExistencia = (int)productos.buscar(producto);
        
        if (indiceExistencia >= 0) { //Ya existe, no lo voy a agregar
            return false;
        } else { //No existe, lo podemos agregar
            int retorno = productos.insertar(producto);

            if (retorno < 0 ) { //ERROR
                return false;
            } else { //Funciona la insersion
                return true;
            }
        }
    }

    public boolean agregarMes (String mes) {
        int indiceExistencia = (int)meses.buscar(mes);

        if (indiceExistencia >= 0 ){ //Ya existe, no lo voy a agregar
            return false;
        } else { //No existe, lo podemos agregar
            int retorno = meses.insertar(mes);
            if (retorno < 0){ //ERROR
                return false;
            } else { //Funciona la insersion
                return true;
            }
        }
    }

    //Este metodo regresa el indice de "x", "y" y "z" del cubo
    //Me los regresa en un arrgelo porque son 3 elementos
    private ArregloEstatico buscarCoordenadas (String x, String y, String z){
        ArregloEstatico coordenadas = new ArregloEstatico(3);

        int indiceCampesino = (int)campesinos.buscar(x);
        int indiceProducto = (int)productos.buscar(y);
        int indiceMes = (int)meses.buscar(z);
        if (indiceCampesino >= 0 && indiceProducto >= 0 && indiceMes >= 0) { //Deben existir, son validos
            coordenadas.insertar(indiceCampesino);
            coordenadas.insertar(indiceProducto);
            coordenadas.insertar(indiceMes);
            return coordenadas;
        } else { //Por lo menos, uno no es valido
            return null;
        }
    }

    public boolean agregarToneladas(String claveCampesino, String claveProducto, String mes, double cantToneladas){

        ArregloEstatico coordenadas = buscarCoordenadas(claveCampesino, claveProducto, mes);
        if (coordenadas != null) { //Son validas
            return toneladas.modifica ( (int) coordenadas.valor(0),
                                        (int) coordenadas.valor(1),
                                        (int) coordenadas.valor(2), cantToneladas);
        } else { //ERROR
            return false;
        }
    }

    public void imprimirCosechas () {
        Salida.terminal("\nCampesinos\n");
        campesinos.imprimir();  //Si quieres imprimir TODOS los datos, en un metodo aparte, hacer un "FOR" y recorrerlos
        Salida.terminal("\nProductos\n");
        productos.imprimir();
        Salida.terminal("\nMeses\n");
        meses.imprimir();
        Salida.terminal("\nCosechas de Toneladas\n");
        toneladas.imprimirXColumna();
        Salida.terminal("\n");
    }

    //Queremos responder las preguntas de ejemplo como:
    //Cuanto lleva acumulado Juan en los meses de Enero y Marzo de Chile?

    //Primer metodo: recopila datos de un campesino, de un mes, de un producto
    public Double tonsCampProdMes(String claveC, String claveP, String claveMes) {
        ArregloEstatico coordenadas = buscarCoordenadas(claveC, claveP, claveMes);
        if (coordenadas != null) { //Existen
            return (Double)toneladas.valor( (int) coordenadas.valor(0),
                                            (int) coordenadas.valor(1),
                                            (int) coordenadas.valor(2) );
        } else { //ERROR
            return null;
        }
    }
    //Segundo metodo: recopila los datos de todos los meses pedidos
    public Double tonsCampProd(String claveC, String claveP, ArregloEstatico mesesPedidos) {
        //Variable que acumula
        Double toneladasAcumuladas = 0.0;
        //Recorrer todos los meses
        for (int cadaMes = 0; cadaMes < meses.cantidad(); cadaMes++){
            //Extraer cada mes
            String mesTemporal = (String)mesesPedidos.valor(cadaMes);
            toneladasAcumuladas = tonsCampProdMes(claveC, claveP, mesTemporal) + toneladasAcumuladas;
        }
        return toneladasAcumuladas;
    }
}
