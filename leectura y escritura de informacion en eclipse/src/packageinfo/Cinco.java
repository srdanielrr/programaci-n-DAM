package packageinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Cinco {

    public static void main(String[] args) {

        BufferedReader br = null;
        RandomAccessFile raf = null;

        try {
            // Archivo que se va a leer
        	
            File datos = new File("C:/EjerciciosStreams/datos.txt");

            // Archivo aleatorio que se va a crear
            
            File datosAleatorio = new File("C:/EjerciciosStreams/datosAleatorio");

            // Comprueba si existe el archivo 
            
            if (datos.exists()) {

                // Abre datos.txt en modo lectura
            	
                br = new BufferedReader(new FileReader(datos));

                // Crea o abre el archivo aleatorio en modo lectura y escritura
                
                raf = new RandomAccessFile(datosAleatorio, "rw");

                // Borra el contenido anterior para sobrescribirlo
                
                raf.setLength(0);

                String linea;

                // Lee cada línea de datos.txt
                
                while ((linea = br.readLine()) != null) { //lee una línea completa del archivo y devuelve esto como string hasta que no queden mas líneas
                   
                	// Escribe la línea en el archivo de acceso aleatorio
                	
                    raf.writeBytes(linea + System.lineSeparator());
                }

                System.out.println("Archivo datosAleatorio creado correctamente.");

            } else {
                System.out.println("El archivo datos.txt no existe.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (raf != null) raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}