package unidad3;

public class Main {
	
    public static void main(String[] args) {

        // Creamos un informático
        Informatico informatico = new Informatico(
                "Python",           	 // CodigoUsado
                "Daniel",           	 // nombre
                30,               		 // edad
                "Ruiz-Ruano",            // apellidos
                "Informático",    		 // puesto_trabajo
                2010,           		 // sueldo
                "Daniel Ruiz-Ruano",     // nombre_completo
                2000             		 // añoinicio
        );

        // Métodos del informático y heredados de empleado
        informatico.infoempleado();
        System.out.println(); // "\n"
        System.out.println("Años trabajados: " + informatico.añostrabajados());
        System.out.println("Sueldo anual: " + informatico.sueldoanual());
        informatico.ProblemasOnline("Problemas BD molino de aceite (phpmyadmin) ");

        System.out.println("------------------------------------");

        // Crear un administrativo
        Administrativo admin = new Administrativo(
                "Word, Excel",    // HerramientasAdministrativas
                "Pilarica",
                29,
                "Pérez",
                "Administrativa",
                1400.0,
                "Pilarica Pérez",
                2021
        );

        //usamos métodos como antes heredados y del propio admin
        
        admin.infoempleado();
        System.out.println();
        admin.Crearnomina("Nómina de enero");
        
        

        System.out.println("------------------------------------------------");

        // Crear un contable
        Contable conta = new Contable(
                "Microsoft excel",
                "Luisito",
                45,
                "Comunica",
                "Contable",
                1600.0,
                "Luisito comunica",
                2011
        );

        conta.infoempleado();
        System.out.println();
        conta.Calcularbalanceaceituna("aceitunas de la campaña 2024");
    }
}
