package packageinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Cuatro {

    public static void main(String[] args) {
        
        BufferedReader br = null; //declaramos variable para leer texto
        
        try {
            // Previamente creamos datos dentro de la ruta
        	// Inicializamos carpeta contenedora datos.txt
        	
            File datos = new File("C:/EjerciciosStreams/datos.txt");
            
            // Comprobamos si el archivo existe datos.txt
            
            if (datos.exists()) {
                
                // Se abre el archivo en modo lectura
            	
                br = new BufferedReader(new FileReader(datos));
                
                String linea;
                
                System.out.println("Contenido del directorio telefónico:");
                
                // Lee línea a línea hasta que llegue al final del archivo
                
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                
            } else {
                System.out.println("No existe datos.txt");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cierra el flujo de lectura si fue creado
            	
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}