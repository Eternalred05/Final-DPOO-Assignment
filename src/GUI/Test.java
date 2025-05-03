package GUI;

import Logic.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Test extends JFrame {

	private JPanel contentPane;
	private JButton btnInfoTienda;
	private JLabel lblEstoEstaEn;
	Tienda timbirichi;
	private JLabel lblTimbirichiCujae;
	public Test(Tienda tienda) {
		timbirichi = tienda;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnInfoTienda());
		contentPane.add(getLblEstoEstaEn());
		contentPane.add(getLblTimbirichiCujae());
	}

	private JButton getBtnInfoTienda() {
		if (btnInfoTienda == null) {
			btnInfoTienda = new JButton("Info Tienda");
			btnInfoTienda.setBounds(162, 127, 112, 23);
		}
		return btnInfoTienda;
	}
	private JLabel getLblEstoEstaEn() {
		if (lblEstoEstaEn == null) {
			lblEstoEstaEn = new JLabel("Esto esta en construccion, vaya a otro lado");
			lblEstoEstaEn.setBounds(96, 89, 299, 14);
		}
		return lblEstoEstaEn;
	}
	private JLabel getLblTimbirichiCujae() {
		if (lblTimbirichiCujae == null) {
			lblTimbirichiCujae = new JLabel("Timbirichi CUJAE");
			lblTimbirichiCujae.setFont(new Font("Algerian", Font.PLAIN, 24));
			lblTimbirichiCujae.setBounds(96, 25, 206, 53);
		}
		return lblTimbirichiCujae;
	}
}
