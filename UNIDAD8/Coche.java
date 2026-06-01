package concesionario;

/*
 * Clase Coche.
 * Representa un coche del concesionario.
 * 
 * Algunos nombres en Java los escribo en camelCase para que queden más claros:
 * tipoVehiculo, garantiaMeses y antiguoPropietario.
 * 
 * Luego, en el DAO, esos nombres se relacionan con los campos reales de la tabla:
 * tipo_vehiculo, garantia_meses y antiguo_propietario.
 */
public class Coche {

    private String matricula;
    private String modelo;
    private String tipoVehiculo;
    private double precio;
    private String color;
    private int kilometros;
    private Integer garantiaMeses;
    private String antiguoPropietario;

    
     // Constructor 
     
    //Uso Integer en garantiaMeses en vez de int porque puede valer null cuando el coche no tenga garantía.
    
    public Coche(String matricula, String modelo, String tipoVehiculo, double precio, String color, int kilometros, Integer garantiaMeses, String antiguoPropietario) {
                
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.precio = precio;
        this.color = color;
        this.kilometros = kilometros;
        this.garantiaMeses = garantiaMeses;
        this.antiguoPropietario = antiguoPropietario;
    }

   //getters 
    
    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getColor() {
        return color;
    }

    public int getKilometros() {
        return kilometros;
    }

    public Integer getGarantiaMeses() {
        return garantiaMeses;
    }

    public String getAntiguoPropietario() {
        return antiguoPropietario;
    }

   //setters
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public void setGarantiaMeses(Integer garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public void setAntiguoPropietario(String antiguoPropietario) {
        this.antiguoPropietario = antiguoPropietario;
    }

   //manera más legíble por consola
    
    @Override
    public String toString() {
        return matricula + " - " + modelo + " | " + tipoVehiculo
                + " | " + color + " | " + precio + " € | "
                + kilometros + " km";
    }
}