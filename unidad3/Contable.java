package unidad3;

// clase contable

public class Contable extends Empleado{

private String HerramientasContab;


public Contable(String HerramientasContab,String nombre,int edad,String apellidos,String puesto_trabajo,double sueldo,String nombre_completo, int añoinicio) {
		
		super(nombre, edad, apellidos, puesto_trabajo, sueldo, nombre_completo, añoinicio);
		this.HerramientasContab = HerramientasContab;
		
	}
	
//getter y setter Contable

		public String getHerramientasContab() {
			
			return HerramientasContab;
			
		}
		
		public void setHerramientasContab(String HerramientasContab) {
			
			this.HerramientasContab=HerramientasContab;
		}
		
		//método contable
		
		public void Calcularbalanceaceituna(String aceitunas) {
		        System.out.println("El contable " + getnombre_completo()
		                + " está realizando la contabilidad de: " + aceitunas);
		    }
		
		
	
}