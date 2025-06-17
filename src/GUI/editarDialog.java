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
		comboBoxCargo.setModel(new DefaultComboBoxModel(new String[] {"", "Gestor de ventas", "Encargado de inventario", "Asesor de ventas", "Especialista en roductos", "Encargado de servicio", "Especialista en software", "Cajero"}));
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

		JPanel panelCPU = new JPanel();
		getContentPane().add(panelCPU, "name_378939534683800");

		JPanel panelRAM = new JPanel();
		getContentPane().add(panelRAM, "name_378954342278800");

		JPanel panelHDD = new JPanel();
		getContentPane().add(panelHDD, "name_378979497942400");

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
