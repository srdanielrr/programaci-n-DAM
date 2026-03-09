package packageinfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Dos {
    public static void main(String[] args) {

        File carpeta = new File("C:/EjerciciosStreams"); //inicializamos carpeta
        File docuA = new File(carpeta, "docuA.txt"); //inicializamos archivo y lo metemos en carpeta

        //  Comprobamos que existe el archivo y sino paramos
        
        if (!docuA.exists()) {
            System.out.println("No existe docuA.txt. Ejecuta primero Uno.java");
            return;
        }

        PrintWriter out = null; // creamos variable "out" que es un objeto para escribir texto

        try {
            // Abrir en modo escritura 
        	
            out = new PrintWriter(new FileWriter(docuA, false)); // inicializamos el objeto, con los dos parámetros
         // El 2º parámetro de FileWriter es "append":
         // false -> reescribe el fichero desde cero
         // true  -> añade el contenido al final del fichero cosa que no interesa

            // Escribir 0 a 10 utilizando un bucle for
            
            for (int i = 0; i <= 10; i++) {
                out.println(i);
            }

            System.out.println("Números de  0-10: " + docuA.getAbsolutePath());

        } catch (IOException e) { //capturamos exception típica
            e.printStackTrace();
            
        } finally { // usamos finally para asegurar que el archivo se cierre si o si pq al terminar el try/catch entra en el finally
            if (out != null) out.close(); // si out no es null, es decir ,  si se llegó a abrir el archivo entonces lo cierro
        }
    }
}