package Runner;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.UIManager;

import GUI.Login;
import Logic.*;
import javafx.scene.text.Font;

public class Main {
	private static Tienda tienda;

	public static void inicializar() {
		tienda = Tienda.inicializarTienda();
		tienda.inicializarTrabajadores();
		tienda.inicializarComponentes();
	}

	private static void setLookAndFeel() {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		UIManager.put("OptionPane.messageFont", new Font("MS Reference Sans Serif", Font.PLAIN, 20));
	}

	public static void main(String[] args) {
		inicializar();
		setLookAndFeel();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login dialog = new Login(tienda);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}