package concesionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



 // Aquí están las operaciones CRUD
 
public class ClienteDAO {

  //INSERTAR NUEVO CLIENTE
	
    public void insertar(Cliente cliente) {
        
    	String sql = "INSERT INTO clientes (nif, nombre, apellido1, apellido2, direccion, telefono, email) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cliente.getNif());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido1());
            ps.setString(4, cliente.getApellido2());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getTelefono());
            ps.setString(7, cliente.getEmail());

            ps.executeUpdate();
            System.out.println("Cliente insertado correctamente: " + cliente.getNombre());

        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
        }
    }

    /*
     * SELECT de la tabla clientes(todos)
     * Los guarda en una lista para poder mostrarlos después por consola.
     */
    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
       
        String sql = "SELECT * FROM clientes";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            /*
             * Este bucle recorre todas las filas que devuelve la consulta.
             * Cada fila de la tabla se convierte en un objeto Cliente.
             */
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("nif"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                );

                listaClientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }

        return listaClientes;
    }

    /*
     * Busca un cliente por su NIF.
     * Si lo encuentra, devuelve un objeto Cliente.
     * Si no lo encuentra, devuelve null.
     */
    public Cliente buscarPorNif(String nif) {
        String sql = "SELECT * FROM clientes WHERE nif = ?";
        Cliente cliente = null;

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nif);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente(
                            rs.getString("nif"),
                            rs.getString("nombre"),
                            rs.getString("apellido1"),
                            rs.getString("apellido2"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar cliente: " + e.getMessage());
        }

        return cliente;
    }

    /*
     * Actualiza los datos de un cliente.
     * Se usa el NIF para saber qué cliente hay que modificar.
     */
    public void actualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre = ?, apellido1 = ?, apellido2 = ?, "
                   + "direccion = ?, telefono = ?, email = ? WHERE nif = ?";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido1());
            ps.setString(3, cliente.getApellido2());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getNif());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Cliente actualizado correctamente: " + cliente.getNif());
            } else {
                System.out.println("No se encontró ningún cliente con ese NIF.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        }
    }

    /*
     * Elimina un cliente de la base de datos usando su NIF.
     */
    public void eliminar(String nif) {
        String sql = "DELETE FROM clientes WHERE nif = ?";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nif);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Cliente eliminado correctamente: " + nif);
            } else {
                System.out.println("No se encontró ningún cliente con ese NIF.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
    }
}