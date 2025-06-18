package GUI;
import Logic.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class reporteComponentes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableComponentes;
	private Tienda tienda;
	@SuppressWarnings("rawtypes")
	private DefaultTableModel modelo;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modeloCbox;

	public reporteComponentes(Tienda tiendaPC, MenuTienda parent) {
		super(parent,true);
		tienda = tiendaPC;
		setIconImage(Toolkit.getDefaultToolkit().getImage(reporteComponentes.class.getResource("/com/sun/java/swing/plaf/windows/icons/ListView.gif")));
		setTitle("Reporte de Componentes por Marca y  Precio");
		setResizable(false);
		setBounds(100, 100, 686, 565);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblMarcasDisponibles = new JLabel("Marcas Disponibles");
		lblMarcasDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMarcasDisponibles.setBounds(30, 11, 240, 34);
		contentPanel.add(lblMarcasDisponibles);

		Object[] marcasO;
		ArrayList<String> marcasA = new ArrayList<>();
		for(Componente c : tienda.getComponentes()){
			if(!marcasA.contains(c.getMarca().toLowerCase()))
				marcasA.add(c.getMarca().toLowerCase());
		}
		marcasO = new Object[marcasA.size()+1];
		marcasO[0]= "";
		for(int i=0;i<marcasA.size();i++)
			marcasO[i+1] = marcasA.get(i).substring(0,1).toUpperCase() + marcasA.get(i).substring(1);

		modeloCbox = new DefaultComboBoxModel(marcasO);
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(20, 46, 221, 27);
		comboBox.setModel(modeloCbox);
		contentPanel.add(comboBox);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPrecio.setBounds(440, 11, 80, 34);
		contentPanel.add(lblPrecio);

		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner.setBounds(432, 49, 87, 20);
		contentPanel.add(spinner);

		JButton button = new JButton("Filtrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String marca;
				double precio;
				ArrayList<Componente> componentes;

				marca = (String)comboBox.getSelectedItem();
				precio = (double)spinner.getValue();
				if(!marca.isEmpty()){
					componentes = tienda.componentesPorMarcaPrecio(marca, precio);
					modelo = (DefaultTableModel)tableComponentes.getModel();
					modelo.setRowCount(0);
					for(Componente c : componentes){
						Object componente [] = {c.getClass().getSimpleName(),marca,c.getNumeroSerie(),String.valueOf(c.calcularPrecio()),String.valueOf(c.getCantidadDisponible())};
						modelo.addRow(componente);
					}
					if(componentes.size() != 0)
						JOptionPane.showMessageDialog(null,"Filtro Actualizado.", "Filtrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null,"No se encontró ninguna coincidencia.", "Sin coincidencias", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null,"No deje campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(556, 480, 114, 45);
		contentPanel.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 660, 389);
		contentPanel.add(scrollPane);

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
		tableComponentes.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(tableComponentes);

		JButton button_1 = new JButton("?");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Este reporte buscará componentes con una marca especifica con un precio menor al especifícado.", "Información del reporte", JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button_1.setBounds(623, 11, 47, 41);
		contentPanel.add(button_1);
	}
}
