package concesionario;

import java.util.ArrayList;

/*
 * Desde aquí intentamos la conexión, creo objetos y llamo a los DAO
 * para insertar, consultar, actualizar y eliminar datos en la base de datos.
 */
public class Main {

    public static void main(String[] args) {

        /*
         * Primero compruebo si la conexión funciona.
         * Si aquí falla, es porque MySQL no está iniciado,
         * porque la base de datos no existe o porque falta el conector JDBC.
         */
        System.out.println("======================================");
        System.out.println(" PRÁCTICA CONCESIONARIO - JAVA Y MYSQL");
        System.out.println("======================================");

        ConexionBD.probarConexion();

        /*
         * Objetos DAO.
         * Estos objetos son los que tienen los métodos para trabajar
         * con cada tabla de la base de datos.
         */
        ClienteDAO clienteDAO = new ClienteDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        CocheDAO cocheDAO = new CocheDAO();

        /*
         * Borro antes los datos de prueba por si ejecuto el programa más de una vez.
         * Como el NIF y la matrícula son claves primarias, si intento insertar
         * dos veces el mismo dato, MySQL dará error de duplicado.
         *
         * Esto no borra toda la tabla, solo los registros de prueba que uso aquí.
         */
        System.out.println("\n--- LIMPIANDO DATOS DE PRUEBA ANTERIORES ---");

        cocheDAO.eliminar("1111AAA");
        cocheDAO.eliminar("2222BBB");
        cocheDAO.eliminar("3333CCC");

        clienteDAO.eliminar("10000001A");
        clienteDAO.eliminar("10000002B");
        clienteDAO.eliminar("10000003C");

        empleadoDAO.eliminar("20000001A");
        empleadoDAO.eliminar("20000002B");
        empleadoDAO.eliminar("20000003C");

        /*
         * Creo 3 clientes.
         * Estos objetos todavía están solo en Java.
         * Para guardarlos en MySQL tengo que llamar después al método insertar().
         */
        Cliente cliente1 = new Cliente(
                "10000001A",
                "Ana",
                "García",
                "López",
                "Calle Real 12, Almería",
                "600111222",
                "ana.garcia@email.com"
        );

        Cliente cliente2 = new Cliente(
                "10000002B",
                "Luis",
                "Martínez",
                "Sánchez",
                "Avenida Andalucía 30, Granada",
                "600333444",
                "luis.martinez@email.com"
        );

        Cliente cliente3 = new Cliente(
                "10000003C",
                "Marta",
                "Ruiz",
                "Pérez",
                "Calle Sol 8, Málaga",
                "600555666",
                "marta.ruiz@email.com"
        );

        /*
         * Creo 3 empleados.
         * Dos de ellos tienen Almería en la dirección para poder hacer
         * luego la consulta que pide la práctica.
         */
        Empleado empleado1 = new Empleado(
                "20000001A",
                "Carlos",
                "Fernández",
                "Molina",
                "Calle Granada 10, Almería",
                "610111222",
                "carlos.fernandez@concesionario.com",
                1500.00
        );

        Empleado empleado2 = new Empleado(
                "20000002B",
                "Laura",
                "Sánchez",
                "Romero",
                "Avenida Mediterráneo 5, Almería",
                "610333444",
                "laura.sanchez@concesionario.com",
                1650.00
        );

        Empleado empleado3 = new Empleado(
                "20000003C",
                "Pedro",
                "López",
                "Martín",
                "Calle Larios 20, Málaga",
                "610555666",
                "pedro.lopez@concesionario.com",
                1800.00
        );

        /*
         * Creo 3 coches.
         * El tipo de vehículo tiene que coincidir con el ENUM de la base de datos:
         * km0, segunda_mano o nuevo.
         *
         * En los coches nuevos pongo garantía.
         * En los de segunda mano pongo antiguo propietario.
         * En los km0 dejo esos campos como null si no corresponde.
         */
        Coche coche1 = new Coche(
                "1111AAA",
                "Toyota Corolla",
                "nuevo",
                24000.00,
                "Blanco",
                0,
                36,
                null
        );

        Coche coche2 = new Coche(
                "2222BBB",
                "Seat León",
                "segunda_mano",
                12500.00,
                "Rojo",
                85000,
                null,
                "Juan Pérez"
        );

        Coche coche3 = new Coche(
                "3333CCC",
                "Hyundai i30",
                "km0",
                19900.00,
                "Azul",
                5000,
                null,
                null
        );

        /*
         * Inserto los clientes en la base de datos.
         */
        System.out.println("\n--- INSERTANDO CLIENTES ---");
        clienteDAO.insertar(cliente1);
        clienteDAO.insertar(cliente2);
        clienteDAO.insertar(cliente3);

        /*
         * Inserto los empleados en la base de datos.
         */
        System.out.println("\n--- INSERTANDO EMPLEADOS ---");
        empleadoDAO.insertar(empleado1);
        empleadoDAO.insertar(empleado2);
        empleadoDAO.insertar(empleado3);

        /*
         * Inserto los coches en la base de datos.
         */
        System.out.println("\n--- INSERTANDO COCHES ---");
        cocheDAO.insertar(coche1);
        cocheDAO.insertar(coche2);
        cocheDAO.insertar(coche3);

        /*
         * Muestro todos los clientes para comprobar que se han insertado.
         * El método listar() devuelve una lista de objetos Cliente.
         */
        System.out.println("\n--- LISTADO DE CLIENTES ---");
        ArrayList<Cliente> clientes = clienteDAO.listar();

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        /*
         * Muestro todos los empleados para comprobar que se han insertado.
         */
        System.out.println("\n--- LISTADO DE EMPLEADOS ---");
        ArrayList<Empleado> empleados = empleadoDAO.listar();

        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }

