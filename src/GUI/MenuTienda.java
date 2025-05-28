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
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Componentes.JTextFieldLimitado;

import javax.swing.JCheckBox;
import javax.swing.JProgressBar;

public class MenuTienda extends JFrame {

	private JPanel contentPane;
	private Tienda tiendaPC;


	@SuppressWarnings("rawtypes")
	private DefaultTableModel modelo;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel defaultComboBoxModel;
	// tablas de listados
	private JTable tableTrabajador;
	private JTable tableComponentes;
	// booleanos de inicializacion
	private boolean inicializarTrabajadores = false;
	private boolean inicializarRAMS = false;
	private boolean inicializarHDD = false;
	private boolean inicializarCPU = false;
	//Jdialogs
	InfoTienda dialogInfoTienda;
	reporteTrabajador dialogreporteTrabajador;
	reporteComponentes dialogReporteComponentes;
	// contadores
	private int counterTrabajador = 0;

	public MenuTienda(Tienda tienda) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuTienda.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		setTitle("Men\u00FA Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 529);
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
		panelInicio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelInicio, "panelInicio");
		panelInicio.setLayout(null);

		final JPanel paneIngresarTrabajador = new JPanel();
		paneIngresarTrabajador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(paneIngresarTrabajador, "paneIngresarTrabajador");
		paneIngresarTrabajador.setLayout(null);

