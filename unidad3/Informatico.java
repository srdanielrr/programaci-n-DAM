package unidad3;

//Clase informático

	public class Informatico extends Empleado{
		
		private String CodigoUsado;
		
		public Informatico(String CodigoUsado,String nombre,int edad,String apellidos,String puesto_trabajo,double sueldo,String nombre_completo, int añoinicio) {
			
			super(nombre, edad, apellidos, puesto_trabajo, sueldo, nombre_completo, añoinicio);
			this.CodigoUsado=CodigoUsado;
			
		}
		
		//getter y setter informático
		
		public String getCodigoUsado() {
			
			return CodigoUsado;
			
		}
		
		public void setCodigoUsado(String CodigoUsado) {
			
			this.CodigoUsado=CodigoUsado;
		}
		
		//método informático
		
		 public void ProblemasOnline(String problemasonline) {
		        System.out.println("El informático " + getnombre_completo()
		                + " está arreglando: " + problemasonline);
		    }
		
		
	}
	