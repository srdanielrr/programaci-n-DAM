package concesionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/*
 * Estamos operando con la tabla coches.
 * Aquí algunos nombres de Java cambian respecto a SQL:
 * tipoVehiculo -> tipo_vehiculo
 * garantiaMeses -> garantia_meses
 * antiguoPropietario -> antiguo_propietario
 */
public class CocheDAO {

    /*
     * Inserta un coche en la tabla coches.
     */
    public void insertar(Coche coche) {
        String sql = "INSERT INTO coches (matricula, modelo, tipo_vehiculo, precio, color, kilometros, garantia_meses, antiguo_propietario) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, coche.getMatricula());
            ps.setString(2, coche.getModelo());
            ps.setString(3, coche.getTipoVehiculo());
            ps.setDouble(4, coche.getPrecio());
            ps.setString(5, coche.getColor());
            ps.setInt(6, coche.getKilometros());

            /*
             * garantiaMeses puede ser null.
             * Si es null, guardo NULL en la base de datos.
             */
            if (coche.getGarantiaMeses() != null) {
                ps.setInt(7, coche.getGarantiaMeses());
            } else {
                ps.setNull(7, Types.INTEGER);
            }

            ps.setString(8, coche.getAntiguoPropietario());

            ps.executeUpdate();
            System.out.println("Coche insertado correctamente: " + coche.getMatricula());

        } catch (SQLException e) {
            System.out.println("Error al insertar coche: " + e.getMessage());
        }
    }

    /*
     * Lista todos los coches de la base de datos.
     */
    public ArrayList<Coche> listar() {
        ArrayList<Coche> listaCoches = new ArrayList<>();
        String sql = "SELECT * FROM coches";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Integer garantia = rs.getObject("garantia_meses") != null
                        ? rs.getInt("garantia_meses")
                        : null;

                Coche coche = new Coche(
                        rs.getString("matricula"),
                        rs.getString("modelo"),
                        rs.getString("tipo_vehiculo"),
                        rs.getDouble("precio"),
                        rs.getString("color"),
                        rs.getInt("kilometros"),
                        garantia,
                        rs.getString("antiguo_propietario")
                );

                listaCoches.add(coche);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar coches: " + e.getMessage());
        }

        return listaCoches;
    }

    /*
     * Busca un coche por matrícula.
     */
    public Coche buscarPorMatricula(String matricula) {
        String sql = "SELECT * FROM coches WHERE matricula = ?";
        Coche coche = null;

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, matricula);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Integer garantia = rs.getObject("garantia_meses") != null
                            ? rs.getInt("garantia_meses")
                            : null;

                    coche = new Coche(
                            rs.getString("matricula"),
                            rs.getString("modelo"),
                            rs.getString("tipo_vehiculo"),
                            rs.getDouble("precio"),
                            rs.getString("color"),
                            rs.getInt("kilometros"),
                            garantia,
                            rs.getString("antiguo_propietario")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar coche: " + e.getMessage());
        }

        return coche;
    }

    /*
     * Actualiza los datos de un coche.
     * Se usa la matrícula para localizar el coche correcto.
     */
    public void actualizar(Coche coche) {
        String sql = "UPDATE coches SET modelo = ?, tipo_vehiculo = ?, precio = ?, color = ?, "
                   + "kilometros = ?, garantia_meses = ?, antiguo_propietario = ? WHERE matricula = ?";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, coche.getModelo());
            ps.setString(2, coche.getTipoVehiculo());
            ps.setDouble(3, coche.getPrecio());
            ps.setString(4, coche.getColor());
            ps.setInt(5, coche.getKilometros());

            if (coche.getGarantiaMeses() != null) {
                ps.setInt(6, coche.getGarantiaMeses());
            } else {
                ps.setNull(6, Types.INTEGER);
            }

            ps.setString(7, coche.getAntiguoPropietario());
            ps.setString(8, coche.getMatricula());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Coche actualizado correctamente: " + coche.getMatricula());
            } else {
                System.out.println("No se encontró ningún coche con esa matrícula.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar coche: " + e.getMessage());
        }
    }

    /*
     * Elimina un coche usando su matrícula.
     */
    public void eliminar(String matricula) {
        String sql = "DELETE FROM coches WHERE matricula = ?";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, matricula);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Coche eliminado correctamente: " + matricula);
            } else {
                System.out.println("No se encontró ningún coche con esa matrícula.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar coche: " + e.getMessage());
        }
    }

    /*
     * Devuelve el modelo de un coche a partir de su matrícula.
     */
    public String obtenerModeloPorMatricula(String matricula) {
        String sql = "SELECT modelo FROM coches WHERE matricula = ?";
        String modelo = null;

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, matricula);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    modelo = rs.getString("modelo");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el modelo del coche: " + e.getMessage());
        }

        return modelo;
    }
}