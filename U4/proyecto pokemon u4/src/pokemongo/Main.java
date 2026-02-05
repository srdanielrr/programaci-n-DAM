package pokemongo;

public class Main {

    public static void main(String[] args) {

        // SUBCLASES POKEMON
    	
        PokemonFuego pFuego = new PokemonFuego("Charizard", 222, 601, "Fuego", 900);
        PokemonPlanta pPlanta = new PokemonPlanta("Bulbasaur", 121, 710, "Planta", 25);
        PokemonAire pAire = new PokemonAire("Rayquaza", 21, 910, "Aire dragón", 225);

        // Entrenadores 1 + 2 + asignación del Pokémon compañero con constructor con parámetros
        
        Entrenador entrenador1 = new Entrenador("Ash Ketchup", 150, 16, "Pueblo Paleta", pFuego);
        Entrenador entrenador2 = new Entrenador("Misty", 120, 17, "Celeste", pPlanta);
        
        //  Entrenador 3 con constructor vacío
        
        //Como tenemos el constructor vacío le modificamos su contenido con el método setter
        
        Entrenador entrenador3 = new Entrenador();
        entrenador3.setNombre("Brock");
        entrenador3.setExp(90);
        entrenador3.setEdad(18);
        entrenador3.setLugarNacimiento("Ciudad Plateada");
        entrenador3.setPokemonCompanero(pAire);

        // Mostrar datos por consola
        
        System.out.println("🥊🥊🥊DATOS DE ENTRENADORES Y SUS POKEMON🥊🥊🥊");

        System.out.println("Entrenador 1: " + entrenador1.getNombre()+"🥋");
        System.out.println("  Experiencia: " + entrenador1.getExp());
        System.out.println("  Edad: " + entrenador1.getEdad());
        System.out.println("  Lugar nacimiento: " + entrenador1.getLugarNacimiento());
        
        //***Recordatorio propio***:
        //para poder leer el nivel y el tamaño del pokemon, como al objeto entrenador le asociamos la referencia pokemon
        //podemos llamarlo entrando a entrenador + llamando a la asociación  + y así usar el getter de nivel/tamaño
        
        System.out.println("  Pokémon en propiedad: " + entrenador1.getPokemonCompañero().getNombre()+ " | Nivel: " + entrenador1.getPokemonCompañero().getNivel()
        					+ " | Tamaño: " + entrenador1.getPokemonCompañero().getTamano()+ " | Habilidad: " +
        					pFuego.fuego());

        System.out.println();

        System.out.println("Entrenador 2: " + entrenador2.getNombre()+"🥋");
        System.out.println("  Experiencia: " + entrenador2.getExp());
        System.out.println("  Edad: " + entrenador2.getEdad());
        System.out.println("  Lugar nacimiento: " + entrenador2.getLugarNacimiento());
        System.out.println("  Pokémon en propiedad: " + entrenador2.getPokemonCompañero().getNombre()
                			+ " | Nivel: " + entrenador2.getPokemonCompañero().getNivel()
                			+ " | Tamaño: " + entrenador2.getPokemonCompañero().getTamano() + " | Habilidad: "
                			+ pPlanta.usarLatigoCepa());

        System.out.println();
       
        

        System.out.println("Entrenador 3: " + entrenador3.getNombre()+"🥋");
        System.out.println("  Experiencia: " + entrenador3.getExp());
        System.out.println("  Edad: " + entrenador3.getEdad());
        System.out.println("  Lugar nacimiento: " + entrenador3.getLugarNacimiento());
        System.out.println("  Pokémon en propiedad: " + entrenador3.getPokemonCompañero().getNombre()
                			+ " | Nivel: " + entrenador3.getPokemonCompañero().getNivel()
                			+ " | Tamaño: " + entrenador3.getPokemonCompañero().getTamano()+ " | Habilidad: " +
                			pAire.viento());
        
        System.out.println();
        
        System.out.println("⚔️⚔️⚔⚔️⚔️¿ARE YOU READY FOR THE NEXT BATTLE?⚔️⚔️⚔️⚔️");

        // Crear combate 
        
        Combatepokemon combate = new Combatepokemon(entrenador1.getPokemonCompañero(),entrenador2.getPokemonCompañero());

        // Guardar el combatefinal() en la variable como comentamos en la clase combate para evitar errores
        
        Pokémon ganador = combate.combatefinal();

        // Ganador combate
        
     
        System.out.println();
        
        System.out.println("Nivel " + entrenador1.getPokemonCompañero().getNombre() + ": "
                			+ entrenador1.getPokemonCompañero().getNivel());
        System.out.println("       ⚔️      ");
        System.out.println("Nivel " + entrenador2.getPokemonCompañero().getNombre() + ": "
        					+ entrenador2.getPokemonCompañero().getNivel());
        
        if (ganador != null) {
            System.out.println("Ganador = 🏆🏆🏆🏆" + ganador.getNombre()+"🏆🏆🏆🏆");
            
        }
    }
}
