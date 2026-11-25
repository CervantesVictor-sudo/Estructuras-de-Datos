package Examen_Extraordinario.Ejercicio_3;

import EntradaSalida.Entrada;
import EntradaSalida.Salida;
import edlineal.ArregloDinamico;
import edlineal.ArregloEstatico;

public class ProgramaReparaciones {

    public static void main(String[] args) {

        ArregloEstatico listaSucursales = new ArregloEstatico(5);

        Sucursal sucursal1 = new Sucursal("Sucursal 1", "Direccion 1");
        Sucursal sucursal2 = new Sucursal("Sucursal 2", "Direccion 2");
        Sucursal sucursal3 = new Sucursal("Sucursal 3", "Direccion 3");
        Sucursal sucursal4 = new Sucursal("Sucursal 4", "Direccion 4");
        Sucursal sucursal5 = new Sucursal("Sucursal 5", "Direccion 5");

        listaSucursales.insertar(sucursal1);
        listaSucursales.insertar(sucursal2);
        listaSucursales.insertar(sucursal3);
        listaSucursales.insertar(sucursal4);
        listaSucursales.insertar(sucursal5);

        boolean seguirEnPrograma = true;

        while (seguirEnPrograma) {

            Salida.terminal("\n--------------MENU PRINCIPAL--------------\n");
            Salida.terminal("1) Listar aparatos de una sucursal\n");
            Salida.terminal("2) Dar de alta aparato en sucursal\n");
            Salida.terminal("3) Borrar aparato de una sucursal\n");
            Salida.terminal("4) Buscar aparato por descripcion\n");
            Salida.terminal("5) Salir\n");
            Salida.terminal("Elige una opcion: ");

            String opcionMenu = Entrada.terminalCadenas();
            int opcion = Integer.parseInt(opcionMenu);

            if (opcion == 1) {

                Salida.terminal("\nSucursales disponibles:\n");
                int cantidadSucursales = listaSucursales.cantidad();
                int indiceSucursal = 0;

                while (indiceSucursal < cantidadSucursales) {
                    Sucursal sucursalActual = (Sucursal) listaSucursales.valor(indiceSucursal);
                    int numeroMostrar = indiceSucursal + 1;
                    Salida.terminal(numeroMostrar + ") " + sucursalActual.getNombre() + "\n");
                    indiceSucursal = indiceSucursal + 1;
                }

                Salida.terminal("Elige una sucursal: ");
                String numeroSucursalElegida = Entrada.terminalCadenas();
                int numSucursalElegida = Integer.parseInt(numeroSucursalElegida);
                int posicionSucursal = numSucursalElegida - 1;

                if (posicionSucursal < 0 || posicionSucursal >= listaSucursales.cantidad()) {
                    Salida.terminal("Sucursal no valida\n");
                } else {
                    Sucursal sucursalElegida = (Sucursal) listaSucursales.valor(posicionSucursal);
                    Salida.terminal("\nAparatos en " + sucursalElegida.getNombre() + ":\n");

                    ArregloDinamico listaAparatos = sucursalElegida.getListaAparatos();
                    int cantidadAparatos = listaAparatos.cantidad();

                    if (cantidadAparatos == 0) {
                        Salida.terminal("No hay aparatos en esta sucursal\n");
                    } else {
                        listaAparatos.iniciarIterador();

                        while (listaAparatos.iteradorNulo() == false) {
                            Object datoActual = listaAparatos.obtenerDato();
                            Aparato aparatoActual = (Aparato) datoActual;

                            Salida.terminal("- " + aparatoActual.getDescripcion() + " | Estado: " + aparatoActual.getEstadoActual() + "\n");

                            listaAparatos.moverIterador();
                        }
                    }
                }

            } else if (opcion == 2) {

                Salida.terminal("\nSucursales disponibles:\n");
                int cantidadSucursales = listaSucursales.cantidad();
                int indiceSucursal = 0;

                while (indiceSucursal < cantidadSucursales) {
                    Sucursal sucursalActual = (Sucursal) listaSucursales.valor(indiceSucursal);
                    int numeroMostrar = indiceSucursal + 1;
                    Salida.terminal(numeroMostrar + ") " + sucursalActual.getNombre() + "\n");
                    indiceSucursal = indiceSucursal + 1;
                }

                Salida.terminal("Elige una sucursal: ");
                String numeroSucursalElegida = Entrada.terminalCadenas();
                int numSucursalElegida = Integer.parseInt(numeroSucursalElegida);
                int posicionSucursal = numSucursalElegida - 1;

                if (posicionSucursal < 0 || posicionSucursal >= listaSucursales.cantidad()) {
                    Salida.terminal("Sucursal no valida\n");
                } else {
                    Sucursal sucursalElegida = (Sucursal) listaSucursales.valor(posicionSucursal);

                    Salida.terminal("\nAlta de aparato en: " + sucursalElegida.getNombre() + "\n");

                    Salida.terminal("Descripcion del aparato: ");
                    String descripcionAparato = Entrada.terminalCadenas();

                    Salida.terminal("Marca del aparato: ");
                    String marcaAparato = Entrada.terminalCadenas();

                    Salida.terminal("Anio de fabricacion: ");
                    String anioAparato = Entrada.terminalCadenas();
                    int anio = Integer.parseInt(anioAparato);

                    Salida.terminal("Desperfecto: ");
                    String desperfectoAparato = Entrada.terminalCadenas();

                    Salida.terminal("Estado actual (recibido, en revision, reparado, entregado): ");
                    String estadoAparato = Entrada.terminalCadenas();

                    Salida.terminal("\n---Datos del cliente---\n");

                    Salida.terminal("Nombre del cliente: ");
                    String nombreCliente = Entrada.terminalCadenas();

                    Salida.terminal("Telefono del cliente: ");
                    String telefonoCliente = Entrada.terminalCadenas();

                    Salida.terminal("Correo del cliente: ");
                    String correoCliente = Entrada.terminalCadenas();

                    Salida.terminal("\n---Datos del tecnico---\n");

                    Salida.terminal("Nombre del tecnico: ");
                    String nombreTecnico = Entrada.terminalCadenas();

                    Salida.terminal("Especialidad del tecnico: ");
                    String especialidadTecnico = Entrada.terminalCadenas();

                    Cliente clienteNuevo = new Cliente(nombreCliente, telefonoCliente, correoCliente);
                    Tecnico tecnicoNuevo = new Tecnico(nombreTecnico, especialidadTecnico);

                    Aparato aparatoNuevo = new Aparato(descripcionAparato, marcaAparato, anio, desperfectoAparato,
                                                                    estadoAparato, clienteNuevo, tecnicoNuevo);

                    sucursalElegida.agregarAparato(aparatoNuevo);

                    Salida.terminal("Aparato registrado en la sucursal\n");
                }

            } else if (opcion == 3) {

                Salida.terminal("\nSucursales disponibles:\n");
                int cantidadSucursales = listaSucursales.cantidad();
                int indiceSucursal = 0;

                while (indiceSucursal < cantidadSucursales) {
                    Sucursal sucursalActual = (Sucursal) listaSucursales.valor(indiceSucursal);
                    int numeroMostrar = indiceSucursal + 1;
                    Salida.terminal(numeroMostrar + ") " + sucursalActual.getNombre() + "\n");
                    indiceSucursal = indiceSucursal + 1;
                }

                Salida.terminal("Elige una sucursal: ");
                String numeroSucursalElegida = Entrada.terminalCadenas();
                int numSucursalElegida = Integer.parseInt(numeroSucursalElegida);
                int posicionSucursal = numSucursalElegida - 1;

                if (posicionSucursal < 0 || posicionSucursal >= listaSucursales.cantidad()) {
                    Salida.terminal("Sucursal no valida\n");
                } else {
                    Sucursal sucursalElegida = (Sucursal) listaSucursales.valor(posicionSucursal);
                    Salida.terminal("\nBorrar aparato en " + sucursalElegida.getNombre() + "\n");
                    Salida.terminal("Descripcion del aparato a borrar: ");
                    String descripcionBorrar = Entrada.terminalCadenas();

                    boolean seElimino = sucursalElegida.eliminarAparatoPorDescripcion(descripcionBorrar);

                    if (seElimino) {
                        Salida.terminal("Aparato eliminado\n");
                    } else {
                        Salida.terminal("No se encontro un aparato con esa descripcion\n");
                    }
                }

            } else if (opcion == 4) {

                Salida.terminal("\n--------------Buscar aparato por descripcion--------------\n");
                Salida.terminal("Descripcion del aparato a buscar: ");
                String descripcionBuscar = Entrada.terminalCadenas();

                int cantidadSucursales = listaSucursales.cantidad();
                int indiceSucursal = 0;
                boolean yaSeEncontro = false;

                while (indiceSucursal < cantidadSucursales && yaSeEncontro == false) {
                    Sucursal sucursalActual = (Sucursal) listaSucursales.valor(indiceSucursal);
                    Aparato aparatoEncontrado = sucursalActual.buscarAparatoPorDescripcion(descripcionBuscar);

                    if (aparatoEncontrado != null) {
                        Salida.terminal("\nAparato encontrado en la sucursal: " + sucursalActual.getNombre() + "\n");
                        Salida.terminal("Descripcion: " + aparatoEncontrado.getDescripcion() + "\n");
                        Salida.terminal("Marca: " + aparatoEncontrado.getMarca() + "\n");
                        Salida.terminal("Anio: " + aparatoEncontrado.getAnioFabricacion() + "\n");
                        Salida.terminal("Desperfecto: " + aparatoEncontrado.getDesperfecto() + "\n");
                        Salida.terminal("Estado: " + aparatoEncontrado.getEstadoActual() + "\n");

                        Cliente clienteAparato = aparatoEncontrado.getCliente();
                        if (clienteAparato != null) {
                            Salida.terminal("Cliente: " + clienteAparato.getNombre() + "\n");
                            Salida.terminal("Telefono: " + clienteAparato.getTelefono() + "\n");
                            Salida.terminal("Correo: " + clienteAparato.getCorreo() + "\n");
                        }

                        Tecnico tecnicoAparato = aparatoEncontrado.getTecnico();
                        if (tecnicoAparato != null) {
                            Salida.terminal("Tecnico: " + tecnicoAparato.getNombre() + "\n");
                            Salida.terminal("Especialidad: " + tecnicoAparato.getEspecialidad() + "\n");
                        }

                        yaSeEncontro = true;
                    } else {
                        indiceSucursal = indiceSucursal + 1;
                    }
                }

                if (yaSeEncontro == false) {
                    Salida.terminal("No se encontro el aparato en ninguna sucursal\n");
                }

            } else if (opcion == 5) {
                seguirEnPrograma = false;
            } else {
                Salida.terminal("Opcion no valida\n");
            }
        }

        Salida.terminal("Programa terminado\n");
    }
}
