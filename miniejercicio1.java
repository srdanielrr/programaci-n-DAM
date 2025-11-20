

import java.util.Scanner; // importamos para poder leer datos.
// import java.util.Arrays; //se podría hacer más óptimo con arrays pero no lo usamos esta vez.

public class miniejercicio1 {
	
	public static void main(String[] args) {
        
		
										//Ejercicio 1//
		
	
		
		  System.out.print("Ejercicio 1" +  "\n");
		
		  Scanner sc = new Scanner(System.in); // inicializamos scanner.
		  
		  //pedimos al usuario los valores y los asignamos a las variables.
		 
		    System.out.print("Introduce tres números " + "\n");
		 
		    System.out.print("Primer número:  ");
	        int num_1 = sc.nextInt();
	        
	        System.out.print("Segundo número: ");
	        int num_2 = sc.nextInt();
	        
	        System.out.print("Tercer número: ");
	        int num_3 = sc.nextInt();
	        
	        String tipo_orden;
	        
	        //Bucle while para que vuelva a pedir la opción si no se elige ninguna de ellas(a,b).
	        
	        while (true) {
	        	
                System.out.print("\nElige el tipo de ordenación: a) ascendente  b) descendente ");
              //.trim devuelve la cadena sin espacios.
              //.tolowercase devuelve la cadena sin mayúsculas.
                tipo_orden = sc.next().trim().toLowerCase(); 
                
                //si es distinta la respuesta se vuelve a preguntar, sino continua el programa.
                if (tipo_orden.equals("a") || tipo_orden.equals("b")) break;
               
                System.out.println("Introduce a o b");
            }
	        
	        //Aquí ordenamos los números sin arrays
	        
	        //La idea es colocar el menor a la izquierda y el mayor a la derecha usando
	        // la variable "numguarda" como variable temporal.
	        
	        if (num_1 > num_2) { 
	        	
	        	int numguarda = num_1; // variable temporal se iguala al valor de num1 si se cumple el if
	        	num_1 = num_2; //movemos el menor a la "izquierda".
	        	num_2 = numguarda;  //el mayor queda a la "derecha".
	        	
	        }
            
	        if (num_2 > num_3) { 
            	
            	int numguarda = num_2; 
            	num_2 = num_3;  // movemos el menor hacia el centro.
            	num_3 = numguarda; // el mayor queda al final.
            	
            }
	        
	     // Repetimos la primera comparación por si el paso 2
	     // desordenó de nuevo los dos primeros.
            
            if (num_1 > num_2) { 
            	
            	int numguarda = num_1; 
            	num_1 = num_2; 
            	num_2 = numguarda; 
            	
            }

	        //Usamos sentencia switch para elegir el orden
            
            //declaramos variable.
	        
	        
            
	        switch(tipo_orden) {
	        
	        case "a": 
	        	System.out.println("Ordenando de manera ascendente...");
	        	System.out.print("Ascendente: " + num_1 + ", " + num_2 + ", "  + num_3 + "." );
	        	
	        break;
	        
	        case "b": 
	        	System.out.println("Ordenando de manera descendente...");
	        	System.out.print("Descendente: " + num_3 + ", " + num_2 + ", "  + num_1 + "." );
	        	
	        break;
	        
	   
	
	}
	        sc.close();
	}
}

