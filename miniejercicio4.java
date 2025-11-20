import java.util.Scanner; //En este caso podríamos declarar "(java.util.Locale.US)" para aceptar puntos (".").
public class miniejercicio4 {
	
	
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Cálculo de IMC: ");
		
		
	double peso, altura; //declaramos variables.
		
	     //Creamos 2 do-while para en caso de obtener un dato erróneo pedirlo el necesario.
	        do {
	            System.out.print("Introduce tu peso en (kg): ");
	            peso = sc.nextDouble();
	            if (peso < 30 || peso > 300) {
	                System.out.println("Introduzca un peso entre (30–300). Intentelo de nuevo.");
	            }
	        } while (peso < 30 || peso > 300);

	      
	        do {
	            System.out.print("Introduce tu altura en (m): ");
	            altura = sc.nextDouble();
	            if (altura < 1.30 || altura > 2.00) {
	                System.out.println("Introduzca una altura entre (1,30–2,00). Intentelo de nuevo.");
	            }
	        } while (altura < 1.30 || altura > 2.00);
	        
	        
	   double indice_mc = peso/(altura * altura); //operación IMC.
	        
	   String imc; //variable string para mostrar en pantalla el rango imc.
	   
	        if (indice_mc < 18.5) {
	        	imc = "Bajo peso";
	        } else if (indice_mc <= 24.9) { // 18.5–24.9
	        	imc = "Normal";
	        } else if (indice_mc <= 29.9) { // 25.0–29.9
	        	imc = "Sobrepeso";
	        } else {
	        	imc = "Obesidad";
	        }
	        
	        System.out.println("El IMC es: " + indice_mc);
	        System.out.println("tu rango es: " + imc);
	        
	        sc.close();
		
}
}


	
	
	

