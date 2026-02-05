package pokemongo;

public class PokemonFuego extends Pokémon {

		//declaración de atributos privates
		private String tipoFuego;
	    private int tempFuego;

	    // Constructor vacío
	    public PokemonFuego() {
	        super();
	    }
	    //Constructor con parámetros
	    public PokemonFuego(String nombre, int nivel, int tamano, String tipoFuego, int tempFuego) {
	        super(nombre, nivel, tamano);
	        this.tipoFuego = tipoFuego;
	        this.tempFuego = tempFuego;
	    }
	    
	    //Getters y setters
	    
	    public String getTipoFuego() {
	        return tipoFuego;
	    }

	    public void setTipoFuego(String tipoFuego) {
	        this.tipoFuego = tipoFuego;
	    }

	    public int getTempFuego() {
	        return tempFuego;
	    }

	    public void setTempFuego(int tempFuego) {
	        this.tempFuego = tempFuego;
	    }

	    // Método fuego
	    
	    public String fuego() {
	        return "¡Arrasando con llamas!";
	    }
	}




