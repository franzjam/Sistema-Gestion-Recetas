/**********************************************************
 * 
 *  @author Pedro Morales
 *  @author Sebastian Sandoval
 *  @author Israel Ogas
 *  @version 1
 * 
 * ********************************************************
 * 							USUARIOS
 * 	ALUMNO DE TEST
 * 	RUT : 12345678
 * 	PASS : 87654
 * 
 * 	DOCENTE DE TEST
 * 	RUT : 80186894
 *  PASS : 49868
 * 
 * *******************************************************
 * 
 * 	CORREO : projectGRDC@gmail.com
 *	PASS : GRDCproject1234
 * 
 * ********************************************************
 * 
 * 		VERIFICAR existeUsuario( //VERIFICAR PARAMETROS  )
 * 		
 * 
 *********************************************************/
//probando x2
// Crear clase archivo y ver todo lo de archivos (Clase Universidad)
public class ClasePrincipal 
{
	public static void main(String[] args)
	{
		Universidad universidad = new Universidad();
		VentanaPrincipal ventanaInicial = new VentanaPrincipal(universidad);
		
		ventanaInicial.setVisible(true);
	}
}
