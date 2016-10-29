import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class VentanaEliminarAlumno extends JFrame {

	private JPanel contentPane;
	private Archivos archivo;

	public VentanaEliminarAlumno(final Universidad universidad,final Alumno alumno, final VentanaDocente ventanaAnterior) {
		setTitle("Ventana Eliminar Alumno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
//------------------------------------------------------------------------------------------------------------------------
													//BOTONES
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaAnterior.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnAtras.setBounds(33, 192, 113, 30);
		contentPane.add(btnAtras);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(230, 192, 113, 30);
		contentPane.add(btnSalir);
		
		JPanel panelDatosAlumno = new JPanel();
		panelDatosAlumno.setBorder(new TitledBorder(null, "Datos alumno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatosAlumno.setBounds(10, 13, 357, 168);
		contentPane.add(panelDatosAlumno);
		panelDatosAlumno.setLayout(null);
		
			JLabel lblInformacionUsuario = new JLabel("Nombre :");
			lblInformacionUsuario.setBounds(21, 21, 232, 14);
			panelDatosAlumno.add(lblInformacionUsuario);
			lblInformacionUsuario.setText("Nombre: "+alumno.getNombrePersona());
			
			JLabel lblRut = new JLabel("RUT: ");
			lblRut.setBounds(263, 21, 94, 14);
			panelDatosAlumno.add(lblRut);
			lblRut.setText("RUT: "+alumno.getRut());
			
			JLabel lblCorreo = new JLabel("Correo: ");
			lblCorreo.setBounds(21, 46, 326, 14);
			panelDatosAlumno.add(lblCorreo);
			lblCorreo.setText("Correo: "+alumno.getCorreo());
			
			JLabel lblDireccion = new JLabel("Direcci\u00F3n: ");
			lblDireccion.setBounds(21, 71, 326, 14);
			panelDatosAlumno.add(lblDireccion);
			lblDireccion.setText("Dirección: "+alumno.getDireccion());
			
			JLabel lblEdad = new JLabel("Edad: ");
			lblEdad.setBounds(21, 95, 151, 14);
			panelDatosAlumno.add(lblEdad);
			lblEdad.setText("Edad: "+alumno.getEdad());
			
			JLabel lblTelefono = new JLabel("Tel\u00E9fono: ");
			lblTelefono.setBounds(21, 120, 159, 14);
			panelDatosAlumno.add(lblTelefono);
			lblTelefono.setText("Teléfono: "+alumno.getTelefono());
			
			JButton btnEliminarAlumno = new JButton("Eliminar Alumno");
			btnEliminarAlumno.setBounds(196, 127, 151, 30);
			panelDatosAlumno.add(btnEliminarAlumno);
			btnEliminarAlumno.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)  {
					if(universidad.getListaAlumnos().eliminarAlumno(alumno))
						JOptionPane.showMessageDialog(null,"Datos eliminados exitosamente","Eliminar UsuarioEstandar",JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null,"Ha ocurrido un error al eliminar","Eliminar UsuarioEstandar",JOptionPane.ERROR_MESSAGE);
					}
			});

	}
}
