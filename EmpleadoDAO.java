package concesionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Estamos con la tabla empleados para hacer CRUD

public class EmpleadoDAO {

    /*
     * Inserta un empleado en la tabla empleados.
     */
    public void insertar(Empleado empleado) {
        String sql = "INSERT INTO empleados (nif, nombre, apellido1, apellido2, direccion, telefono, email, sueldo) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, empleado.getNif());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellido1());
            ps.setString(4, empleado.getApellido2());
            ps.setString(5, empleado.getDireccion());
            ps.setString(6, empleado.getTelefono());
            ps.setString(7, empleado.getEmail());
            ps.setDouble(8, empleado.getSueldo());

            ps.executeUpdate();
            System.out.println("Empleado insertado correctamente: " + empleado.getNombre());

        } catch (SQLException e) {
            System.out.println("Error al insertar empleado: " + e.getMessage());
        }
    }

    /*
     * Lista todos los empleados de la base de datos.
     */
    public ArrayList<Empleado> listar() {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            /*
             * Recorro el ResultSet.
             * Cada vuelta del while corresponde a una fila de la tabla empleados.
             */
            while (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getString("nif"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getDouble("sueldo")
                );

                listaEmpleados.add(empleado);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }

        return listaEmpleados;
    }

    /*
     * Busca un empleado por su NIF.
     */
    public Empleado buscarPorNif(String nif) {
        String sql = "SELECT * FROM empleados WHERE nif = ?";
        Empleado empleado = null;

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nif);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    empleado = new Empleado(
                            rs.getString("nif"),
                            rs.getString("nombre"),
                            rs.getString("apellido1"),
                            rs.getString("apellido2"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            rs.getDouble("sueldo")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar empleado: " + e.getMessage());
        }

        return empleado;
    }

    /*
     * Actualiza los datos de un empleado.
     * Se localiza por el NIF, que es la clave primaria de la tabla.
     */
    public void actualizar(Empleado empleado) {
        String sql = "UPDATE empleados SET nombre = ?, apellido1 = ?, apellido2 = ?, "
                   + "direccion = ?, telefono = ?, email = ?, sueldo = ? WHERE nif = ?";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido1());
            ps.setString(3, empleado.getApellido2());
            ps.setString(4, empleado.getDireccion());
            ps.setString(5, empleado.getTelefono());
            ps.setString(6, empleado.getEmail());
            ps.setDouble(7, empleado.getSueldo());
            ps.setString(8, empleado.getNif());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Empleado actualizado correctamente: " + empleado.getNif());
            } else {
                System.out.println("No se encontró ningún empleado con ese NIF.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
        }
    }

    /*
     * Elimina un empleado usando su NIF.
     */
    public void eliminar(String nif) {
        String sql = "DELETE FROM empleados WHERE nif = ?";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nif);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Empleado eliminado correctamente: " + nif);
            } else {
                System.out.println("No se encontró ningún empleado con ese NIF.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
        }
    }

    /*
     * Consulta los empleados cuya dirección contiene la palabra indicada.
     * para obtener los empleados de Almería.
     */
    public ArrayList<Empleado> obtenerEmpleadosPorDireccion(String ciudad) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados WHERE direccion LIKE ?";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, "%" + ciudad + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Empleado empleado = new Empleado(
                            rs.getString("nif"),
                            rs.getString("nombre"),
                            rs.getString("apellido1"),
                            rs.getString("apellido2"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            rs.getDouble("sueldo")
                    );

                    empleados.add(empleado);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar empleados por dirección: " + e.getMessage());
        }

        return empleados;
    }

   
     //Muestra todos los empleados junto con su sueldo.
    
    public void listarEmpleadosYSueldos() {
        String sql = "SELECT nombre, apellido1, apellido2, sueldo FROM empleados";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getString("nombre") + " "
                        + rs.getString("apellido1") + " "
                        + rs.getString("apellido2")
                        + " -> Sueldo: " + rs.getDouble("sueldo") + " €"
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al listar empleados y sueldos: " + e.getMessage());
        }
    }

    /*
     * Actualiza el sueldo de todos los empleados un 5%.
     * 
     * Aquí uso un ResultSet actualizable, que permite modificar los datos
     * mientras se recorren los resultados de la consulta.
     */
    public void actualizarSueldosCincoPorCiento() {
        String sql = "SELECT nif, nombre, sueldo FROM empleados";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(
                     sql,
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE
             );
             ResultSet rs = ps.executeQuery()) {

            System.out.println("Sueldos actualizados:");

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                double sueldoActual = rs.getDouble("sueldo");
                double sueldoNuevo = sueldoActual * 1.05;

                /*
                 * updateDouble cambia el valor del sueldo en la fila actual.
                 * updateRow confirma ese cambio en la base de datos.
                 */
                rs.updateDouble("sueldo", sueldoNuevo);
                rs.updateRow();

                System.out.println(nombre + " -> " + sueldoNuevo + " €");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar los sueldos: " + e.getMessage());
        }
    }
}