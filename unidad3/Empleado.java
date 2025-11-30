package unidad3;

import java.time.Year;

public class Empleado {
	
	
	//atributos privados y públicos
	
	private int edad;
	String nombre;
	String apellidos;
	private String puesto_trabajo;
	private double sueldo;
	private String nombre_completo;
	private int añoinicio;
	
	
	
	//constructor sin parámetros
	
	public Empleado(){
		
		
	}
	
	
	
	//constructor con parámetros
	//usamos protected para que sólo las subclases puedan utilizar este constructor
	protected Empleado(String nombre,int edad,String apellidos,String puesto_trabajo,double sueldo,String nombre_completo, int añoinicio) {
		
		this.apellidos=apellidos;
		this.edad=edad;
		this.nombre=nombre;
		this.puesto_trabajo=puesto_trabajo;
		this.sueldo=sueldo;
		this.nombre_completo=nombre_completo;
		this.añoinicio=añoinicio;
		
	}
	
	
	//Creamos getters y setters para atributos privates
	
	//GETTER Y SETTER NOMBRECOMPLETO
	
	public String getnombre_completo(){
		
		return nombre_completo;
	}
	
	public void setnombre_completo(String nombre_completo) {
		
		this.nombre_completo=nombre_completo;
		
	}
	
	//GETTER Y SETTER PUESTO

	public String getpuesto_trabajo(){
		
		return puesto_trabajo;
	}
	
	public void setpuesto_trabajo(String puesto_trabajo) {
		
		this.puesto_trabajo=puesto_trabajo;
		
	}
	
	//lo ponemos protected para que sólo las subclases lo puedan leer y modificar
	
	
	//GETTER Y SETTER SUELDO
	protected double getsueldo(){
		
		return sueldo;
	}
	
	protected void setsueldo(double sueldo){
        
		this.sueldo=sueldo;
    }
	
	//GETTER Y SETTER EDAD
	
	public int getedad(){
		
		return edad;
	}
	public void setedad(int edad){
        this.edad=edad;
    }
	
	//getter añoinicio
	public int getañoinicio() {
		
		return añoinicio;
	}
	
//MÉTODOS
	
	public void infoempleado() {
		
		System.out.print("el empleado: " + nombre_completo + ", tiene un sueldo de: " + sueldo);
		
	}
	
	public void mesvacacional() {
		
		System.out.print("el empleado: " + nombre_completo + " tiene el mes de navidad para coger la aceituna");
		
	}
	
	public double sueldoanual() {
		
		return sueldo * 12;
		
	}
	public int añostrabajados() {
		
		
		int añoactual = Year.now().getValue();
		
		int años = añoactual - añoinicio;
		
		return años;
		
		
	}
	
}

