package packageinfo;
import java.io.File;
import java.io.IOException;

//Crear directorio sino existe se crea
//Dentro del directorio crear 3 ficheros vacíos sino existen los creamos


public class Uno {
    public static void main(String[] args) {

        File carpeta = new File("C:/EjerciciosStreams");

        // Comprobamos si existe o no y lo creamos si es necesario
        
        if (!carpeta.exists()) { // si no existe devuelve true
            if (carpeta.mkdirs()) { // si podemos crearla devolvemos carpeta creada
                System.out.println("Carpeta creada.");
            } else {
                System.out.println("No se pudo crear la carpeta.");
                return;
            }
        } else {
            System.out.println("La carpeta ya existe.");
        }
        
        //Creamos los ficheros

        File a = new File(carpeta, "docuA.txt");
        File b = new File(carpeta, "docuB.txt");
        File c = new File(carpeta, "docuC.txt");

        try {
            if (!a.exists()) a.createNewFile();
            if (!b.exists()) b.createNewFile();
            if (!c.exists()) c.createNewFile();
            System.out.println("Archivos creados vacíos." + a + b + c);
        } catch (IOException e) { // capturo la excepción IOEXCEPTION ya que métodos o archivos que abren/crean/escriben suelen lanzar ioexcepcion
            e.printStackTrace();
        }
    }
}