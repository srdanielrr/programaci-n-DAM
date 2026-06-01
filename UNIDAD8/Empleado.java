package concesionario;

/*
 * La clase empleado la uso para representar a un trabajador del concesionario.
 * Los atributos coinciden con la bd.
 */


public class Empleado {

    private String nif;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String telefono;
    private String email;
    private double sueldo;

 //constructor empleado
    
    public Empleado(String nif, String nombre, String apellido1, String apellido2,
                    String direccion, String telefono, String email, double sueldo) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.sueldo = sueldo;
    }

  //getters
    
    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public double getSueldo() {
        return sueldo;
    }

    //setters
    
    
    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    //más legible por consola
    
    @Override
    public String toString() {
        return nif + " - " + nombre + " " + apellido1 + " " + apellido2
                + " | " + direccion + " | " + telefono + " | " + email
                + " | Sueldo: " + sueldo + " €";
    }
}