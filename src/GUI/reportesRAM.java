package GUI;
import Logic.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logic.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Color;

public class reportesRAM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Tienda tienda;
	private JTable table;
	@SuppressWarnings("rawtypes")
	private DefaultTableModel modelo;

	public reportesRAM(Tienda tiendaPC, MenuTienda parent) {
		super(parent,true);
		setTitle("Reportes de RAM por su Velocidad y tipo de Memoria");
		setIconImage(Toolkit.getDefaultToolkit().getImage(reporteComponentes.class.getResource("/com/sun/java/swing/plaf/windows/icons/ListView.gif")));
		tienda = tiendaPC;
		setResizable(false);
		setBounds(100, 100, 686, 565);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 658, 373);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Cantidad", "Numero de Serie", "Marca", "Memoria(GB)", "Tipo", "Precio"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(72);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(57);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "DDR", "DDR2", "DDR3", "DDR4", "DDR5"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(66, 46, 108, 22);
		contentPanel.add(comboBox);

		JLabel lblTipoDeMemoria = new JLabel("Tipo de Memoria");
		lblTipoDeMemoria.setForeground(Color.WHITE);
		lblTipoDeMemoria.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTipoDeMemoria.setBounds(37, 11, 200, 34);
		contentPanel.add(lblTipoDeMemoria);

		JLabel lblCantidadDeMemoria = new JLabel("Cantidad de memoria");
		lblCantidadDeMemoria.setForeground(Color.WHITE);
		lblCantidadDeMemoria.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCantidadDeMemoria.setBounds(367, 11, 246, 34);
		contentPanel.add(lblCantidadDeMemoria);

		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1.0, 1.0, 128.0, 1.0));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinner.setBounds(440, 47, 87, 21);
		contentPanel.add(spinner);

		JLabel lblGb = new JLabel("GB");
		lblGb.setForeground(Color.WHITE);
		lblGb.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGb.setBounds(537, 37, 34, 34);
		contentPanel.add(lblGb);

		JButton button = new JButton("Filtrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ArrayList<Componente> rams;
				String tipo = (String)comboBox.getSelectedItem();
				double memoria = (double)spinner.getValue();
				if(!tipo.isEmpty()){
					rams = tienda.ramsPorTipoyMemoria(tipo, memoria);
					modelo = (DefaultTableModel)table.getModel();
					modelo.setRowCount(0);
					for(Componente c : rams){
						Object ramsO [] = {c.getCantidadDisponible(),c.getNumeroSerie(),c.getMarca(),((RAM)c).getMemoria(),((RAM)c).getTipo(),c.calcularPrecio()};
						modelo.addRow(ramsO);
					}
					if(rams.size()!=0)
						JOptionPane.showMessageDialog(null,"Filtro Actualizado.", "Filtrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null,"No se encontró ninguna coincidencia.", "Sin coincidencias", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null,"No deje campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);

			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button.setBounds(560, 464, 108, 41);
		contentPanel.add(button);

		JButton button_1 = new JButton("?");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Este reporte buscará memorias ram con un tipo de memoria específico y una cantidad de memoria en gigabytes mayor o igual a la que se especifica.", "Información del reporte", JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		button_1.setBounds(625, 27, 47, 41);
		contentPanel.add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(reportesRAM.class.getResource("/Resources/228516.jpg")));
		lblNewLabel.setBounds(0, 0, 680, 523);
		contentPanel.add(lblNewLabel);
	}
}
