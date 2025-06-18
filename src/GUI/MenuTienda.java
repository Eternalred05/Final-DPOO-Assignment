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
import java.time.LocalDate;
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
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

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
	//Jdialogs
	InfoTienda dialogInfoTienda;
	reporteTrabajador dialogreporteTrabajador;
	reporteComponentes dialogReporteComponentes;
	reportesRAM dialogReportesRAM;
	// contadores
	private int counterTrabajador = 0;
	private JTable tablePC;

	public MenuTienda(Tienda tienda, String usuario, boolean gerencia) {
		JOptionPane.showMessageDialog(null,"Bienvenido a la app de gestión de la tienda, "+ usuario ,"Bienvenido",JOptionPane.INFORMATION_MESSAGE);

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuTienda.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		setTitle("Men\u00FA Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tiendaPC = tienda;
		counterTrabajador = tiendaPC.getTrabajadores().size();

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1264, 21);
		contentPane.add(menuBar);

		JMenu mnGerencia = new JMenu("Gerencia");
		menuBar.add(mnGerencia);
		JPanel panel = new JPanel();
		panel.setBounds(0, 21, 1280, 720);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));

		final JPanel panelInicio = new JPanel();
		panelInicio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelInicio, "panelInicio");
		panelInicio.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MenuTienda.class.getResource("/Resources/1stScreen.jpg")));
		lblNewLabel_3.setBounds(0, 0, 1280, 673);
		panelInicio.add(lblNewLabel_3);

		final JPanel paneIngresarTrabajador = new JPanel();
		paneIngresarTrabajador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(paneIngresarTrabajador, "paneIngresarTrabajador");

		final JPanel panelMotherboard = new JPanel();
		panelMotherboard.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelMotherboard, "panelMotherboard");
		panelMotherboard.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(267, 126, 733, 407);
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
		comboBoxSocketMother.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxSocketMother.setBounds(235, 94, 173, 27);
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
		spinnerPrecioBaseMotherboard.setModel(new SpinnerNumberModel(0.0, 0.0, 999.0, 1.0));
		spinnerPrecioBaseMotherboard.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinnerPrecioBaseMotherboard.setBounds(235, 204, 81, 27);
		panel_4.add(spinnerPrecioBaseMotherboard);

		final JTextFieldLimitado marcaMotherboard = new JTextFieldLimitado();
		marcaMotherboard.setLimit(15);
		marcaMotherboard.setHorizontalAlignment(SwingConstants.CENTER);
		marcaMotherboard.setFont(new Font("Tahoma", Font.PLAIN, 17));
		marcaMotherboard.setBounds(235, 15, 173, 27);
		panel_4.add(marcaMotherboard);

		final JSpinner spinnerUnitsMotherboard = new JSpinner();
		spinnerUnitsMotherboard.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinnerUnitsMotherboard.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinnerUnitsMotherboard.setBounds(235, 241, 81, 27);
		panel_4.add(spinnerUnitsMotherboard);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5.setBounds(519, 299, 173, 49);
		panel_4.add(panel_5);

		final JLabel labelPrecioMother = new JLabel("0.0000$");
		labelPrecioMother.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrecioMother.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		idMotherboard.setFont(new Font("Tahoma", Font.PLAIN, 17));
		idMotherboard.setBounds(235, 170, 173, 27);
		panel_4.add(idMotherboard);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblModelo.setBounds(20, 51, 81, 34);
		panel_4.add(lblModelo);

		final JTextFieldLimitado modeloMotherboard = new JTextFieldLimitado();
		modeloMotherboard.setLimit(10);
		modeloMotherboard.setHorizontalAlignment(SwingConstants.CENTER);
		modeloMotherboard.setFont(new Font("Tahoma", Font.PLAIN, 17));
		modeloMotherboard.setBounds(235, 55, 173, 27);
		panel_4.add(modeloMotherboard);

		JLabel lblTiposDeRams = new JLabel("Tipo de RAM soportada");
		lblTiposDeRams.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTiposDeRams.setBounds(20, 126, 242, 34);
		panel_4.add(lblTiposDeRams);

		final JComboBox comboBoxRAMMother = new JComboBox();
		comboBoxRAMMother.setModel(new DefaultComboBoxModel(new String[] {"", "DDR", "DDR2", "DDR3", "DDR4", "DDR5"}));
		comboBoxRAMMother.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxRAMMother.setBounds(235, 130, 173, 27);
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
		chckbxSata.setFont(new Font("Tahoma", Font.PLAIN, 20));

		final JCheckBox chckbxSata_2 = new JCheckBox("SATA-2");
		chckbxSata_2.setBounds(12, 109, 114, 23);
		panel_6.add(chckbxSata_2);
		chckbxSata_2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		final JCheckBox chckbxSata_3 = new JCheckBox("SATA-3");
		chckbxSata_3.setBounds(171, 76, 114, 23);
		panel_6.add(chckbxSata_3);
		chckbxSata_3.setFont(new Font("Tahoma", Font.PLAIN, 20));

		final JCheckBox chckbxIde = new JCheckBox("IDE");
		chckbxIde.setBounds(171, 109, 87, 23);
		panel_6.add(chckbxIde);
		chckbxIde.setFont(new Font("Tahoma", Font.PLAIN, 20));

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
		buttonIngresarMother.setFont(new Font("Tahoma", Font.BOLD, 20));
		buttonIngresarMother.setBounds(1127, 619, 129, 39);
		panelMotherboard.add(buttonIngresarMother);

		JLabel lblNewLabel = new JLabel("Del modelo de Motherboard que desea a\u00F1adir ingrese:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(398, 11, 541, 31);
		panelMotherboard.add(lblNewLabel);
		paneIngresarTrabajador.setLayout(null);

		JLabel lblNumeroDeId = new JLabel("Numero de ID actual");
		lblNumeroDeId.setForeground(Color.BLACK);
		lblNumeroDeId.setBounds(1051, 49, 203, 25);
		paneIngresarTrabajador.add(lblNumeroDeId);
		lblNumeroDeId.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JPanel numId = new JPanel();
		numId.setBounds(1125, 85, 35, 34);
		numId.setBackground(Color.WHITE);
		paneIngresarTrabajador.add(numId);
		numId.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		numId.setLayout(null);

		final JLabel numIDT = new JLabel("0");
		numIDT.setBounds(0, 0, 35, 34);
		numId.add(numIDT);
		numIDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		numIDT.setHorizontalAlignment(SwingConstants.CENTER);
		final JTextFieldLimitado nombreTrabajador = new JTextFieldLimitado();
		nombreTrabajador.setLimit(25);
		nombreTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nombreTrabajador.setBounds(595, 174, 235, 20);
		paneIngresarTrabajador.add(nombreTrabajador);

		JLabel label_1 = new JLabel("Nombre");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(453, 165, 103, 34);
		paneIngresarTrabajador.add(label_1);

		JLabel label_14 = new JLabel("Apellidos");
		label_14.setForeground(Color.BLACK);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_14.setBounds(453, 212, 126, 34);
		paneIngresarTrabajador.add(label_14);

		final JTextFieldLimitado apellidosTrabajador = new JTextFieldLimitado();
		apellidosTrabajador.setLimit(25);
		apellidosTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		apellidosTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		apellidosTrabajador.setBounds(595, 221, 235, 20);
		paneIngresarTrabajador.add(apellidosTrabajador);

		final JTextFieldLimitado idTrabajador = new JTextFieldLimitado();
		idTrabajador.setLimit(11);
		idTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		idTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idTrabajador.setBounds(595, 263, 235, 20);
		paneIngresarTrabajador.add(idTrabajador);

		JLabel label_15 = new JLabel("Identificador");
		label_15.setForeground(Color.BLACK);
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_15.setBounds(453, 254, 164, 34);
		paneIngresarTrabajador.add(label_15);

		final JComboBox comboBoxCargo = new JComboBox();
		comboBoxCargo.setForeground(Color.BLACK);
		comboBoxCargo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxCargo.setBounds(595, 336, 235, 20);
		Object[] cargos = new Object[8];
		cargos[0]="";
		cargos[1]= "Gestor de ventas";
		cargos[2]= "Encargado de inventario";
		cargos[3]="Asesor de ventas";
		cargos[4]="Especialista en productos";
		cargos[5]="Encargado de servicio";
		cargos[6]="Especialista en software";
		cargos[7]="Cajero";

		defaultComboBoxModel = new DefaultComboBoxModel(cargos);
		comboBoxCargo.setModel(defaultComboBoxModel);
		paneIngresarTrabajador.add(comboBoxCargo);

		JLabel label_21 = new JLabel("Cargo");
		label_21.setForeground(Color.BLACK);
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_21.setBounds(453, 326, 87, 34);
		paneIngresarTrabajador.add(label_21);

		JLabel label_25 = new JLabel("Nivel \r\nEscolar");
		label_25.setForeground(Color.BLACK);
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_25.setBounds(451, 371, 151, 34);
		paneIngresarTrabajador.add(label_25);

		final JComboBox comboBoxEscolar = new JComboBox();
		comboBoxEscolar.setForeground(Color.BLACK);
		comboBoxEscolar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxEscolar.setBounds(595, 381, 235, 20);

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

		paneIngresarTrabajador.add(comboBoxEscolar);

		final JTextFieldLimitado salarioTrabajador = new JTextFieldLimitado();
		salarioTrabajador.setForeground(Color.BLACK);
		salarioTrabajador.setLimit(10);
		salarioTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		salarioTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		salarioTrabajador.setBounds(595, 422, 235, 20);
		paneIngresarTrabajador.add(salarioTrabajador);

		JLabel label_26 = new JLabel("Salario");
		label_26.setForeground(Color.BLACK);
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_26.setBounds(453, 413, 105, 34);
		paneIngresarTrabajador.add(label_26);

		JLabel lblNewLabel_1 = new JLabel("Ingrese los datos de un trabajador:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(453, 11, 402, 23);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		paneIngresarTrabajador.add(lblNewLabel_1);


		// Botones del Panel del Trabajador

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBounds(1125, 622, 129, 34);
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		paneIngresarTrabajador.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(296, 123, 674, 373);
		paneIngresarTrabajador.add(panel_1);



		final JPanel panelListaTrabajadores = new JPanel();
		panel.add(panelListaTrabajadores, "ListaTrabajador");
		panelListaTrabajadores.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 1240, 513);
		panelListaTrabajadores.add(scrollPane);

		tableTrabajador = new JTable();
		tableTrabajador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		tableTrabajador.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(tableTrabajador);

		JLabel lblListadoDeTrabajadores = new JLabel("Listado de Trabajadores");
		lblListadoDeTrabajadores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListadoDeTrabajadores.setBounds(465, 6, 256, 38);
		panelListaTrabajadores.add(lblListadoDeTrabajadores);


		// Componentes de las RAM
		final JPanel panelRAM = new JPanel();
		panelRAM.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelRAM, "name_71550325536300");
		panelRAM.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(301, 137, 690, 332);
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
		comboBoxTipoRAM.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
		spinnerCapacidadRAM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinnerCapacidadRAM.setModel(new SpinnerNumberModel(1.0, 1.0, 128.0, 1.0));
		spinnerCapacidadRAM.setBounds(237, 70, 81, 27);
		panel_3.add(spinnerCapacidadRAM);

		final JSpinner spinnerPrecioBaseRAM = new JSpinner();
		spinnerPrecioBaseRAM.setModel(new SpinnerNumberModel(0.0, 0.0, 250.0, 1.0));
		spinnerPrecioBaseRAM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinnerPrecioBaseRAM.setBounds(237, 201, 81, 27);
		panel_3.add(spinnerPrecioBaseRAM);

		final JTextFieldLimitado textMarcaRAM = new JTextFieldLimitado();
		textMarcaRAM.setHorizontalAlignment(SwingConstants.CENTER);
		textMarcaRAM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textMarcaRAM.setLimit(15);
		textMarcaRAM.setBounds(238, 27, 162, 27);
		panel_3.add(textMarcaRAM);

		final JSpinner spinnerRAMUnit = new JSpinner();
		spinnerRAMUnit.setModel(new SpinnerNumberModel(1, 1, 300, 1));
		spinnerRAMUnit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinnerRAMUnit.setBounds(237, 240, 81, 27);
		panel_3.add(spinnerRAMUnit);

		JPanel panel_PrecioRAM = new JPanel();
		panel_PrecioRAM.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_PrecioRAM.setBounds(481, 240, 173, 49);
		panel_3.add(panel_PrecioRAM);
		panel_PrecioRAM.setLayout(null);

		final JLabel lblPrecioRAM = new JLabel("0.0000$");
		lblPrecioRAM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecioRAM.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioRAM.setBounds(10, 11, 153, 27);
		panel_PrecioRAM.add(lblPrecioRAM);

		JLabel lblPrecioDeLa = new JLabel("Precio de la RAM");
		lblPrecioDeLa.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrecioDeLa.setBounds(492, 193, 162, 42);
		panel_3.add(lblPrecioDeLa);

		JLabel RAMNumeroSerie = new JLabel("N\u00FAmero de Serie");
		RAMNumeroSerie.setBounds(20, 161, 162, 34);
		panel_3.add(RAMNumeroSerie);
		RAMNumeroSerie.setFont(new Font("Tahoma", Font.BOLD, 17));

		final JTextFieldLimitado textNumeroSerie = new JTextFieldLimitado();
		textNumeroSerie.setBounds(237, 163, 162, 27);
		panel_3.add(textNumeroSerie);
		textNumeroSerie.setLimit(10);
		textNumeroSerie.setHorizontalAlignment(SwingConstants.CENTER);
		textNumeroSerie.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblGb = new JLabel("GB");
		lblGb.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblGb.setBounds(328, 64, 51, 34);
		panel_3.add(lblGb);

		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(1125, 619, 145, 39);
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
		lblDelModeloDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDelModeloDe.setBounds(351, 11, 541, 31);
		panelRAM.add(lblDelModeloDe);

		final JPanel panelListadoComponentes = new JPanel();
		panelListadoComponentes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelListadoComponentes, "name_93809758457200");
		panelListadoComponentes.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 49, 1246, 523);
		panelListadoComponentes.add(scrollPane_1);

		tableComponentes = new JTable();
		tableComponentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		tableComponentes.getTableHeader().setReorderingAllowed(false);
		scrollPane_1.setViewportView(tableComponentes);

		JLabel lblNewLabel_2 = new JLabel("Listado de Componentes Disponibles");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(401, 11, 400, 38);
		panelListadoComponentes.add(lblNewLabel_2);

		final JPanel panelCPU = new JPanel();
		panelCPU.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelCPU, "name_151071058935400");
		panelCPU.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(302, 131, 729, 356);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelCPU.add(panel_7);
		panel_7.setLayout(null);

		JLabel label_6 = new JLabel("Marca");
		label_6.setBounds(30, 11, 61, 34);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_7.add(label_6);

		final JTextFieldLimitado marcaCPU = new JTextFieldLimitado();
		marcaCPU.setBounds(266, 15, 190, 27);
		marcaCPU.setLimit(15);
		marcaCPU.setHorizontalAlignment(SwingConstants.CENTER);
		marcaCPU.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_7.add(marcaCPU);

		final JTextFieldLimitado idCPU = new JTextFieldLimitado();
		idCPU.setBounds(266, 160, 190, 27);
		idCPU.setLimit(15);
		idCPU.setHorizontalAlignment(SwingConstants.CENTER);
		idCPU.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
		modeloCPU.setBounds(264, 61, 192, 27);
		modeloCPU.setLimit(20);
		modeloCPU.setHorizontalAlignment(SwingConstants.CENTER);
		modeloCPU.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_7.add(modeloCPU);

		JLabel label_11 = new JLabel("Tipo de Socket");
		label_11.setBounds(30, 103, 140, 34);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_7.add(label_11);

		final JComboBox comboBoxSocketCPU = new JComboBox();
		comboBoxSocketCPU.setBounds(267, 107, 189, 27);
		comboBoxSocketCPU.setModel(new DefaultComboBoxModel(new String[] {"", "LGA", "BGA", "PGA"}));
		comboBoxSocketCPU.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_7.add(comboBoxSocketCPU);

		JLabel label_13 = new JLabel("Precio base");
		label_13.setBounds(30, 245, 120, 34);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_7.add(label_13);

		final JSpinner spinnerPrecioBaseCPU = new JSpinner();
		spinnerPrecioBaseCPU.setBounds(267, 249, 81, 27);
		spinnerPrecioBaseCPU.setModel(new SpinnerNumberModel(0.0, 0.0, 450.0, 1.0));
		spinnerPrecioBaseCPU.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_7.add(spinnerPrecioBaseCPU);

		JLabel label_16 = new JLabel("Cantidad de unidades");
		label_16.setBounds(30, 279, 196, 47);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_7.add(label_16);

		final JSpinner spinnerUnidadesCPU = new JSpinner();
		spinnerUnidadesCPU.setModel(new SpinnerNumberModel(1, 1, 500, 1));
		spinnerUnidadesCPU.setBounds(267, 289, 81, 27);
		spinnerUnidadesCPU.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
		precioCPU.setFont(new Font("Tahoma", Font.PLAIN, 20));
		precioCPU.setBounds(12, 13, 153, 27);
		panel_8.add(precioCPU);

		JLabel lblVelocidad = new JLabel("Velocidad(Ghz)");
		lblVelocidad.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblVelocidad.setBounds(30, 201, 148, 34);
		panel_7.add(lblVelocidad);

		final JSpinner spinnerVelocidadCPU = new JSpinner();
		spinnerVelocidadCPU.setModel(new SpinnerNumberModel(1.0, 1.0, 5.0, 1.0));
		spinnerVelocidadCPU.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinnerVelocidadCPU.setBounds(267, 204, 81, 27);
		panel_7.add(spinnerVelocidadCPU);

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
					JOptionPane.showMessageDialog(null,"Los datos de este procesador han sido ingresados satisfactoriamente a la Tienda.Se ha actualizado el precio del Procesador.","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);

				}
				catch (IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		buttonIngresarCPU.setBounds(1126, 619, 129, 39);
		panelCPU.add(buttonIngresarCPU);
		buttonIngresarCPU.setFont(new Font("Arial Black", Font.PLAIN, 21));

		JLabel lblDelModeloDe_1 = new JLabel("Del modelo de microprocesador que desea a\u00F1adir ingrese:");
		lblDelModeloDe_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDelModeloDe_1.setBounds(405, 11, 541, 31);
		panelCPU.add(lblDelModeloDe_1);

		final JPanel panelHDD = new JPanel();
		panelHDD.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelHDD, "name_151142814562600");
		panelHDD.setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_9.setBounds(315, 125, 723, 359);
		panelHDD.add(panel_9);
		panel_9.setLayout(null);

		JLabel label_17 = new JLabel("Marca");
		label_17.setBounds(30, 11, 70, 34);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(label_17);

		final JTextFieldLimitado marcaHdd = new JTextFieldLimitado();
		marcaHdd.setBounds(247, 15, 185, 27);
		marcaHdd.setLimit(15);
		marcaHdd.setHorizontalAlignment(SwingConstants.CENTER);
		marcaHdd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_9.add(marcaHdd);

		JLabel label_18 = new JLabel("N\u00FAmero de Serie");
		label_18.setBounds(30, 188, 162, 34);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(label_18);

		final JTextFieldLimitado numeroSerieHDD = new JTextFieldLimitado();
		numeroSerieHDD.setBounds(247, 192, 179, 27);
		numeroSerieHDD.setLimit(10);
		numeroSerieHDD.setHorizontalAlignment(SwingConstants.CENTER);
		numeroSerieHDD.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_9.add(numeroSerieHDD);

		JLabel label_19 = new JLabel("Modelo");
		label_19.setBounds(30, 58, 81, 34);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(label_19);

		final JTextFieldLimitado modeloHDD = new JTextFieldLimitado();
		modeloHDD.setBounds(247, 62, 185, 27);
		modeloHDD.setLimit(10);
		modeloHDD.setHorizontalAlignment(SwingConstants.CENTER);
		modeloHDD.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_9.add(modeloHDD);

		JLabel label_20 = new JLabel("Precio base");
		label_20.setBounds(30, 233, 129, 27);
		label_20.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(label_20);

		final JSpinner spinnerPrecioHdd = new JSpinner();
		spinnerPrecioHdd.setModel(new SpinnerNumberModel(0.0, 0.0, 450.0, 1.0));
		spinnerPrecioHdd.setBounds(247, 230, 81, 27);
		spinnerPrecioHdd.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
		labelPrecioHDD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelPrecioHDD.setBounds(10, 11, 153, 27);
		panel_11.add(labelPrecioHDD);

		JLabel lblTipoDeConexin = new JLabel("Tipo de conexi\u00F3n");
		lblTipoDeConexin.setBounds(30, 105, 173, 34);
		lblTipoDeConexin.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(lblTipoDeConexin);

		final JComboBox comboBoxConexionHDD = new JComboBox();
		comboBoxConexionHDD.setBounds(247, 109, 185, 27);
		comboBoxConexionHDD.setModel(new DefaultComboBoxModel(new String[] {"", "IDE", "SATA", "SATA-2", "SATA-3"}));
		comboBoxConexionHDD.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_9.add(comboBoxConexionHDD);

		JLabel label_22 = new JLabel("Cantidad de unidades");
		label_22.setBounds(30, 271, 192, 37);
		label_22.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(label_22);

		final JSpinner unitsHDD = new JSpinner();
		unitsHDD.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		unitsHDD.setBounds(247, 276, 81, 27);
		unitsHDD.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_9.add(unitsHDD);

		JLabel label_23 = new JLabel("Cantidad de Memoria");
		label_23.setBounds(30, 150, 192, 27);
		label_23.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_9.add(label_23);

		final JSpinner spinnerMemoriaHDD = new JSpinner();
		spinnerMemoriaHDD.setBounds(247, 147, 81, 27);
		spinnerMemoriaHDD.setModel(new SpinnerNumberModel(128.0, 128.0, 4096.0, 1.0));
		spinnerMemoriaHDD.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_9.add(spinnerMemoriaHDD);

		JLabel label_24 = new JLabel("GB");
		label_24.setBounds(329, 144, 51, 34);
		label_24.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_9.add(label_24);

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
					JOptionPane.showMessageDialog(null,"Los datos de este disco duro han sido ingresados satisfactoriamente a la Tienda.Se ha actualizado el precio del disco duro.","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);

				}
				catch (IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		buttonIngresarHDD.setBounds(1141, 622, 129, 34);
		panelHDD.add(buttonIngresarHDD);
		buttonIngresarHDD.setFont(new Font("Arial Black", Font.PLAIN, 21));

		JLabel lblDelModeloDe_2 = new JLabel("Del modelo de disco duro que desea a\u00F1adir ingrese:");
		lblDelModeloDe_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDelModeloDe_2.setBounds(421, 11, 484, 31);
		panelHDD.add(lblDelModeloDe_2);

		final JPanel panelListadoPC = new JPanel();
		panel.add(panelListadoPC, "name_52437176500000");
		panelListadoPC.setLayout(null);

		JLabel lblListadoDeComputadoras = new JLabel("Listado de Computadoras Conformadas");
		lblListadoDeComputadoras.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListadoDeComputadoras.setBounds(429, 11, 400, 38);
		panelListadoPC.add(lblListadoDeComputadoras);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 70, 1241, 538);
		panelListadoPC.add(scrollPane_2);

		tablePC = new JTable();
		tablePC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePC.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "Motherboard", "CPU", "Memoria RAM (GB)", "Almacenamiento(GB)", "Precio"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablePC.getColumnModel().getColumn(0).setResizable(false);
		tablePC.getColumnModel().getColumn(1).setResizable(false);
		tablePC.getColumnModel().getColumn(1).setPreferredWidth(145);
		tablePC.getColumnModel().getColumn(2).setResizable(false);
		tablePC.getColumnModel().getColumn(2).setPreferredWidth(114);
		tablePC.getColumnModel().getColumn(3).setResizable(false);
		tablePC.getColumnModel().getColumn(3).setPreferredWidth(108);
		tablePC.getColumnModel().getColumn(4).setResizable(false);
		tablePC.getColumnModel().getColumn(4).setPreferredWidth(120);
		tablePC.getColumnModel().getColumn(5).setResizable(false);
		tablePC.getTableHeader().setReorderingAllowed(false);
		scrollPane_2.setViewportView(tablePC);

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
				panelListadoPC.setVisible(false);
				apellidosTrabajador.setText("");
				nombreTrabajador.setText("");
				idTrabajador.setText("");
				comboBoxCargo.setSelectedIndex(0);
				comboBoxEscolar.setSelectedIndex(0);
				salarioTrabajador.setText("");
				numIDT.setText(String.valueOf(counterTrabajador));

			}
		});
		if(!gerencia)
			mntmAadirTrabajador.setEnabled(false);
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
				panelListadoPC.setVisible(false);
				// poner todo en blanco
				marcaMotherboard.setText("");
				modeloMotherboard.setText("");
				comboBoxRAMMother.setSelectedItem("");
				comboBoxSocketMother.setSelectedItem("");
				idMotherboard.setText("");
				spinnerPrecioBaseMotherboard.setValue(1.00);
				spinnerUnitsMotherboard.setValue(1);
				chckbxIde.setSelected(false);
				chckbxSata.setSelected(false);
				chckbxSata_2.setSelected(false);
				chckbxSata_3.setSelected(false);
				labelPrecioMother.setText(String.valueOf(0.00)+"$");



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
				panelListadoPC.setVisible(false);
				// iniciar con todo en blanco
				textMarcaRAM.setText("");
				textNumeroSerie.setText("");
				comboBoxTipoRAM.setSelectedItem("");
				spinnerCapacidadRAM.setValue(1.00);
				spinnerPrecioBaseRAM.setValue(0.00);
				spinnerRAMUnit.setValue(1);
				lblPrecioRAM.setText(String.valueOf(0.00)+"$");


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
				panelListadoPC.setVisible(false);
				// para iniciar con todo en blanco
				marcaHdd.setText("");
				modeloHDD.setText("");
				comboBoxConexionHDD.setSelectedItem("");
				spinnerMemoriaHDD.setValue(128.00);
				spinnerPrecioHdd.setValue(1.00);
				unitsHDD.setValue(1);
				numeroSerieHDD.setText("");
				labelPrecioHDD.setText(String.valueOf(0.00)+"$");
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
				panelListadoPC.setVisible(false);
			}
		});
		mnAadirComponentes.add(mntmProcesadorcpu);

		JMenuItem mntmCrearPc = new JMenuItem("Crear PC");
		mntmCrearPc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tiendaPC.buscarRAMS()!= 0 && tiendaPC.buscarHDDS()!= 0 && tiendaPC.buscarCPUS() != 0 && tiendaPC.buscarMotherboards() != 0 ) {
					try {
						crearPC dialog = new crearPC(tiendaPC ,MenuTienda.this);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null,"Debe haber al menos un componente de cada tipo para formar una pc.","No se ha ingresado cada tipo de componente",JOptionPane.ERROR_MESSAGE);

			}
		});
		mnGerencia.add(mntmCrearPc);

		JMenu mnNewMenu = new JMenu("Listados");
		menuBar.add(mnNewMenu);

		final JMenuItem mntmMostrarListado = new JMenuItem("Mostrar Listado de Trabajadores");
		mntmMostrarListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tiendaPC.getTrabajadores().size() != 0){
					// mostrar panel de la tabla
					panelInicio.setVisible(false);
					paneIngresarTrabajador.setVisible(false);
					panelListaTrabajadores.setVisible(true);
					panelMotherboard.setVisible(false);
					panelRAM.setVisible(false);	
					panelListadoComponentes.setVisible(false);
					panelHDD.setVisible(false);
					panelCPU.setVisible(false);
					panelListadoPC.setVisible(false);

					// añadir trabajadores a la tabla
					modelo = (DefaultTableModel) tableTrabajador.getModel();
					modelo.setRowCount(0);
					for(Trabajador t : tiendaPC.getTrabajadores()){
						Object trabajador [] = {t.getNumeroTrabajador(),t.getNombre(),t.getApellidos(),t.getCargo(),t.getId(),t.getNivelEscolar(),t.getSalario()};
						modelo.addRow(trabajador);
					}

				}
				else
					JOptionPane.showMessageDialog(null,"No hay ningún trabajador agregado a la tienda.","No se ha ingresado ningún trabajador",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmMostrarListado);

		final JMenuItem mntmMostrarListadoDe = new JMenuItem("Mostrar Listado de Componentes");
		mntmMostrarListadoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tiendaPC.getComponentes().size() != 0){
					// Mostrar panel de la tabla
					panelInicio.setVisible(false);
					paneIngresarTrabajador.setVisible(false);
					panelListaTrabajadores.setVisible(false);
					panelMotherboard.setVisible(false);
					panelRAM.setVisible(false);	
					panelListadoComponentes.setVisible(true);
					panelHDD.setVisible(false);
					panelCPU.setVisible(false);
					panelListadoPC.setVisible(false);

					// rellenar tabla
					modelo = (DefaultTableModel) tableComponentes.getModel();
					modelo.setRowCount(0);
					for(Componente c : tiendaPC.getComponentes()){
						Object Info [] = {c.getClass().getSimpleName(),c.getMarca(),c.getNumeroSerie(),c.calcularPrecio(),c.getCantidadDisponible()};
						modelo.addRow(Info);
					}
				}
				else
					JOptionPane.showMessageDialog(null,"No hay ningún componente agregado a la tienda.","No se ha ingresado ningún componente",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmMostrarListadoDe);

		final JMenuItem mntmMostrarListadoDe_1 = new JMenuItem("Mostrar Listado de PC conformadas");
		mntmMostrarListadoDe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tiendaPC.getComputadoras().size() !=0){
					panelInicio.setVisible(false);
					paneIngresarTrabajador.setVisible(false);
					panelListaTrabajadores.setVisible(false);
					panelMotherboard.setVisible(false);
					panelRAM.setVisible(false);	
					panelListadoComponentes.setVisible(false);
					panelHDD.setVisible(false);
					panelCPU.setVisible(false);
					panelListadoPC.setVisible(true);
					// rellenar tabla
					modelo = (DefaultTableModel)tablePC.getModel();
					modelo.setRowCount(0);
					for(PC p : tiendaPC.getComputadoras()){	
						Object [] info = {p.getId(), p.getMotherboardPC().getModelo(), p.getCpuPC().getModelo(), p.memoriaTotal(), p.almacenamientoTotal(), p.calcularPrecioTotal()};
						modelo.addRow(info);
					}
				}
				else
					JOptionPane.showMessageDialog(null,"No hay ninguna computadora agregada a la tienda.","No se ha ingresado ninguna computadora",JOptionPane.INFORMATION_MESSAGE);


			}
		});
		mnNewMenu.add(mntmMostrarListadoDe_1);

		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);

		JMenuItem mntmNewMenuItem = new JMenuItem("Reporte de Trabajadores por Salario,Cargo y Escolaridad.");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tiendaPC.getTrabajadores().size() != 0){
					if (dialogreporteTrabajador == null || !dialogreporteTrabajador.isShowing()) {
						try {
							dialogreporteTrabajador = new reporteTrabajador(tiendaPC,MenuTienda.this);
							dialogreporteTrabajador.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialogreporteTrabajador.setLocationRelativeTo(null);
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
							dialogReporteComponentes = new reporteComponentes(tiendaPC, MenuTienda.this);
							dialogReporteComponentes.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialogReporteComponentes.setLocationRelativeTo(null);
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
		mntmReporteDeComputadoras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tiendaPC.getComputadoras().size()!=0){

					try {
						reportesPC dialog = new reportesPC(MenuTienda.this, tiendaPC);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null,"No hay computadora agregada a la tienda.","No se ha ingresado ninguna computadora",JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		mnReportes.add(mntmReporteDeComputadoras);

		JMenuItem mntmReporteDeTarjetas = new JMenuItem("Reporte de tarjetas RAM seg\u00FAn su velocidad y tipo de Memoria.");
		mntmReporteDeTarjetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tiendaPC.buscarRAMS()!= 0){
					try {
						dialogReportesRAM = new reportesRAM(tiendaPC, MenuTienda.this);
						dialogReportesRAM.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialogReportesRAM.setLocationRelativeTo(null);
						dialogReportesRAM.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null,"No hay ninguna memoria RAM agregada a la tienda.","No se ha ingresado ninguna memoria ram",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnReportes.add(mntmReporteDeTarjetas);

		JMenu mnInformacin = new JMenu("Informaci\u00F3n Adicional");
		menuBar.add(mnInformacin);

		JMenuItem mntmDatosDeLa = new JMenuItem("Datos de la Tienda");
		mntmDatosDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dialogInfoTienda = new InfoTienda(tiendaPC, MenuTienda.this);
					dialogInfoTienda.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialogInfoTienda.setLocationRelativeTo(null);
					dialogInfoTienda.setVisible(true);
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

		final JMenuItem mntmInicio = new JMenuItem("Volver al Inicio");
		mnInformacin.add(mntmInicio);

		JMenuItem mntmModificarInformacinDe = new JMenuItem("Modificar Informaci\u00F3n de la tienda");
		mntmModificarInformacinDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CambiarDatos dialog = new CambiarDatos(MenuTienda.this, tiendaPC);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		if(!gerencia)
			mntmModificarInformacinDe.setEnabled(false);
		mnInformacin.add(mntmModificarInformacinDe);

		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login dialog = new Login(tiendaPC);
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnInformacin.add(mntmCerrarSesin);
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
				panelListadoPC.setVisible(false);
			}
		});

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableTrabajador.getSelectedRows().length == 1){
					int fila = tableTrabajador.getSelectedRow();
					if(fila != 0){
						String id = (String)tableTrabajador.getValueAt(fila , 4);
						int pos = tiendaPC.posTrabajadorPorID(id);
						JOptionPane.showMessageDialog(null,"Se ha borrado el trabajador " +tiendaPC.getTrabajadores().get(pos).getNombre()+" correctamente","Trabajador eliminado", JOptionPane.INFORMATION_MESSAGE);
						tiendaPC.getTrabajadores().remove(pos);
						mntmMostrarListado.doClick();
					}
					else
						JOptionPane.showMessageDialog(null,"No se puede eliminar el gerente","Error", JOptionPane.ERROR_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null,"Seleccione a un trabajador de la lista","No selecciono ninguno", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnBorrar.setBounds(1161, 608, 89, 23);
		if(!gerencia)
			btnBorrar.setEnabled(false);
		panelListaTrabajadores.add(btnBorrar);

		JButton btnBorrar_1 = new JButton("Borrar");
		btnBorrar_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBorrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableComponentes.getSelectedRows().length == 1){
					int fila = tableComponentes.getSelectedRow();
					String tipo = (String)tableComponentes.getValueAt(fila , 0);
					String id = (String)tableComponentes.getValueAt(fila , 2);
					int pos = -1;
					if(tipo.equals("RAM"))
						pos = tiendaPC.posRAMPorID(id);
					if(tipo.equals("CPU"))
						pos = tiendaPC.posCPUPorID(id);
					if(tipo.equals("HDD"))
						pos = tiendaPC.posHDDPorID(id);
					if(tipo.equals("Motherboard"))
						pos = tiendaPC.posMotherboardPorID(id);
					JOptionPane.showMessageDialog(null,"Se ha eliminado el componente " +tiendaPC.getComponentes().get(pos).getNumeroSerie()+" correctamente","Componente eliminado", JOptionPane.INFORMATION_MESSAGE);
					tiendaPC.getComponentes().remove(pos);
					if(tableComponentes.getRowCount()==1)
						mntmInicio.doClick();
					else
						mntmMostrarListadoDe.doClick();

				}
				else
					JOptionPane.showMessageDialog(null,"Seleccione un Componente de la lista","No selecciono ninguno", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnBorrar_1.setBounds(1167, 611, 89, 23);
		panelListadoComponentes.add(btnBorrar_1);


		JButton btnNewButton_1 = new JButton("Borrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tablePC.getSelectedRows().length == 1){
					int fila = tablePC.getSelectedRow();
					String id = (String)tablePC.getValueAt(fila , 0);
					int pos = tiendaPC.posPCPorID(id);
					JOptionPane.showMessageDialog(null,"Se ha eliminado la computadora con id: " +tiendaPC.getComputadoras().get(pos).getId()+" correctamente","PC eliminada", JOptionPane.INFORMATION_MESSAGE);
					tiendaPC.getComputadoras().remove(pos);
					if(tablePC.getRowCount()==1)
						mntmInicio.doClick();
					else
						mntmMostrarListadoDe_1.doClick();

				}
				else
					JOptionPane.showMessageDialog(null,"Seleccione una computadora de la lista","No selecciono ninguno", JOptionPane.ERROR_MESSAGE);

			}
		});
		btnNewButton_1.setBounds(10, 619, 89, 23);
		panelListadoPC.add(btnNewButton_1);
		// editar trabajador
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableTrabajador.getSelectedRows().length == 1) {
					int fila = tableTrabajador.getSelectedRow();
					if(fila!=0){
						String id = (String)tableTrabajador.getValueAt(fila,4);
						int pos = tiendaPC.posTrabajadorPorID(id);
						Trabajador t = tiendaPC.getTrabajadores().get(pos);
						try {
							editarDialog dialog = new editarDialog(MenuTienda.this,tiendaPC,pos,t,null);
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						mntmMostrarListado.doClick();
					}
					else
						JOptionPane.showMessageDialog(null,"No se puede editar el gerente..","No se puede modificar al gerente", JOptionPane.ERROR_MESSAGE);
				} else
					JOptionPane.showMessageDialog(null,"Seleccione a un trabajador de la lista","No seleccionó ninguno", JOptionPane.ERROR_MESSAGE);

			}

		});

		btnEditar.setBounds(10, 608, 89, 23);
		if(!gerencia)
			btnEditar.setEnabled(false);
		panelListaTrabajadores.add(btnEditar);

		// editar componente
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableComponentes.getSelectedRows().length == 1) {
					int fila = tableComponentes.getSelectedRow();
					String tipo = (String)tableComponentes.getValueAt(fila , 0);
					String id = (String)tableComponentes.getValueAt(fila , 2);
					int pos = -1;
					if(tipo.equals("RAM"))
						pos = tiendaPC.posRAMPorID(id);
					if(tipo.equals("CPU"))
						pos = tiendaPC.posCPUPorID(id);
					if(tipo.equals("HDD"))
						pos = tiendaPC.posHDDPorID(id);
					if(tipo.equals("Motherboard"))
						pos = tiendaPC.posMotherboardPorID(id);
					Componente c = tiendaPC.getComponentes().get(pos);
					try {
						editarDialog dialog = new editarDialog(MenuTienda.this,tiendaPC,pos,null,c);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}



					mntmMostrarListadoDe.doClick();
				}
				else
					JOptionPane.showMessageDialog(null,"No se seleccionó ningún componente.","Error al editar", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnEditar_1.setBounds(10, 611, 89, 23);
		panelListadoComponentes.add(btnEditar_1);
	}
}
