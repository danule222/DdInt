package pruebaInicialDI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ventanaLogin {

	static Connection conexion;
	
	private JFrame frame;
	private JLabel lblUsuario;
	private JTextField tfUsuario;
	private JLabel lblContrasenna;
	private JTextField tfContrasenna;
	private JButton btnLogin;

	/**
	 * Iniciar la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conectarBDD();
					ventanaLogin window = new ventanaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crear la aplicación.
	 */
	public ventanaLogin() {
		initialize();
	}

	/**
	 * Inicializar el contenido de la ventana.
	 */
	private void initialize() {
		frame = new JFrame("Inicio de sesión");
		frame.setBounds(100, 100, 282, 158);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 13, 95, 14);
		frame.getContentPane().add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(91, 11, 165, 20);
		frame.getContentPane().add(tfUsuario);
		
		lblContrasenna = new JLabel("Contrase\u00F1a");
		lblContrasenna.setBounds(10, 40, 95, 14);
		frame.getContentPane().add(lblContrasenna);
		
		tfContrasenna = new JTextField();
		tfContrasenna.setColumns(10);
		tfContrasenna.setBounds(91, 38, 165, 20);
		frame.getContentPane().add(tfContrasenna);
		
		JLabel msgSistema = new JLabel("");
		msgSistema.setHorizontalAlignment(SwingConstants.CENTER);
		msgSistema.setForeground(Color.GRAY);
		msgSistema.setBounds(10, 65, 246, 14);
		frame.getContentPane().add(msgSistema);
		
		btnLogin = new JButton("Iniciar sesi\u00F3n");
		btnLogin.addActionListener(new ActionListener() {
			
			/**
			 * Genera una consulta en la que se comprueba con los datos introducidos
			 * en los campos "Usuario" y "Contraseña" si el usuario existe en la base
			 * de datos.
			 */
			public void actionPerformed(ActionEvent e) {
				String usuario = tfUsuario.getText();
				String contrasenna = tfContrasenna.getText();
				
				Statement consulta;
				ResultSet resultado = null;
				try {
					consulta = conexion.createStatement();
					resultado = consulta.executeQuery("SELECT count(nombre) FROM usuarios WHERE nombre = \"" + usuario
							+ "\" AND contrasenna = \"" + contrasenna + "\";");
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("Problema al crear consulta.");
				}
				String vof = null;
				try {
					while (resultado.next()) {
					    
						try {
							vof = resultado.getString("count(nombre)");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println(usuario + "\n" + contrasenna);
				System.out.println(vof);
				if (vof.equals("1")) {
					msgSistema.setText("Usuario existente.");
				} else {
					msgSistema.setText("Usuario no existente.");
				}
			}
		});
		btnLogin.setBounds(71, 85, 125, 23);
		frame.getContentPane().add(btnLogin);
	}
	
	/**
	 * Establecer contacto con la base de datos.
	 */
	public static void conectarBDD() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			conexion = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/pruebainicialdi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
			"daniel","7880");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
