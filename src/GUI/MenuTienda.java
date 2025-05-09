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

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuTienda extends JFrame {

	private JPanel contentPane;
	Tienda timbirichi;
	private JLabel lblTimbirichiCujae;
	public MenuTienda(Tienda tienda) {
		setTitle("Men\u00FA Tienda");
		timbirichi = tienda;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblTimbirichiCujae());

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 766, 21);
		contentPane.add(menuBar);

		JMenu mnGerencia = new JMenu("Gerencia");
		menuBar.add(mnGerencia);

		JMenuItem mntmAadirTrabajador = new JMenuItem("A\u00F1adir Trabajador");
		mnGerencia.add(mntmAadirTrabajador);

		JMenu mnAadirComponentes = new JMenu("A\u00F1adir Componentes");
		mnGerencia.add(mnAadirComponentes);

		JMenuItem mntmMotherboard = new JMenuItem("Motherboard");
		mnAadirComponentes.add(mntmMotherboard);

		JMenuItem mntmRam = new JMenuItem("RAM");
		mnAadirComponentes.add(mntmRam);

		JMenuItem mntmDiscosDuros = new JMenuItem("Discos Duros");
		mnAadirComponentes.add(mntmDiscosDuros);

		JMenuItem mntmProcesadorcpu = new JMenuItem("Procesador(CPU)");
		mnAadirComponentes.add(mntmProcesadorcpu);

		JMenuItem mntmCrearPc = new JMenuItem("Crear PC");
		mnGerencia.add(mntmCrearPc);

		JMenu mnNewMenu = new JMenu("Reportes");
		menuBar.add(mnNewMenu);

		JMenuItem mntmMostrarListado = new JMenuItem("Mostrar Listado de Trabajadores");
		mnNewMenu.add(mntmMostrarListado);

		JMenuItem mntmMostrarListadoDe = new JMenuItem("Mostrar Listado de Componentes");
		mnNewMenu.add(mntmMostrarListadoDe);

		JMenuItem mntmMostrarListadoDe_1 = new JMenuItem("Mostrar Listado de PC conformadas");
		mnNewMenu.add(mntmMostrarListadoDe_1);

		JMenu mnInformacin = new JMenu("Informaci\u00F3n");
		menuBar.add(mnInformacin);

		JMenuItem mntmDatosDeLa = new JMenuItem("Datos de la Tienda");
		mnInformacin.add(mntmDatosDeLa);

		JMenuItem mntmInformacionDeLos = new JMenuItem("Informacion de los Desarrolladores");
		mntmInformacionDeLos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Desarrollado por Alexandro Valdés Piñeda y Gloria Santos Rosado, Grupo 12 Facultad de Ingeniería Informática","Info Desarrollo",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnInformacin.add(mntmInformacionDeLos);
	}
	private JLabel getLblTimbirichiCujae() {
		if (lblTimbirichiCujae == null) {
			lblTimbirichiCujae = new JLabel("Timbirichi CUJAE REAL NO FAKE");
			lblTimbirichiCujae.setFont(new Font("Algerian", Font.PLAIN, 30));
			lblTimbirichiCujae.setBounds(136, 32, 504, 53);
		}
		return lblTimbirichiCujae;
	}
}
