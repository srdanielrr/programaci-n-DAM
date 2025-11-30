import java.util.Scanner;
public class miniejercicio3 {
	
	
	
	public static void main(String[] args) {
		
		
		
		//Escribe un programa en Java que pida un número por teclado hasta que éste sea positivo. 
		//A continuación, muestra los primeros 20 números sucesivos a dicho número.
		//Utiliza un bucle for.
		
		
		//inicializamos scanner.
		Scanner sc = new Scanner(System.in);
	
		//Creamos bucle while hasta que el número sea positivo.
		while(true) {
			
			System.out.print("Hola, introduce un número por teclado que sea positivo");
			int numero = sc.nextInt();
			
			
			if(numero > 0) {
				
					//Creamos bucle for inicializando i siendo "número + 1" y paramos el bucle
					//cuando el valor de i sea menor/igual a número + 20.
				
				  for (int i = numero + 1; i <= numero + 20; i++) {
					  
					  System.out.println(i);
					  
				  }
			            
				
				break;
			}
		}
		
	
		
	}

}
