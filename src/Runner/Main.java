package Runner;

import java.awt.EventQueue;

import javax.swing.JDialog;

import GUI.Login;
import Logic.*;

public class Main {
	private static Tienda tienda;

	public static void inicializar(){
		tienda = Tienda.inicializarTienda();
		tienda.inicializarTrabajadores();
		tienda.inicializarComponentes();
	}

	public static void main(String[] args) {
		inicializar();
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
