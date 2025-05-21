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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

import javax.swing.JTextField;

import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

public class MenuTienda extends JFrame {

	private JPanel contentPane;
	private Tienda tiendaPC;
	private int counterTrabajador = 0;
	private JTextField nombreTrabajador;
	private JTextField apellidosTrabajador;
	private JTextField idTrabajador;

	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel defaultComboBoxModel;
	private JTextField salarioTrabajador;
	private JTable tableTrabajador;
	private boolean inicializarTrabajadores = false;

	public MenuTienda(Tienda tienda) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuTienda.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		setTitle("Men\u00FA Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// igualar tienda ingresada como parametro
		tiendaPC = tienda;

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 766, 21);
		contentPane.add(menuBar);

		JMenu mnGerencia = new JMenu("Gerencia");
		menuBar.add(mnGerencia);
		JPanel panel = new JPanel();
		panel.setBounds(0, 21, 766, 476);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));

		final JPanel panelInicio = new JPanel();
		panel.add(panelInicio, "panelInicio");
		panelInicio.setLayout(null);

		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblBienvenido.setBounds(268, 11, 156, 39);
		panelInicio.add(lblBienvenido);

		final JPanel paneIngresarTrabajador = new JPanel();
		panel.add(paneIngresarTrabajador, "paneIngresarTrabajador");
		paneIngresarTrabajador.setLayout(null);

		JPanel panelMotherboard = new JPanel();
		panel.add(panelMotherboard, "panelMotherboard");

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial Black", Font.PLAIN, 23));
		lblNombre.setBounds(308, 56, 103, 34);
		paneIngresarTrabajador.add(lblNombre);

		JLabel lblIngresarTrabajador = new JLabel("Ingresar Trabajador");
		lblIngresarTrabajador.setFont(new Font("Algerian", Font.PLAIN, 21));
		lblIngresarTrabajador.setBounds(238, 11, 251, 20);
		paneIngresarTrabajador.add(lblIngresarTrabajador);

		nombreTrabajador = new JTextField();
		nombreTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		nombreTrabajador.setBounds(238, 101, 251, 20);
		paneIngresarTrabajador.add(nombreTrabajador);
		nombreTrabajador.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Arial Black", Font.PLAIN, 23));
		lblApellidos.setBounds(297, 128, 126, 34);
		paneIngresarTrabajador.add(lblApellidos);

		apellidosTrabajador = new JTextField();
		apellidosTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		apellidosTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		apellidosTrabajador.setColumns(10);
		apellidosTrabajador.setBounds(238, 165, 251, 20);
		paneIngresarTrabajador.add(apellidosTrabajador);

		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setFont(new Font("Arial Black", Font.PLAIN, 23));
		lblIdentificador.setBounds(281, 193, 164, 34);
		paneIngresarTrabajador.add(lblIdentificador);

		idTrabajador = new JTextField();
		idTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		idTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		idTrabajador.setColumns(10);
		idTrabajador.setBounds(238, 228, 251, 20);
		paneIngresarTrabajador.add(idTrabajador);

		JPanel panel_1 = new JPanel(); // panel para los datos a ingresar
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(66, 56, 628, 228);
		paneIngresarTrabajador.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel(); // panel para los combobox y el salario
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(66, 296, 489, 94);
		paneIngresarTrabajador.add(panel_2);
		panel_2.setLayout(null);


		// ComboBox relacionado con los cargos de la tienda

		final JComboBox comboBoxCargo = new JComboBox();
		comboBoxCargo.setFont(new Font("Arial Black", Font.PLAIN, 11));
		comboBoxCargo.setBounds(7, 30, 173, 20);
		Object[] cargos = new Object[8];
		cargos[0]="";
		cargos[1]= "Gestor de Ventas";
		cargos[2]= "Encargado de inventario";
		cargos[3]="Asesor de ventas";
		cargos[4]="Especialista en productos";
		cargos[5]="Encargado de servicio";
		cargos[6]="Especialista en software";
		cargos[7]="Subgerente";

		defaultComboBoxModel = new DefaultComboBoxModel(cargos);
		comboBoxCargo.setModel(defaultComboBoxModel);
		panel_2.add(comboBoxCargo);

		JLabel lblCargo_1 = new JLabel("Cargo");
		lblCargo_1.setBounds(48, -1, 87, 34);
		panel_2.add(lblCargo_1);
		lblCargo_1.setFont(new Font("Arial Black", Font.PLAIN, 23));

		// Combo Box relacionado con los niveles escolares

		final JComboBox comboBoxEscolar = new JComboBox();
		comboBoxEscolar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		comboBoxEscolar.setBounds(200, 30, 151, 20);

		Object[] niveles = new Object[8];
		niveles[0]="";
		niveles[1]= "Primario";
		niveles[2]= "Secundario";
		niveles[3]="Preuniversitario";
		niveles[4]="Técnico Medio";
		niveles[5]="Obrero Calificado";
		niveles[6]="Universitario";
		cargos[7]="Técnico profesional";

		defaultComboBoxModel = new DefaultComboBoxModel(niveles);
		comboBoxEscolar.setModel(defaultComboBoxModel);
		panel_2.add(comboBoxEscolar);

		JLabel lblNivelEscolar = new JLabel("Nivel \r\nEscolar");
		lblNivelEscolar.setBounds(191, -1, 184, 34);
		panel_2.add(lblNivelEscolar);
		lblNivelEscolar.setFont(new Font("Arial Black", Font.PLAIN, 23));

		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Arial Black", Font.PLAIN, 23));
		lblSalario.setBounds(374, -1, 105, 34);
		panel_2.add(lblSalario);

		salarioTrabajador = new JTextField();
		salarioTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		salarioTrabajador.setBounds(374, 30, 103, 20);
		panel_2.add(salarioTrabajador);
		salarioTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		salarioTrabajador.setColumns(10);

		JLabel lblNumeroDeId = new JLabel("Numero de ID actual");
		lblNumeroDeId.setBounds(59, 401, 198, 25);
		paneIngresarTrabajador.add(lblNumeroDeId);
		lblNumeroDeId.setFont(new Font("Arial Black", Font.PLAIN, 17));

		JPanel numId = new JPanel();
		numId.setBackground(Color.WHITE);
		numId.setBounds(255, 401, 35, 34);
		paneIngresarTrabajador.add(numId);
		numId.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		numId.setLayout(null);

		final JLabel numIDT = new JLabel("0");
		numIDT.setFont(new Font("Arial Black", Font.PLAIN, 15));
		numIDT.setHorizontalAlignment(SwingConstants.CENTER);
		numIDT.setBounds(0, 0, 35, 34);
		numId.add(numIDT);




		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = nombreTrabajador.getText();
				String apellidos = apellidosTrabajador.getText();
				String id = idTrabajador.getText();
				String cargo =(String)comboBoxCargo.getSelectedItem();
				String escolaridad = (String) comboBoxEscolar.getSelectedItem();
				double salario; 
				try{
					salario = Double.parseDouble(salarioTrabajador.getText());
					tiendaPC.addTrabajador(nombre,apellidos,id,counterTrabajador,salario,escolaridad,cargo);
					Object trabajador [] = {String.valueOf(counterTrabajador),nombre,apellidos,cargo,id,escolaridad,String.valueOf(salario)};
					DefaultTableModel modelo = (DefaultTableModel) tableTrabajador.getModel();
					modelo.addRow(trabajador);
					JOptionPane.showMessageDialog(null,"Los datos del trabajador han sido ingresados satisfactoriamente a la Tienda","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);
					counterTrabajador++;
					numIDT.setText(Integer.toString(counterTrabajador));
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null,"El salario esta vacio","Error",JOptionPane.ERROR_MESSAGE);
				}
				catch (IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 21));
		btnNewButton.setBounds(565, 295, 129, 62);
		paneIngresarTrabajador.add(btnNewButton);

		JButton btnInicializar = new JButton("Inicializar");
		btnInicializar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!inicializarTrabajadores){

					String[][] trabajadores = {
							{"Gloria", "Santos Rosado", "06030867876", "5000", "Preuniversitario", "Especialista en productos"},
							{"Jorge Luis", "Valdés Piñeda", "97070758088", "15000", "Universitario", "Subgerente"},
							{"Javier", "Soto Villanueva", "05090160882", "7000", "Universitario", "Asesor de Ventas"},
							{"Ronal", "Sálazar Hernández", "05101568066", "6500", "Universitario", "Especialista en Software"},
							{"Aylin", "Vázquez Alvarez", "06061367412", "4000", "Obrero Calificado", "Encargado de inventario"}
					};

					for (String[] datos : trabajadores) {
						try {

							tiendaPC.addTrabajador(datos[0], datos[1], datos[2], counterTrabajador,Integer.parseInt(datos[3]), datos[4], datos[5]);
							Object trabajador [] = {String.valueOf(counterTrabajador),datos[0],datos[1],datos[5],datos[2],datos[4],datos[3]};
							DefaultTableModel modelo = (DefaultTableModel) tableTrabajador.getModel();
							modelo.addRow(trabajador);
							counterTrabajador++;
							numIDT.setText(Integer.toString(counterTrabajador));

						} catch (IllegalArgumentException e) {
							JOptionPane.showMessageDialog(null,"El trabajador llamado: "+ datos[0]+" "+ datos[1]+" ya se habia ingresado, se procederá a ingresar el proximo que no se haya añadido previamente.","Trabajador Ingresado previamente",JOptionPane.ERROR_MESSAGE);
						}
					}
					inicializarTrabajadores = true;
					JOptionPane.showMessageDialog(null,"Se han inicializado los datos de prueba correctamente.","Datos Inicializados correctamente",JOptionPane.INFORMATION_MESSAGE);	
				} 
				else
					JOptionPane.showMessageDialog(null,"Ya se inicializaron los datos de los trabajadores.","Ya se inicializaron estos datos",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnInicializar.setFont(new Font("Arial Black", Font.PLAIN, 21));
		btnInicializar.setBounds(584, 403, 172, 62);
		paneIngresarTrabajador.add(btnInicializar);


		final JPanel panelListaTrabajadores = new JPanel();
		panel.add(panelListaTrabajadores, "ListaTrabajador");
		panelListaTrabajadores.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 95, 756, 370);
		panelListaTrabajadores.add(scrollPane);

		tableTrabajador = new JTable();

		tableTrabajador.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00FAmero", "Nombre", "Apellidos", "Cargo", "Carnet", "Nivel Escolar", "Salario"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTrabajador.getColumnModel().getColumn(0).setResizable(false);
		tableTrabajador.getColumnModel().getColumn(0).setPreferredWidth(47);
		tableTrabajador.getColumnModel().getColumn(1).setResizable(false);
		tableTrabajador.getColumnModel().getColumn(2).setResizable(false);
		tableTrabajador.getColumnModel().getColumn(2).setPreferredWidth(85);
		tableTrabajador.getColumnModel().getColumn(3).setResizable(false);
		tableTrabajador.getColumnModel().getColumn(3).setPreferredWidth(125);
		tableTrabajador.getColumnModel().getColumn(4).setResizable(false);
		tableTrabajador.getColumnModel().getColumn(4).setPreferredWidth(70);
		tableTrabajador.getColumnModel().getColumn(5).setResizable(false);
		tableTrabajador.getColumnModel().getColumn(5).setPreferredWidth(84);
		tableTrabajador.getColumnModel().getColumn(6).setResizable(false);
		tableTrabajador.getColumnModel().getColumn(6).setPreferredWidth(61);
		scrollPane.setViewportView(tableTrabajador);

		JMenuItem mntmAadirTrabajador = new JMenuItem("A\u00F1adir Trabajador");
		mntmAadirTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.setVisible(false);
				paneIngresarTrabajador.setVisible(true);
				panelListaTrabajadores.setVisible(false);

			}
		});
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
		mntmMostrarListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.setVisible(false);
				paneIngresarTrabajador.setVisible(false);
				panelListaTrabajadores.setVisible(true);
			}
		});
		mnNewMenu.add(mntmMostrarListado);

		JMenuItem mntmMostrarListadoDe = new JMenuItem("Mostrar Listado de Componentes");
		mnNewMenu.add(mntmMostrarListadoDe);

		JMenuItem mntmMostrarListadoDe_1 = new JMenuItem("Mostrar Listado de PC conformadas");
		mnNewMenu.add(mntmMostrarListadoDe_1);

		JMenu mnInformacin = new JMenu("Informaci\u00F3n Adicional");
		menuBar.add(mnInformacin);

		JMenuItem mntmDatosDeLa = new JMenuItem("Datos de la Tienda");
		mntmDatosDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					InfoTienda dialog = new InfoTienda(tiendaPC);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mnInformacin.add(mntmDatosDeLa);

		JMenuItem mntmInformacionDeLos = new JMenuItem("Informacion de los Desarrolladores");
		mntmInformacionDeLos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Desarrollado por Alexandro Valdés Piñeda y Gloria Santos Rosado, Grupo 12 Facultad de Ingeniería Informática","Info Desarrollo",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnInformacin.add(mntmInformacionDeLos);

		JMenuItem mntmInicio = new JMenuItem("Volver al Inicio");
		mnInformacin.add(mntmInicio);
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.setVisible(true);
				paneIngresarTrabajador.setVisible(false);
			}
		});

	}
}
