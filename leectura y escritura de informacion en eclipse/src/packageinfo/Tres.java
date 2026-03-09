package packageinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Tres {
    public static void main(String[] args) {

        File carpeta = new File("C:/EjerciciosStreams"); //carpeta contenedora
        File docuB = new File(carpeta, "docuB.txt"); // archivo y carpeta
        
        // si no existe "docub.txt" paramos la ejecución con return

        if (!docuB.exists()) {
            System.out.println("No existe docuB.txt. Ejecuta primero Uno.java");
            return;
        }

        BufferedReader br = null; //inicializamos variables vacías
        PrintWriter out = null;

        try {
            // Inicializamos variable para leer por teclado
        	
            br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Introduce la base: ");
            double base = Double.parseDouble(br.readLine().replace(',', '.'));

            System.out.print("Introduce la altura: ");
            double altura = Double.parseDouble(br.readLine().replace(',', '.'));

            // Calcular área
            
            double area = (base * altura) / 2.0;

            // Guardar en docuB.txt
            
            out = new PrintWriter(new FileWriter(docuB, false)); // Inicializamos "out" para escribir en la ruta/archivo docuB, sobrescribiendo su contenido.
            out.println("Base: " + base);
            out.println("Altura: " + altura);
            out.println("Área del triángulo: " + area);

            System.out.println("Área del triángulo guardada en la ruta: " + docuB.getAbsolutePath());

        } catch (IOException e) { // capturamos errores de entrada/salida por si falla/archivo no existe/no se abre etc
            e.printStackTrace();
            
        } catch (NumberFormatException e) { // capturamos errores de conversión de texto a número
            System.out.println("Error: has introducido un número mal.");
        } finally {
            if (out != null) out.close(); // se ejecuta si o si haya catch o no, para cerrar los recursos y limpieza tras haber creado algo dentro de out
            try {
                if (br != null) br.close(); // aquí lo mismo, si en el objeto br hay algo distinto a null se cierra
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}