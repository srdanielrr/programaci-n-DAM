import java.util.Scanner;
public class miniejercicio5 {

	public static void main(String[] args) {
		
		
		
		 //Escribe un programa en Java que muestre y cuente los números que son múltiplos 
		 //de 2 o de 3 que hay entre 1 y 100.  
		 
		
		Scanner sc = new Scanner(System.in); 
		int contadornum=0;
		while(true) {
		
		System.out.println("Elija de que número quiere saber los múltiplos entre 1-100: a)2 b)3");
		
			String num = sc.next().toLowerCase();
			
			
			if(num.equals("a")) {
			System.out.println("El número elegido es el 2: ");
			
			for(int i=2; i <= 100; i=i+2) {
				
				System.out.println("múltiplos de 2: " + i);
				contadornum ++;
			}
			
			
			}else if(num.equals("b")){
				System.out.println("El número elegido es el 3: ");
				for(int t=3; t <= 100; t=t+3) {
					
					System.out.println("múltiplos de 3: " + t );
					
					contadornum++;
					
				}
				
				
				
			}
			
			 if (num.equals("a") || num.equals("b")) break;
		
		
	} System.out.println("\n" + "Total: " + contadornum);
	
}
}
