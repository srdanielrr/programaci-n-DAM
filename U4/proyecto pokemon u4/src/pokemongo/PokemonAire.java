package pokemongo;

public class PokemonAire extends Pokémon {
	//declaración atributos privates
	
    private String tipoAire;
    private int ataqueBase;
    //Constructor vacío
    
    public PokemonAire() {
        super();
    }
    //Constructor con parámetros
    
    public PokemonAire(String nombre, int nivel, int tamano, String tipoAire, int ataqueBase) {
        super(nombre, nivel, tamano);
        this.tipoAire = tipoAire;
        this.ataqueBase = ataqueBase;
    }
    //Getters y setters
    
    public String getTipoAire() {
        return tipoAire;
    }

    public void setTipoAire(String tipoAire) {
        this.tipoAire = tipoAire;
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public void setAtaqueBase(int ataqueBase) {
        this.ataqueBase = ataqueBase;
    }

    // Método aire
    
    public String viento() {
        return "viento a discrepción";
    }
}
