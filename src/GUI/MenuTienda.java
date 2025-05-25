package GUI;

import Logic.*;
import Componentes.*;
import Resources.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;

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
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Componentes.JTextFieldLimitado;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;

public class MenuTienda extends JFrame {

	private JPanel contentPane;
	private Tienda tiendaPC;
	private int counterTrabajador = 0;

	@SuppressWarnings("rawtypes")
	private DefaultTableModel modelo;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel defaultComboBoxModel;
	private JTable tableTrabajador;
	private JTable tableRAM;
	private boolean inicializarTrabajadores = false;
	private boolean inicializarRAMS = false;

	public MenuTienda(Tienda tienda) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuTienda.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		setTitle("Men\u00FA Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 529);
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		setMaximizedBounds(env.getMaximumWindowBounds());
		contentPane = new JPanel();
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
		panelInicio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Men\u00FA Principal de la Tienda", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.add(panelInicio, "panelInicio");
		panelInicio.setLayout(null);

		final JPanel paneIngresarTrabajador = new JPanel();
		paneIngresarTrabajador.setBorder(new TitledBorder(null, "Ingresar Datos de un trabajador", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.add(paneIngresarTrabajador, "paneIngresarTrabajador");
		paneIngresarTrabajador.setLayout(null);

		final JPanel panelMotherboard = new JPanel();
		panelMotherboard.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A\u00F1adir Motherboard al stock", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelMotherboard, "panelMotherboard");
		panelMotherboard.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 39, 746, 359);
		panelMotherboard.add(panel_4);

		JLabel label_3 = new JLabel("Marca");
		label_3.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_3.setBounds(79, 11, 101, 34);
		panel_4.add(label_3);

		JLabel lblTipoDeMemoria = new JLabel("Tipo de Socket");
		lblTipoDeMemoria.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblTipoDeMemoria.setBounds(30, 143, 226, 34);
		panel_4.add(lblTipoDeMemoria);

		JComboBox comboBoxSocketMother = new JComboBox();
		comboBoxSocketMother.setModel(new DefaultComboBoxModel(new String[] {"", "LGA", "PGA", "BGA"}));
		comboBoxSocketMother.setFont(new Font("Arial Black", Font.PLAIN, 17));
		comboBoxSocketMother.setBounds(66, 188, 129, 27);
		panel_4.add(comboBoxSocketMother);

		JLabel label_8 = new JLabel("Precio base");
		label_8.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_8.setBounds(20, 83, 172, 49);
		panel_4.add(label_8);

		JLabel label_9 = new JLabel("Cantidad de unidades");
		label_9.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_9.setBounds(357, 83, 298, 49);
		panel_4.add(label_9);

		JSpinner spinnerPrecioBaseMotherboard = new JSpinner();
		spinnerPrecioBaseMotherboard.setModel(new SpinnerNumberModel(0, 0, 250, 1));
		spinnerPrecioBaseMotherboard.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerPrecioBaseMotherboard.setBounds(188, 95, 81, 27);
		panel_4.add(spinnerPrecioBaseMotherboard);

		JTextFieldLimitado marcaMotherboard = new JTextFieldLimitado();
		marcaMotherboard.setLimit(15);
		marcaMotherboard.setHorizontalAlignment(SwingConstants.CENTER);
		marcaMotherboard.setFont(new Font("Arial Black", Font.PLAIN, 17));
		marcaMotherboard.setBounds(20, 45, 226, 27);
		panel_4.add(marcaMotherboard);

		JSpinner spinnerUnitsMotherboard = new JSpinner();
		spinnerUnitsMotherboard.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerUnitsMotherboard.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerUnitsMotherboard.setBounds(657, 96, 61, 27);
		panel_4.add(spinnerUnitsMotherboard);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5.setBounds(519, 299, 173, 49);
		panel_4.add(panel_5);

		JLabel labelPrecioMother = new JLabel("0.0000$");
		labelPrecioMother.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrecioMother.setFont(new Font("Arial Black", Font.PLAIN, 20));
		labelPrecioMother.setBounds(10, 11, 153, 27);
		panel_5.add(labelPrecioMother);

		JLabel lblPrecioDelMotherboard = new JLabel("Precio del Motherboard");
		lblPrecioDelMotherboard.setFont(new Font("Arial Black", Font.PLAIN, 23));
		lblPrecioDelMotherboard.setBounds(448, 256, 298, 49);
		panel_4.add(lblPrecioDelMotherboard);

		JLabel label_12 = new JLabel("N\u00FAmero de Serie");
		label_12.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_12.setBounds(279, 11, 242, 34);
		panel_4.add(label_12);

		JTextFieldLimitado idMotherboard = new JTextFieldLimitado();
		idMotherboard.setLimit(10);
		idMotherboard.setHorizontalAlignment(SwingConstants.CENTER);
		idMotherboard.setFont(new Font("Arial Black", Font.PLAIN, 17));
		idMotherboard.setBounds(311, 45, 162, 27);
		panel_4.add(idMotherboard);

		JLabel label_14 = new JLabel("$");
		label_14.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_14.setBounds(279, 90, 51, 34);
		panel_4.add(label_14);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblModelo.setBounds(566, 11, 140, 34);
		panel_4.add(lblModelo);

		JTextFieldLimitado modeloMotherboard = new JTextFieldLimitado();
		modeloMotherboard.setLimit(10);
		modeloMotherboard.setHorizontalAlignment(SwingConstants.CENTER);
		modeloMotherboard.setFont(new Font("Arial Black", Font.PLAIN, 17));
		modeloMotherboard.setBounds(544, 45, 162, 27);
		panel_4.add(modeloMotherboard);

		JLabel lblTiposDeRams = new JLabel("Tipos de RAMS soportadas");
		lblTiposDeRams.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblTiposDeRams.setBounds(335, 143, 372, 34);
		panel_4.add(lblTiposDeRams);

		JComboBox comboBoxRAMMother = new JComboBox();
		comboBoxRAMMother.setModel(new DefaultComboBoxModel(new String[] {"", "DDR", "DDR2", "DDR3", "DDR4", "DDR5"}));
		comboBoxRAMMother.setFont(new Font("Arial Black", Font.PLAIN, 17));
		comboBoxRAMMother.setBounds(470, 188, 129, 27);
		panel_4.add(comboBoxRAMMother);

		JCheckBox chckbxSata = new JCheckBox("SATA");
		chckbxSata.setFont(new Font("Arial Black", Font.PLAIN, 20));
		chckbxSata.setBounds(20, 270, 114, 23);
		panel_4.add(chckbxSata);

		JCheckBox chckbxSata_2 = new JCheckBox("SATA-2");
		chckbxSata_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		chckbxSata_2.setBounds(20, 299, 114, 23);
		panel_4.add(chckbxSata_2);

		JCheckBox chckbxSata_3 = new JCheckBox("SATA-3");
		chckbxSata_3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		chckbxSata_3.setBounds(175, 270, 114, 23);
		panel_4.add(chckbxSata_3);

		JCheckBox chckbxIde = new JCheckBox("IDE");
		chckbxIde.setFont(new Font("Arial Black", Font.PLAIN, 20));
		chckbxIde.setBounds(175, 299, 114, 23);
		panel_4.add(chckbxIde);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_6.setBounds(10, 226, 413, 100);
		panel_4.add(panel_6);

		JLabel lblConexionesDeLos = new JLabel("Conexiones de los discos duros");
		panel_6.add(lblConexionesDeLos);
		lblConexionesDeLos.setFont(new Font("Arial Black", Font.PLAIN, 23));

		JButton buttonInicializarMother = new JButton("Inicializar");
		buttonInicializarMother.setFont(new Font("Arial Black", Font.PLAIN, 21));
		buttonInicializarMother.setBounds(10, 403, 172, 62);
		panelMotherboard.add(buttonInicializarMother);

		JButton buttonIngresarMother = new JButton("Ingresar");
		buttonIngresarMother.setFont(new Font("Arial Black", Font.PLAIN, 21));
		buttonIngresarMother.setBounds(627, 403, 129, 62);
		panelMotherboard.add(buttonIngresarMother);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial Black", Font.PLAIN, 23));
		lblNombre.setBounds(308, 56, 103, 34);
		paneIngresarTrabajador.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Arial Black", Font.PLAIN, 23));
		lblApellidos.setBounds(297, 128, 126, 34);
		paneIngresarTrabajador.add(lblApellidos);

		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setFont(new Font("Arial Black", Font.PLAIN, 23));
		lblIdentificador.setBounds(281, 193, 164, 34);
		paneIngresarTrabajador.add(lblIdentificador);

		JPanel panel_1 = new JPanel(); // panel para los datos a ingresar
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(66, 56, 628, 228);
		paneIngresarTrabajador.add(panel_1);
		panel_1.setLayout(null);

		final JTextFieldLimitado idTrabajador = new JTextFieldLimitado();
		idTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		idTrabajador.setLimit(11);
		idTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		idTrabajador.setBounds(174, 177, 252, 20);
		panel_1.add(idTrabajador);

		final JTextFieldLimitado apellidosTrabajador = new JTextFieldLimitado();
		apellidosTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		apellidosTrabajador.setLimit(25);
		apellidosTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		apellidosTrabajador.setBounds(174, 112, 252, 20);
		panel_1.add(apellidosTrabajador);

		final JTextFieldLimitado nombreTrabajador = new JTextFieldLimitado();
		nombreTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreTrabajador.setLimit(25);
		nombreTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		nombreTrabajador.setBounds(174, 41, 252, 20);
		panel_1.add(nombreTrabajador);

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
		niveles[7]="Técnico profesional";

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

		final JTextFieldLimitado salarioTrabajador = new JTextFieldLimitado();
		salarioTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		salarioTrabajador.setLimit(10);
		salarioTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		salarioTrabajador.setBounds(374, 29, 105, 20);
		panel_2.add(salarioTrabajador);

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


		// Botones del Panel del Trabajador

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
					JOptionPane.showMessageDialog(null,"Ingrese el salario correctamente.","Error",JOptionPane.ERROR_MESSAGE);
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
							modelo = (DefaultTableModel) tableTrabajador.getModel();
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
		panelListaTrabajadores.setBorder(new TitledBorder(null, "Listado de Trabajadores", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.add(panelListaTrabajadores, "ListaTrabajador");
		panelListaTrabajadores.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 95, 756, 370);
		panelListaTrabajadores.add(scrollPane);

		tableTrabajador = new JTable();
		tableTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 12));

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

		// Componentes de las RAM
		final JPanel panelRAM = new JPanel();
		panelRAM.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A\u00F1adir memoria RAM al Stock", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelRAM, "name_71550325536300");
		panelRAM.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setLayout(null);
		panel_3.setBounds(35, 29, 690, 338);
		panelRAM.add(panel_3);

		JLabel label = new JLabel("Marca");
		label.setFont(new Font("Arial Black", Font.BOLD, 23));
		label.setBounds(91, 39, 101, 34);
		panel_3.add(label);

		JLabel lblCantidadDeMemoria = new JLabel("Cantidad de Memoria");
		lblCantidadDeMemoria.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblCantidadDeMemoria.setBounds(20, 236, 287, 27);
		panel_3.add(lblCantidadDeMemoria);

		JLabel label_2 = new JLabel("Tipo de memoria");
		label_2.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_2.setBounds(395, 136, 251, 34);
		panel_3.add(label_2);

		final JComboBox comboBoxTipoRAM = new JComboBox();
		comboBoxTipoRAM.setFont(new Font("Arial Black", Font.PLAIN, 17));
		comboBoxTipoRAM.setBounds(450, 181, 129, 27);
		Object[] tiposRAM = new Object[6];
		tiposRAM[0]="";
		tiposRAM[1]= "DDR";
		tiposRAM[2]= "DDR2";
		tiposRAM[3]="DDR3";
		tiposRAM[4]="DDR4";
		tiposRAM[5]="DDR5";
		defaultComboBoxModel = new DefaultComboBoxModel(tiposRAM);
		comboBoxTipoRAM.setModel(defaultComboBoxModel);
		panel_3.add(comboBoxTipoRAM);

		JLabel label_4 = new JLabel("Precio base");
		label_4.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_4.setBounds(20, 129, 172, 49);
		panel_3.add(label_4);

		JLabel label_5 = new JLabel("Cantidad de unidades");
		label_5.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_5.setBounds(20, 176, 298, 49);
		panel_3.add(label_5);

		final JSpinner spinnerCapacidadRAM = new JSpinner();
		spinnerCapacidadRAM.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerCapacidadRAM.setModel(new SpinnerNumberModel(0.0, 0.0, 128.0, 1.0));
		spinnerCapacidadRAM.setBounds(311, 238, 61, 27);
		panel_3.add(spinnerCapacidadRAM);

		final JSpinner spinnerPrecioBaseRAM = new JSpinner();
		spinnerPrecioBaseRAM.setModel(new SpinnerNumberModel(0.0, 0.0, 250.0, 1.0));
		spinnerPrecioBaseRAM.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerPrecioBaseRAM.setBounds(188, 141, 81, 27);
		panel_3.add(spinnerPrecioBaseRAM);

		final JTextFieldLimitado textMarcaRAM = new JTextFieldLimitado();
		textMarcaRAM.setHorizontalAlignment(SwingConstants.CENTER);
		textMarcaRAM.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textMarcaRAM.setLimit(15);
		textMarcaRAM.setBounds(31, 77, 226, 27);
		panel_3.add(textMarcaRAM);

		final JSpinner spinnerRAMUnit = new JSpinner();
		spinnerRAMUnit.setModel(new SpinnerNumberModel(0, 0, 300, 1));
		spinnerRAMUnit.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerRAMUnit.setBounds(311, 188, 61, 27);
		panel_3.add(spinnerRAMUnit);

		JPanel panel_PrecioRAM = new JPanel();
		panel_PrecioRAM.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_PrecioRAM.setBounds(482, 278, 173, 49);
		panel_3.add(panel_PrecioRAM);
		panel_PrecioRAM.setLayout(null);

		final JLabel lblPrecioRAM = new JLabel("0.0000$");
		lblPrecioRAM.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblPrecioRAM.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioRAM.setBounds(10, 11, 153, 27);
		panel_PrecioRAM.add(lblPrecioRAM);

		JLabel lblPrecioDeLa = new JLabel("Precio de la RAM");
		lblPrecioDeLa.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblPrecioDeLa.setBounds(450, 225, 243, 49);
		panel_3.add(lblPrecioDeLa);

		JLabel RAMNumeroSerie = new JLabel("N\u00FAmero de Serie");
		RAMNumeroSerie.setBounds(395, 39, 242, 34);
		panel_3.add(RAMNumeroSerie);
		RAMNumeroSerie.setFont(new Font("Arial Black", Font.BOLD, 23));

		final JTextFieldLimitado textNumeroSerie = new JTextFieldLimitado();
		textNumeroSerie.setBounds(426, 77, 162, 27);
		panel_3.add(textNumeroSerie);
		textNumeroSerie.setLimit(10);
		textNumeroSerie.setHorizontalAlignment(SwingConstants.CENTER);
		textNumeroSerie.setFont(new Font("Arial Black", Font.PLAIN, 17));

		JLabel lblGb = new JLabel("GB");
		lblGb.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblGb.setBounds(382, 232, 51, 34);
		panel_3.add(lblGb);

		JLabel label_1 = new JLabel("$");
		label_1.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_1.setBounds(279, 136, 51, 34);
		panel_3.add(label_1);

		JButton button_1 = new JButton("Inicializar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!inicializarRAMS){

					String[][] rams = {
							{"5", "SM5-16G", "Samsung", "16", "DDR5", "60"},
							{"7", "HX4-32G", "Hynyx", "32", "DDR4", "45"},
							{"10", "TS5-64GB", "Toshiba", "64", "DDR5", "80"},
							{"20", "RZB-128G", "Razor Blade", "128", "DDR5", "120"},
							{"15", "MCN-8EB", "Micron", "8", "DDR2", "10"}
					};

					for (String[] datos : rams) {
						try {
							tiendaPC.addRAM(Integer.parseInt(datos[0]), datos[1], datos[2], Double.parseDouble(datos[3]),datos[4],Double.parseDouble(datos[5]));
							RAM ram = new RAM(Integer.parseInt(datos[0]), datos[1], datos[2], Double.parseDouble(datos[3]),datos[4],Double.parseDouble(datos[5]));
							modelo = (DefaultTableModel) tableRAM.getModel();
							Object ramInfo [] = {ram.getClass().getSimpleName(),datos[2],datos[1],ram.calcularPrecio(),datos[0]};
							modelo.addRow(ramInfo);
						} catch (IllegalArgumentException e) {
							JOptionPane.showMessageDialog(null,"La ram con el número de serie: "+ datos[1]+" ya se habia ingresado, se procederá a ingresar la próxima que no se haya añadido previamente.","RAM Ingresada previamente",JOptionPane.ERROR_MESSAGE);
						}
					}
					inicializarRAMS = true;
					JOptionPane.showMessageDialog(null,"Se han inicializado los datos de prueba correctamente.","Datos Inicializados correctamente",JOptionPane.INFORMATION_MESSAGE);	
				} 
				else
					JOptionPane.showMessageDialog(null,"Ya se inicializaron los datos de las RAMS.","Ya se inicializaron estos datos",JOptionPane.ERROR_MESSAGE);
			}
		});
		button_1.setBounds(35, 378, 172, 62);
		panelRAM.add(button_1);
		button_1.setFont(new Font("Arial Black", Font.PLAIN, 21));

		JButton button = new JButton("Ingresar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String marca = textMarcaRAM.getText();
				String tipo = (String)comboBoxTipoRAM.getSelectedItem();
				String id = textNumeroSerie.getText();
				double capacidad = (double)spinnerCapacidadRAM.getValue();
				int cantidad = (int)spinnerRAMUnit.getValue();
				double precioBase = (double)spinnerPrecioBaseRAM.getValue();
				try{
					tiendaPC.addRAM(cantidad, id, marca, capacidad, tipo, precioBase);
					RAM ram = new RAM(cantidad, id, marca, capacidad, tipo, precioBase);
					lblPrecioRAM.setText(String.valueOf(ram.calcularPrecio())+"$");
					modelo = (DefaultTableModel) tableRAM.getModel();
					Object ramInfo [] = {ram.getClass().getSimpleName(),marca,id,ram.calcularPrecio(),cantidad};
					modelo.addRow(ramInfo);
					JOptionPane.showMessageDialog(null,"Los datos de esta RAM han sido ingresados satisfactoriamente a la Tienda.Se ha actualizado el precio de la RAM.","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);

				}
				catch (IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
				}


			}
		});
		button.setBounds(596, 378, 129, 62);
		panelRAM.add(button);
		button.setFont(new Font("Arial Black", Font.PLAIN, 21));

		final JPanel panelListadoComponentes = new JPanel();
		panelListadoComponentes.setBorder(new TitledBorder(null, "Listado de Componentes Disponibles", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.add(panelListadoComponentes, "name_93809758457200");
		panelListadoComponentes.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 75, 746, 390);
		panelListadoComponentes.add(scrollPane_1);

		tableRAM = new JTable();
		tableRAM.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Tipo de Componente", "Marca", "Identificador", "Precio", "Cantidad"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableRAM.getColumnModel().getColumn(0).setResizable(false);
		tableRAM.getColumnModel().getColumn(0).setPreferredWidth(121);
		tableRAM.getColumnModel().getColumn(1).setResizable(false);
		tableRAM.getColumnModel().getColumn(1).setPreferredWidth(95);
		tableRAM.getColumnModel().getColumn(2).setResizable(false);
		tableRAM.getColumnModel().getColumn(2).setPreferredWidth(79);
		tableRAM.getColumnModel().getColumn(3).setResizable(false);
		tableRAM.getColumnModel().getColumn(3).setPreferredWidth(55);
		tableRAM.getColumnModel().getColumn(4).setResizable(false);
		tableRAM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane_1.setViewportView(tableRAM);

		final JPanel panelCPU = new JPanel();
		panelCPU.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A\u00F1adir procesador(CPU) al Stock", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelCPU, "name_151071058935400");
		panelCPU.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_7.setBounds(10, 29, 746, 382);
		panelCPU.add(panel_7);
		panel_7.setLayout(null);

		JLabel label_6 = new JLabel("Marca");
		label_6.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_6.setBounds(69, 11, 101, 34);
		panel_7.add(label_6);

		JTextFieldLimitado marcaCPU = new JTextFieldLimitado();
		marcaCPU.setLimit(15);
		marcaCPU.setHorizontalAlignment(SwingConstants.CENTER);
		marcaCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		marcaCPU.setBounds(10, 45, 226, 27);
		panel_7.add(marcaCPU);

		JTextFieldLimitado idCPU = new JTextFieldLimitado();
		idCPU.setLimit(10);
		idCPU.setHorizontalAlignment(SwingConstants.CENTER);
		idCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		idCPU.setBounds(301, 45, 162, 27);
		panel_7.add(idCPU);

		JLabel label_7 = new JLabel("N\u00FAmero de Serie");
		label_7.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_7.setBounds(269, 11, 242, 34);
		panel_7.add(label_7);

		JLabel label_10 = new JLabel("Modelo");
		label_10.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_10.setBounds(556, 11, 140, 34);
		panel_7.add(label_10);

		JTextFieldLimitado modeloCPU = new JTextFieldLimitado();
		modeloCPU.setLimit(10);
		modeloCPU.setHorizontalAlignment(SwingConstants.CENTER);
		modeloCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		modeloCPU.setBounds(534, 45, 162, 27);
		panel_7.add(modeloCPU);

		JLabel label_11 = new JLabel("Tipo de Socket");
		label_11.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_11.setBounds(20, 143, 226, 34);
		panel_7.add(label_11);

		JComboBox comboBoxSocketCPU = new JComboBox();
		comboBoxSocketCPU.setModel(new DefaultComboBoxModel(new String[] {"", "LGA", "BGA", "PGA"}));
		comboBoxSocketCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		comboBoxSocketCPU.setBounds(56, 188, 129, 27);
		panel_7.add(comboBoxSocketCPU);

		JLabel label_13 = new JLabel("Precio base");
		label_13.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_13.setBounds(10, 83, 172, 49);
		panel_7.add(label_13);

		JSpinner spinnerPrecioBaseCPU = new JSpinner();
		spinnerPrecioBaseCPU.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerPrecioBaseCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerPrecioBaseCPU.setBounds(178, 95, 81, 27);
		panel_7.add(spinnerPrecioBaseCPU);

		JLabel label_15 = new JLabel("$");
		label_15.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_15.setBounds(269, 90, 51, 34);
		panel_7.add(label_15);

		JLabel label_16 = new JLabel("Cantidad de unidades");
		label_16.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_16.setBounds(347, 83, 298, 49);
		panel_7.add(label_16);

		JSpinner spinnerUnidadesCPU = new JSpinner();
		spinnerUnidadesCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerUnidadesCPU.setBounds(647, 96, 61, 27);
		panel_7.add(spinnerUnidadesCPU);

		JLabel lblPrecioDeLa_1 = new JLabel("Precio de la CPU");
		lblPrecioDeLa_1.setFont(new Font("Arial Black", Font.PLAIN, 23));
		lblPrecioDeLa_1.setBounds(411, 136, 234, 49);
		panel_7.add(lblPrecioDeLa_1);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_8.setBounds(436, 188, 173, 49);
		panel_7.add(panel_8);

		JLabel precioCPU = new JLabel("0.0000$");
		precioCPU.setHorizontalAlignment(SwingConstants.CENTER);
		precioCPU.setFont(new Font("Arial Black", Font.PLAIN, 20));
		precioCPU.setBounds(10, 11, 153, 27);
		panel_8.add(precioCPU);

		JButton buttonIngresarCPU = new JButton("Ingresar");
		buttonIngresarCPU.setFont(new Font("Arial Black", Font.PLAIN, 21));
		buttonIngresarCPU.setBounds(592, 309, 129, 62);
		panel_7.add(buttonIngresarCPU);

		JButton buttonInicializarCPU = new JButton("Inicializar");
		buttonInicializarCPU.setFont(new Font("Arial Black", Font.PLAIN, 21));
		buttonInicializarCPU.setBounds(10, 309, 172, 62);
		panel_7.add(buttonInicializarCPU);

		final JPanel panelHDD = new JPanel();
		panelHDD.setBorder(new TitledBorder(null, "A\u00F1adir Disco Duro al stock", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.add(panelHDD, "name_151142814562600");
		panelHDD.setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_9.setBounds(10, 36, 734, 418);
		panelHDD.add(panel_9);
		panel_9.setLayout(null);

		JLabel label_17 = new JLabel("Marca");
		label_17.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_17.setBounds(89, 11, 101, 34);
		panel_9.add(label_17);

		JTextFieldLimitado textFieldLimitado = new JTextFieldLimitado();
		textFieldLimitado.setLimit(15);
		textFieldLimitado.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textFieldLimitado.setBounds(30, 45, 226, 27);
		panel_9.add(textFieldLimitado);

		JLabel label_18 = new JLabel("N\u00FAmero de Serie");
		label_18.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_18.setBounds(289, 11, 242, 34);
		panel_9.add(label_18);

		JTextFieldLimitado textFieldLimitado_1 = new JTextFieldLimitado();
		textFieldLimitado_1.setLimit(10);
		textFieldLimitado_1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado_1.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textFieldLimitado_1.setBounds(321, 45, 162, 27);
		panel_9.add(textFieldLimitado_1);

		JLabel label_19 = new JLabel("Modelo");
		label_19.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_19.setBounds(576, 11, 140, 34);
		panel_9.add(label_19);

		JTextFieldLimitado textFieldLimitado_2 = new JTextFieldLimitado();
		textFieldLimitado_2.setLimit(10);
		textFieldLimitado_2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado_2.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textFieldLimitado_2.setBounds(554, 45, 162, 27);
		panel_9.add(textFieldLimitado_2);

		JLabel label_20 = new JLabel("Precio base");
		label_20.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_20.setBounds(30, 83, 172, 49);
		panel_9.add(label_20);

		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinner.setBounds(198, 95, 81, 27);
		panel_9.add(spinner);

		JLabel label_21 = new JLabel("$");
		label_21.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_21.setBounds(289, 90, 51, 34);
		panel_9.add(label_21);

		JLabel lblPrecioDelDisco = new JLabel("Precio del disco duro");
		lblPrecioDelDisco.setFont(new Font("Arial Black", Font.PLAIN, 23));
		lblPrecioDelDisco.setBounds(444, 196, 280, 49);
		panel_9.add(lblPrecioDelDisco);

		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_11.setBounds(498, 246, 173, 49);
		panel_9.add(panel_11);

		JLabel labelPrecioHDD = new JLabel("0.0000$");
		labelPrecioHDD.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrecioHDD.setFont(new Font("Arial Black", Font.PLAIN, 20));
		labelPrecioHDD.setBounds(10, 11, 153, 27);
		panel_11.add(labelPrecioHDD);

		JButton button_2 = new JButton("Inicializar");
		button_2.setFont(new Font("Arial Black", Font.PLAIN, 21));
		button_2.setBounds(10, 345, 172, 62);
		panel_9.add(button_2);

		JButton button_3 = new JButton("Ingresar");
		button_3.setFont(new Font("Arial Black", Font.PLAIN, 21));
		button_3.setBounds(587, 345, 129, 62);
		panel_9.add(button_3);

		JLabel lblTipoDeConexin = new JLabel("Tipo de conexi\u00F3n");
		lblTipoDeConexin.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblTipoDeConexin.setBounds(23, 203, 256, 34);
		panel_9.add(lblTipoDeConexin);

		JComboBox comboBoxConexionHDD = new JComboBox();
		comboBoxConexionHDD.setModel(new DefaultComboBoxModel(new String[] {"", "IDE", "SATA", "SATA-2", "SATA-3"}));
		comboBoxConexionHDD.setFont(new Font("Arial Black", Font.PLAIN, 17));
		comboBoxConexionHDD.setBounds(47, 246, 129, 27);
		panel_9.add(comboBoxConexionHDD);

		JLabel label_22 = new JLabel("Cantidad de unidades");
		label_22.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_22.setBounds(331, 83, 298, 49);
		panel_9.add(label_22);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinner_1.setBounds(631, 96, 61, 27);
		panel_9.add(spinner_1);

		JLabel label_23 = new JLabel("Cantidad de Memoria");
		label_23.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_23.setBounds(30, 143, 287, 27);
		panel_9.add(label_23);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(128.0, 128.0, 4096.0, 1.0));
		spinner_2.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinner_2.setBounds(321, 143, 61, 27);
		panel_9.add(spinner_2);

		JLabel label_24 = new JLabel("GB");
		label_24.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_24.setBounds(392, 139, 51, 34);
		panel_9.add(label_24);

		JMenuItem mntmAadirTrabajador = new JMenuItem("A\u00F1adir Trabajador");
		mntmAadirTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.setVisible(false);
				paneIngresarTrabajador.setVisible(true);
				panelListaTrabajadores.setVisible(false);
				panelMotherboard.setVisible(false);
				panelRAM.setVisible(false);	
				panelListadoComponentes.setVisible(false);
				panelHDD.setVisible(false);
				panelCPU.setVisible(false);
			}
		});
		mnGerencia.add(mntmAadirTrabajador);

		JMenu mnAadirComponentes = new JMenu("A\u00F1adir Componentes");
		mnGerencia.add(mnAadirComponentes);

		JMenuItem mntmMotherboard = new JMenuItem("Motherboard");
		mntmMotherboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.setVisible(false);
				paneIngresarTrabajador.setVisible(false);
				panelListaTrabajadores.setVisible(false);
				panelMotherboard.setVisible(true);
				panelRAM.setVisible(false);	
				panelListadoComponentes.setVisible(false);
				panelHDD.setVisible(false);
				panelCPU.setVisible(false);
			}
		});
		mnAadirComponentes.add(mntmMotherboard);

		JMenuItem mntmRam = new JMenuItem("RAM");
		mntmRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.setVisible(false);
				paneIngresarTrabajador.setVisible(false);
				panelListaTrabajadores.setVisible(false);
				panelMotherboard.setVisible(false);
				panelRAM.setVisible(true);	
				panelListadoComponentes.setVisible(false);
				panelHDD.setVisible(false);
				panelCPU.setVisible(false);
			}
		});
		mnAadirComponentes.add(mntmRam);

		JMenuItem mntmDiscosDuros = new JMenuItem("Discos Duros");
		mntmDiscosDuros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.setVisible(false);
				paneIngresarTrabajador.setVisible(false);
				panelListaTrabajadores.setVisible(false);
				panelMotherboard.setVisible(false);
				panelRAM.setVisible(false);	
				panelListadoComponentes.setVisible(false);
				panelHDD.setVisible(true);
				panelCPU.setVisible(false);
			}
		});
		mnAadirComponentes.add(mntmDiscosDuros);

		JMenuItem mntmProcesadorcpu = new JMenuItem("Procesador(CPU)");
		mntmProcesadorcpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.setVisible(false);
				paneIngresarTrabajador.setVisible(false);
				panelListaTrabajadores.setVisible(false);
				panelMotherboard.setVisible(false);
				panelRAM.setVisible(false);	
				panelListadoComponentes.setVisible(false);
				panelHDD.setVisible(false);
				panelCPU.setVisible(true);	
			}
		});
		mnAadirComponentes.add(mntmProcesadorcpu);

		JMenuItem mntmCrearPc = new JMenuItem("Crear PC");
		mnGerencia.add(mntmCrearPc);

		JMenu mnNewMenu = new JMenu("Listados");
		menuBar.add(mnNewMenu);

		JMenuItem mntmMostrarListado = new JMenuItem("Mostrar Listado de Trabajadores");
		mntmMostrarListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tiendaPC.getTrabajadores().size() != 0){
					panelInicio.setVisible(false);
					paneIngresarTrabajador.setVisible(false);
					panelListaTrabajadores.setVisible(true);
					panelMotherboard.setVisible(false);
					panelRAM.setVisible(false);	
					panelListadoComponentes.setVisible(false);
					panelHDD.setVisible(false);
					panelCPU.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null,"No hay ningún trabajador agregado a la tienda.","No se ha ingresado ningún trabajador",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmMostrarListado);

		JMenuItem mntmMostrarListadoDe = new JMenuItem("Mostrar Listado de Componentes");
		mntmMostrarListadoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tiendaPC.getComponentes().size() != 0){
					panelInicio.setVisible(false);
					paneIngresarTrabajador.setVisible(false);
					panelListaTrabajadores.setVisible(false);
					panelMotherboard.setVisible(false);
					panelRAM.setVisible(false);	
					panelListadoComponentes.setVisible(true);
					panelHDD.setVisible(false);
					panelCPU.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null,"No hay ningún componente agregado a la tienda.","No se ha ingresado ningún componente",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmMostrarListadoDe);

		JMenuItem mntmMostrarListadoDe_1 = new JMenuItem("Mostrar Listado de PC conformadas");
		mnNewMenu.add(mntmMostrarListadoDe_1);

		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);

		JMenuItem mntmNewMenuItem = new JMenuItem("Reporte de Trabajadores por Salario,Cargo y Escolaridad.");
		mnReportes.add(mntmNewMenuItem);

		JMenuItem mntmReporteDeComputadoras = new JMenuItem("Reporte de Computadoras seg\u00FAn su precio.");
		mnReportes.add(mntmReporteDeComputadoras);

		JMenuItem mntmReportesDeComponentes = new JMenuItem("Reportes de Componentes seg\u00FAn su marca y precio.");
		mnReportes.add(mntmReportesDeComponentes);

		JMenuItem mntmReporteDeTarjetas = new JMenuItem("Reporte de tarjetas RAM seg\u00FAn su velocidad y tipo de Memoria.");
		mnReportes.add(mntmReporteDeTarjetas);

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
				panelListaTrabajadores.setVisible(false);
				panelMotherboard.setVisible(false);
				panelRAM.setVisible(false);	
				panelListadoComponentes.setVisible(false);
				panelHDD.setVisible(false);
				panelCPU.setVisible(false);
			}
		});

	}
}
