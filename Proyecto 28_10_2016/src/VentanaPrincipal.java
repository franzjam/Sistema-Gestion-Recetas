import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField psswField;
	
	
	public VentanaPrincipal(final Universidad universidad)  
	{
		
		setTitle("Prototipo");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 500);
		setResizable(false);
		
		Toolkit pantallaNativa = Toolkit.getDefaultToolkit();//Sistema nativo de ventana
		Dimension pantallaTamano = pantallaNativa.getScreenSize(); //Obtener resolucion pantalla
		
		int alturaPantalla = pantallaTamano.height;
		int anchoPantalla = pantallaTamano.width;
		
		setSize(415, 526); //Dar tamano
		setLocation(anchoPantalla/3, alturaPantalla/4); //Centrarlo
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPontificiaUniversidadCatolica = new JLabel("PONTIFICIA UNIVERSIDAD CATOLICA DE GASTRONOMIA");
		lblPontificiaUniversidadCatolica.setForeground(Color.WHITE);
		lblPontificiaUniversidadCatolica.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblPontificiaUniversidadCatolica.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontificiaUniversidadCatolica.setBounds(10, 21, 392, 14);
		contentPane.add(lblPontificiaUniversidadCatolica);
		
//-------------------------------------------------------------------------------------------------------------------------
		
		//PANEL INGRESAR DATOS DE INICIO SESION
		JPanel panelInicioSesion = new JPanel();
		panelInicioSesion.setForeground(Color.BLACK);
		panelInicioSesion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ingrese su RUT y contrase\u00F1a", TitledBorder.CENTER, TitledBorder.TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelInicioSesion.setBackground(SystemColor.textHighlight);
		panelInicioSesion.setBounds(20, 192, 370, 104);
		contentPane.add(panelInicioSesion);
		panelInicioSesion.setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(37, 35, 73, 14);
		panelInicioSesion.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("CONTRASE\u00D1A");
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasena.setBounds(22, 65, 88, 14);
		panelInicioSesion.add(lblContrasena);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textFieldUsuario.setBounds(125, 32, 214, 20);
		panelInicioSesion.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		psswField = new JPasswordField();
		psswField.setBounds(125, 62, 214, 20);
		panelInicioSesion.add(psswField);
		
//-------------------------------------------------------------------------------------------------------------------------	
		
		//PANEL TIPO USUARIO
		JPanel panelTipoUsuario = new JPanel();
		panelTipoUsuario.setBackground(SystemColor.textHighlight);
		panelTipoUsuario.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo Usuario", TitledBorder.CENTER, TitledBorder.TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 14), new Color(255, 255, 255)));
		panelTipoUsuario.setBounds(31, 318, 226, 63);
		contentPane.add(panelTipoUsuario);
		panelTipoUsuario.setLayout(null);
		
		JLabel lblTipoUsuario = new JLabel("USUARIO");
		lblTipoUsuario.setBounds(24, 27, 71, 14);
		panelTipoUsuario.add(lblTipoUsuario);
		lblTipoUsuario.setForeground(Color.WHITE);
		lblTipoUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		
		String[] tipoUsuario = {"Alumno","Docente"};
		
		final JComboBox comboBoxTipoUsuario = new JComboBox(tipoUsuario);
		comboBoxTipoUsuario.setBounds(94, 24, 105, 20);
		panelTipoUsuario.add(comboBoxTipoUsuario);
		comboBoxTipoUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		
//-------------------------------------------------------------------------------------------------------------------------
		
		//BOTON INICIAR SESION
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnIniciarSesion.setBounds(270, 333, 107, 39);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoUsuario = (String) comboBoxTipoUsuario.getSelectedItem();
				
				if(tipoUsuario.equals("Alumno"))
				{
					Alumno usuario = universidad.getListaAlumnos().getAlumno(textFieldUsuario.getText(),psswField); 
					if(usuario!=null)
					{
						JOptionPane.showMessageDialog(VentanaPrincipal.this,"Se inició sesión correctamente","Bienvenido",1);
						//creo la ventanaUsuarioEstandar
						VentanaAlumno ventanaUsuario = new VentanaAlumno(universidad,usuario,VentanaPrincipal.this);
						ventanaUsuario.setVisible(true);
						setVisible(false);
					}else{
						JOptionPane.showMessageDialog(VentanaPrincipal.this,"No se encontró usuario","Error",0);
					}
				}
				if(tipoUsuario.equals("Docente")){
					Docente docente=universidad.getListaDocentes().getDocente(textFieldUsuario.getText(),psswField);
					if(docente!=null){
						JOptionPane.showMessageDialog(VentanaPrincipal.this,"Se inició sesión correctamente","Bienvenido",1);		
						VentanaDocente ventanadocente = new VentanaDocente(docente,universidad);
						ventanadocente.setVisible(true);
						dispose();
						
					}else{
						JOptionPane.showMessageDialog(VentanaPrincipal.this,"No se encontró docente registrado","Error",0);
					}	
				}
			}}
		);
			
		contentPane.add(btnIniciarSesion);
		
//-----------------------------------------------------------------------------------------------------------------------
		
		//BOTON SALIR
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnSalir.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		btnSalir.setBounds(316, 445, 75, 39);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalir);

//------------------------------------------------------------------------------------------------------------------------
		
		//BOTON RECUPERAR CONTRASEÑA
		JButton btnRecuperarContrasena = new JButton("Recuperar Contrase\u00F1a");
		btnRecuperarContrasena.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnRecuperarContrasena.setBounds(111, 400, 185, 43);
		btnRecuperarContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int posUsuarioRecuperado;
				String correoUsuarioBuscado = JOptionPane.showInputDialog(null, "Ingrese su correo: ", "Para recuperar contraseña", JOptionPane.QUESTION_MESSAGE);	
				if(correoUsuarioBuscado != null)
					if(universidad.getListaAlumnos().existeAlumnoCorreo(correoUsuarioBuscado)){			
						String ingreseNombre = JOptionPane.showInputDialog(null, "Ingrese su nombre: ", "Para recuperar contraseña", JOptionPane.QUESTION_MESSAGE);
						posUsuarioRecuperado = universidad.getListaAlumnos().posicionUsuario(ingreseNombre);
						if(posUsuarioRecuperado != -1){
							EnviarContrasenaCorreo enviarCorreo = new EnviarContrasenaCorreo();
							enviarCorreo.crearMensaje(universidad,correoUsuarioBuscado, posUsuarioRecuperado);
						}
					}else{
						JOptionPane.showMessageDialog(VentanaPrincipal.this, "No se encontró usuario");
					}
			}
		});
		contentPane.add(btnRecuperarContrasena);
	}//FIN CONTRUCTOR

	

}