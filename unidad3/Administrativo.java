package unidad3;

//Clase Administrativo

		public class Administrativo extends Empleado{
		
		private String HerramientasAdministrativas;
		
		
		public Administrativo(String HerramientasAdministrativas,String nombre,int edad,String apellidos,String puesto_trabajo,double sueldo,String nombre_completo, int añoinicio) {
			
			super(nombre, edad, apellidos, puesto_trabajo, sueldo, nombre_completo, añoinicio);
			this.HerramientasAdministrativas=HerramientasAdministrativas;
			
		}
		
	//getter y setter administrativo
	
			public String getHerramientasAdmin() {
				
				return HerramientasAdministrativas;
				
			}
			
			public void setHerramientasAdmin(String HerramientasAdministrativas) {
				
				this.HerramientasAdministrativas=HerramientasAdministrativas;
			}
			
			//método administrativo
			
			public void Crearnomina(String nomina) {
			        System.out.println("El administrativo " + getnombre_completo()
			                + " está realizando: " + nomina);
			    }
			
			
		
	}