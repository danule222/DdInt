package pruebaInicialDI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaLogin {

	private JFrame frame;
	private JLabel lblUsuario;
	private JTextField textField;
	private JLabel lblContrasenna;
	private JTextField textField_1;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaLogin window = new ventanaLogin();
					window.frame.setVisible(true);
					try{  
						Class.forName("com.mysql.jdbc.Driver");  
						Connection conexion = DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/pruebainicialdi","daniel","7880");
						}catch(Exception e){ System.out.println(e);}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Inicio de sesión");
		frame.setBounds(100, 100, 282, 158);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 13, 95, 14);
		frame.getContentPane().add(lblUsuario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(91, 11, 165, 20);
		frame.getContentPane().add(textField);
		
		lblContrasenna = new JLabel("Contrase\u00F1a");
		lblContrasenna.setBounds(10, 40, 95, 14);
		frame.getContentPane().add(lblContrasenna);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 38, 165, 20);
		frame.getContentPane().add(textField_1);
		
		// ACCIÓN AL PRESIONAR EL BOTÓN "INICIAR SESIÓN"
		
		btnLogin = new JButton("Inicar sesi\u00F3n");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLogin.setBounds(71, 85, 125, 23);
		frame.getContentPane().add(btnLogin);
	}

}
