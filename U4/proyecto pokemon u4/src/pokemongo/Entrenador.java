package pokemongo;

public class Entrenador {
	
	//Atributos entrenador privates
	
	private String nombre;
	private int exp;
	private int edad;
	private String lugarnacimiento;
	private Pokémon pokemonCompañero;
	

	
	 // Constructor vacío 
	
    public Entrenador() {
    }
    
    //Constructor con parámetros
    //Se añade la unión con pokemonCompañero(unión entre entrenador y pokémon)
    //Añadimos pokemon que "forme parte" de entrenador es decir cada objeto entrenador contiene una referencia a un objeto pokemon

	public Entrenador(String nombre, int exp, int edad, String lugarnacimiento,Pokémon pokemonCompañero) {
       
        this.nombre = nombre;
        this.exp = exp;
        this.edad = edad;
        this.lugarnacimiento=lugarnacimiento;
        this.pokemonCompañero=pokemonCompañero;
	
	}
	  // Getters y setters
    
	public String getNombre() { 
		return nombre; 
		}
	
    public void setNombre(String nombre) { 
    	this.nombre = nombre; 
    	}
    

    public int getExp() { 
    	return exp; 
    	}
    
    public void setExp(int exp) { 
    	this.exp = exp; 
    	}
    

    public int getEdad() { 
    	return edad; 
    	}
    
    public void setEdad(int edad) { 
    	this.edad = edad; 
    	
    }
    

    public String getLugarNacimiento() { 
    	return lugarnacimiento; 
    	}
    public void setLugarNacimiento(String lugarnacimiento) { 
    	this.lugarnacimiento = lugarnacimiento; 
    	}

    public Pokémon getPokemonCompañero() { 
    	return pokemonCompañero; 
    	}
    public void setPokemonCompanero(Pokémon pokemonCompañero) { 
    	this.pokemonCompañero = pokemonCompañero; 
    	}
    }
	
	