        /*
         * Muestro todos los coches para comprobar que se han insertado.
         */
        System.out.println("\n--- LISTADO DE COCHES ---");
        ArrayList<Coche> coches = cocheDAO.listar();

        for (Coche coche : coches) {
            System.out.println(coche);
        }

        /*
         * Consulta pedida en la práctica:
         * obtener los empleados de Almería.
         */
        System.out.println("\n--- EMPLEADOS DE ALMERÍA ---");
        ArrayList<Empleado> empleadosAlmeria = empleadoDAO.obtenerEmpleadosPorDireccion("Almería");

        if (empleadosAlmeria.isEmpty()) {
            System.out.println("No se han encontrado empleados de Almería.");
        } else {
            for (Empleado empleado : empleadosAlmeria) {
                System.out.println(empleado.getNombre() + " "
                        + empleado.getApellido1() + " "
                        + empleado.getApellido2()
                        + " | Dirección: " + empleado.getDireccion());
            }
        }

        /*
         * Consulta pedida en la práctica:
         * obtener el modelo de un coche dada su matrícula.
         */
        System.out.println("\n--- MODELO DE COCHE POR MATRÍCULA ---");

        String matriculaBuscada = "1111AAA";
        String modelo = cocheDAO.obtenerModeloPorMatricula(matriculaBuscada);

        if (modelo != null) {
            System.out.println("El modelo del coche con matrícula "
                    + matriculaBuscada + " es: " + modelo);
        } else {
            System.out.println("No se ha encontrado ningún coche con la matrícula "
                    + matriculaBuscada);
        }

        /*
         * seleccionar todos los empleados y su sueldo.
         */
        System.out.println("\n--- EMPLEADOS Y SUELDOS ANTES DE LA SUBIDA ---");
        empleadoDAO.listarEmpleadosYSueldos();

        /*
         * subir todos los sueldos un 5%.
         *
         * Este método está hecho en EmpleadoDAO usando ResultSet actualizable,
         * que permite modificar los datos mientras se recorren los resultados.
         */
        System.out.println("\n--- ACTUALIZANDO SUELDOS UN 5% ---");
        empleadoDAO.actualizarSueldosCincoPorCiento();

        /*
         * Vuelvo a mostrar los empleados y sueldos para comprobar
         * que la subida se ha aplicado correctamente.
         */
        System.out.println("\n--- EMPLEADOS Y SUELDOS DESPUÉS DE LA SUBIDA ---");
        empleadoDAO.listarEmpleadosYSueldos();

        /*
         * Cambio el teléfono de un cliente y lo actualizo en la base de datos.
         */
        System.out.println("\n--- PRUEBA DE ACTUALIZACIÓN DE CLIENTE ---");
        cliente1.setTelefono("699999999");
        clienteDAO.actualizar(cliente1);

        Cliente clienteActualizado = clienteDAO.buscarPorNif("10000001A");

        if (clienteActualizado != null) {
            System.out.println("Cliente actualizado: " + clienteActualizado);
        }

        /*
         * Cambio el precio de un coche y lo actualizo en la base de datos.
         */
        System.out.println("\n--- PRUEBA DE ACTUALIZACIÓN DE COCHE ---");
        coche2.setPrecio(11900.00);
        cocheDAO.actualizar(coche2);

        Coche cocheActualizado = cocheDAO.buscarPorMatricula("2222BBB");

        if (cocheActualizado != null) {
            System.out.println("Coche actualizado: " + cocheActualizado);
        }

        /*
         * Aquí no elimino los datos al final porque quiero poder revisar
         * desde phpMyAdmin que se han insertado y actualizado correctamente.
         */
        System.out.println("\n======================================");
        System.out.println(" PROGRAMA FINALIZADO CORRECTAMENTE");
        System.out.println("======================================");
    }
}