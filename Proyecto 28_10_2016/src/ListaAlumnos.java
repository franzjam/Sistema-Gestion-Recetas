import java.util.ArrayList;

import javax.swing.JPasswordField;

public class ListaAlumnos {

	private ArrayList <Alumno> arrayAlumnos;
	
	public ListaAlumnos(Archivos archivo)
	{
		arrayAlumnos = archivo.cargarArchivoTextoUsuario(arrayAlumnos);

	}
	
	
	//Este metodo agrega a un nuevo alumno
	public boolean agregarAlumno (Alumno alumno)
	{
		if(arrayAlumnos.add(alumno))
			return true;
		return false;
	}
	
	//Recibe el usuario y contraseña y si existe devuelve true ()
	public boolean existeAlumno(String usuario, JPasswordField contrasena)
	{
		String valor = new String(contrasena.getPassword()); 	
	    if(arrayAlumnos!=null){
	    	for(int i = 0; i < arrayAlumnos.size(); i++){
				if(usuario.equals(arrayAlumnos.get(i).getRut()) && valor.equals(arrayAlumnos.get(i).getContrasena())){
					return true;
				}
			}
	    }
		return false;
	}


	public boolean existeAlumnoCorreo(String correoBuscado)
	{													//recibe un correo
		if(arrayAlumnos!=null){
			for(int i = 0; i < arrayAlumnos.size(); i++)
			{
				if(correoBuscado.equals(arrayAlumnos.get(i).getCorreo())){
					return true;				//si existe usuario que tenga el correo retorna true
				}
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean eliminarAlumno(Alumno usuario)
	{    	
		if(existeAlumnoRut(usuario.getRut()))
		{
			Archivos archivos= new Archivos();
			archivos.eliminarTxtAlumno(usuario);
			return true;
		}
		return false;	
	}
	
	public boolean existeAlumnoRut(String rutBuscado)
	{											//recibe un rut
		if(arrayAlumnos!=null){
			for(int i = 0; i < arrayAlumnos.size(); i++)
			{
				System.out.println(rutBuscado+" y "+arrayAlumnos.get(i).getRut());
				if(rutBuscado.equals(arrayAlumnos.get(i).getRut())){
					return true;			//si existe usuario con el rut recibido retorna true
				}
			}
		}
		return false;
	}
	
	public int posicionUsuario(String nombreUsuario)
	{										//recibe el nombre de un usuario
		if(arrayAlumnos!=null){
			for(int i = 0; i < arrayAlumnos.size(); i++){
				if(nombreUsuario.equals(arrayAlumnos.get(i).getNombrePersona())){	
					return i;			//retorna la posicion en que se encuentra del ArrayList de usuarios
				}
			}
		}
		return -1;//si no está retorna -1
	}
	
	
	
	

	public Alumno getAlumno(String usuario, JPasswordField contrasena)
	{										//recibe un usuario y contraseña															    	
		String valor = new String(contrasena.getPassword()); 
		if(arrayAlumnos!=null){	
			for(int i = 0; i < arrayAlumnos.size(); i++){
				if(usuario.equals(arrayAlumnos.get(i).getRut()) && valor.equals(arrayAlumnos.get(i).getContrasena())){
					return arrayAlumnos.get(i);		//devuelve usuario si se encuentra en el ArrayList de usuarios
				}
			}
		}
		return null;	//retorna null si no se encontró
	}
	
	//recibe un rut de una persona 
	public Alumno getAlumno(String rut)
	{									   	
		if(arrayAlumnos!=null){
			for(int i = 0; i < arrayAlumnos.size(); i++){
				if(rut.equals(arrayAlumnos.get(i).getRut()))
				{//retorna el usuario si coincide con el rut recibido
					return arrayAlumnos.get(i);
					
				}
			}
		}
		return null;	//retorna null si no se encontro coincidencia
	}


	public ArrayList<Alumno> getArrayAlumnos() {
		return arrayAlumnos;
	}
	
	
	
	
	
	
	
	
	
	public void setArrayAlumnos(ArrayList<Alumno> arrayAlumnos) {
		this.arrayAlumnos = arrayAlumnos;
	}

}
