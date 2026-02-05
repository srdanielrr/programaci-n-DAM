package pokemongo;

public class PokemonPlanta extends Pokémon {
	
	//declaración de atributos privates
	
    private String tipoPlanta;
    private int latigoCepa;

    //constructor vacío
    
    public PokemonPlanta() {
        super();
    }
    //Constructor con parámetros
    
    public PokemonPlanta(String nombre, int nivel, int tamano, String tipoPlanta, int latigoCepa) {
        super(nombre, nivel, tamano);
        this.tipoPlanta = tipoPlanta;
        this.latigoCepa = latigoCepa;
    }
    //Getters y setters
    
    public String getTipoPlanta() {
        return tipoPlanta;
    }

    public void setTipoPlanta(String tipoPlanta) {
        this.tipoPlanta = tipoPlanta;
    }

    public int getLatigoCepa() {
        return latigoCepa;
    }

    public void setLatigoCepa(int latigoCepa) {
        this.latigoCepa = latigoCepa;
    }

    // Método planta
    
    public String usarLatigoCepa() {
        return "¡Látigo cepa!";
    }
}
