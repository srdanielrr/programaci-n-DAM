package concesionario;

/*
 * La clase cliente la uso para guardar en Java los datos de un cliente ramdon del concesionario.
 * 
 * Los atributos son private para que no se puedan modificar directamente
 * desde otras clases. Así se accede a ellos mediante getters y setters,
 * que es una forma más segura.
 */
public class Cliente {

    private String nif;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String telefono;
    private String email;

    
     //Constructor de Cliente.

     
    public Cliente(String nif, String nombre, String apellido1, String apellido2,String direccion, String telefono, String email) {
                   
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

   //GETTERS
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

 //SETTERS
    
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

    /*
     * @Override indica que estoy cambiando el comportamiento normal de toString().
     * Lo hago para que, cuando imprima un cliente por consola, se vea con sus datos
     * y no como una dirección rara.
     */
    @Override
    public String toString() {
        return nif + " - " + nombre + " " + apellido1 + " " + apellido2
                + " | " + direccion + " | " + telefono + " | " + email;
    }
}