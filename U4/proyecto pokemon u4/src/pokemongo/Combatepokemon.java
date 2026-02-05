package pokemongo;

public class Combatepokemon {

   
    private Pokémon Pokemon1º;
    private Pokémon Pokemon2º;

    // Constructor vacío
    
    public Combatepokemon() {
    }

    // Constructor con parámetros
    
    public Combatepokemon(Pokémon Pokemon1º, Pokémon Pokemon2º) {
    	
        this.Pokemon1º = Pokemon1º;
        this.Pokemon2º = Pokemon2º;
    }

    // Getters y setters
    public Pokémon getPokemon1() {
        return Pokemon1º;
    }

    public void setPokemon1(Pokémon Pokemon1º) {
        this.Pokemon1º = Pokemon1º;
    }

    public Pokémon getPokemon2º() {
        return Pokemon2º;
    }

    public void setPokemon2(Pokémon Pokemon2º) {
        this.Pokemon2º = Pokemon2º;
    }

    // Método Combate
    
    // Este método NO es void porque queremos devolver el resultado del combate
    // Al devolver un Pokémon (o null si hay empate) podemos GUARDAR el ganador en una variable en el main:
    // Si el método fuera void, solo podría imprimir por pantalla
    //(**recordatorio propio**)
    
    
    public Pokémon combatefinal() {
    	
    	//Condicional para ver qué pokemon tiene más nivel
    	
        if (Pokemon1º.getNivel() > Pokemon2º.getNivel()) {
        	
        	// **Recordatorio**
        	// Para poder añadir en esta clase combate la habilidad fuego/viento/planta no puedo llamar al método desde aquí porque son métodos
        	// de las subclases para ello debería crear un método habilidad en la superclase y sobreescribir con override
        	//para poder llamarlo desde aquí a la habilidad.
        	
        	System.out.println("Gana el pokemon número 1: ");
            return Pokemon1º;
            
        } else if (Pokemon2º.getNivel() > Pokemon1º.getNivel()) {
        	System.out.println("Gana el pokemon número 2: ");
            return Pokemon2º;
            
        } else {
        	
        	System.out.print("empate");
            return null; 
        }
    }
}
