package GUI;
import Logic.*;

import java.awt.EventQueue;

import javax.swing.JDialog;

import java.awt.Toolkit;

import Componentes.JTextFieldLimitado;
import Logic.Tienda;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.text.html.parser.ContentModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import Componentes.JPasswordFieldLimitado;

public class Login extends JDialog {
	private Tienda tienda;
	private boolean correcto = false;
	private boolean gerencia = false;
	private String usuario;

	public Login(Tienda tiendaPC) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		setResizable(false);
		setTitle("Ingrese sus credenciales");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 586, 398);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		tienda = tiendaPC;

		JLabel lblIngreseLaContrasea = new JLabel("Ingrese la contrase\u00F1a");
		lblIngreseLaContrasea.setForeground(Color.WHITE);
		lblIngreseLaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngreseLaContrasea.setBounds(189, 156, 196, 23);
		getContentPane().add(lblIngreseLaContrasea);

		JLabel lblIngreseElUsuario = new JLabel("Ingrese el usuario");
		lblIngreseElUsuario.setForeground(Color.WHITE);
		lblIngreseElUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngreseElUsuario.setBounds(201, 84, 169, 23);
		getContentPane().add(lblIngreseElUsuario);

		final JTextFieldLimitado user = new JTextFieldLimitado();
		user.setFont(new Font("Tahoma", Font.PLAIN, 14));
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setLimit(30);
		user.setBounds(133, 118, 295, 20);
		getContentPane().add(user);

		final JPasswordFieldLimitado password = new JPasswordFieldLimitado();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		password.setLimit(11);
		password.setBounds(133, 190, 295, 20);
		getContentPane().add(password);



		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBackground(Color.WHITE);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!user.getText().isEmpty() && !password.getText().isEmpty()){
					for(Trabajador t : tienda.getTrabajadores())
						if(t.getNombre().equals(user.getText().trim()) && t.getId().equals(password.getText())){
							correcto = true;
							usuario = t.getNombre();
						}
					if(correcto){
						JOptionPane.showMessageDialog(null, "Las credenciales ingresadas son correctas.","Información Correcta",JOptionPane.INFORMATION_MESSAGE);
						if(usuario.equals(tienda.getGerente().getNombre()))
							gerencia = true;
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									MenuTienda frame = new MenuTienda(tienda, usuario,gerencia);
									frame.setVisible(true);
									dispose();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});

					}
					else 
						JOptionPane.showMessageDialog(null, "Credenciales incorrectas.","Información incorrecta",JOptionPane.ERROR_MESSAGE);

				}
				else
					JOptionPane.showMessageDialog(null, "No deje campos vacíos.","Información no ingresada",JOptionPane.ERROR_MESSAGE);



			}
		});
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnContinuar.setBounds(230, 248, 110, 23);
		getContentPane().add(btnContinuar);

		final JCheckBox showPass = new JCheckBox("Mostrar");
		showPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (showPass.isSelected()) {
					password.setEchoChar((char) 0);
				} else 
					password.setEchoChar('\u2022');

			}
		});
		showPass.setForeground(Color.BLACK);
		showPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		showPass.setBackground(Color.WHITE);
		showPass.setBounds(441, 190, 73, 20);
		getContentPane().add(showPass);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Resources/fondoLogin.jpg")));
		label.setBounds(0, 0, 580, 369);
		getContentPane().add(label);


	}
}
