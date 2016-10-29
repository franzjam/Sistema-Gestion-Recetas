import java.util.ArrayList;

public class Receta 
{
	private String nombreReceta;
	private String[] ingredientes;
	private String[] utensilios;
	private Alumno autor;
	private int caloriasTotales;
	private String Instrucciones;
	private int tiempoEstimadoPreparacion;
	private String[] categorias; 
	private int calificacionReceta;
	private String[] denuncias;
	private VentanaReceta ventanaPrincipal;
	private ListaComentarios ListaComentarios;
	
	
	
	
	
	
	
	
	
	
	
	public ListaComentarios getListaComentarios() {
		return ListaComentarios;
	}









	public void setListaComentarios(ListaComentarios listaComentarios) {
		ListaComentarios = listaComentarios;
	}









	public ListaComentarios getComentarios() {
		return ListaComentarios;
	}









	//se cargan los comentarios de todas las recetas
	public void  cargarComentarios(Universidad universidad)
	{						
		if(ListaComentarios!=null)
			ListaComentarios.cargarArrayComentarios(universidad);
	}





	
	
	







	public void setComentarios(ListaComentarios comentarios) {
		this.ListaComentarios = comentarios;
	}






















	public Receta()	
	{
		this.nombreReceta = null;
		this.ingredientes = null;
		this.utensilios = null;
		this.caloriasTotales = 0;
		Instrucciones = null;
		this.tiempoEstimadoPreparacion = 0;
		this.categorias = null;
		this.calificacionReceta = 0;
		this.denuncias = null;
		this.ventanaPrincipal=null;
		this.ListaComentarios= null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Receta(String nombreReceta, String[] ingredientes,
			String[] utensilios, int caloriasTotales, String intrucciones,
			int tiempoEstimadoPreparacion, String[] categorias,
			int calificacionReceta, ArrayList<Comentario> comentarios,Alumno usuario) 
	{
		this.nombreReceta = nombreReceta;
		this.ingredientes = ingredientes;
		this.utensilios = utensilios;
		this.caloriasTotales = caloriasTotales;
		Instrucciones = intrucciones;
		this.tiempoEstimadoPreparacion = tiempoEstimadoPreparacion;
		this.categorias = categorias;
		this.calificacionReceta = calificacionReceta;
		this.ListaComentarios = new ListaComentarios(comentarios);
		this.autor= usuario;
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	public Alumno getAutor() {
		return autor;
	}
	
	public void setAutor(Alumno autor) 
	{
		this.autor = autor;
	}
	
	public VentanaReceta getVentanaPrincipal() {
		return ventanaPrincipal;
	}


	public void setVentanaPrincipal(VentanaReceta ventanaPrincipal) 
	{
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public void mostrarReceta()
	{
		ventanaPrincipal.setVisible(true);
	}

	public String getNombreReceta() {
		return nombreReceta;
	}
	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}
	public String[] getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String[] ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String[] getUtensilios() {
		return utensilios;
	}
	public void setUtensilios(String[] arrayList) {
		this.utensilios = arrayList;
	}
	public int getCaloriasTotales() {
		return caloriasTotales;
	}
	public void setCaloriasTotales(int caloriasTotales) {
		this.caloriasTotales = caloriasTotales;
	}
	public String getInstrucciones() {
		return Instrucciones;
	}
	public void setInstrucciones(String intrucciones) {
		Instrucciones = intrucciones;
	}
	public int getTiempoEstimadoPreparacion() {
		return tiempoEstimadoPreparacion;
	}
	public void setTiempoEstimadoPreparacion(int tiempoEstimadoPreparacion) {
		this.tiempoEstimadoPreparacion = tiempoEstimadoPreparacion;
	}
	public String[] getCategorias() {
		return categorias;
	}
	public void setCategorias(String[] arrayList) {
		this.categorias = arrayList;
	}
	public int getCalificacionReceta() {
		return calificacionReceta;
	}
	public void setCalificacionReceta(int calificacionReceta) {
		this.calificacionReceta = calificacionReceta;
	}
	public String[] getDenuncias() {
		return denuncias;
	}
	public void setDenuncias(String[] denuncias) {
		this.denuncias = denuncias;
	}
	@Override
	public String toString()
	{
		return nombreReceta;
	}
	
	}
