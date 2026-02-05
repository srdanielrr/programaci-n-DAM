package pokemongo;

public class Pokémon {

    // Atributos privados
	
    private String nombre;
    private int nivel;
    private int tamano;

    // Constructor vacío
    
    public Pokémon() {
    }

    // Constructor con parámetros
    
    public Pokémon(String nombre, int nivel, int tamano) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tamano = tamano;
    }

    // Getters y setters 
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
}

