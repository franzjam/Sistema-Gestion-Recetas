import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class VentanaAlumno extends JFrame {

	private JPanel contentPane;
	private VentanaMisRecetas misRecetas;
	
	public VentanaAlumno(final Universidad universidad,final Alumno alumno, final VentanaPrincipal ventanaAnterior) 
	{
		setTitle("VentanaUsuarioEstandar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 312);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setDefaultCloseOperation(0);
		contentPane.setLayout(null);
		
		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setForeground(Color.WHITE);
		panelBienvenida.setBackground(SystemColor.textHighlight);
		panelBienvenida.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bienvenido/a", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 12), Color.WHITE));
		panelBienvenida.setBounds(6, 5, 313, 45);
		contentPane.add(panelBienvenida);
		panelBienvenida.setLayout(null);
		
		JLabel lblInformacionUsuario = new JLabel("Nombre : "+alumno.getNombrePersona());
		lblInformacionUsuario.setForeground(Color.WHITE);
		lblInformacionUsuario.setBounds(15, 20, 242, 14);
		panelBienvenida.add(lblInformacionUsuario);
		lblInformacionUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		
		JLabel lblRut = new JLabel("RUT: ");
		lblRut.setForeground(Color.WHITE);
		lblRut.setBounds(223, 20, 90, 14);
		panelBienvenida.add(lblRut);
		lblRut.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblRut.setText("RUT: "+alumno.getRut());
		
		JPanel panelDatosUsuario = new JPanel();
		panelDatosUsuario.setBackground(SystemColor.textHighlight);
		panelDatosUsuario.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Alumno", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Century Gothic", Font.PLAIN, 12), Color.WHITE));
		panelDatosUsuario.setBounds(6, 55, 313, 113);
		contentPane.add(panelDatosUsuario);
		panelDatosUsuario.setLayout(null);
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setBounds(15, 65, 248, 14);
		panelDatosUsuario.add(lblEdad);
		lblEdad.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEdad.setText("Edad: "+alumno.getEdad());
		
		final JLabel lblCorreo = new JLabel("Correo: ");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setBounds(15, 20, 248, 14);
		panelDatosUsuario.add(lblCorreo);
		lblCorreo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblCorreo.setText("Correo: "+alumno.getCorreo());
		
		final JLabel lblDireccion = new JLabel("Direcci\u00F3n: ");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setBounds(15, 43, 248, 14);
		panelDatosUsuario.add(lblDireccion);
		lblDireccion.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDireccion.setText("Direcci�n: "+alumno.getDireccion());
		
		final JLabel lblTelefono = new JLabel("Tel\u00E9fono: ");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setBounds(15, 88, 248, 14);
		panelDatosUsuario.add(lblTelefono);
		lblTelefono.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTelefono.setText("Tel�fono: "+alumno.getTelefono());
		
//----------------------------------------------------------------------------------------------------------------------		
																	
		final JLabel lblmodificarCorreo = new JLabel("[Modificar]");
		lblmodificarCorreo.setBounds(246, 22, 57, 14);
		panelDatosUsuario.add(lblmodificarCorreo);
		lblmodificarCorreo.setForeground(Color.BLACK);
		lblmodificarCorreo.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		
//------------------------------------------------------------------------------------------------------------------------		
						
		final JLabel lblmodificarDireccion = new JLabel("[Modificar]");
		lblmodificarDireccion.setBounds(246, 42, 57, 14);
		panelDatosUsuario.add(lblmodificarDireccion);
		lblmodificarDireccion.setForeground(Color.BLACK);
		lblmodificarDireccion.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		
//------------------------------------------------------------------------------------------------------------------------		
							
		final JLabel lblmodificarTelefono = new JLabel("[Modificar]");
		lblmodificarTelefono.setBounds(246, 88, 57, 14);
		panelDatosUsuario.add(lblmodificarTelefono);
		lblmodificarTelefono.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblmodificarTelefono.setForeground(Color.BLACK);
				
