import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.lang.System;
import java.io.IOException;

public class VentanaCrearAlumno extends JFrame {
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtRUT;
	private JTextField txtCorreo;
	private JTextField txtEdad;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDigVer;
	private Archivos archivo;
	
	public VentanaCrearAlumno(final Universidad universidad,final VentanaDocente ventanaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 412);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		Toolkit myNativeScreen = Toolkit.getDefaultToolkit(); //Sistema nativo de ventana
		Dimension sizeScreen = myNativeScreen.getScreenSize(); //Obtener resolucion pantalla
		
		int alturaPantalla = sizeScreen.height;
		int anchoPantalla = sizeScreen.width;
		
		setSize(315, 452); //Dar tamano
		setLocation(anchoPantalla/3, alturaPantalla/4); //Centrarlo
		
//-------------------------------------------------------------------------------------------------------------------------
		
		//JLabel
		JLabel lblIngreseLosSiguientes = new JLabel("Ingrese los siguientes datos :");
		lblIngreseLosSiguientes.setBounds(10, 21, 255, 14);
		contentPane.add(lblIngreseLosSiguientes);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(10, 75, 70, 14);
		contentPane.add(lblNombre);
		
		JLabel lblRut = new JLabel("RUT :");
		lblRut.setBounds(10, 100, 46, 14);
		contentPane.add(lblRut);
		
		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setBounds(10, 125, 46, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setBounds(10, 150, 46, 14);
		contentPane.add(lblEdad);
		
		JLabel lblSexo = new JLabel("Sexo :");
		lblSexo.setBounds(10, 177, 46, 14);
		contentPane.add(lblSexo);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono :");
		lblTelfono.setBounds(10, 227, 70, 14);
		contentPane.add(lblTelfono);
		
		JLabel lblDirección = new JLabel("Direcci\u00F3n :");
		lblDirección.setBounds(10, 202, 70, 14);
		contentPane.add(lblDirección);
		
		JLabel label = new JLabel("-");
		label.setBounds(237, 100, 38, 14);
		contentPane.add(label);
		
		final JLabel lblVerifCorreo = new JLabel();
		lblVerifCorreo.setBounds(280, 120, 29, 20);
		contentPane.add(lblVerifCorreo);
		
		final JLabel lblVerifTelefono = new JLabel();
		lblVerifTelefono.setBounds(280, 227, 46, 14);
		contentPane.add(lblVerifTelefono);
		
		final JLabel lblVerifEdad = new JLabel();
		lblVerifEdad.setBounds(280, 150, 46, 14);
		contentPane.add(lblVerifEdad);
		
		final JLabel lblVerifRUT = new JLabel();
		lblVerifRUT.setBounds(280, 100, 46, 14);
		contentPane.add(lblVerifRUT);
		
		final JLabel lblVerifDireccion = new JLabel();
		lblVerifDireccion.setBounds(280, 202, 46, 14);
		contentPane.add(lblVerifDireccion);
		
		final JLabel lblVerifNombre = new JLabel();
		lblVerifNombre.setBounds(280, 75, 46, 14);
		contentPane.add(lblVerifNombre);
		
		
//-----------------------------------------------------------------------------------------------------------------------------
												//JTextField
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Ej: Luis Perez");
		txtNombre.setBounds(89, 72, 186, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtRUT = new JTextField();
		txtRUT.setToolTipText("Ej: 12345678");
		txtRUT.setBounds(89, 97, 144, 20);
		contentPane.add(txtRUT);
		txtRUT.setColumns(10);
		
		txtDigVer = new JTextField();
		txtDigVer.setToolTipText("0-9 o K");
		txtDigVer.setBounds(251, 97, 24, 20);
		contentPane.add(txtDigVer);
		txtDigVer.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setToolTipText("example@domain.com");
		txtCorreo.setBounds(89, 122, 186, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
			
		txtEdad = new JTextField();
		txtEdad.setBounds(89, 147, 46, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);	
		
		String[] sexoStrings = {"Masculino", "Femenino"};
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(89, 199, 186, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setToolTipText("Ej: 12345678");
		txtTelefono.setBounds(89, 224, 186, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
//--------------------------------------------------------------------------------------------------------------------------
										//VALIDACIONES
		txtNombre.addKeyListener(new KeyListener(){
			//Se ejecuta cuando el usuario presiona una tecla (especial)
			public void keyTyped(KeyEvent e){

			}
			//Se ejecuta cuando el usuario presiona una tecla.
			public void keyPressed(KeyEvent e){
				if(txtNombre.getText().length() == 0){
					txtNombre.setBackground(Color.red);
					lblVerifNombre.setText("\u2717");
				}
				
				if(txtNombre.getText().length() > 0 ){
					txtNombre.setBackground(Color.green);
					lblVerifNombre.setText("\u2713");
				}
			}
			//Se ejecuta cuando el usuario libera una tecla
			public void keyReleased(KeyEvent e){
				if(txtNombre.getText().length() == 0){
					txtNombre.setBackground(Color.red);
					lblVerifNombre.setText("\u2717");
				}
			}
		});
		
		//Funcion que limita la cantidad de numeros a ingresar en el TxtFieldRUT a 8
		txtRUT.addKeyListener(new KeyListener()
		{
			int tamanoRUT = 8;
			
			public void keyTyped(KeyEvent e){
				if (txtRUT.getText().length() == tamanoRUT)
					e.consume();
			}
			public void keyPressed(KeyEvent e){
				if(txtRUT.getText().length() < tamanoRUT){
					txtRUT.setBackground(Color.red);
					lblVerifRUT.setText("\u2717");
				}
				
				if(txtRUT.getText().length() == (tamanoRUT - 1)){
					txtRUT.setBackground(Color.green);
					lblVerifRUT.setText("\u2713");
				}
			}
			public void keyReleased(KeyEvent e){
				if(txtRUT.getText().length() < tamanoRUT){
					txtRUT.setBackground(Color.red);
					lblVerifRUT.setText("\u2717");
				}
			}
		});
		
		txtDigVer.addKeyListener(new KeyListener()
		{
			int tamanoDigVerf = 1;
			public void keyTyped(KeyEvent e){
				if (txtDigVer.getText().length() == tamanoDigVerf)
					e.consume();
			}
			public void keyPressed(KeyEvent e){
				if(txtDigVer.getText().length() == (tamanoDigVerf - 1)){
					txtDigVer.setBackground(Color.green);
					lblVerifRUT.setText("\u2713");
				}
			}
			public void keyReleased(KeyEvent e){
				if(txtDigVer.getText().length() < tamanoDigVerf){
					txtDigVer.setBackground(Color.red);
					lblVerifRUT.setText("\u2717");
				}
			}
		});
		
		txtEdad.addKeyListener(new KeyListener()
		{
			int tamanoEdad = 2;
			
			public void keyTyped(KeyEvent e){
				if(txtEdad.getText().length() == tamanoEdad){
					e.consume(); 
				}
			}
			public void keyPressed(KeyEvent e){
				if(txtEdad.getText().length() < tamanoEdad){
					txtEdad.setBackground(Color.red);
					lblVerifEdad.setText("\u2717");
				}
				
				if(txtEdad.getText().length() == (tamanoEdad - 1)){
					txtEdad.setBackground(Color.green);
					lblVerifEdad.setText("\u2713");
				}
			}
			public void keyReleased(KeyEvent e){
				if(txtEdad.getText().length() < tamanoEdad){
					txtEdad.setBackground(Color.red);
					lblVerifEdad.setText("\u2717");
				}
			}
		});
		
		txtDireccion.addKeyListener(new KeyListener(){
			//Se ejecuta cuando el usuario presiona una tecla (especial)
			public void keyTyped(KeyEvent e){

			}
			//Se ejecuta cuando el usuario presiona una tecla.
			public void keyPressed(KeyEvent e){
				if(txtDireccion.getText().length() == 0){
					txtDireccion.setBackground(Color.red);
					lblVerifDireccion.setText("\u2717");
				}
				
				if(txtDireccion.getText().length() > 0 ){
					txtDireccion.setBackground(Color.green);
					lblVerifDireccion.setText("\u2713");
				}
			}
			//Se ejecuta cuando el usuario libera una tecla
			public void keyReleased(KeyEvent e){
				if(txtDireccion.getText().length() == 0){
					txtDireccion.setBackground(Color.red);
					lblVerifDireccion.setText("\u2717");
				}
			}
		});

		//Limitar a escribir 8 numeros en el Campo TELEFONO
		txtTelefono.addKeyListener(new KeyListener(){
			int tamanoTelefono = 8;
			//Se ejecuta cuando el usuario presiona una tecla (especial)
			public void keyTyped(KeyEvent e){
			if(txtTelefono.getText().length() == tamanoTelefono)
				e.consume(); //limita la cantidad de caracteres
			}
			//Se ejecuta cuando el usuario presiona una tecla.
			public void keyPressed(KeyEvent e){
				if(txtTelefono.getText().length() < tamanoTelefono){
					txtTelefono.setBackground(Color.red);
					lblVerifTelefono.setText("\u2717");
				}
							
				if(txtTelefono.getText().length() == (tamanoTelefono - 1)){
					txtTelefono.setBackground(Color.green);
					lblVerifTelefono.setText("\u2713");
				}
			}
			//Se ejecuta cuando el usuario libera una tecla
			public void keyReleased(KeyEvent e){
				if(txtTelefono.getText().length() < tamanoTelefono){
					txtTelefono.setBackground(Color.red);
					lblVerifTelefono.setText("\u2717");
				}
			}
		});
		final JComboBox comboBoxSexo = new JComboBox(sexoStrings);
		comboBoxSexo.setBounds(89, 174, 85, 20);
		contentPane.add(comboBoxSexo);
//-----------------------------------------------------------------------------------------------------------------------------
												//BOTONES
		final JButton btnGenerarContrasena = new JButton("Generar Contrase\u00F1a");
		btnGenerarContrasena.setEnabled(false);
		btnGenerarContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicion = universidad.getListaAlumnos().getArrayAlumnos().size() - 1;
				try {
					archivo = new Archivos();
					archivo.guardarTxtAlumnos(universidad.getListaAlumnos().getArrayAlumnos());
					JOptionPane.showMessageDialog(VentanaCrearAlumno.this,universidad.getListaAlumnos().getArrayAlumnos().get(posicion).getContrasena(),"Su contraseña es",1);
				} catch (HeadlessException | IOException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnGenerarContrasena.setBounds(60, 338, 173, 31);
		contentPane.add(btnGenerarContrasena);
		
		JButton btnRegistrarse = new JButton("Registrar UsuarioEstandar"); //boton de registrar
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sexoUsuario = (String) comboBoxSexo.getSelectedItem();
				
				if(verificarEmail(txtCorreo.getText()))
				{
					lblVerifCorreo.setText("\u2717");
					txtCorreo.setBackground(Color.red);
					JOptionPane.showMessageDialog(VentanaCrearAlumno.this,"Ingresó mal o faltó llenar algun campo","Error",0);
				}else{
					lblVerifCorreo.setText("\u2713");
					txtCorreo.setBackground(Color.GREEN);
					Alumno usuarioNuevo= new Alumno(txtNombre.getText(),txtRUT.getText(),txtDireccion.getText(),txtCorreo.getText(), sexoUsuario,Integer.parseInt(txtEdad.getText()),Integer.parseInt(txtTelefono.getText()));
					usuarioNuevo.setContrasena(usuarioNuevo.generarContraseña(txtRUT.getText()));
					universidad.getListaAlumnos().getArrayAlumnos().add(usuarioNuevo);
					JOptionPane.showMessageDialog(VentanaCrearAlumno.this,"Datos ingresados correctamente","Usuario creado",1);	
					
					btnGenerarContrasena.setEnabled(true);

				}
			}
		});
		btnRegistrarse.setBounds(10, 277, 179, 37);
		contentPane.add(btnRegistrarse);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnAtras.setBounds(199, 277, 100, 37);
		contentPane.add(btnAtras);
		
		JButton btnSalir = new JButton("Cerrar Sesión");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(174, 11, 125, 29);
		contentPane.add(btnSalir);
	}//FIN DEL CONTRUCTOR

	//verifica que en mail se escribio correctamente
	public boolean verificarEmail(String email)
	{
		int verificarArroba = 0;
		int verificarPuntos = 0;
		
		for(int i = 0;i < email.length(); i++){
			if(email.charAt(i) == '@')//ExtraerCaracter
				verificarArroba++;

			if(email.charAt(i) == '.')
				verificarPuntos++;
		}
		
		if(verificarArroba != 1 && verificarPuntos < 1)
			return true;
		
		return false;
	}
}
