import java.util.ArrayList;
import javax.swing.JPasswordField;

public class ListaDocentes {
	
	private ArrayList <Docente> arrayDocentes;
	
	public ListaDocentes(Archivos archivo){
		arrayDocentes = archivo.cargarArchivoTextoDocente(arrayDocentes);
	}
	
	public Docente getDocente(String docente, JPasswordField contrasena)
	{															//recibe el docente y contraseña
		String valor = new String(contrasena.getPassword());
		if(arrayDocentes!=null){
			for(int i = 0; i < arrayDocentes.size(); i++){
				if(docente.equals(arrayDocentes.get(i).getRut()) && valor.equals(arrayDocentes.get(i).getContrasena())){
					return arrayDocentes.get(i);				//si existe retorna el docente
				}
			}
		}
		return null;			//si no existe retorna null
	}

	public boolean existeDocente(Docente docente,String contrasena)
	{														//recibe el docenta y contraseña
		if(contrasena.equals(docente.getContrasena())){
				return true;		//si la contraseña es igual a la contraseña del docente retorna true
		}else{
			return false;
		}
	}

	public ArrayList<Docente> getArrayDocentes() {
		return arrayDocentes;
	}

	public void setArrayDocentes(ArrayList<Docente> arrayDocentes) {
		this.arrayDocentes = arrayDocentes;
	}
}
