package concesionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Esta clase se encarga de conectar el programa Java con la base de datos MySQL.
 * phpMyAdmin solo lo uso para crear y ver la base de datos, pero Java se conecta directamente al servidor MySQL de XAMPP.
 */
public class ConexionBD {

    /*
     * Datos necesarios para conectar con MySQL.
     * En XAMPP normalmente el usuario es root y la contraseña está vacía.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/concesionario?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    /*
     * Este método abre la conexión con la base de datos.
     * Lo usarán los DAO cada vez que tengan que insertar, consultar,
     * actualizar o borrar datos.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    /*
     * Método para comprobar si la conexión funciona.
     
     * Lo llamaré al principio del main para saber si MySQL está encendido
     * y si la base de datos concesionario existe.
     
     * Si esto falla, no tendría sentido seguir intentando insertar o consultar datos,
     * porque todo lo demás también falla.
     */
    
    // Try-catch para comprobar si es válida o no la conexión y capturar el error.
    
    public static void probarConexion() {
        try (Connection conexion = getConnection()) {
            System.out.println("Conexión correcta con la base de datos.");
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar con la base de datos.");
            System.out.println("Detalle del error: " + e.getMessage());
        }
    }
}