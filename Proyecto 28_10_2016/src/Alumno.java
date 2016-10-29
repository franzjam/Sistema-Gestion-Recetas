import java.util.ArrayList;


public class Alumno extends Persona{
	private String contrasena;
	private ArrayList<Receta> recetas;
	private ListaReceta listaRecetas;
	
	
	
	
	
	
	
	
	
	
	
	public Alumno()
	{
		this ("","","","","",0,0);
		this.contrasena = "";
	}

	
	
	
	
	
	
	
	

	public Alumno(String nombrePersona, String rut, String direccion,
			String correo, String sexo, int edad, int telefono, String contrasena)
	{
		super(nombrePersona, rut, direccion, correo, sexo, edad, telefono);
		recetas=new ArrayList<Receta>();
		this.setContrasena(contrasena);
		listaRecetas= new ListaReceta();
	}

	
	
	
	
	
	
	
	
	
	
	public Alumno(String nombrePersona, String rut, String direccion,
			String correo, String sexo, int edad, int telefono)
	{
		super(nombrePersona, rut, direccion, correo, sexo, edad, telefono);
		recetas=new ArrayList<Receta>();
		listaRecetas= new ListaReceta();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
















	public String getContrasena() {
		return contrasena;
	}










	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}










	public ArrayList<Receta> getRecetas() {
		return recetas;
	}










	public void setRecetas(ArrayList<Receta> recetas) {
		this.recetas = recetas;
	}










	public ListaReceta getListaRecetas() {
		return listaRecetas;
	}










	public void setListaRecetas(ListaReceta listaRecetas) {
		this.listaRecetas = listaRecetas;
	}










	public Alumno(String nombrePersona)
	{
		super(nombrePersona);
	}
	
	
	
	
	
	
	
	
	//se genera una contraseña estadar para el usuario
		public String generarContraseña(String rut) 
		{
			int pass, i, digito = 0, aux = 0;
			String contrasena;
			pass = Integer.parseInt(rut);

			for(i=0;i<5;i++)				//se obtienen los ultimos digitos del rut
			{								//y se convierte en la contraseña
				digito = pass%10;
				pass = pass/10;
				aux = aux*10 + digito;
			}
			this.contrasena = String.valueOf(aux);
			contrasena = String.valueOf(aux);
			return contrasena;
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString()
	{

		return getNombrePersona()+" \n";
	}
}

