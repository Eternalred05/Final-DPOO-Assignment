package GUI;
import Logic.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import Componentes.JTextFieldLimitado;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class reporteTrabajador extends JDialog {

	private static final long serialVersionUID = 4706864473570201069L;
	private final JPanel contentPanel = new JPanel();
	@SuppressWarnings("rawtypes")
	private DefaultTableModel modelo;
	private JTable tableTrabajador;
	private Tienda tienda;

	public reporteTrabajador(Tienda tiendaPC,MenuTienda parent) {
		super(parent,true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(reporteTrabajador.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		setTitle("Reporte de Trabajadores por Salario,Cargo y escolaridad.");
		setBounds(100, 100, 686, 565);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		tienda = tiendaPC;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 650, 339);
		contentPanel.add(scrollPane);

		tableTrabajador = new JTable();
		tableTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 11));

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

		final JComboBox comboBoxCargo = new JComboBox();
		comboBoxCargo.setModel(new DefaultComboBoxModel(new String[] {"", "Gestor de Venta", "Encargado de inventario", "Asesor de ventas", "Especialista en productos", "Encargado de servicio", "Especialista en software", "Cajero", "Gerente"}));
		comboBoxCargo.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		comboBoxCargo.setBounds(10, 77, 196, 20);
		contentPanel.add(comboBoxCargo);

		final JComboBox comboBoxEscolar = new JComboBox();
		comboBoxEscolar.setModel(new DefaultComboBoxModel(new String[] {"", "Primario", "Secundario", "Preuniversitario", "T\u00E9cnico Medio", "Obrero Calificado", "Universitario", "T\u00E9cnico profesional"}));
		comboBoxEscolar.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		comboBoxEscolar.setBounds(249, 77, 151, 20);
		contentPanel.add(comboBoxEscolar);

		JLabel label = new JLabel("Salario");
		label.setFont(new Font("Sans Serif Collection", Font.PLAIN, 23));
		label.setBounds(455, 32, 105, 34);
		contentPanel.add(label);

		JLabel label_1 = new JLabel("Cargo");
		label_1.setFont(new Font("Sans Serif Collection", Font.PLAIN, 23));
		label_1.setBounds(45, 32, 87, 34);
		contentPanel.add(label_1);

		JLabel label_2 = new JLabel("Nivel \r\nEscolar");
		label_2.setFont(new Font("Sans Serif Collection", Font.PLAIN, 23));
		label_2.setBounds(239, 32, 184, 34);
		contentPanel.add(label_2);

		final JSpinner spinnerSalario = new JSpinner();
		spinnerSalario.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		spinnerSalario.setModel(new SpinnerNumberModel(2000.0, 2000.0, 15000.0, 1.0));
		spinnerSalario.setBounds(455, 78, 87, 20);
		contentPanel.add(spinnerSalario);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cargo;
				String nivel;
				double salario;
				ArrayList<Trabajador> trabajadores;

				cargo = (String)comboBoxCargo.getSelectedItem();
				nivel = (String)comboBoxEscolar.getSelectedItem();
				salario = (double)spinnerSalario.getValue();
				if(!cargo.isEmpty() && !nivel.isEmpty()){
					trabajadores = tienda.trabajadoresPorSalarioCargoEscolaridad(salario, cargo, nivel);
					modelo = (DefaultTableModel)tableTrabajador.getModel();
					modelo.setRowCount(0);
					for(Trabajador t : trabajadores){
						Object trabajador [] = {t.getNumeroTrabajador(),t.getNombre(),t.getApellidos(),cargo,t.getId(),nivel,String.valueOf(t.getSalario())};
						modelo.addRow(trabajador);
					}
					if(trabajadores.size() != 0)
						JOptionPane.showMessageDialog(null,"Filtro Actualizado.", "Filtrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null,"No se encontró ninguna coincidencia.", "Sin coincidencias", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null,"No deje campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);

			}
		});
		btnFiltrar.setFont(new Font("Sans Serif Collection", Font.PLAIN, 21));
		btnFiltrar.setBounds(509, 463, 151, 52);
		contentPanel.add(btnFiltrar);

		JButton button = new JButton("?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Este reporte buscará trabajadores con un cargo y un nivel escolar específico además de también con un salario mayor del que se específique.", "Información del reporte", JOptionPane.INFORMATION_MESSAGE);		
			}
		});
		button.setFont(new Font("Sans Serif Collection", Font.PLAIN, 20));
		button.setBounds(613, 11, 47, 41);
		contentPanel.add(button);
	}
}