		final JPanel panelMotherboard = new JPanel();
		panelMotherboard.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelMotherboard, "panelMotherboard");
		panelMotherboard.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 47, 733, 359);
		panelMotherboard.add(panel_4);

		JLabel label_3 = new JLabel("Marca");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_3.setBounds(20, 11, 101, 34);
		panel_4.add(label_3);

		JLabel lblTipoDeMemoria = new JLabel("Tipo de Socket");
		lblTipoDeMemoria.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTipoDeMemoria.setBounds(20, 90, 129, 34);
		panel_4.add(lblTipoDeMemoria);

		final JComboBox comboBoxSocketMother = new JComboBox();
		comboBoxSocketMother.setModel(new DefaultComboBoxModel(new String[] {"", "LGA", "PGA", "BGA"}));
		comboBoxSocketMother.setFont(new Font("Arial Black", Font.PLAIN, 17));
		comboBoxSocketMother.setBounds(269, 94, 114, 27);
		panel_4.add(comboBoxSocketMother);

		JLabel label_8 = new JLabel("Precio base");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_8.setBounds(20, 204, 114, 27);
		panel_4.add(label_8);

		JLabel label_9 = new JLabel("Cantidad de unidades");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_9.setBounds(20, 230, 196, 49);
		panel_4.add(label_9);

		final JSpinner spinnerPrecioBaseMotherboard = new JSpinner();
		spinnerPrecioBaseMotherboard.setModel(new SpinnerNumberModel(0.0, 0.0, 350.0, 1.0));
		spinnerPrecioBaseMotherboard.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerPrecioBaseMotherboard.setBounds(269, 204, 114, 27);
		panel_4.add(spinnerPrecioBaseMotherboard);

		final JTextFieldLimitado marcaMotherboard = new JTextFieldLimitado();
		marcaMotherboard.setLimit(15);
		marcaMotherboard.setHorizontalAlignment(SwingConstants.CENTER);
		marcaMotherboard.setFont(new Font("Arial Black", Font.PLAIN, 17));
		marcaMotherboard.setBounds(269, 15, 114, 27);
		panel_4.add(marcaMotherboard);

		final JSpinner spinnerUnitsMotherboard = new JSpinner();
		spinnerUnitsMotherboard.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinnerUnitsMotherboard.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerUnitsMotherboard.setBounds(269, 241, 116, 27);
		panel_4.add(spinnerUnitsMotherboard);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5.setBounds(519, 299, 173, 49);
		panel_4.add(panel_5);

		final JLabel labelPrecioMother = new JLabel("0.0000$");
		labelPrecioMother.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrecioMother.setFont(new Font("Arial Black", Font.PLAIN, 20));
		labelPrecioMother.setBounds(10, 11, 153, 27);
		panel_5.add(labelPrecioMother);

		JLabel lblPrecioDelMotherboard = new JLabel("Precio del Motherboard");
		lblPrecioDelMotherboard.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrecioDelMotherboard.setBounds(519, 252, 184, 34);
		panel_4.add(lblPrecioDelMotherboard);

		JLabel label_12 = new JLabel("N\u00FAmero de Serie");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_12.setBounds(20, 166, 162, 34);
		panel_4.add(label_12);

		final JTextFieldLimitado idMotherboard = new JTextFieldLimitado();
		idMotherboard.setLimit(10);
		idMotherboard.setHorizontalAlignment(SwingConstants.CENTER);
		idMotherboard.setFont(new Font("Arial Black", Font.PLAIN, 17));
		idMotherboard.setBounds(269, 170, 114, 27);
		panel_4.add(idMotherboard);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblModelo.setBounds(20, 51, 81, 34);
		panel_4.add(lblModelo);

		final JTextFieldLimitado modeloMotherboard = new JTextFieldLimitado();
		modeloMotherboard.setLimit(10);
		modeloMotherboard.setHorizontalAlignment(SwingConstants.CENTER);
		modeloMotherboard.setFont(new Font("Arial Black", Font.PLAIN, 17));
		modeloMotherboard.setBounds(269, 55, 114, 27);
		panel_4.add(modeloMotherboard);

		JLabel lblTiposDeRams = new JLabel("Tipos de RAMS soportadas");
		lblTiposDeRams.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTiposDeRams.setBounds(20, 126, 242, 34);
		panel_4.add(lblTiposDeRams);

		final JComboBox comboBoxRAMMother = new JComboBox();
		comboBoxRAMMother.setModel(new DefaultComboBoxModel(new String[] {"", "DDR", "DDR2", "DDR3", "DDR4", "DDR5"}));
		comboBoxRAMMother.setFont(new Font("Arial Black", Font.PLAIN, 17));
		comboBoxRAMMother.setBounds(269, 130, 114, 27);
		panel_4.add(comboBoxRAMMother);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(429, 15, 293, 192);
		panel_4.add(panel_6);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_6.setLayout(null);

		JLabel lblConexionesDeLos = new JLabel("Conexiones de los discos duros");
		lblConexionesDeLos.setBounds(12, 13, 257, 34);
		panel_6.add(lblConexionesDeLos);
		lblConexionesDeLos.setFont(new Font("Tahoma", Font.PLAIN, 18));

		final JCheckBox chckbxSata = new JCheckBox("SATA");
		chckbxSata.setBounds(12, 76, 114, 23);
		panel_6.add(chckbxSata);
		chckbxSata.setFont(new Font("Arial Black", Font.PLAIN, 20));

		final JCheckBox chckbxSata_2 = new JCheckBox("SATA-2");
		chckbxSata_2.setBounds(12, 109, 114, 23);
		panel_6.add(chckbxSata_2);
		chckbxSata_2.setFont(new Font("Arial Black", Font.PLAIN, 20));

		final JCheckBox chckbxSata_3 = new JCheckBox("SATA-3");
		chckbxSata_3.setBounds(171, 76, 114, 23);
		panel_6.add(chckbxSata_3);
		chckbxSata_3.setFont(new Font("Arial Black", Font.PLAIN, 20));

		final JCheckBox chckbxIde = new JCheckBox("IDE");
		chckbxIde.setBounds(171, 109, 87, 23);
		panel_6.add(chckbxIde);
		chckbxIde.setFont(new Font("Arial Black", Font.PLAIN, 20));

		JButton buttonInicializarMother = new JButton("Inicializar");
		buttonInicializarMother.setFont(new Font("Arial Black", Font.PLAIN, 21));
		buttonInicializarMother.setBounds(10, 415, 172, 39);
		panelMotherboard.add(buttonInicializarMother);

		JButton buttonIngresarMother = new JButton("A\u00F1adir ");
		buttonIngresarMother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> conexiones;
				if(chckbxSata.isSelected()||chckbxSata_2.isSelected() ||chckbxSata_3.isSelected() || chckbxIde.isSelected() ){
					conexiones = new ArrayList<String>();
					if(chckbxSata.isSelected())
						conexiones.add("SATA");
					if(chckbxSata_2.isSelected())
						conexiones.add("SATA-2");
					if(chckbxSata_3.isSelected())
						conexiones.add("SATA-3");
					if(chckbxIde.isSelected())
						conexiones.add("IDE");
					String marca = marcaMotherboard.getText();
					String tipoSocket = (String)comboBoxSocketMother.getSelectedItem();
					String modeloSocket = modeloMotherboard.getText();
					String id = idMotherboard.getText();
					int cantidad = (int)spinnerUnitsMotherboard.getValue();
					double precioBase = (double)spinnerPrecioBaseMotherboard.getValue();
					String tipoMemoriaRAM = (String)comboBoxRAMMother.getSelectedItem();
					try{
						tiendaPC.addMotherboard(cantidad,id, marca, modeloSocket,tipoSocket, tipoMemoriaRAM,conexiones,precioBase);
						Motherboard m = new Motherboard(cantidad,id, marca, modeloSocket,tipoSocket, tipoMemoriaRAM,conexiones,precioBase);
						labelPrecioMother.setText(String.valueOf(m.calcularPrecio())+"$");
						modelo = (DefaultTableModel)tableComponentes.getModel();
						Object motherInfo [] = {m.getClass().getSimpleName(),marca,id,m.calcularPrecio(),cantidad};
						modelo.addRow(motherInfo);
						JOptionPane.showMessageDialog(null,"Los datos de esta Motherboard han sido ingresados satisfactoriamente a la Tienda.Se ha actualizado el precio de la Motherboard.","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);
					}
					catch (IllegalArgumentException e){
						JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
					}
				}
				else
					JOptionPane.showMessageDialog(null,"Seleccione al menos una conexión para los discos.","Error",JOptionPane.ERROR_MESSAGE);	
			}
		});
		buttonIngresarMother.setFont(new Font("Arial Black", Font.PLAIN, 21));
		buttonIngresarMother.setBounds(612, 415, 129, 39);
		panelMotherboard.add(buttonIngresarMother);

		JLabel lblNewLabel = new JLabel("Del modelo de Mother Board que desea a\u00F1adir ingrese:");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel.setBounds(100, 13, 541, 31);
		panelMotherboard.add(lblNewLabel);

		JPanel panel_1 = new JPanel(); // panel para los datos a ingresar
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(30, 49, 378, 184);
		paneIngresarTrabajador.add(panel_1);
		panel_1.setLayout(null);

		final JTextFieldLimitado idTrabajador = new JTextFieldLimitado();
		idTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		idTrabajador.setLimit(11);
		idTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		idTrabajador.setBounds(154, 111, 212, 20);
		panel_1.add(idTrabajador);

		final JTextFieldLimitado apellidosTrabajador = new JTextFieldLimitado();
		apellidosTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		apellidosTrabajador.setLimit(25);
		apellidosTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		apellidosTrabajador.setBounds(154, 69, 212, 20);
		panel_1.add(apellidosTrabajador);

		final JTextFieldLimitado nombreTrabajador = new JTextFieldLimitado();
		nombreTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreTrabajador.setLimit(25);
		nombreTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		nombreTrabajador.setBounds(154, 22, 212, 20);
		panel_1.add(nombreTrabajador);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 13, 103, 34);
		panel_1.add(lblNombre);
		lblNombre.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(12, 60, 126, 34);
		panel_1.add(lblApellidos);
		lblApellidos.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));

		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(12, 102, 164, 34);
		panel_1.add(lblIdentificador);
		lblIdentificador.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));

		JLabel lblNumeroDeId = new JLabel("Numero de ID actual");
		lblNumeroDeId.setBounds(479, 60, 227, 25);
		paneIngresarTrabajador.add(lblNumeroDeId);
		lblNumeroDeId.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));

		JPanel numId = new JPanel();
		numId.setBackground(Color.WHITE);
		numId.setBounds(577, 98, 35, 34);
		paneIngresarTrabajador.add(numId);
		numId.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		numId.setLayout(null);

		final JLabel numIDT = new JLabel("0");
		numIDT.setBounds(0, 0, 35, 34);
		numId.add(numIDT);
		numIDT.setFont(new Font("Arial Black", Font.PLAIN, 15));
		numIDT.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1 = new JLabel("Ingrese los datos de un trabajador:");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(210, 13, 402, 23);
		paneIngresarTrabajador.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(343, 262, 382, 137);
		paneIngresarTrabajador.add(panel_2);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setLayout(null);


		// ComboBox relacionado con los cargos de la tienda

		final JComboBox comboBoxCargo = new JComboBox();
		comboBoxCargo.setFont(new Font("Arial Black", Font.PLAIN, 11));
		comboBoxCargo.setBounds(189, 13, 151, 20);
		Object[] cargos = new Object[8];
		cargos[0]="";
		cargos[1]= "Gestor de Ventas";
		cargos[2]= "Encargado de inventario";
		cargos[3]="Asesor de ventas";
		cargos[4]="Especialista en productos";
		cargos[5]="Encargado de servicio";
		cargos[6]="Especialista en software";
		cargos[7]="Cajero";

		defaultComboBoxModel = new DefaultComboBoxModel(cargos);
		comboBoxCargo.setModel(defaultComboBoxModel);
		panel_2.add(comboBoxCargo);

		JLabel lblCargo_1 = new JLabel("Cargo");
		lblCargo_1.setBounds(12, 3, 87, 34);
		panel_2.add(lblCargo_1);
		lblCargo_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));

		// Combo Box relacionado con los niveles escolares

		final JComboBox comboBoxEscolar = new JComboBox();
		comboBoxEscolar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		comboBoxEscolar.setBounds(189, 52, 151, 20);

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
		lblNivelEscolar.setBounds(12, 42, 151, 34);
		panel_2.add(lblNivelEscolar);
		lblNivelEscolar.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));

		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblSalario.setBounds(12, 90, 105, 34);
		panel_2.add(lblSalario);

		final JTextFieldLimitado salarioTrabajador = new JTextFieldLimitado();
		salarioTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		salarioTrabajador.setLimit(10);
		salarioTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		salarioTrabajador.setBounds(189, 99, 151, 20);
		panel_2.add(salarioTrabajador);



		// Botones del Panel del Trabajador

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = nombreTrabajador.getText();
				String apellidos = apellidosTrabajador.getText();
				String id = idTrabajador.getText();
				String cargo =(String)comboBoxCargo.getSelectedItem();
				String escolaridad = (String)comboBoxEscolar.getSelectedItem();
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
		btnNewButton.setBounds(589, 412, 129, 34);
		paneIngresarTrabajador.add(btnNewButton);

		JButton btnInicializar = new JButton("Inicializar");
		btnInicializar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!inicializarTrabajadores){

					String[][] trabajadores = {
							{"Gloria", "Santos Rosado", "06030867876", "5000", "Preuniversitario", "Especialista en productos"},
							{"Jorge Luis", "Valdés Piñeda", "97070758088", "15000", "Universitario", "Especialista en Software"},
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
		btnInicializar.setBounds(47, 412, 172, 34);
		paneIngresarTrabajador.add(btnInicializar);


		final JPanel panelListaTrabajadores = new JPanel();
		panel.add(panelListaTrabajadores, "ListaTrabajador");
		panelListaTrabajadores.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 756, 370);
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

		JLabel lblListadoDeTrabajadores = new JLabel("Listado de Trabajadores");
		lblListadoDeTrabajadores.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblListadoDeTrabajadores.setBounds(265, 6, 256, 38);
		panelListaTrabajadores.add(lblListadoDeTrabajadores);

		// Componentes de las RAM
		final JPanel panelRAM = new JPanel();
		panelRAM.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelRAM, "name_71550325536300");
		panelRAM.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(35, 48, 690, 317);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setLayout(null);
		panelRAM.add(panel_3);

		JLabel label = new JLabel("Marca");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(20, 23, 81, 34);
		panel_3.add(label);

		JLabel lblCantidadDeMemoria = new JLabel("Cantidad de Memoria");
		lblCantidadDeMemoria.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCantidadDeMemoria.setBounds(20, 70, 205, 27);
		panel_3.add(lblCantidadDeMemoria);

		JLabel label_2 = new JLabel("Tipo de memoria");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(20, 116, 153, 34);
		panel_3.add(label_2);

		final JComboBox comboBoxTipoRAM = new JComboBox();
		comboBoxTipoRAM.setFont(new Font("Arial Black", Font.PLAIN, 17));
		comboBoxTipoRAM.setBounds(237, 120, 163, 27);
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
		label_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_4.setBounds(20, 197, 129, 34);
		panel_3.add(label_4);

		JLabel label_5 = new JLabel("Cantidad de unidades");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_5.setBounds(20, 229, 205, 49);
		panel_3.add(label_5);

		final JSpinner spinnerCapacidadRAM = new JSpinner();
		spinnerCapacidadRAM.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerCapacidadRAM.setModel(new SpinnerNumberModel(0.0, 0.0, 128.0, 1.0));
		spinnerCapacidadRAM.setBounds(237, 70, 81, 27);
		panel_3.add(spinnerCapacidadRAM);

		final JSpinner spinnerPrecioBaseRAM = new JSpinner();
		spinnerPrecioBaseRAM.setModel(new SpinnerNumberModel(0.0, 0.0, 250.0, 1.0));
		spinnerPrecioBaseRAM.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerPrecioBaseRAM.setBounds(237, 201, 81, 27);
		panel_3.add(spinnerPrecioBaseRAM);

		final JTextFieldLimitado textMarcaRAM = new JTextFieldLimitado();
		textMarcaRAM.setHorizontalAlignment(SwingConstants.CENTER);
		textMarcaRAM.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textMarcaRAM.setLimit(15);
		textMarcaRAM.setBounds(238, 27, 162, 27);
		panel_3.add(textMarcaRAM);

		final JSpinner spinnerRAMUnit = new JSpinner();
		spinnerRAMUnit.setModel(new SpinnerNumberModel(0, 0, 300, 1));
		spinnerRAMUnit.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerRAMUnit.setBounds(237, 240, 81, 27);
		panel_3.add(spinnerRAMUnit);

		JPanel panel_PrecioRAM = new JPanel();
		panel_PrecioRAM.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_PrecioRAM.setBounds(481, 240, 173, 49);
		panel_3.add(panel_PrecioRAM);
		panel_PrecioRAM.setLayout(null);

		final JLabel lblPrecioRAM = new JLabel("0.0000$");
		lblPrecioRAM.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblPrecioRAM.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioRAM.setBounds(10, 11, 153, 27);
		panel_PrecioRAM.add(lblPrecioRAM);

		JLabel lblPrecioDeLa = new JLabel("Precio de la RAM");
		lblPrecioDeLa.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrecioDeLa.setBounds(482, 193, 162, 42);
		panel_3.add(lblPrecioDeLa);

		JLabel RAMNumeroSerie = new JLabel("N\u00FAmero de Serie");
		RAMNumeroSerie.setBounds(20, 163, 162, 34);
		panel_3.add(RAMNumeroSerie);
		RAMNumeroSerie.setFont(new Font("Tahoma", Font.BOLD, 17));

		final JTextFieldLimitado textNumeroSerie = new JTextFieldLimitado();
		textNumeroSerie.setBounds(238, 156, 162, 27);
		panel_3.add(textNumeroSerie);
		textNumeroSerie.setLimit(10);
		textNumeroSerie.setHorizontalAlignment(SwingConstants.CENTER);
		textNumeroSerie.setFont(new Font("Arial Black", Font.PLAIN, 17));

		JLabel lblGb = new JLabel("GB");
		lblGb.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblGb.setBounds(349, 64, 51, 34);
		panel_3.add(lblGb);

		JButton button_1 = new JButton("Inicializar");
		button_1.setBounds(35, 394, 172, 46);
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
							modelo = (DefaultTableModel) tableComponentes.getModel();
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
		panelRAM.add(button_1);
		button_1.setFont(new Font("Arial Black", Font.PLAIN, 21));

		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(580, 401, 145, 39);
		btnAadir.addActionListener(new ActionListener() {
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
					modelo = (DefaultTableModel) tableComponentes.getModel();
					Object ramInfo [] = {ram.getClass().getSimpleName(),marca,id,ram.calcularPrecio(),cantidad};
					modelo.addRow(ramInfo);
					JOptionPane.showMessageDialog(null,"Los datos de esta RAM han sido ingresados satisfactoriamente a la Tienda.Se ha actualizado el precio de la RAM.","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);

				}
				catch (IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
				}


			}
		});
		panelRAM.add(btnAadir);
		btnAadir.setFont(new Font("Arial Black", Font.PLAIN, 21));

		JLabel lblDelModeloDe = new JLabel("Del modelo de Memoria RAM que desea a\u00F1adir ingrese:");
		lblDelModeloDe.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblDelModeloDe.setBounds(111, 4, 541, 31);
		panelRAM.add(lblDelModeloDe);

		final JPanel panelListadoComponentes = new JPanel();
		panelListadoComponentes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelListadoComponentes, "name_93809758457200");
		panelListadoComponentes.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 49, 746, 390);
		panelListadoComponentes.add(scrollPane_1);

		tableComponentes = new JTable();
		tableComponentes.setModel(new DefaultTableModel(
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
		tableComponentes.getColumnModel().getColumn(0).setResizable(false);
		tableComponentes.getColumnModel().getColumn(0).setPreferredWidth(121);
		tableComponentes.getColumnModel().getColumn(1).setResizable(false);
		tableComponentes.getColumnModel().getColumn(1).setPreferredWidth(95);
		tableComponentes.getColumnModel().getColumn(2).setResizable(false);
		tableComponentes.getColumnModel().getColumn(2).setPreferredWidth(79);
		tableComponentes.getColumnModel().getColumn(3).setResizable(false);
		tableComponentes.getColumnModel().getColumn(3).setPreferredWidth(55);
		tableComponentes.getColumnModel().getColumn(4).setResizable(false);
		tableComponentes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane_1.setViewportView(tableComponentes);

		JLabel lblNewLabel_2 = new JLabel("Listado de Componentes Disponibles");
		lblNewLabel_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(200, 13, 400, 38);
		panelListadoComponentes.add(lblNewLabel_2);

		final JPanel panelCPU = new JPanel();
		panelCPU.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelCPU, "name_151071058935400");
		panelCPU.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(12, 47, 729, 356);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelCPU.add(panel_7);
		panel_7.setLayout(null);

		JLabel label_6 = new JLabel("Marca");
		label_6.setBounds(30, 11, 61, 34);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_7.add(label_6);

		final JTextFieldLimitado marcaCPU = new JTextFieldLimitado();
		marcaCPU.setBounds(266, 15, 148, 27);
		marcaCPU.setLimit(15);
		marcaCPU.setHorizontalAlignment(SwingConstants.CENTER);
		marcaCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_7.add(marcaCPU);

		final JTextFieldLimitado idCPU = new JTextFieldLimitado();
		idCPU.setBounds(266, 160, 148, 27);
		idCPU.setLimit(15);
		idCPU.setHorizontalAlignment(SwingConstants.CENTER);
		idCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_7.add(idCPU);

		JLabel label_7 = new JLabel("N\u00FAmero de Serie");
		label_7.setBounds(30, 156, 148, 34);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_7.add(label_7);

		JLabel label_10 = new JLabel("Modelo");
		label_10.setBounds(30, 58, 81, 32);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_7.add(label_10);

		final JTextFieldLimitado modeloCPU = new JTextFieldLimitado();
		modeloCPU.setBounds(264, 61, 150, 27);
		modeloCPU.setLimit(20);
		modeloCPU.setHorizontalAlignment(SwingConstants.CENTER);
		modeloCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_7.add(modeloCPU);

		JLabel label_11 = new JLabel("Tipo de Socket");
		label_11.setBounds(30, 103, 140, 34);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_7.add(label_11);

		final JComboBox comboBoxSocketCPU = new JComboBox();
		comboBoxSocketCPU.setBounds(267, 107, 148, 27);
		comboBoxSocketCPU.setModel(new DefaultComboBoxModel(new String[] {"", "LGA", "BGA", "PGA"}));
		comboBoxSocketCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_7.add(comboBoxSocketCPU);

		JLabel label_13 = new JLabel("Precio base");
		label_13.setBounds(30, 245, 120, 34);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_7.add(label_13);

		final JSpinner spinnerPrecioBaseCPU = new JSpinner();
		spinnerPrecioBaseCPU.setBounds(267, 249, 81, 27);
		spinnerPrecioBaseCPU.setModel(new SpinnerNumberModel(0.0, 0.0, 450.0, 1.0));
		spinnerPrecioBaseCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_7.add(spinnerPrecioBaseCPU);

		JLabel label_16 = new JLabel("Cantidad de unidades");
		label_16.setBounds(30, 279, 196, 47);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_7.add(label_16);

		final JSpinner spinnerUnidadesCPU = new JSpinner();
		spinnerUnidadesCPU.setModel(new SpinnerNumberModel(1, 1, 500, 1));
		spinnerUnidadesCPU.setBounds(267, 289, 81, 27);
		spinnerUnidadesCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_7.add(spinnerUnidadesCPU);

		JLabel lblPrecioDeLa_1 = new JLabel("Precio de la CPU");
		lblPrecioDeLa_1.setBounds(554, 234, 140, 34);
		lblPrecioDeLa_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_7.add(lblPrecioDeLa_1);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(532, 279, 173, 49);
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_7.add(panel_8);

		final JLabel precioCPU = new JLabel("0.0000$");
		precioCPU.setHorizontalAlignment(SwingConstants.CENTER);
		precioCPU.setFont(new Font("Arial Black", Font.PLAIN, 20));
		precioCPU.setBounds(12, 13, 153, 27);
		panel_8.add(precioCPU);

		JLabel lblVelocidad = new JLabel("Velocidad(Ghz)");
		lblVelocidad.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblVelocidad.setBounds(30, 201, 148, 34);
		panel_7.add(lblVelocidad);

		final JSpinner spinnerVelocidadCPU = new JSpinner();
		spinnerVelocidadCPU.setModel(new SpinnerNumberModel(1.0, 1.0, 5.0, 1.0));
		spinnerVelocidadCPU.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinnerVelocidadCPU.setBounds(267, 204, 81, 27);
		panel_7.add(spinnerVelocidadCPU);

		JButton buttonInicializarCPU = new JButton("Inicializar");
		buttonInicializarCPU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!inicializarCPU){
					/* int cantidadDisponible, String numeroSerie, String marca, String modelo, String socket, double velocidad, double precioBase)*/
					String[][] cpus = {
							{"5", "Intel-G4400", "Intel", "Core i5-1135G7", "LGA", "4.2","150"},
							{"3", "AMD-Ryzen5600X", "AMD", "Ryzen 5 5600X", "PGA", "4.6", "230"},
							{"7", "Intel-i7-9700K", "Intel", "Core i7-9700K", "LGA", "4.9", "350"},
							{"2", "Threadripper3990X", "AMD", "Threadripper 3990X", "BGA", "4.3", "1500"},
							{"4", "Intel-XeonE5-2680", "Intel", "Xeon E5-2680 v4", "LGA", "3.3", "500"}
					};

					for (String[] datos : cpus) {
						try {
							tiendaPC.addCPU(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],datos[4],Double.parseDouble(datos[5]),Double.parseDouble(datos[6]));
							CPU cpu = new CPU(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],datos[4],Double.parseDouble(datos[5]),Double.parseDouble(datos[6]));
							modelo = (DefaultTableModel)tableComponentes.getModel();
							Object cpuInfo [] = {cpu.getClass().getSimpleName(),datos[2],datos[1],cpu.calcularPrecio(),datos[0]};
							modelo.addRow(cpuInfo);
						} catch (IllegalArgumentException e) {
							JOptionPane.showMessageDialog(null,"El procesador con el número de serie: "+ datos[1]+" ya se habia ingresado, se procederá a ingresar el próximo que no se haya añadido previamente.","CPU Ingresada previamente",JOptionPane.ERROR_MESSAGE);
						}
					}
					inicializarCPU = true;
					JOptionPane.showMessageDialog(null,"Se han inicializado los datos de prueba correctamente.","Datos Inicializados correctamente",JOptionPane.INFORMATION_MESSAGE);	
				} 
				else
					JOptionPane.showMessageDialog(null,"Ya se inicializaron los datos de los procesadores previamente.","Ya se inicializaron estos datos",JOptionPane.ERROR_MESSAGE);
			}
		});
		buttonInicializarCPU.setBounds(22, 416, 172, 39);
		panelCPU.add(buttonInicializarCPU);
		buttonInicializarCPU.setFont(new Font("Arial Black", Font.PLAIN, 21));

		JButton buttonIngresarCPU = new JButton("A\u00F1adir");
		buttonIngresarCPU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String marca = marcaCPU.getText();
				String id = idCPU.getText();
				double velocidad = (double)spinnerVelocidadCPU.getValue();
				int cantidad = (int)spinnerUnidadesCPU.getValue();
				String modelocpu = modeloCPU.getText();
				double precioBase = (double)spinnerPrecioBaseCPU.getValue();
				String socket = (String)comboBoxSocketCPU.getSelectedItem();
				try{
					tiendaPC.addCPU(cantidad,id,marca,modelocpu,socket,velocidad,precioBase);
					CPU cpu = new CPU(cantidad,id,marca,modelocpu,socket,velocidad,precioBase);
					precioCPU.setText(String.valueOf(cpu.calcularPrecio())+"$");
					modelo = (DefaultTableModel) tableComponentes.getModel();
					Object cpuInfo [] = {cpu.getClass().getSimpleName(),marca,id,cpu.calcularPrecio(),cantidad};
					modelo.addRow(cpuInfo);
					JOptionPane.showMessageDialog(null,"Los datos de este procesador han sido ingresados satisfactoriamente a la Tienda.Se ha actualizado el precio del Procesador.","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);

				}
				catch (IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		buttonIngresarCPU.setBounds(612, 416, 129, 39);
		panelCPU.add(buttonIngresarCPU);
		buttonIngresarCPU.setFont(new Font("Arial Black", Font.PLAIN, 21));

		JLabel lblDelModeloDe_1 = new JLabel("Del modelo de microprocesador que desea a\u00F1adir ingrese:");
		lblDelModeloDe_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblDelModeloDe_1.setBounds(115, 3, 541, 31);
		panelCPU.add(lblDelModeloDe_1);

		final JPanel panelHDD = new JPanel();
		panelHDD.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelHDD, "name_151142814562600");
		panelHDD.setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_9.setBounds(22, 44, 723, 359);
		panelHDD.add(panel_9);
		panel_9.setLayout(null);

		JLabel label_17 = new JLabel("Marca");
		label_17.setBounds(30, 11, 70, 34);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(label_17);

		final JTextFieldLimitado marcaHdd = new JTextFieldLimitado();
		marcaHdd.setBounds(247, 15, 154, 27);
		marcaHdd.setLimit(15);
		marcaHdd.setHorizontalAlignment(SwingConstants.CENTER);
		marcaHdd.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_9.add(marcaHdd);

		JLabel label_18 = new JLabel("N\u00FAmero de Serie");
		label_18.setBounds(30, 205, 162, 34);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(label_18);

		final JTextFieldLimitado numeroSerieHDD = new JTextFieldLimitado();
		numeroSerieHDD.setBounds(253, 209, 148, 27);
		numeroSerieHDD.setLimit(10);
		numeroSerieHDD.setHorizontalAlignment(SwingConstants.CENTER);
		numeroSerieHDD.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_9.add(numeroSerieHDD);

		JLabel label_19 = new JLabel("Modelo");
		label_19.setBounds(30, 58, 81, 34);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(label_19);

		final JTextFieldLimitado modeloHDD = new JTextFieldLimitado();
		modeloHDD.setBounds(247, 62, 154, 27);
		modeloHDD.setLimit(10);
		modeloHDD.setHorizontalAlignment(SwingConstants.CENTER);
		modeloHDD.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_9.add(modeloHDD);

		JLabel label_20 = new JLabel("Precio base");
		label_20.setBounds(30, 252, 129, 27);
		label_20.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(label_20);

		final JSpinner spinnerPrecioHdd = new JSpinner();
		spinnerPrecioHdd.setModel(new SpinnerNumberModel(0.0, 0.0, 450.0, 1.0));
		spinnerPrecioHdd.setBounds(253, 249, 81, 27);
		spinnerPrecioHdd.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_9.add(spinnerPrecioHdd);

		JLabel lblPrecioDelDisco = new JLabel("Precio del disco duro");
		lblPrecioDelDisco.setBounds(497, 205, 185, 34);
		lblPrecioDelDisco.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_9.add(lblPrecioDelDisco);

		JPanel panel_11 = new JPanel();
		panel_11.setBounds(498, 246, 173, 49);
		panel_11.setLayout(null);
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_9.add(panel_11);

		final JLabel labelPrecioHDD = new JLabel("0.0000$");
		labelPrecioHDD.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrecioHDD.setFont(new Font("Arial Black", Font.PLAIN, 20));
		labelPrecioHDD.setBounds(10, 11, 153, 27);
		panel_11.add(labelPrecioHDD);

		JLabel lblTipoDeConexin = new JLabel("Tipo de conexi\u00F3n");
		lblTipoDeConexin.setBounds(30, 105, 173, 34);
		lblTipoDeConexin.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(lblTipoDeConexin);

		final JComboBox comboBoxConexionHDD = new JComboBox();
		comboBoxConexionHDD.setBounds(247, 109, 154, 27);
		comboBoxConexionHDD.setModel(new DefaultComboBoxModel(new String[] {"", "IDE", "SATA", "SATA-2", "SATA-3"}));
		comboBoxConexionHDD.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_9.add(comboBoxConexionHDD);

		JLabel label_22 = new JLabel("Cantidad de unidades");
		label_22.setBounds(30, 292, 192, 37);
		label_22.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(label_22);

		final JSpinner unitsHDD = new JSpinner();
		unitsHDD.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		unitsHDD.setBounds(253, 292, 81, 27);
		unitsHDD.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_9.add(unitsHDD);

		JLabel label_23 = new JLabel("Cantidad de Memoria");
		label_23.setBounds(30, 152, 192, 27);
		label_23.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(label_23);

		final JSpinner spinnerMemoriaHDD = new JSpinner();
		spinnerMemoriaHDD.setBounds(253, 152, 81, 27);
		spinnerMemoriaHDD.setModel(new SpinnerNumberModel(128.0, 128.0, 4096.0, 1.0));
		spinnerMemoriaHDD.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panel_9.add(spinnerMemoriaHDD);

		JLabel label_24 = new JLabel("GB");
		label_24.setBounds(364, 149, 51, 34);
		label_24.setFont(new Font("Arial Black", Font.BOLD, 23));
		panel_9.add(label_24);
		JButton buttoInicializarHDD = new JButton("Inicializar");
		buttoInicializarHDD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!inicializarHDD){
					String[][] hdds = {
							{"5", "SM5-512G", "Samsung", "SM512HDD", "512", "SATA-3","50"},
							{"7", "SM7-256G", "Samsung", "SM245HDD", "256", "SATA-2","45"},
							{"12", "TS-128G", "Toshiba", "TS128HDD", "128", "SATA","30"},
							{"10", "WD-1TB", "Western Digital", "WD1024HDD", "1024", "SATA-3","90"},
							{"15", "HX5-4TB", "Hynyx", "HX4TBHDD", "4096", "SATA-3","120"}
					};

					for (String[] datos : hdds) {
						try {
							tiendaPC.addHDD(Integer.parseInt(datos[0]), datos[1], datos[2],datos[3],Double.parseDouble(datos[4]),datos[5],Double.parseDouble(datos[6]));
							HDD hdd = new HDD(Integer.parseInt(datos[0]), datos[1], datos[2],datos[3],Double.parseDouble(datos[4]),datos[5],Double.parseDouble(datos[6]));
							modelo = (DefaultTableModel)tableComponentes.getModel();
							Object hddInfo [] = {hdd.getClass().getSimpleName(),datos[2],datos[1],hdd.calcularPrecio(),datos[0]};
							modelo.addRow(hddInfo);
						} catch (IllegalArgumentException e) {
							JOptionPane.showMessageDialog(null,"El disco duro con el número de serie: "+ datos[1]+" ya se habia ingresado, se procederá a ingresar el próximo que no se haya añadido previamente.","HDD Ingresado previamente",JOptionPane.ERROR_MESSAGE);
						}
					}
					inicializarHDD = true;
					JOptionPane.showMessageDialog(null,"Se han inicializado los datos de prueba correctamente.","Datos Inicializados correctamente",JOptionPane.INFORMATION_MESSAGE);	
				} 
				else
					JOptionPane.showMessageDialog(null,"Ya se inicializaron los datos de los discos duros.","Ya se inicializaron estos datos",JOptionPane.ERROR_MESSAGE);

			}
		});
		buttoInicializarHDD.setBounds(22, 416, 172, 34);
		panelHDD.add(buttoInicializarHDD);
		buttoInicializarHDD.setFont(new Font("Arial Black", Font.PLAIN, 21));

		JButton buttonIngresarHDD = new JButton("A\u00F1adir");
		buttonIngresarHDD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String marca = marcaHdd.getText();
				String tipo = (String)comboBoxConexionHDD.getSelectedItem();
				String id = numeroSerieHDD.getText();
				double capacidad = (double)spinnerMemoriaHDD.getValue();
				int cantidad = (int)unitsHDD.getValue();
				String modeloHdd = modeloHDD.getText();
				double precioBase = (double)spinnerPrecioHdd.getValue();
				try{
					tiendaPC.addHDD(cantidad,id,marca,modeloHdd,capacidad,tipo,precioBase);
					HDD hdd = new HDD(cantidad,id,marca,modeloHdd,capacidad,tipo,precioBase);
					labelPrecioHDD.setText(String.valueOf(hdd.calcularPrecio())+"$");
					modelo = (DefaultTableModel) tableComponentes.getModel();
					Object hddInfo [] = {hdd.getClass().getSimpleName(),marca,id,hdd.calcularPrecio(),cantidad};
					modelo.addRow(hddInfo);
					JOptionPane.showMessageDialog(null,"Los datos de este disco duro han sido ingresados satisfactoriamente a la Tienda.Se ha actualizado el precio del disco duro.","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);

				}
				catch (IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		buttonIngresarHDD.setBounds(613, 416, 129, 34);
		panelHDD.add(buttonIngresarHDD);
		buttonIngresarHDD.setFont(new Font("Arial Black", Font.PLAIN, 21));

		JLabel lblDelModeloDe_2 = new JLabel("Del modelo de disco duro que desea a\u00F1adir ingrese:");
		lblDelModeloDe_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblDelModeloDe_2.setBounds(143, 0, 484, 31);
		panelHDD.add(lblDelModeloDe_2);

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
				apellidosTrabajador.setText("");
				nombreTrabajador.setText("");
				idTrabajador.setText("");
				comboBoxCargo.setSelectedIndex(0);
				comboBoxEscolar.setSelectedIndex(0);
				salarioTrabajador.setText("");

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
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tiendaPC.getTrabajadores().size() != 0){
					if (dialogreporteTrabajador == null || !dialogreporteTrabajador.isShowing()) {
						try {
							dialogreporteTrabajador = new reporteTrabajador(tiendaPC);
							dialogreporteTrabajador.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialogreporteTrabajador.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(null,"Ya tiene abierta esta ventana.","Error",JOptionPane.ERROR_MESSAGE);	
				} else
					JOptionPane.showMessageDialog(null,"No hay ningún trabajador agregado a la tienda.","No se ha ingresado ningún trabajador",JOptionPane.INFORMATION_MESSAGE);
			}

		});
		mnReportes.add(mntmNewMenuItem);

		JMenuItem mntmReportesDeComponentes = new JMenuItem("Reportes de Componentes seg\u00FAn su marca y precio.");
		mntmReportesDeComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tiendaPC.getComponentes().size() != 0){
					if (dialogReporteComponentes == null || !dialogReporteComponentes.isShowing()) {
						try {
							dialogReporteComponentes = new reporteComponentes(tiendaPC);
							dialogReporteComponentes.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialogReporteComponentes.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(null,"Ya tiene abierta esta ventana.","Error",JOptionPane.ERROR_MESSAGE);	
				} else
					JOptionPane.showMessageDialog(null,"No hay ningún componente agregado a la tienda.","No se ha ingresado ningún componente",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnReportes.add(mntmReportesDeComponentes);

		JMenuItem mntmReporteDeComputadoras = new JMenuItem("Reporte de Computadoras seg\u00FAn su precio.");
		mnReportes.add(mntmReporteDeComputadoras);

		JMenuItem mntmReporteDeTarjetas = new JMenuItem("Reporte de tarjetas RAM seg\u00FAn su velocidad y tipo de Memoria.");
		mnReportes.add(mntmReporteDeTarjetas);

		JMenu mnInformacin = new JMenu("Informaci\u00F3n Adicional");
		menuBar.add(mnInformacin);

		JMenuItem mntmDatosDeLa = new JMenuItem("Datos de la Tienda");
		mntmDatosDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (dialogInfoTienda == null || !dialogInfoTienda.isShowing()) {
					try {
						dialogInfoTienda = new InfoTienda(tiendaPC);
						dialogInfoTienda.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialogInfoTienda.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null,"Ya tiene abierta esta ventana.","Error",JOptionPane.ERROR_MESSAGE);	
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
