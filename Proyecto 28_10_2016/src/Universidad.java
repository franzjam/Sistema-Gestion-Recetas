import java.util.*;

public class Universidad 
{
	private String nombre;
	private Archivos archivo;
	private ListaAlumnos listaAlumnos;
	private ListaDocentes listaDocentes;

	public Universidad(String nombre, Archivos archivo) {
		this.nombre = nombre;
		this.archivo = archivo;
	}
	
	public Universidad() 
	{
		ArrayList<Receta> todasLasRecetas;
		this.nombre = "";
		archivo = new Archivos();
		listaDocentes = new ListaDocentes(archivo);
		listaAlumnos = new ListaAlumnos(archivo);
		todasLasRecetas = TodasLasRecetas();
		cargarComentarios(todasLasRecetas);
		cargarVentanasRecetas(todasLasRecetas);
	}
	
	
	
	
	
	//retorna todas las recetas de todos los usuarios
	public ArrayList<Receta> TodasLasRecetas()
	{
		ArrayList<Receta> todasRecetas= new ArrayList<Receta>();
		for(int i=0;i<listaAlumnos.getArrayAlumnos().size();i++)
		{
			for(int j=0;j<listaAlumnos.getArrayAlumnos().get(i).getListaRecetas().getArrayRecetas().size();j++)
			{
				if(!listaAlumnos.getArrayAlumnos().get(i).getListaRecetas().getArrayRecetas().isEmpty())
					todasRecetas.add(listaAlumnos.getArrayAlumnos().get(i).getListaRecetas().getArrayRecetas().get(j));
			}
		}
		return todasRecetas;
	}			
	
		

	
	
	
	
	
	
	
	
	
	
	//se cargan los comentarios de todas las recetas
	public void  cargarComentarios(ArrayList<Receta> recetas)
	{						
		for(int i=0;i<recetas.size();i++)
		{
			recetas.get(i).cargarComentarios(Universidad.this);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public void cargarVentanasRecetas(ArrayList<Receta> arrayRecetas)
	{														//se crean las ventanasPrincipales de todas las recetas
		for(int i=0;i<arrayRecetas.size();i++)
		{
			arrayRecetas.get(i).setVentanaPrincipal(new VentanaReceta(arrayRecetas.get(i)));
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Archivos getArchivo() {
		return archivo;
	}

	public void setArchivo(Archivos archivo) {
		this.archivo = archivo;
	}

	public ListaAlumnos getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(ListaAlumnos listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	public ListaDocentes getListaDocentes() {
		return listaDocentes;
	}

	public void setListaDocentes(ListaDocentes listaDocentes) {
		this.listaDocentes = listaDocentes;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}
