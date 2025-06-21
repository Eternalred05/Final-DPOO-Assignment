package GUI;
import Logic.*;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;

import Componentes.JTextFieldLimitado;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class editarDialog extends JDialog {
	Trabajador t;
	Componente c;

	public editarDialog(MenuTienda parent, final Tienda tienda,int pos, Trabajador param, Componente param2 ) {
		super(parent,true);
		setTitle("Editar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(crearPC.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		setResizable(false);
		setBounds(100, 100, 686, 565);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new CardLayout(0, 0));
		t = param;
		c = param2;

		JPanel panelTrabajador = new JPanel();
		getContentPane().add(panelTrabajador, "name_378915643378600");
		panelTrabajador.setLayout(null);

		JLabel label = new JLabel("Salario");
		label.setBounds(90, 385, 105, 34);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelTrabajador.add(label);

		JLabel label_1 = new JLabel("Nivel \r\nEscolar");
		label_1.setBounds(90, 338, 151, 34);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelTrabajador.add(label_1);

		JLabel label_2 = new JLabel("Cargo");
		label_2.setBounds(90, 275, 87, 34);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelTrabajador.add(label_2);

		final JComboBox comboBoxCargo = new JComboBox();
		comboBoxCargo.setBounds(281, 286, 235, 20);
		comboBoxCargo.setModel(new DefaultComboBoxModel(new String[] {"", "Gestor de ventas", "Encargado de inventario", "Asesor de ventas", "Especialista en productos", "Encargado de servicio", "Especialista en software", "Cajero"}));
		comboBoxCargo.setForeground(Color.BLACK);
		comboBoxCargo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTrabajador.add(comboBoxCargo);

		final JComboBox comboBoxEscolar = new JComboBox();
		comboBoxEscolar.setBounds(281, 353, 235, 20);
		comboBoxEscolar.setModel(new DefaultComboBoxModel(new String[] {"", "Primario", "Secundario", "Preuniversitario", "T\u00E9cnico Medio", "Obrero Calificado", "Universitario", "T\u00E9cnico profesional"}));
		comboBoxEscolar.setForeground(Color.BLACK);
		comboBoxEscolar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTrabajador.add(comboBoxEscolar);

		JLabel label_3 = new JLabel("Identificador");
		label_3.setBounds(92, 215, 164, 34);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelTrabajador.add(label_3);

		JLabel label_4 = new JLabel("Apellidos");
		label_4.setBounds(90, 168, 126, 34);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelTrabajador.add(label_4);

		JLabel label_5 = new JLabel("Nombre");
		label_5.setBounds(92, 121, 103, 34);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelTrabajador.add(label_5);

		final JTextFieldLimitado nombreTrabajador = new JTextFieldLimitado();
		nombreTrabajador.setBounds(281, 179, 235, 20);
		nombreTrabajador.setLimit(25);
		nombreTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTrabajador.add(nombreTrabajador);

		final JTextFieldLimitado apellidosTrabajador = new JTextFieldLimitado();
		apellidosTrabajador.setBounds(281, 132, 235, 20);
		apellidosTrabajador.setLimit(25);
		apellidosTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		apellidosTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTrabajador.add(apellidosTrabajador);

		JTextFieldLimitado idTrabajador = new JTextFieldLimitado();
		idTrabajador.setBounds(281, 226, 235, 20);
		idTrabajador.setLimit(11);
		idTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		idTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTrabajador.add(idTrabajador);

		JLabel lblNumeroDeTrabajador = new JLabel("N\u00FAmero de Trabajador");
		lblNumeroDeTrabajador.setBounds(458, 11, 212, 25);
		lblNumeroDeTrabajador.setForeground(Color.WHITE);
		lblNumeroDeTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelTrabajador.add(lblNumeroDeTrabajador);

		JPanel panel = new JPanel();
		panel.setBounds(531, 38, 35, 34);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.WHITE);
		panelTrabajador.add(panel);

		JLabel numTrabajador = new JLabel("0");
		numTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		numTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numTrabajador.setBounds(0, 0, 35, 34);
		panel.add(numTrabajador);

		final JSpinner salarioTrabajador = new JSpinner();
		salarioTrabajador.setBounds(281, 396, 81, 20);
		salarioTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		salarioTrabajador.setModel(new SpinnerNumberModel(2000.0, 2000.0, 15000.0, 100.0));
		panelTrabajador.add(salarioTrabajador);

		JPanel panelMotherboard = new JPanel();
		getContentPane().add(panelMotherboard, "name_378927127267400");
		panelMotherboard.setLayout(null);

		JLabel label_6 = new JLabel("Marca");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_6.setBounds(10, 66, 101, 34);
		panelMotherboard.add(label_6);

		final JTextFieldLimitado marcaMother = new JTextFieldLimitado();
		marcaMother.setLimit(15);
		marcaMother.setHorizontalAlignment(SwingConstants.CENTER);
		marcaMother.setFont(new Font("Tahoma", Font.PLAIN, 19));
		marcaMother.setBounds(237, 64, 173, 27);
		panelMotherboard.add(marcaMother);

		final JTextFieldLimitado modeloMother = new JTextFieldLimitado();
		modeloMother.setLimit(10);
		modeloMother.setHorizontalAlignment(SwingConstants.CENTER);
		modeloMother.setFont(new Font("Tahoma", Font.PLAIN, 19));
		modeloMother.setBounds(237, 104, 173, 27);
		panelMotherboard.add(modeloMother);

		JLabel label_7 = new JLabel("Modelo");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_7.setBounds(10, 101, 81, 34);
		panelMotherboard.add(label_7);

		JLabel label_8 = new JLabel("Tipo de Socket");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_8.setBounds(10, 138, 129, 34);
		panelMotherboard.add(label_8);

		final JComboBox comboBoxSocketMother = new JComboBox();
		comboBoxSocketMother.setModel(new DefaultComboBoxModel(new String[] {"", "LGA", "PGA", "BGA"}));
		comboBoxSocketMother.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBoxSocketMother.setBounds(237, 141, 173, 27);
		panelMotherboard.add(comboBoxSocketMother);

		final JComboBox comboBoxRAMMother = new JComboBox();
		comboBoxRAMMother.setModel(new DefaultComboBoxModel(new String[] {"", "DDR", "DDR2", "DDR3", "DDR4", "DDR5"}));
		comboBoxRAMMother.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBoxRAMMother.setBounds(237, 177, 173, 27);
		panelMotherboard.add(comboBoxRAMMother);

		JLabel lblTipoDeRam = new JLabel("Tipo de RAM");
		lblTipoDeRam.setForeground(Color.WHITE);
		lblTipoDeRam.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTipoDeRam.setBounds(10, 185, 242, 34);
		panelMotherboard.add(lblTipoDeRam);

		JLabel label_10 = new JLabel("N\u00FAmero de Serie");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_10.setBounds(10, 221, 162, 34);
		panelMotherboard.add(label_10);

		JTextFieldLimitado IDMother = new JTextFieldLimitado();
		IDMother.setLimit(10);
		IDMother.setHorizontalAlignment(SwingConstants.CENTER);
		IDMother.setFont(new Font("Tahoma", Font.PLAIN, 19));
		IDMother.setBounds(237, 217, 173, 27);
		panelMotherboard.add(IDMother);

		final JSpinner precioMother = new JSpinner();
		precioMother.setModel(new SpinnerNumberModel(100.0, 100.0, 1000.0, 1.0));
		precioMother.setFont(new Font("Tahoma", Font.PLAIN, 19));
		precioMother.setBounds(237, 257, 116, 27);
		panelMotherboard.add(precioMother);

		JLabel label_11 = new JLabel("Precio base");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_11.setBounds(10, 258, 114, 27);
		panelMotherboard.add(label_11);

		JLabel label_12 = new JLabel("Cantidad de unidades");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_12.setBounds(10, 285, 196, 49);
		panelMotherboard.add(label_12);

		final JSpinner unitMother = new JSpinner();
		unitMother.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		unitMother.setFont(new Font("Tahoma", Font.PLAIN, 19));
		unitMother.setBounds(237, 295, 116, 27);
		panelMotherboard.add(unitMother);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(377, 286, 293, 192);
		panelMotherboard.add(panel_1);

		JLabel label_13 = new JLabel("Conexiones de los discos duros");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_13.setBounds(12, 13, 257, 34);
		panel_1.add(label_13);

		final JCheckBox chckbxSata = new JCheckBox("SATA");
		chckbxSata.setFont(new Font("Tahoma", Font.PLAIN, 21));
		chckbxSata.setBounds(12, 76, 114, 23);
		panel_1.add(chckbxSata);

		final JCheckBox chckbxSata_2 = new JCheckBox("SATA-2");
		chckbxSata_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		chckbxSata_2.setBounds(12, 109, 114, 23);
		panel_1.add(chckbxSata_2);

		final JCheckBox chckbxSata_3 = new JCheckBox("SATA-3");
		chckbxSata_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		chckbxSata_3.setBounds(171, 76, 114, 23);
		panel_1.add(chckbxSata_3);

		final JCheckBox chckbxIde = new JCheckBox("IDE");
		chckbxIde.setFont(new Font("Tahoma", Font.PLAIN, 21));
		chckbxIde.setBounds(171, 109, 87, 23);
		panel_1.add(chckbxIde);

		JLabel label_14 = new JLabel("Precio del Motherboard");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_14.setBounds(58, 376, 184, 34);
		panelMotherboard.add(label_14);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(68, 406, 173, 49);
		panelMotherboard.add(panel_2);
		
				JLabel labelPrecioMother = new JLabel("0.0000$");
				labelPrecioMother.setBounds(12, 13, 153, 27);
				panel_2.add(labelPrecioMother);
				labelPrecioMother.setHorizontalAlignment(SwingConstants.CENTER);
				labelPrecioMother.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JPanel panelCPU = new JPanel();
		getContentPane().add(panelCPU, "name_378939534683800");
		panelCPU.setLayout(null);

		JLabel label_23 = new JLabel("Marca");
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_23.setBounds(10, 56, 61, 34);
		panelCPU.add(label_23);

		final JTextFieldLimitado marcaCPU = new JTextFieldLimitado();
		marcaCPU.setLimit(15);
		marcaCPU.setHorizontalAlignment(SwingConstants.CENTER);
		marcaCPU.setFont(new Font("Tahoma", Font.PLAIN, 19));
		marcaCPU.setBounds(246, 60, 201, 27);
		panelCPU.add(marcaCPU);

		final JTextFieldLimitado modeloCPU = new JTextFieldLimitado();
		modeloCPU.setLimit(20);
		modeloCPU.setHorizontalAlignment(SwingConstants.CENTER);
		modeloCPU.setFont(new Font("Tahoma", Font.PLAIN, 19));
		modeloCPU.setBounds(244, 106, 203, 27);
		panelCPU.add(modeloCPU);

		JLabel label_24 = new JLabel("Modelo");
		label_24.setForeground(Color.WHITE);
		label_24.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_24.setBounds(10, 103, 81, 32);
		panelCPU.add(label_24);

		JLabel label_25 = new JLabel("Tipo de Socket");
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_25.setBounds(10, 148, 140, 34);
		panelCPU.add(label_25);

		final JComboBox comboBoxSocket = new JComboBox();
		comboBoxSocket.setModel(new DefaultComboBoxModel(new String[] {"", "LGA", "BGA", "PGA"}));
		comboBoxSocket.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBoxSocket.setBounds(247, 152, 200, 27);
		panelCPU.add(comboBoxSocket);

		JTextFieldLimitado IDCPU = new JTextFieldLimitado();
		IDCPU.setLimit(15);
		IDCPU.setHorizontalAlignment(SwingConstants.CENTER);
		IDCPU.setFont(new Font("Tahoma", Font.PLAIN, 19));
		IDCPU.setBounds(246, 205, 201, 27);
		panelCPU.add(IDCPU);

		JLabel label_26 = new JLabel("N\u00FAmero de Serie");
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_26.setBounds(10, 201, 148, 34);
		panelCPU.add(label_26);

		JLabel label_27 = new JLabel("Velocidad(Ghz)");
		label_27.setForeground(Color.WHITE);
		label_27.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_27.setBounds(10, 246, 148, 34);
		panelCPU.add(label_27);

		final JSpinner velocidadCPU = new JSpinner();
		velocidadCPU.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		velocidadCPU.setFont(new Font("Tahoma", Font.PLAIN, 19));
		velocidadCPU.setBounds(247, 249, 81, 27);
		panelCPU.add(velocidadCPU);

		final JSpinner precioCPU = new JSpinner();
		precioCPU.setModel(new SpinnerNumberModel(100.0, 100.0, 599.0, 1.0));
		precioCPU.setFont(new Font("Tahoma", Font.PLAIN, 19));
		precioCPU.setBounds(247, 294, 81, 27);
		panelCPU.add(precioCPU);

		JLabel label_28 = new JLabel("Precio base");
		label_28.setForeground(Color.WHITE);
		label_28.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_28.setBounds(10, 290, 120, 34);
		panelCPU.add(label_28);

		JLabel label_29 = new JLabel("Cantidad de unidades");
		label_29.setForeground(Color.WHITE);
		label_29.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_29.setBounds(10, 324, 196, 47);
		panelCPU.add(label_29);

		final JSpinner unitCPU = new JSpinner();
		unitCPU.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		unitCPU.setFont(new Font("Tahoma", Font.PLAIN, 19));
		unitCPU.setBounds(247, 334, 81, 27);
		panelCPU.add(unitCPU);

		JLabel label_30 = new JLabel("Precio de la CPU");
		label_30.setForeground(Color.WHITE);
		label_30.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_30.setBounds(457, 270, 140, 34);
		panelCPU.add(label_30);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(435, 304, 173, 49);
		panelCPU.add(panel_3);

		JLabel labelPrecioCPU = new JLabel("0.0000$");
		labelPrecioCPU.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrecioCPU.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelPrecioCPU.setBounds(12, 13, 153, 27);
		panel_3.add(labelPrecioCPU);

		JLabel lblCambieLosDatos_1 = new JLabel("Cambie los datos de CPU que desee");
		lblCambieLosDatos_1.setForeground(Color.WHITE);
		lblCambieLosDatos_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCambieLosDatos_1.setBounds(156, 13, 380, 34);
		panelCPU.add(lblCambieLosDatos_1);

		JPanel panelRAM = new JPanel();
		getContentPane().add(panelRAM, "name_378954342278800");
		panelRAM.setLayout(null);

		final JTextFieldLimitado marcaRAM = new JTextFieldLimitado();
		marcaRAM.setLimit(15);
		marcaRAM.setHorizontalAlignment(SwingConstants.CENTER);
		marcaRAM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		marcaRAM.setBounds(231, 91, 162, 27);
		panelRAM.add(marcaRAM);

		JLabel label_16 = new JLabel("Marca");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_16.setBounds(12, 87, 81, 34);
		panelRAM.add(label_16);

		JLabel label_17 = new JLabel("Cantidad de Memoria");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_17.setBounds(12, 134, 205, 27);
		panelRAM.add(label_17);

		final JSpinner memoriaRAM = new JSpinner();
		memoriaRAM.setModel(new SpinnerNumberModel(1.0, 1.0, 128.0, 1.0));
		memoriaRAM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		memoriaRAM.setBounds(231, 134, 81, 27);
		panelRAM.add(memoriaRAM);

		final JComboBox comboBoxRAM = new JComboBox();
		comboBoxRAM.setModel(new DefaultComboBoxModel(new String[] {"", "DDR", "DDR2", "DDR3", "DDR4", "DDR5"}));
		comboBoxRAM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxRAM.setBounds(231, 178, 163, 27);
		panelRAM.add(comboBoxRAM);

		JLabel label_19 = new JLabel("Tipo de memoria");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_19.setBounds(12, 174, 153, 34);
		panelRAM.add(label_19);

		JLabel label_20 = new JLabel("N\u00FAmero de Serie");
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_20.setBounds(12, 221, 162, 34);
		panelRAM.add(label_20);

		JLabel label_21 = new JLabel("Precio base");
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_21.setBounds(12, 294, 129, 34);
		panelRAM.add(label_21);

		JLabel label_22 = new JLabel("Cantidad de unidades");
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_22.setBounds(12, 341, 205, 49);
		panelRAM.add(label_22);

		final JSpinner unitRAM = new JSpinner();
		unitRAM.setModel(new SpinnerNumberModel(1, 1, 300, 1));
		unitRAM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		unitRAM.setBounds(231, 352, 81, 27);
		panelRAM.add(unitRAM);

		final JSpinner precioRAM = new JSpinner();
		precioRAM.setModel(new SpinnerNumberModel(100.0, 100.0, 600.0, 1.0));
		precioRAM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		precioRAM.setBounds(231, 280, 81, 27);
		panelRAM.add(precioRAM);

		final JTextFieldLimitado IDRAM = new JTextFieldLimitado();
		IDRAM.setLimit(10);
		IDRAM.setHorizontalAlignment(SwingConstants.CENTER);
		IDRAM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		IDRAM.setBounds(231, 228, 162, 27);
		panelRAM.add(IDRAM);

		JLabel lblCambieLosDatos = new JLabel("Cambie los datos de la RAM que desee");
		lblCambieLosDatos.setForeground(Color.WHITE);
		lblCambieLosDatos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCambieLosDatos.setBounds(150, 13, 387, 51);
		panelRAM.add(lblCambieLosDatos);

		JLabel lblPrecioDeLa = new JLabel("Precio de la RAM");
		lblPrecioDeLa.setForeground(Color.WHITE);
		lblPrecioDeLa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrecioDeLa.setBounds(283, 416, 153, 34);
		panelRAM.add(lblPrecioDeLa);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_6.setBounds(266, 447, 173, 49);
		panelRAM.add(panel_6);

		JLabel labelPrecioRAM = new JLabel("0.0000$");
		labelPrecioRAM.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrecioRAM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelPrecioRAM.setBounds(10, 11, 153, 27);
		panel_6.add(labelPrecioRAM);

		JPanel panelHDD = new JPanel();
		getContentPane().add(panelHDD, "name_378979497942400");
		panelHDD.setLayout(null);

		JLabel label_32 = new JLabel("Marca");
		label_32.setForeground(Color.WHITE);
		label_32.setBounds(10, 82, 70, 34);
		label_32.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_32);

		final JTextFieldLimitado marcaHDD = new JTextFieldLimitado();
		marcaHDD.setBounds(227, 86, 204, 27);
		marcaHDD.setLimit(15);
		marcaHDD.setHorizontalAlignment(SwingConstants.CENTER);
		marcaHDD.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelHDD.add(marcaHDD);

		final JTextFieldLimitado modeloHDD = new JTextFieldLimitado();
		modeloHDD.setBounds(227, 133, 204, 27);
		modeloHDD.setLimit(10);
		modeloHDD.setHorizontalAlignment(SwingConstants.CENTER);
		modeloHDD.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelHDD.add(modeloHDD);

		JLabel label_33 = new JLabel("Modelo");
		label_33.setForeground(Color.WHITE);
		label_33.setBounds(10, 129, 81, 34);
		label_33.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_33);

		JLabel label_34 = new JLabel("Tipo de conexi\u00F3n");
		label_34.setForeground(Color.WHITE);
		label_34.setBounds(10, 176, 173, 34);
		label_34.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_34);

		final JComboBox conexionHDD = new JComboBox();
		conexionHDD.setModel(new DefaultComboBoxModel(new String[] {"", "IDE", "SATA", "SATA-2", "SATA-3"}));
		conexionHDD.setBounds(227, 180, 204, 27);
		conexionHDD.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelHDD.add(conexionHDD);

		JLabel label_35 = new JLabel("GB");
		label_35.setForeground(Color.WHITE);
		label_35.setBounds(318, 220, 51, 34);
		label_35.setFont(new Font("Tahoma", Font.BOLD, 23));
		panelHDD.add(label_35);

		final JSpinner memoriaHDD = new JSpinner();
		memoriaHDD.setModel(new SpinnerNumberModel(128.0, 128.0, 4096.0, 1.0));
		memoriaHDD.setBounds(227, 227, 81, 27);
		memoriaHDD.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelHDD.add(memoriaHDD);

		JLabel label_36 = new JLabel("Cantidad de Memoria");
		label_36.setForeground(Color.WHITE);
		label_36.setBounds(10, 227, 192, 27);
		label_36.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_36);

		JLabel label_37 = new JLabel("N\u00FAmero de Serie");
		label_37.setForeground(Color.WHITE);
		label_37.setBounds(10, 276, 162, 34);
		label_37.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_37);

		JTextFieldLimitado IDHDD = new JTextFieldLimitado();
		IDHDD.setBounds(233, 280, 198, 27);
		IDHDD.setLimit(10);
		IDHDD.setHorizontalAlignment(SwingConstants.CENTER);
		IDHDD.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelHDD.add(IDHDD);

		final JSpinner precioHDD = new JSpinner();
		precioHDD.setModel(new SpinnerNumberModel(100.0, 100.0, 600.0, 100.0));
		precioHDD.setBounds(233, 320, 81, 27);
		precioHDD.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelHDD.add(precioHDD);

		JLabel label_38 = new JLabel("Precio base");
		label_38.setForeground(Color.WHITE);
		label_38.setBounds(10, 323, 129, 27);
		label_38.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_38);

		JLabel label_39 = new JLabel("Cantidad de unidades");
		label_39.setForeground(Color.WHITE);
		label_39.setBounds(10, 363, 192, 37);
		label_39.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_39);

		final JSpinner unitsHDD = new JSpinner();
		unitsHDD.setModel(new SpinnerNumberModel(1, 1, 200, 1));
		unitsHDD.setBounds(233, 363, 81, 27);
		unitsHDD.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelHDD.add(unitsHDD);

		JLabel label_40 = new JLabel("Precio del disco duro");
		label_40.setForeground(Color.WHITE);
		label_40.setBounds(477, 222, 185, 34);
		label_40.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelHDD.add(label_40);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(477, 261, 173, 49);
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelHDD.add(panel_4);

		JLabel labelPrecioHDD = new JLabel("0.0000$");
		labelPrecioHDD.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrecioHDD.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelPrecioHDD.setBounds(10, 11, 153, 27);
		panel_4.add(labelPrecioHDD);

		JButton button_3 = new JButton("Editar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HDD h = (HDD)c;
				try{
					h.editarHDD((int)unitsHDD.getValue(),marcaHDD.getText(),modeloHDD.getText(),(double)memoriaHDD.getValue(),(String)conexionHDD.getSelectedItem(),(double)precioHDD.getValue());
					JOptionPane.showMessageDialog(null,"Se han guardado los cambios","Cambios realizados",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				catch(IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error al editar el disco",JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		button_3.setBounds(534, 491, 129, 34);
		panelHDD.add(button_3);

		JLabel lblCambieLosDatos_2 = new JLabel("Cambie los datos del disco duro que desee");
		lblCambieLosDatos_2.setForeground(Color.WHITE);
		lblCambieLosDatos_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCambieLosDatos_2.setBounds(116, 27, 445, 34);
		panelHDD.add(lblCambieLosDatos_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(editarDialog.class.getResource("/Resources/228489.jpg")));
		lblNewLabel_5.setBounds(-250, -1117, 3410, 1918);
		panelHDD.add(lblNewLabel_5);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(541, 491, 129, 34);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					t.editarTrabajador(nombreTrabajador.getText(),apellidosTrabajador.getText(),(double)salarioTrabajador.getValue(),(String)comboBoxCargo.getSelectedItem(),(String)comboBoxEscolar.getSelectedItem());
					JOptionPane.showMessageDialog(null,"Se han guardado los cambios","Cambios realizados",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				catch(IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error al editar al trabajador",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panelTrabajador.add(btnEditar);

		JLabel lblCambieLosDatos_4 = new JLabel("Cambie los datos de este trabajador que desee");
		lblCambieLosDatos_4.setForeground(Color.WHITE);
		lblCambieLosDatos_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCambieLosDatos_4.setBounds(121, 74, 477, 34);
		panelTrabajador.add(lblCambieLosDatos_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(-769, -542, 1920, 1275);
		panelTrabajador.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(editarDialog.class.getResource("/Resources/228367.jpg")));

		// Rellenar campos y mostrar paneles según entrada
		if(t != null){
			nombreTrabajador.setText(t.getNombre());
			apellidosTrabajador.setText(t.getApellidos());
			idTrabajador.setText(t.getId());
			idTrabajador.setEnabled(false);
			numTrabajador.setText(String.valueOf(t.getNumeroTrabajador()));
			comboBoxCargo.setSelectedItem(t.getCargo());
			comboBoxEscolar.setSelectedItem(t.getNivelEscolar());
			salarioTrabajador.setValue(t.getSalario());
		}
		else
			panelTrabajador.setVisible(false);
		if(c instanceof Motherboard){
			panelMotherboard.setVisible(true);
			if(((Motherboard)c).getConexionesDiscos().contains("SATA"))
				chckbxSata.doClick();
			if(((Motherboard)c).getConexionesDiscos().contains("SATA-2"))
				chckbxSata_2.doClick();
			if(((Motherboard)c).getConexionesDiscos().contains("SATA-3"))
				chckbxSata_3.doClick();
			if(((Motherboard)c).getConexionesDiscos().contains("IDE"))
				chckbxIde.doClick();

			modeloMother.setText(((Motherboard)c).getModelo());
			marcaMother.setText(((Motherboard)c).getMarca());
			unitMother.setValue(c.getCantidadDisponible());
			precioMother.setValue(c.getPrecioBase());
			comboBoxSocketMother.setSelectedItem(((Motherboard)c).getTipoConector());
			comboBoxRAMMother.setSelectedItem(((Motherboard)c).getTipoMemoriaRAM());
			labelPrecioMother.setText(String.valueOf(c.calcularPrecio()));
			IDMother.setText(c.getNumeroSerie());
			IDMother.setEnabled(false);



		}
		else if(c instanceof CPU){
			panelCPU.setVisible(true);
			precioCPU.setValue(c.getPrecioBase());
			unitCPU.setValue(c.getCantidadDisponible());
			IDCPU.setText(c.getNumeroSerie());
			IDCPU.setEnabled(false);
			marcaCPU.setText(((CPU)c).getMarca());
			modeloCPU.setText(((CPU)c).getModelo());
			comboBoxSocket.setSelectedItem(((CPU)c).getSocket());
			labelPrecioCPU.setText(String.valueOf(c.calcularPrecio()));
			velocidadCPU.setValue(((CPU)c).getVelocidad());


		}
		else if(c instanceof RAM){
			panelRAM.setVisible(true);
			precioRAM.setValue(c.getPrecioBase());
			unitRAM.setValue(c.getCantidadDisponible());
			memoriaRAM.setValue(((RAM)c).getMemoria());
			IDRAM.setText(c.getNumeroSerie());
			IDRAM.setEnabled(false);
			marcaRAM.setText(((RAM)c).getMarca());
			comboBoxRAM.setSelectedItem(((RAM)c).getTipo());
			labelPrecioRAM.setText(String.valueOf(c.calcularPrecio()));


		}
		else if(c instanceof HDD){
			panelHDD.setVisible(true);	
			precioHDD.setValue(c.getPrecioBase());
			unitsHDD.setValue(c.getCantidadDisponible());
			memoriaHDD.setValue(((HDD)c).getCapacidad());
			IDHDD.setText(c.getNumeroSerie());
			IDHDD.setEnabled(false);
			marcaHDD.setText(((HDD)c).getMarca());
			modeloHDD.setText(((HDD)c).getModelo());
			conexionHDD.setSelectedItem(((HDD)c).getTipoConexion());
			labelPrecioHDD.setText(String.valueOf(c.calcularPrecio()));
		}
		// Boton editar RAM
		JButton button_1 = new JButton("Editar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RAM r = (RAM)c;
				try{
					r.editarRAM((int)unitRAM.getValue(),marcaRAM.getText(),(double)memoriaRAM.getValue(),(String)comboBoxRAM.getSelectedItem(),(double)precioRAM.getValue());
					JOptionPane.showMessageDialog(null,"Se han guardado los cambios","Cambios realizados",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				catch(IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error al editar la RAM",JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		button_1.setBounds(541, 491, 129, 34);
		panelRAM.add(button_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(editarDialog.class.getResource("/Resources/559467.jpg")));
		lblNewLabel_4.setBounds(-904, -118, 1920, 1080);
		panelRAM.add(lblNewLabel_4);
		// Boton de editar CPU
		JButton button_2 = new JButton("Editar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CPU r = (CPU)c;
				try{
					r.editarCPU((int)unitCPU.getValue(),marcaCPU.getText(),modeloCPU.getText(),(String)comboBoxSocket.getSelectedItem(),(double)velocidadCPU.getValue(),(double)precioCPU.getValue());
					JOptionPane.showMessageDialog(null,"Se han guardado los cambios","Cambios realizados",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				catch(IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error al editar la CPU",JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		button_2.setBounds(541, 491, 129, 34);
		panelCPU.add(button_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(editarDialog.class.getResource("/Resources/228546.jpg")));
		lblNewLabel_3.setBounds(-1151, -1006, 2560, 1920);
		panelCPU.add(lblNewLabel_3);

		// editar Motherboard
		JButton button = new JButton("Editar");
		button.addActionListener(new ActionListener() {
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
					Motherboard m = (Motherboard)c;
					try{
						m.editarMotherboard((int)unitMother.getValue(),marcaMother.getText(),modeloMother.getText(),(String)comboBoxSocketMother.getSelectedItem(),(String)comboBoxRAMMother.getSelectedItem() , conexiones,(double) precioMother.getValue());
						JOptionPane.showMessageDialog(null,"Se han guardado los cambios","Cambios realizados",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					catch(IllegalArgumentException e){
						JOptionPane.showMessageDialog(null,e.getMessage(),"Error al editar la Motherboard",JOptionPane.ERROR_MESSAGE);

					}

					dispose();
				} else
					JOptionPane.showMessageDialog(null,"Seleccione al menos una conexión para los discos.","Error",JOptionPane.ERROR_MESSAGE);	
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 23));
		button.setBounds(541, 491, 129, 34);
		panelMotherboard.add(button);

		JLabel lblCambieLosDatos_3 = new JLabel("Cambie los datos de la Motherboard que desee");
		lblCambieLosDatos_3.setForeground(Color.WHITE);
		lblCambieLosDatos_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCambieLosDatos_3.setBounds(86, 13, 500, 40);
		panelMotherboard.add(lblCambieLosDatos_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-104, -49, 2560, 1600);
		panelMotherboard.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(editarDialog.class.getResource("/Resources/228261.jpg")));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(58, -121, 2560, 1600);
		panelMotherboard.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(editarDialog.class.getResource("/Resources/228261.jpg")));





	}
}