//------------------------------------------------------------------------------------------------------------------------		
		
		//Modifica el telefono al presionar en el label [Modificar]
		lblmodificarTelefono.addMouseListener(new MouseListener() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				String telefonoAntiguo = JOptionPane.showInputDialog(null, "Ingrese su antiguo tel�fono: ", "Cambiar tel�fono : ", JOptionPane.QUESTION_MESSAGE);
				int telefonoAntiguoInt = 0, nuevoTelefono = 0;
				if(telefonoAntiguo != null)
				{
					if(!telefonoAntiguo.equals(""))
					{
						if(telefonoAntiguo.matches("[0-9]*"))
						{
							telefonoAntiguoInt = Integer.parseInt(telefonoAntiguo);
							if(alumno.getTelefono() == telefonoAntiguoInt)
							{
								String editarTelefono = JOptionPane.showInputDialog(null, "Ingrese su nuevo tel�fono: ", "Edite tel�fono : ", JOptionPane.QUESTION_MESSAGE);
								if(editarTelefono != null && !editarTelefono.equals(""))
								{
									if(editarTelefono.matches("[0-9]*"))
									{
										if(editarTelefono.length() == 8)
										{
											nuevoTelefono = Integer.parseInt(editarTelefono);
											alumno.setTelefono(nuevoTelefono);
											lblTelefono.setText("Telefono: "+alumno.getTelefono());
											
											JOptionPane.showMessageDialog(VentanaAlumno.this, "Tel�fono cambiado Exitosamente!");
										}else{
											JOptionPane.showMessageDialog(VentanaAlumno.this, "Numero debe ser de 8 digitos");
										}
									}else{
										JOptionPane.showMessageDialog(VentanaAlumno.this, "Ingresar s�lo numeros");
									}
								}else{
									JOptionPane.showMessageDialog(VentanaAlumno.this, "Falt� rellenar campo");
								}	
							}else{
								JOptionPane.showMessageDialog(VentanaAlumno.this, "El tel�fono ingresado no coincide con el antiguo");
							}
						}else{
							JOptionPane.showMessageDialog(VentanaAlumno.this, "Ingresar s�lo numeros");
						}
					}else{
						JOptionPane.showMessageDialog(VentanaAlumno.this, "Falt� rellenar campo");
					}
				}
			}
				
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarTelefono.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarTelefono.setForeground(Color.BLACK);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
						
		//Modifica la direccion al presionar en el label [Modificar]
		lblmodificarDireccion.addMouseListener(new MouseListener() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				String direccionAntigua = JOptionPane.showInputDialog(null, "Ingrese su antigua direcci�n: ", "Cambiar direcci�n : ", JOptionPane.QUESTION_MESSAGE);
				if(direccionAntigua != null)
				{
					if(!direccionAntigua.equals(""))
					{
						if(alumno.getDireccion().equals(direccionAntigua))
						{
							String editarDireccion = JOptionPane.showInputDialog(null, "Ingrese su nueva direcci�n: ", "Edite direcci�n : ", JOptionPane.QUESTION_MESSAGE);
							if(editarDireccion != null && !editarDireccion.equals(""))
							{
								alumno.setDireccion(editarDireccion);
								lblDireccion.setText("Direccion: "+alumno.getDireccion());
								
								JOptionPane.showMessageDialog(VentanaAlumno.this, "Direcci�n cambiada Exitosamente!");
							}else{
								JOptionPane.showMessageDialog(VentanaAlumno.this, "Falt� rellenar campo");
							}
						}else{
							JOptionPane.showMessageDialog(VentanaAlumno.this, "La direcci�n ingresada no coincide con la antigua");
						}
					}else{
						JOptionPane.showMessageDialog(VentanaAlumno.this, "Falt� rellenar campo");
					}
				}
			}
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarDireccion.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarDireccion.setForeground(Color.BLACK);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
				
		
		//Modifica el correo al presionar en el label [Modificar]
		lblmodificarCorreo.addMouseListener(new MouseListener() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				String correoAntiguo = JOptionPane.showInputDialog(null, "Ingrese su antiguo correo: ", "Cambiar correo : ", JOptionPane.QUESTION_MESSAGE);
				
				if(correoAntiguo != null)
				{
					if(!correoAntiguo.equals(""))
					{
						if(alumno.getCorreo().equals(correoAntiguo)){
							String editarCorreo = JOptionPane.showInputDialog(null, "Ingrese su nuevo correo: ", "Edite correo : ", JOptionPane.QUESTION_MESSAGE);
							if(editarCorreo != null && !editarCorreo.equals(""))
							{
								if(editarCorreo.matches("[-\\w\\.]+@\\w+\\.\\w+"))//debe aparecer si o si el @ y el punto.
								{
									alumno.setCorreo(editarCorreo);
									lblCorreo.setText("Correo: "+alumno.getCorreo());
								
									JOptionPane.showMessageDialog(VentanaAlumno.this, "Correo cambiada Exitosamente!");
								}else{
									JOptionPane.showMessageDialog(VentanaAlumno.this, "El correo debe contener al menos un '@' y un '.'");
								}	
							}else{
								JOptionPane.showMessageDialog(VentanaAlumno.this, "Falt� rellenar campo");
							}
						}else{
							JOptionPane.showMessageDialog(VentanaAlumno.this, "El correo ingresado no coincide con el antiguo");
						}
					}else{
						JOptionPane.showMessageDialog(VentanaAlumno.this, "Falt� rellenar campo");
					}
				}
			}
			//Al pasar por encima el mouse
			public void mouseEntered(MouseEvent arg0) 
			{
				lblmodificarCorreo.setForeground(Color.red);
			}
			//Cuando sacas de encima el mouse
			public void mouseExited(MouseEvent arg0) 
			{
				lblmodificarCorreo.setForeground(Color.BLACK);
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		
//------------------------------------------------------------------------------------------------------------------------		
		
		//BOTON RECETAS PROPIAS
		JButton btnCrearReceta = new JButton("Recetas Propias");
		btnCrearReceta.setBackground(UIManager.getColor("Button.background"));
		btnCrearReceta.setBounds(10, 179, 145, 45);
		btnCrearReceta.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCrearReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				misRecetas= new VentanaMisRecetas(alumno,VentanaAlumno.this);
				misRecetas.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnCrearReceta);
		
