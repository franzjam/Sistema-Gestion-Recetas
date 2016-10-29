import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Archivos 
{
	
	//Constructor
	public Archivos(){}
	
	
	/******************************************************************************************************************
	 * 						METODOS PARA CARGAR ARCHIVOS AL MOMENTO DE EJECUCION DEL SOFTWARE
	 * ****************************************************************************************************************/
	
	
	/**
	 *	Metodo donde se cargan los datos de todos los alumnos desde los txt y se genera el arrayList de alumnos.
	 * 	@param arrayUsuarios			Es un arrayList de Alumnos llenado a partir de txt's.
	 *  @return							Un ArrayList de Alumnos.
	 *  @see 							#cargarDatosRecetas(Alumno)
	 */	
	public ArrayList <Alumno> cargarArchivoTextoUsuario(ArrayList <Alumno> arrayUsuarios)
	{
		File raiz = new File("Universidad Catolica De Gastronomia\\Alumnos");
		
		if(raiz.exists() && raiz.list()!=null){
			String [] carpeta = raiz.list();
		    arrayUsuarios = new ArrayList <Alumno>();
		    
			for(int i=0;i<carpeta.length;i++){
				try(FileReader archivoLectura = new FileReader("Universidad Catolica De Gastronomia\\Alumnos\\"+carpeta[i]+"\\DatosUsuario"+carpeta[i]+".txt")){
					BufferedReader buffer = new BufferedReader(archivoLectura);
					if(buffer.ready()){
						String cadena = buffer.readLine();
				    	if(cadena != null){
				    		StringTokenizer st = new StringTokenizer(cadena,"|");
				    		String nombre = st.nextToken();
					    	String rut = st.nextToken();
					    	String correo = st.nextToken();
					    	int edad = Integer.parseInt(st.nextToken());
					    	String sexo = st.nextToken();
					    	String direccion = st.nextToken();
					    	int telefono = Integer.parseInt(st.nextToken());
					    	String contrasena = st.nextToken();
					    	
					    	//se agrega al ArrayList de usuarios
					    	
					    	arrayUsuarios.add(new Alumno(nombre,rut,direccion,correo,sexo,edad,telefono,contrasena));
					    	
					    	//se llama a la funcion que carga las recetas de los txt
					    	
					    	cargarDatosRecetas(arrayUsuarios.get(i));
				    	}
				    buffer.close();
				    	archivoLectura.close();
					}
				}catch(IOException x){
					System.out.println("Error E/S: "+x);
				}
			}
		}
		return arrayUsuarios;
	}
	
	
	
	
	
	
	/**
	 *	Metodo donde se cargan los datos de todos los docentes desde los txt y se genera el arrayList de docentes.
	 *  @param arrayDocentes			Es un arrayList de Docentes llenado a partir de txt's.
	 *  @return 						Un ArrayList de Docentes.
	 * */
	public ArrayList <Docente> cargarArchivoTextoDocente(ArrayList <Docente> arrayDocentes)
	{
		File raiz = new File("Universidad Catolica De Gastronomia\\Docentes");
		
		if(raiz.exists() && raiz.list()!=null){
			String [] carpeta = raiz.list();
			arrayDocentes = new ArrayList <Docente>();
			
			for(int i=0;i<carpeta.length;i++){	
				try(FileReader archivoLectura = new FileReader("Universidad Catolica De Gastronomia\\Docentes\\"+carpeta[i]+"\\DatosDocente"+carpeta[i]+".txt")){
					BufferedReader buffer = new BufferedReader(archivoLectura);
					if(buffer.ready()){
						String cadena = buffer.readLine();
						if(cadena != null) {
							StringTokenizer st = new StringTokenizer(cadena, "|");
					    	String nombre = st.nextToken();
					    	String rut = st.nextToken();
					    	String correo = st.nextToken();
					    	int edad = Integer.parseInt(st.nextToken());
					    	String sexo = st.nextToken();
					    	String direccion = st.nextToken();
					    	int telefono = Integer.parseInt(st.nextToken());
					    	String contrasena = st.nextToken();	
					    	
					    	//se agrega al ArrayList de docentes
					    	
					    	arrayDocentes.add(new Docente(nombre,rut,direccion,correo,sexo,edad,telefono,contrasena));
						};
						buffer.close();
						archivoLectura.close();
					}
				}catch(IOException x){
					System.out.println("Error E/S: "+x);
				}
			}
			return arrayDocentes;
		}
		return arrayDocentes;
	}

	
	
	
	
	/**
	 * 	En este metodo se cargan los datos de las recetas de todos los txt del usuario.
	 *  @param 	alumno				Contiene a un alumno en especifico. 											
	 *  @see						#leerListaTxt(BufferedReader)
	 *  @see						#leerInstruccionesTxt(BufferedReader)
	 *  @see 						#leerComentariosTxt(BufferedReader)
	 *  @see 						Alumno#getListaRecetas()
	 * */
	public void cargarDatosRecetas(Alumno alumno)
	{				
		File raiz = new File("Universidad Catolica De Gastronomia\\Alumnos\\"+alumno.getRut()+"\\Recetas");
		
		if(raiz.exists() && raiz.list() != null){
			File [] archivosReceta = raiz.listFiles();
			for(int i=0;i<archivosReceta.length;i++){
				if(archivosReceta[i].isFile())
				{
					try(FileReader archivoLectura = new FileReader(archivosReceta[i]))
					{
						BufferedReader buffer = new BufferedReader(archivoLectura);
					
						if(buffer.ready()){
							String nombreReceta = buffer.readLine();
							String cadena = buffer.readLine();
							StringTokenizer st = new StringTokenizer(cadena,"|");
							int calificacionReceta = Integer.parseInt(st.nextToken());
							int tiempoEstimadoPreparacion = Integer.parseInt(st.nextToken());
				    		int caloriasTotales = Integer.parseInt(st.nextToken());
				    		String[] ingredientes = leerListaTxt(buffer);
					    	String[] utensilios = leerListaTxt(buffer);
					    	String[] tipos = leerListaTxt(buffer);
					    	String intrucciones = leerInstruccionesTxt(buffer);
					    	
					    	ArrayList<Comentario> comentarios = leerComentariosTxt(buffer);
					    	
					    	//Se agrega al ArrayList de recetas
					    	
					    	alumno.getListaRecetas().agregarReceta(new Receta(nombreReceta,ingredientes,utensilios,caloriasTotales,intrucciones,tiempoEstimadoPreparacion,tipos,calificacionReceta,comentarios,alumno));
					    }						
						buffer.close();
				    	archivoLectura.close();
					}catch(IOException x){
						System.out.println("Error E/S: "+x);
					}
				}
			}
		}
		
	}		

	
	
	
	
	
	
	
	
	
	
	/******************************************************************************************************************
	 * 								METODOS DE ESCRITURAS EN LOS ARCHIVOS TXT RESPECTIVOS
	 * ****************************************************************************************************************/
	
	
	/**
	 * 	Metodo que escribe las lista de los utensilios, ingredientes y categorias en el txt de la receta.
	 *  @param lista			Es un arreglo de String que contiene los utensilios, ingredientes y categorias 
	 *  						de la receta recibida. 
	 *  @param pEscrit			Se usa para escribir en el txt el arreglo de String recibido.
	 * */
	public void escribirListaTxt(String [] lista,PrintWriter pEscrit)
	{
		if(lista!=null)
		{
			if(lista.length==0)
				pEscrit.println("0");	
			else
			{
				//Primero ingresa el largo de la lista
				
				pEscrit.println(lista.length);			
				for(int i=0;i<lista.length;i++)
				{
					//Despues ingresa cada elemento del a lista
					
					pEscrit.println(lista[i].toString());
				}
			}
		}
		else
			pEscrit.println("0");
	}
	
	
	
	
	
	
	/**
	 *	Metodo que escribe las instrucciones de la receta en el txt de la receta.
	 *	@param instruccion		Contiene las instrucciones de la receta recibida.
	 *	@param pEscrit 			Se usa para escribir en el txt la instruccion de la receta.
	 * */	
	public void escribirInstrucciones(String instruccion,PrintWriter pEscrit)
	{
		if(instruccion!=null)
		{
			if(!instruccion.isEmpty())
			{
				if(!instruccion.equals(""))
				{
					pEscrit.println(instruccion+"|");
				}
				else
					pEscrit.println("0");
			}
			else
				pEscrit.println("0");
		}
		else
			pEscrit.println("0");
	}
	
	
	
	

	
	
	/**
	 * 	Metodo que escribe los comentarios de la receta en el txt
	 *  @param listaComentarios		Contiene los comentarios de la receta recibida.
	 * 	@param pEscrit				Se usa para escribir en el txt los comentarios de la receta. 
	 * */	
	public void escribirComentariosTxt(ArrayList<Comentario> listaComentarios,PrintWriter pEscrit)
	{		
		if(listaComentarios!=null)
		{
			//lee primero la cantidad de elementos de la lista de comentarios
			
			pEscrit.println(listaComentarios.size());	
			
			for(int i=0;i<listaComentarios.size();i++)
			{
				if(listaComentarios.get(i)!=null)
				{	
					//separa cada elemento del comentario por un |
					
					pEscrit.println(listaComentarios.get(i).getAutor().getRut()+"|"+listaComentarios.get(i).getTexto()+"|"+listaComentarios.get(i).getNumero());
				}
			}
		}
		else
			pEscrit.println("0");
	}
		
	
	
	
	
	
	
	
	
	

	/******************************************************************************************************************
	 * 								METODOS DE LECTURA DE LOS ARCHIVOS TXT RESPECTIVOS
	 * ****************************************************************************************************************/
	
	
	/**
	 *	Este método lee cada elemento de una lista (ingredientes, utensilios y categorias)
	 *	@param 	buffer					Es una cadena de instrucciones de la receta extraida del txt
	 * 	@return							Una arreglo de Strings que contiene los elementros de Ingredientes, 
	 * 									Utensilios y Categorias.
	 * 	@throws NumberFormatException	Lanzada cuando se ha intentado convertir una cadena a uno de los 
	 * 									tipos numéricos.
	 *  @throws IOException				Lanzada cuando hay operaciones erroneas de Entrada/Salida.
	 * */
	public String [] leerListaTxt(BufferedReader buffer) throws NumberFormatException, IOException
	{													
		//primero lee la cantidad de elementos de la lista
		
		int cantidad = Integer.parseInt(buffer.readLine());
		
		String[] lista = new String[cantidad];

		if(cantidad>0){
			for(int i=0;i<cantidad;i++){
				//despues los lee un por uno
				
				lista[i] = buffer.readLine();
			}
		}
		return lista;
	}
	
	
	
	
	
	
	
	
	
	/**
	 *	Metodo que lee las instrucciones de la recetas desde el txt datosUsuarioRUT_ALUMNO.txt
	 * 	@param 	buffer					Es una cadena de instrucciones de la receta extraida del txt. 			
	 * 	@return							Un String que contiene las instrucciones de una receta.
	 * 	@throws NumberFormatException	Lanzada cuando se ha intentado convertir una cadena a uno de los 
	 * 									tipos numéricos.
	 *  @throws IOException				Lanzada cuando hay operaciones erroneas de Entrada/Salida.
	 * */
	public String leerInstruccionesTxt(BufferedReader buffer) throws NumberFormatException, IOException
	{
		String instruccion = new String();
		String cadena = new String();
		
		while(buffer.ready())	
		{
			cadena=buffer.readLine();
			if(cadena.indexOf('|')==-1)
			{	
				//si no existe el caracter | lo agrega al String instruccion
				
				instruccion+=cadena;
			}else
			{	
				//si existe lo lee sin el carcater | y retorna el String instruccion
				
				instruccion+=cadena.replace('|','\0');
				return instruccion;
			}
		}
		return null; 
	}
	
	
	
	
	
	

	
	
	
	/**
	 * 	Metodo que lee los comentarios de la recetas desde el txt datosUsuarioRUT_ALUMNO.txt
	 *  @param 	buffer					Es una cadena de los comentarios de la receta extraida del txt. 
	 *  @return 						Un ArrayList de Comentarios.
	 *  @throws NumberFormatException	Lanzada cuando se ha intentado convertir una cadena a uno de los 
	 * 									tipos numéricos
	 *  @throws IOException				Lanzada cuando hay operaciones erroneas de Entrada/Salida.
	 * */
	public ArrayList<Comentario> leerComentariosTxt(BufferedReader buffer) throws NumberFormatException, IOException
	{	
		ArrayList<Comentario> comentarios= new ArrayList<Comentario>();
		String cadena = buffer.readLine();
		
		if(cadena!=null)
		{
			if(!cadena.equals(""))
			{
				//primero lee la cantidad de comentarios
				
				int cantidad = Integer.parseInt(cadena); 
				String autor,codigo,texto;
				
				if(cantidad>0)
				for(int i=0;i<cantidad;i++)
				{								
						//despues lee uno por uno cada elemento del comentario
						
						cadena = buffer.readLine();
						StringTokenizer st = new StringTokenizer(cadena,"|");
						autor = st.nextToken();
						texto = st.nextToken();
						codigo = st.nextToken();
						
						if(!autor.equals("0") && !texto.equals("0"))
						{
							Comentario comentarioAgregar = new Comentario(autor,texto,Integer.parseInt(codigo));
							comentarios.add(comentarioAgregar);
						}
				}
			}
		}
		return comentarios;
	}
	
	
	
	
	
	
	
	
	

	/******************************************************************************************************************
	 * 								METODOS DE GUARDADO EN LOS ARCHIVOS TXT RESPECTIVOS
	 * ****************************************************************************************************************/
	
	
	/**
	 * 	Este metodo guarda la informacion del usuario en su respectivo txt
	 * 	@param 	arrayUsuarios			Es un ArrayList de alumnos.
	 * 	@return							Un booleano indicando si se pudo guardar guardar el Alumno.
	 * 	@throws IOException				Lanzada cuando hay operaciones erroneas de Entrada/Salida.
	 * 	@see 							#actualizarTxtAlumno(Alumno)
	 * */
	public boolean guardarTxtAlumnos(ArrayList<Alumno> arrayAlumnos) throws IOException 
	{									
		if(!arrayAlumnos.isEmpty()){	
			for(int i = 0;i<arrayAlumnos.size();i++)
			{	
				actualizarTxtAlumno(arrayAlumnos.get(i));
			}
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	/**
	 *	Este metodo guarda la informacion del docente en su respectivo txt
	 *	@param 	arrayDocentes			Es un ArrayList de docentes
	 *	@return							Un booleano indicando si se pudo guardar guardar el Docente.
	 *	@throws IOException				Lanzada cuando hay operaciones erroneas de Entrada/Salida.
	 *	@see 							#actualizarTxtDocente(Docente)
	 * */
	public boolean guardarTxtDocentes(ArrayList<Docente> arrayDocentes) throws IOException 
	{		
		if(!arrayDocentes.isEmpty()){
			for(int i = 0;i<arrayDocentes.size();i++){
				arrayDocentes.get(i).actualizarTxtDocente();
			}	
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	

	/******************************************************************************************************************
	 * 							METODOS DE ACTUALIZACION DE DATOS EN LOS ARCHIVOS TXT RESPECTIVOS
	 * ****************************************************************************************************************/
	
	
	/**
	 *	Este metodo actualiza todos los datos del alumno en su respectivo txt
	 *	@param	alumno				Contiene a un alumno en especifico.
	 *	@throws IOException			Lanzada cuando hay operaciones erroneas de Entrada/Salida.
	 *	@see 						#crearCarpetaUsuario(Alumno)
	 * */
	public void actualizarTxtAlumno(Alumno alumno) throws IOException 
	{							
		File archivoUsuarios;
		FileWriter fEscrit;
		BufferedWriter bEscrit;
		PrintWriter pEscrit;
		
		archivoUsuarios = new File("Universidad Catolica De Gastronomia\\Alumnos\\"
									+alumno.getRut()+"\\DatosUsuario"+alumno.getRut()+".txt");
		
		if(!archivoUsuarios.exists()){
			crearCarpetaUsuario(alumno);
		}

		fEscrit = new FileWriter(archivoUsuarios);
		bEscrit = new BufferedWriter(fEscrit);
		pEscrit = new PrintWriter(bEscrit);

		pEscrit.println(alumno.getNombrePersona()+"|"+alumno.getRut()+"|"
									+alumno.getCorreo()+"|"+alumno.getEdad()+"|"+alumno.getSexo()
									+"|"+alumno.getDireccion()+"|"+alumno.getTelefono()
									+"|"+alumno.getContrasena());
	
		System.out.println("\nDatos actualizados en el txt del alumno correctamente");
		
		pEscrit.close();
		bEscrit.close();
	}
	
	
	
	
	
	
	
	
	
	/**
	 *	Este metodo actualiza todos los datos del docente en su respectivo txt
	 *	@param	docente				Contiene a un docente en especifico.
	 *	@throws IOException			Lanzada cuando hay operaciones erroneas de Entrada/Salida.
	 *	@see 						#crearCarpetaUsuario(Docente)
	 * */
	public void actualizarTxtDocente(Docente docente) throws IOException 
	{							
		File archivoUsuarios;
		FileWriter fEscrit;
		BufferedWriter bEscrit;
		PrintWriter pEscrit;
		
		archivoUsuarios = new File("Universidad Catolica De Gastronomia\\Docentes\\"
									+docente.getRut()+"\\DatosDocente"+docente.getRut()+".txt");
		
		if(!archivoUsuarios.exists()){
			crearCarpetaUsuario(docente);
		}

		fEscrit = new FileWriter(archivoUsuarios);
		bEscrit = new BufferedWriter(fEscrit);
		pEscrit = new PrintWriter(bEscrit);

		pEscrit.println(docente.getNombrePersona()+"|"+docente.getRut()+"|"
									+docente.getCorreo()+"|"+docente.getEdad()+"|"+docente.getSexo()
									+"|"+docente.getDireccion()+"|"+docente.getTelefono()
									+"|"+docente.getContrasena());
	
		System.out.println("\nDatos actualizados en el txt del docente correctamente");
		
		pEscrit.close();
		bEscrit.close();
	}

	
	
	
	
	
	
	
	
	/**
	 *	Este metodo actualiza todos los datos de las recetas del alumno en su respectivo txt
	 *	@param	alumno				Contiene a un alumno en especifico.
	 *	@param	receta				Contiene todos los datos de la receta del alumno.
	 *	@throws IOException			Lanzada cuando hay operaciones erroneas de Entrada/Salida.
	 *	@see 						#crearCarpetaUsuario(Docente)
	 * */
	public void actualizarDatosReceta(Alumno alumno,Receta receta) throws IOException
	{
		File archivoReceta = new File("Universidad Catolica De Gastronomia\\Alumnos\\"+alumno.getRut()
									+"\\Recetas\\"+receta.getNombreReceta()+".txt");
														
		if(!archivoReceta.exists()){
			crearCarpetaRecetas(alumno,receta);
		}
		
		FileWriter fEscrit = new FileWriter(archivoReceta);
		BufferedWriter bEscrit = new BufferedWriter(fEscrit);
		PrintWriter pEscrit = new PrintWriter(bEscrit);
	
		pEscrit.println(receta.getNombreReceta());
		pEscrit.println(receta.getCalificacionReceta()+"|"+receta.getTiempoEstimadoPreparacion()
													  +"|"+receta.getCaloriasTotales());
		
		escribirListaTxt(receta.getIngredientes(), pEscrit);
		escribirListaTxt(receta.getUtensilios(), pEscrit);
		escribirListaTxt(receta.getCategorias(), pEscrit);
		escribirInstrucciones(receta.getInstrucciones(),pEscrit);
		escribirComentariosTxt(receta.getListaComentarios().getArrayComentarios(),pEscrit);
		
		pEscrit.close();
		bEscrit.close();
		System.out.println("actualizo datos receta");
	}
	
	
	
	
	
	

	/******************************************************************************************************************
	 * 											METODOS DE CREACION DE CARPETAS
	 * ****************************************************************************************************************/
	
	/** 
	 * 	Este metodo crea una carpeta de recetas dentro de la carpeta del alumno
	 * 	@param	alumno				Contiene a un alumno en especifico.
	 *	@param	receta				Contiene todos los datos de la receta del alumno.
	 * */
	public void crearCarpetaRecetas(Alumno alumno,Receta receta)
	{		
		File carpeta = new File("Universidad Catolica De Gastronomia\\Alumnos\\"+alumno.getRut()+"\\Recetas");
		File archivo = new File(carpeta,receta.getNombreReceta()+".txt");
		
		if(!carpeta.exists()){
			carpeta.mkdirs();	
		}
		
		if(!archivo.exists()){
			try{
				archivo.createNewFile();
			}catch(IOException ex){ex.printStackTrace();}
		}			
	}
	
	
	
	
	
	
	
	
	/** 
	 * 	Este metodo crea una carpeta nueva con el rut del alumno
	 * 	@param	alumno				Contiene a un alumno en especifico.
	 * */
	public void crearCarpetaUsuario(Alumno alumno)
	{
		File carpeta = new File("Universidad Catolica De Gastronomia\\Alumnos\\"+alumno.getRut());
		File archivo = new File(carpeta,"DatosUsuario"+alumno.getRut()+".txt");
		
		if(!carpeta.exists()){
			carpeta.mkdirs();
		}
		if(!archivo.exists()){
			try{
				archivo.createNewFile();
			}catch(IOException ex){ex.printStackTrace();}
		}
			
	}
	
	
	
	
	
	
	
	
	/** 
	 * 	Este metodo crea una carpeta nueva con el rut del docente
	 * 	@param	docente				Contiene a un docente en especifico.
	 * */
	public void crearCarpetaUsuario(Docente docente)
	{
		File carpeta = new File("Universidad Catolica De Gastronomia\\Docentes\\"+docente.getRut());
		File archivo = new File(carpeta,"DatosDocente"+docente.getRut()+".txt");
		
		if(!carpeta.exists()){
			carpeta.mkdirs();
		}
		if(!archivo.exists()){
			try{
				archivo.createNewFile();
			}catch(IOException ex){ex.printStackTrace();}
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	

	/******************************************************************************************************************
	 * 							METODOS DE ELIMINACION DE ARCHIVOS TXT ESPECIFICOS
	 * ****************************************************************************************************************/
	
	/** 
	 * 	Este metodo elimina una receta "SOLO" del txt manteniendo intacto el ArrayList de recetas
	 * 	@param	receta				Contiene una receta en especifico.
	 * 	@param 	rut					Contiene el rut de un alumno para ubicar la receta.
	 * 	@return						Un booleano que indica si se pudo eliminar la receta correctamente.
	 * */
	public boolean eliminarRecetaTxt(Receta receta, String rut)
	{																						
		File raiz = new File("Universidad Catolica De Gastronomia\\Alumnos\\"+rut+"\\Recetas");
		if(raiz.exists()){
			File archivoReceta = new File(raiz,receta.getNombreReceta()+".txt");
				if(archivoReceta.delete())
				{
					return true;
				}
		}
		return false;
	}
	
	
	
	
	

	
	/** 
	 * 	Este metodo elimina el usuario recibido del ArrayList de usuarios
	 * 	@param	alumno				Contiene un alumno en especifico.
	 * 	@return						Un booleano que indica si se pudo eliminar el txt contenido
	 * 								dentro de la carpeta del alumno.
	 * 	@see						#eliminarCarpetaUsuario(Alumno)
	 * */
	public boolean eliminarTxtAlumno(Alumno alumno)
	{    	
		if(eliminarCarpetaUsuario(alumno))
		{
			return true;
		}
		return false;	
	}
	
	
	
	
	
	
	
	
	
	
	

	/******************************************************************************************************************
	 * 										METODOS DE ELIMINACION DE CARPETAS
	 * ****************************************************************************************************************/
	
	/** 
	 * 	Este metodo elimina la carpeta del alumno recibido
	 * 	@param	alumno				Contiene un alumno en especifico.
	 * 	@return						Un booleano que indica si se pudo eliminar la carpeta del alumno.
	 * 	@see						#eliminarArchivos(File[])
	 * */
	public boolean eliminarCarpetaUsuario(Alumno alumno){
		File carpeta = new File("Universidad Catolica De Gastronomia\\Alumnos\\"+alumno.getRut());
		if(carpeta.exists()){
			File[] archivos = carpeta.listFiles();
			if(eliminarArchivos(archivos))
				if(carpeta.delete())	
					return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	

	

	/******************************************************************************************************************
	 * 										METODOS DE ELIMINACION DE ARCHIVOS 
	 * ****************************************************************************************************************/
	
	/** 
	 * 	Este metodo elimina la carpeta del alumno recibido
	 * 	@param	alumno				Contiene el archivo que se quiere eliminar.
	 * 	@return						Un booleano que indica si se pudo eliminar el archivo.
	 * */
	//elimina los ficheros recibidos
	public boolean eliminarArchivos(File []archivos)
	{
		int cont=0;					
		
		for(int i=0;i<archivos.length;i++){
			if(archivos[i].isFile()){
				if(archivos[i].delete())
					cont++;
			}else{
				if(archivos[i].listFiles()!=null)
					if(!eliminarArchivos(archivos[i].listFiles()))
						return false;	
				archivos[i].delete();
				cont++;
			}
		}
		
		if(archivos.length==cont)
			return true;
		
		return false;
	}

	

}//Fin Clase
