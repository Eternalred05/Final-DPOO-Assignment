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

import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;

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
		label.setForeground(Color.BLACK);
		label.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		label.setBounds(139, 346, 105, 34);
		panelTrabajador.add(label);

		JLabel label_1 = new JLabel("Nivel \r\nEscolar");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		label_1.setBounds(137, 304, 151, 34);
		panelTrabajador.add(label_1);

		JLabel label_2 = new JLabel("Cargo");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		label_2.setBounds(139, 259, 87, 34);
		panelTrabajador.add(label_2);

		final JComboBox comboBoxCargo = new JComboBox();
		comboBoxCargo.setModel(new DefaultComboBoxModel(new String[] {"", "Gestor de ventas", "Encargado de inventario", "Asesor de ventas", "Especialista en productos", "Encargado de servicio", "Especialista en software", "Cajero"}));
		comboBoxCargo.setForeground(Color.BLACK);
		comboBoxCargo.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		comboBoxCargo.setBounds(281, 269, 235, 20);
		panelTrabajador.add(comboBoxCargo);

		final JComboBox comboBoxEscolar = new JComboBox();
		comboBoxEscolar.setModel(new DefaultComboBoxModel(new String[] {"", "Primario", "Secundario", "Preuniversitario", "T\u00E9cnico Medio", "Obrero Calificado", "Universitario", "T\u00E9cnico profesional"}));
		comboBoxEscolar.setForeground(Color.BLACK);
		comboBoxEscolar.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		comboBoxEscolar.setBounds(281, 314, 235, 20);
		panelTrabajador.add(comboBoxEscolar);

		JLabel label_3 = new JLabel("Identificador");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		label_3.setBounds(139, 187, 164, 34);
		panelTrabajador.add(label_3);

		JLabel label_4 = new JLabel("Apellidos");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		label_4.setBounds(139, 145, 126, 34);
		panelTrabajador.add(label_4);

		JLabel label_5 = new JLabel("Nombre");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		label_5.setBounds(139, 98, 103, 34);
		panelTrabajador.add(label_5);

		final JTextFieldLimitado nombreTrabajador = new JTextFieldLimitado();
		nombreTrabajador.setLimit(25);
		nombreTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreTrabajador.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		nombreTrabajador.setBounds(281, 107, 235, 20);
		panelTrabajador.add(nombreTrabajador);

		final JTextFieldLimitado apellidosTrabajador = new JTextFieldLimitado();
		apellidosTrabajador.setLimit(25);
		apellidosTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		apellidosTrabajador.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		apellidosTrabajador.setBounds(281, 154, 235, 20);
		panelTrabajador.add(apellidosTrabajador);

		JTextFieldLimitado idTrabajador = new JTextFieldLimitado();
		idTrabajador.setLimit(11);
		idTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		idTrabajador.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		idTrabajador.setBounds(281, 196, 235, 20);
		panelTrabajador.add(idTrabajador);

		JLabel lblNumeroDeTrabajador = new JLabel("Numero de Trabajador");
		lblNumeroDeTrabajador.setForeground(Color.BLACK);
		lblNumeroDeTrabajador.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNumeroDeTrabajador.setBounds(443, 11, 227, 25);
		panelTrabajador.add(lblNumeroDeTrabajador);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.WHITE);
		panel.setBounds(541, 39, 35, 34);
		panelTrabajador.add(panel);

		JLabel numTrabajador = new JLabel("0");
		numTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		numTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		numTrabajador.setBounds(0, 0, 35, 34);
		panel.add(numTrabajador);

		final JSpinner salarioTrabajador = new JSpinner();
		salarioTrabajador.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		salarioTrabajador.setModel(new SpinnerNumberModel(0.0, 0.0, 15000.0, 1.0));
		salarioTrabajador.setBounds(281, 357, 81, 20);
		panelTrabajador.add(salarioTrabajador);

		JPanel panelMotherboard = new JPanel();
		getContentPane().add(panelMotherboard, "name_378927127267400");
		panelMotherboard.setLayout(null);

		JLabel label_6 = new JLabel("Marca");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_6.setBounds(10, 34, 101, 34);
		panelMotherboard.add(label_6);

		JTextFieldLimitado textFieldLimitado = new JTextFieldLimitado();
		textFieldLimitado.setLimit(15);
		textFieldLimitado.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textFieldLimitado.setBounds(259, 38, 114, 27);
		panelMotherboard.add(textFieldLimitado);

		JTextFieldLimitado textFieldLimitado_1 = new JTextFieldLimitado();
		textFieldLimitado_1.setLimit(10);
		textFieldLimitado_1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado_1.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textFieldLimitado_1.setBounds(259, 78, 114, 27);
		panelMotherboard.add(textFieldLimitado_1);

		JLabel label_7 = new JLabel("Modelo");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_7.setBounds(10, 74, 81, 34);
		panelMotherboard.add(label_7);

		JLabel label_8 = new JLabel("Tipo de Socket");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_8.setBounds(10, 113, 129, 34);
		panelMotherboard.add(label_8);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial Black", Font.PLAIN, 17));
		comboBox.setBounds(259, 117, 114, 27);
		panelMotherboard.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial Black", Font.PLAIN, 17));
		comboBox_1.setBounds(259, 153, 114, 27);
		panelMotherboard.add(comboBox_1);

		JLabel label_9 = new JLabel("Tipos de RAMS soportadas");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_9.setBounds(10, 149, 242, 34);
		panelMotherboard.add(label_9);

		JLabel label_10 = new JLabel("N\u00FAmero de Serie");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_10.setBounds(10, 189, 162, 34);
		panelMotherboard.add(label_10);

		JTextFieldLimitado textFieldLimitado_2 = new JTextFieldLimitado();
		textFieldLimitado_2.setLimit(10);
		textFieldLimitado_2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado_2.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textFieldLimitado_2.setBounds(259, 193, 114, 27);
		panelMotherboard.add(textFieldLimitado_2);

		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinner.setBounds(259, 227, 114, 27);
		panelMotherboard.add(spinner);

		JLabel label_11 = new JLabel("Precio base");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_11.setBounds(10, 227, 114, 27);
		panelMotherboard.add(label_11);

		JLabel label_12 = new JLabel("Cantidad de unidades");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_12.setBounds(10, 253, 196, 49);
		panelMotherboard.add(label_12);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinner_1.setBounds(259, 264, 116, 27);
		panelMotherboard.add(spinner_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(56, 307, 293, 192);
		panelMotherboard.add(panel_1);

		JLabel label_13 = new JLabel("Conexiones de los discos duros");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_13.setBounds(12, 13, 257, 34);
		panel_1.add(label_13);

		JCheckBox checkBox = new JCheckBox("SATA");
		checkBox.setFont(new Font("Arial Black", Font.PLAIN, 20));
		checkBox.setBounds(12, 76, 114, 23);
		panel_1.add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("SATA-2");
		checkBox_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		checkBox_1.setBounds(12, 109, 114, 23);
		panel_1.add(checkBox_1);

		JCheckBox checkBox_2 = new JCheckBox("SATA-3");
		checkBox_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		checkBox_2.setBounds(171, 76, 114, 23);
		panel_1.add(checkBox_2);

		JCheckBox checkBox_3 = new JCheckBox("IDE");
		checkBox_3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		checkBox_3.setBounds(171, 109, 87, 23);
		panel_1.add(checkBox_3);

		JLabel label_14 = new JLabel("Precio del Motherboard");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_14.setBounds(452, 34, 184, 34);
		panelMotherboard.add(label_14);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(452, 81, 173, 49);
		panelMotherboard.add(panel_2);

		JLabel label_15 = new JLabel("0.0000$");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_15.setBounds(10, 11, 153, 27);
		panel_2.add(label_15);

		JButton button = new JButton("Editar");
		button.setFont(new Font("Sans Serif Collection", Font.PLAIN, 21));
		button.setBounds(541, 491, 129, 34);
		panelMotherboard.add(button);

		JPanel panelCPU = new JPanel();
		getContentPane().add(panelCPU, "name_378939534683800");
		panelCPU.setLayout(null);

		JLabel label_23 = new JLabel("Marca");
		label_23.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_23.setBounds(10, 56, 61, 34);
		panelCPU.add(label_23);

		JTextFieldLimitado textFieldLimitado_5 = new JTextFieldLimitado();
		textFieldLimitado_5.setLimit(15);
		textFieldLimitado_5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado_5.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textFieldLimitado_5.setBounds(246, 60, 148, 27);
		panelCPU.add(textFieldLimitado_5);

		JTextFieldLimitado textFieldLimitado_6 = new JTextFieldLimitado();
		textFieldLimitado_6.setLimit(20);
		textFieldLimitado_6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado_6.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textFieldLimitado_6.setBounds(244, 106, 150, 27);
		panelCPU.add(textFieldLimitado_6);

		JLabel label_24 = new JLabel("Modelo");
		label_24.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_24.setBounds(10, 103, 81, 32);
		panelCPU.add(label_24);

		JLabel label_25 = new JLabel("Tipo de Socket");
		label_25.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_25.setBounds(10, 148, 140, 34);
		panelCPU.add(label_25);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Arial Black", Font.PLAIN, 17));
		comboBox_3.setBounds(247, 152, 148, 27);
		panelCPU.add(comboBox_3);

		JTextFieldLimitado textFieldLimitado_7 = new JTextFieldLimitado();
		textFieldLimitado_7.setLimit(15);
		textFieldLimitado_7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado_7.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textFieldLimitado_7.setBounds(246, 205, 148, 27);
		panelCPU.add(textFieldLimitado_7);

		JLabel label_26 = new JLabel("N\u00FAmero de Serie");
		label_26.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_26.setBounds(10, 201, 148, 34);
		panelCPU.add(label_26);

		JLabel label_27 = new JLabel("Velocidad(Ghz)");
		label_27.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_27.setBounds(10, 246, 148, 34);
		panelCPU.add(label_27);

		JSpinner spinner_5 = new JSpinner();
		spinner_5.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinner_5.setBounds(247, 249, 81, 27);
		panelCPU.add(spinner_5);

		JSpinner spinner_6 = new JSpinner();
		spinner_6.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinner_6.setBounds(247, 294, 81, 27);
		panelCPU.add(spinner_6);

		JLabel label_28 = new JLabel("Precio base");
		label_28.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_28.setBounds(10, 290, 120, 34);
		panelCPU.add(label_28);

		JLabel label_29 = new JLabel("Cantidad de unidades");
		label_29.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_29.setBounds(10, 324, 196, 47);
		panelCPU.add(label_29);

		JSpinner spinner_7 = new JSpinner();
		spinner_7.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinner_7.setBounds(247, 334, 81, 27);
		panelCPU.add(spinner_7);

		JLabel label_30 = new JLabel("Precio de la CPU");
		label_30.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_30.setBounds(502, 138, 140, 34);
		panelCPU.add(label_30);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(480, 183, 173, 49);
		panelCPU.add(panel_3);

		JLabel label_31 = new JLabel("0.0000$");
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_31.setBounds(12, 13, 153, 27);
		panel_3.add(label_31);

		JButton button_2 = new JButton("Editar");
		button_2.setFont(new Font("Sans Serif Collection", Font.PLAIN, 21));
		button_2.setBounds(541, 491, 129, 34);
		panelCPU.add(button_2);

		JPanel panelRAM = new JPanel();
		getContentPane().add(panelRAM, "name_378954342278800");
		panelRAM.setLayout(null);

		JTextFieldLimitado textFieldLimitado_3 = new JTextFieldLimitado();
		textFieldLimitado_3.setLimit(15);
		textFieldLimitado_3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado_3.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textFieldLimitado_3.setBounds(378, 111, 162, 27);
		panelRAM.add(textFieldLimitado_3);

		JLabel label_16 = new JLabel("Marca");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_16.setBounds(160, 107, 81, 34);
		panelRAM.add(label_16);

		JLabel label_17 = new JLabel("Cantidad de Memoria");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_17.setBounds(160, 154, 205, 27);
		panelRAM.add(label_17);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinner_2.setBounds(377, 154, 81, 27);
		panelRAM.add(spinner_2);

		JLabel label_18 = new JLabel("GB");
		label_18.setFont(new Font("Arial Black", Font.BOLD, 23));
		label_18.setBounds(489, 148, 51, 34);
		panelRAM.add(label_18);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Arial Black", Font.PLAIN, 17));
		comboBox_2.setBounds(377, 204, 163, 27);
		panelRAM.add(comboBox_2);

		JLabel label_19 = new JLabel("Tipo de memoria");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_19.setBounds(160, 200, 153, 34);
		panelRAM.add(label_19);

		JLabel label_20 = new JLabel("N\u00FAmero de Serie");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_20.setBounds(160, 245, 162, 34);
		panelRAM.add(label_20);

		JLabel label_21 = new JLabel("Precio base");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_21.setBounds(160, 281, 129, 34);
		panelRAM.add(label_21);

		JLabel label_22 = new JLabel("Cantidad de unidades");
		label_22.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_22.setBounds(160, 313, 205, 49);
		panelRAM.add(label_22);

		JSpinner spinner_3 = new JSpinner();
		spinner_3.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinner_3.setBounds(377, 324, 81, 27);
		panelRAM.add(spinner_3);

		JSpinner spinner_4 = new JSpinner();
		spinner_4.setFont(new Font("Arial Black", Font.PLAIN, 17));
		spinner_4.setBounds(377, 285, 81, 27);
		panelRAM.add(spinner_4);

		JTextFieldLimitado textFieldLimitado_4 = new JTextFieldLimitado();
		textFieldLimitado_4.setLimit(10);
		textFieldLimitado_4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado_4.setFont(new Font("Arial Black", Font.PLAIN, 17));
		textFieldLimitado_4.setBounds(377, 247, 162, 27);
		panelRAM.add(textFieldLimitado_4);

		JButton button_1 = new JButton("Editar");
		button_1.setFont(new Font("Sans Serif Collection", Font.PLAIN, 21));
		button_1.setBounds(541, 491, 129, 34);
		panelRAM.add(button_1);

		JPanel panelHDD = new JPanel();
		getContentPane().add(panelHDD, "name_378979497942400");
		panelHDD.setLayout(null);

		JLabel label_32 = new JLabel("Marca");
		label_32.setBounds(10, 82, 70, 34);
		label_32.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_32);

		JTextFieldLimitado textFieldLimitado_8 = new JTextFieldLimitado();
		textFieldLimitado_8.setBounds(227, 86, 154, 27);
		textFieldLimitado_8.setLimit(15);
		textFieldLimitado_8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado_8.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panelHDD.add(textFieldLimitado_8);

		JTextFieldLimitado textFieldLimitado_9 = new JTextFieldLimitado();
		textFieldLimitado_9.setBounds(227, 133, 154, 27);
		textFieldLimitado_9.setLimit(10);
		textFieldLimitado_9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado_9.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panelHDD.add(textFieldLimitado_9);

		JLabel label_33 = new JLabel("Modelo");
		label_33.setBounds(10, 129, 81, 34);
		label_33.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_33);

		JLabel label_34 = new JLabel("Tipo de conexi\u00F3n");
		label_34.setBounds(10, 176, 173, 34);
		label_34.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_34);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(227, 180, 154, 27);
		comboBox_4.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panelHDD.add(comboBox_4);

		JLabel label_35 = new JLabel("GB");
		label_35.setBounds(344, 220, 51, 34);
		label_35.setFont(new Font("Arial Black", Font.BOLD, 23));
		panelHDD.add(label_35);

		JSpinner spinner_8 = new JSpinner();
		spinner_8.setBounds(233, 223, 81, 27);
		spinner_8.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panelHDD.add(spinner_8);

		JLabel label_36 = new JLabel("Cantidad de Memoria");
		label_36.setBounds(10, 223, 192, 27);
		label_36.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_36);

		JLabel label_37 = new JLabel("N\u00FAmero de Serie");
		label_37.setBounds(10, 276, 162, 34);
		label_37.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_37);

		JTextFieldLimitado textFieldLimitado_10 = new JTextFieldLimitado();
		textFieldLimitado_10.setBounds(233, 280, 148, 27);
		textFieldLimitado_10.setLimit(10);
		textFieldLimitado_10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLimitado_10.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panelHDD.add(textFieldLimitado_10);

		JSpinner spinner_9 = new JSpinner();
		spinner_9.setBounds(233, 320, 81, 27);
		spinner_9.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panelHDD.add(spinner_9);

		JLabel label_38 = new JLabel("Precio base");
		label_38.setBounds(10, 323, 129, 27);
		label_38.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_38);

		JLabel label_39 = new JLabel("Cantidad de unidades");
		label_39.setBounds(10, 363, 192, 37);
		label_39.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelHDD.add(label_39);

		JSpinner spinner_10 = new JSpinner();
		spinner_10.setBounds(233, 363, 81, 27);
		spinner_10.setFont(new Font("Arial Black", Font.PLAIN, 17));
		panelHDD.add(spinner_10);

		JLabel label_40 = new JLabel("Precio del disco duro");
		label_40.setBounds(478, 129, 185, 34);
		label_40.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelHDD.add(label_40);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(467, 160, 173, 49);
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelHDD.add(panel_4);

		JLabel label_41 = new JLabel("0.0000$");
		label_41.setHorizontalAlignment(SwingConstants.CENTER);
		label_41.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_41.setBounds(10, 11, 153, 27);
		panel_4.add(label_41);

		JButton button_3 = new JButton("Editar");
		button_3.setFont(new Font("Sans Serif Collection", Font.PLAIN, 21));
		button_3.setBounds(534, 491, 129, 34);
		panelHDD.add(button_3);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					tienda.editarTrabajador(t, nombreTrabajador.getText(),apellidosTrabajador.getText(),(double)salarioTrabajador.getValue(),(String)comboBoxCargo.getSelectedItem(),(String)comboBoxEscolar.getSelectedItem());
					JOptionPane.showMessageDialog(null,"Se han guaradado los cambios","Cambios realizados",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				catch(IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error al editar al trabajador",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEditar.setFont(new Font("Sans Serif Collection", Font.PLAIN, 21));
		btnEditar.setBounds(541, 491, 129, 34);
		panelTrabajador.add(btnEditar);

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
		}
		else if(c instanceof CPU){
			panelCPU.setVisible(true);

		}
		else if(c instanceof RAM){
			panelRAM.setVisible(true);
		}
		else if(c instanceof HDD){
			panelHDD.setVisible(true);	
		}




	}
}