//------------------------------------------------------------------------------------------------------------------------
		
		//BOTON BUSCAR RECETA
		JButton btnBuscarReceta = new JButton("Buscar Receta");
		btnBuscarReceta.setBackground(UIManager.getColor("Button.background"));
		btnBuscarReceta.setBounds(169, 179, 145, 45);
		btnBuscarReceta.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnBuscarReceta.addActionListener(new ActionListener() 					
		{
			public void actionPerformed(ActionEvent e) 
			{
				ArrayList<Receta> arrayRecetas = universidad.TodasLasRecetas();
				VentanaBuscarReceta ventanaBusqueda = new VentanaBuscarReceta(arrayRecetas, VentanaAlumno.this,alumno);
				ventanaBusqueda.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBuscarReceta);
		
//------------------------------------------------------------------------------------------------------------------------
		
		//BOTON CERRAR SESION
		JButton btnAtras = new JButton("Cerrar Sesion");
		btnAtras.setBackground(UIManager.getColor("Button.background"));
		btnAtras.setBounds(169, 227, 145, 45);
		btnAtras.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnAtras.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{			
				Archivos archivo = new Archivos();
				try {
					archivo.actualizarTxtAlumno(alumno);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				ventanaAnterior.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnAtras);
		
//------------------------------------------------------------------------------------------------------------------------
		
		JButton btnCambiarContrasea = new JButton("Cambiar Contrase\u00F1a");	//BOTON CAMBIAR CONTRASE�A
		btnCambiarContrasea.setBackground(UIManager.getColor("Button.background"));
		btnCambiarContrasea.setBounds(10, 228, 145, 45);
		btnCambiarContrasea.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		btnCambiarContrasea.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String editarContrasena = JOptionPane.showInputDialog(null, "Ingrese su contrase�a actual: ", "Edite contrase�a : ", JOptionPane.QUESTION_MESSAGE);
			
				if(editarContrasena != null)
				{
					if(alumno.getContrasena().equals(editarContrasena))
					{
						String contrasenaEditada = JOptionPane.showInputDialog(null, "Ingrese su nueva contrase�a: ", "Edite contrase�a : ", JOptionPane.QUESTION_MESSAGE);
						alumno.setContrasena(contrasenaEditada);
						System.out.println("Su nueva contrase�a es : "+alumno.getContrasena());
					}else{
						JOptionPane.showMessageDialog(VentanaAlumno.this, "Contrase�a ingresada es incorrecta o falt� rellenar campo");
					}
				}
			}
		});
		contentPane.add(btnCambiarContrasea);
	}
}

