package GUI;

import Logic.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;

public class reportesPC extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablePC;
	private DefaultTableModel modelo;
	private Tienda tienda;

	public reportesPC(MenuTienda parent, Tienda tiendaPC ) {
		super(parent,true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(reportesPC.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		setTitle("Reporte de Computadoras seg\u00FAn el precio.");
		setResizable(false);
		setBounds(100, 100, 686, 565);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		tienda = tiendaPC;
		JLabel label = new JLabel("Precio");
		label.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label.setBounds(283, 14, 89, 34);
		contentPanel.add(label);

		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Double(500), new Double(500), null, new Double(1)));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner.setBounds(271, 44, 89, 25);
		contentPanel.add(spinner);

		JButton button = new JButton("?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Este reporte buscará computadoras con un precio menor a uno especificado.", "Información del reporte", JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button.setBounds(623, 11, 47, 41);
		contentPanel.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 660, 389);
		contentPanel.add(scrollPane);

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
		scrollPane.setViewportView(tablePC);

		JButton button_1 = new JButton("Filtrar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<PC> pcs = new ArrayList<>();
				double precio = (double)spinner.getValue();
				pcs = tienda.pcPorPrecio(precio); 
				modelo = (DefaultTableModel)tablePC.getModel();
				modelo.setRowCount(0);
				for(PC p : pcs){	
					Object [] info = {p.getId(), p.getMotherboardPC().getModelo(), p.getCpuPC().getModelo(), p.memoriaTotal(), p.almacenamientoTotal(), p.calcularPrecioTotal()};
					modelo.addRow(info);
				}
				if(pcs.size()!=0)
					JOptionPane.showMessageDialog(null,"Filtro Actualizado.", "Filtrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null,"No se encontró ninguna coincidencia.", "Sin coincidencias", JOptionPane.INFORMATION_MESSAGE);

			}
			//	}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button_1.setBounds(557, 491, 113, 34);
		contentPanel.add(button_1);
	}
}
