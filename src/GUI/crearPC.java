package GUI;
import Logic.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import Componentes.JTextFieldLimitado;
import javax.swing.DropMode;

public class crearPC extends JDialog {

	private final JPanel contentPanel = new JPanel();
	@SuppressWarnings("rawtypes")
	private JTable tableMotherBoard;
	private DefaultTableModel modeloMother;
	private DefaultTableModel modeloCPU;
	private DefaultTableModel modeloRAM;
	private DefaultTableModel modeloHDD;
	private DefaultTableModel modelo;

	Tienda tienda;
	private ArrayList<Componente> motherboards;
	private ArrayList<Componente> rams;
	private ArrayList<Componente> cpus;
	private ArrayList<Componente> hdds;
	private Motherboard m;
	private CPU c;
	private ArrayList<RAM> r;
	private ArrayList<HDD> h;
	private JTable tableCPU;
	private JTable tableRAM;
	private JTable tableHDD;
	// Panel Crear PC
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	public crearPC(Tienda tiendaPC, MenuTienda parent) {
		super(parent,true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(crearPC.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		setResizable(false);

		this.tienda = tiendaPC;
		r = new ArrayList<>();
		h = new ArrayList<>();

		setTitle("Crear una PC");
		setBounds(100, 100, 686, 565);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));

		final JPanel panelMother = new JPanel();
		contentPanel.add(panelMother, "name_66277189830500");
		panelMother.setLayout(null);

		final JPanel panelRAM = new JPanel();
		contentPanel.add(panelRAM, "name_12262434440000");
		panelRAM.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 81, 650, 358);
		panelRAM.add(scrollPane_2);

		tableRAM = new JTable();
		tableRAM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableRAM.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "Marca", "Memoria(GB)", "Tipo de memoria", "Precio", "Cantidad"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableRAM.getColumnModel().getColumn(0).setResizable(false);
		tableRAM.getColumnModel().getColumn(1).setResizable(false);
		tableRAM.getColumnModel().getColumn(2).setResizable(false);
		tableRAM.getColumnModel().getColumn(3).setResizable(false);
		tableRAM.getColumnModel().getColumn(3).setPreferredWidth(97);
		tableRAM.getColumnModel().getColumn(4).setResizable(false);
		tableRAM.getColumnModel().getColumn(5).setResizable(false);
		tableRAM.getColumnModel().getColumn(5).setPreferredWidth(84);
		tableRAM.getTableHeader().setReorderingAllowed(false);
		scrollPane_2.setViewportView(tableRAM);

		JLabel lblEscojaHasta = new JLabel("Escoja Hasta 4 RAMS compatibles con la motherboard escogida de la lista:");
		lblEscojaHasta.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		lblEscojaHasta.setBounds(105, 45, 449, 23);
		panelRAM.add(lblEscojaHasta);

		final JPanel panelHDD = new JPanel();
		contentPanel.add(panelHDD, "name_12275574227700");
		panelHDD.setLayout(null);

		JLabel lblEscojaHasta_1 = new JLabel("Escoja hasta 4 Discos Duros  compatible con la motherboard escogida de la lista");
		lblEscojaHasta_1.setFont(new Font("Sans Serif Collection", Font.PLAIN, 11));
		lblEscojaHasta_1.setBounds(124, 47, 434, 23);
		panelHDD.add(lblEscojaHasta_1);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 81, 650, 338);
		panelHDD.add(scrollPane_3);

		tableHDD = new JTable();
		tableHDD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableHDD.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "Marca", "Modelo", "Capacidad(GB)", "Tipo de Conexi\u00F3n", "Precio", "Disponibles"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableHDD.getColumnModel().getColumn(0).setResizable(false);
		tableHDD.getColumnModel().getColumn(1).setResizable(false);
		tableHDD.getColumnModel().getColumn(2).setResizable(false);
		tableHDD.getColumnModel().getColumn(2).setPreferredWidth(135);
		tableHDD.getColumnModel().getColumn(3).setResizable(false);
		tableHDD.getColumnModel().getColumn(3).setPreferredWidth(82);
		tableHDD.getColumnModel().getColumn(4).setResizable(false);
		tableHDD.getColumnModel().getColumn(4).setPreferredWidth(105);
		tableHDD.getColumnModel().getColumn(5).setResizable(false);
		tableHDD.getColumnModel().getColumn(6).setResizable(false);
		tableHDD.getTableHeader().setReorderingAllowed(false);
		scrollPane_3.setViewportView(tableHDD);


		final JPanel panelCrearPC = new JPanel();
		contentPanel.add(panelCrearPC, "name_12290977546500");
		panelCrearPC.setLayout(null);

		JLabel lblLosComponentesDe = new JLabel("Los componentes de su pc ser\u00EDan los siguientes");
		lblLosComponentesDe.setFont(new Font("Sans Serif Collection", Font.PLAIN, 14));
		lblLosComponentesDe.setBounds(169, 2, 339, 20);
		panelCrearPC.add(lblLosComponentesDe);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(64, 33, 563, 99);
		panelCrearPC.add(scrollPane_4);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Motherboard", "CPU"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane_4.setViewportView(table);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(64, 148, 563, 137);
		panelCrearPC.add(scrollPane_5);

		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Numero de Serie", "Tipo de Memoria", "Memoria(GB)"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(92);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(91);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getTableHeader().setReorderingAllowed(false);
		scrollPane_5.setViewportView(table_1);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(64, 315, 563, 137);
		panelCrearPC.add(scrollPane_6);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Marca", "Modelo", "Capacidad(GB)"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		table_2.getTableHeader().setReorderingAllowed(false);
		scrollPane_6.setViewportView(table_2);



		JLabel lblRams = new JLabel("RAMS");
		lblRams.setFont(new Font("Sans Serif Collection", Font.PLAIN, 14));
		lblRams.setBounds(301, 130, 58, 20);
		panelCrearPC.add(lblRams);

		JLabel lblDiscosDuros = new JLabel("Discos Duros");
		lblDiscosDuros.setFont(new Font("Sans Serif Collection", Font.PLAIN, 14));
		lblDiscosDuros.setBounds(283, 296, 109, 20);
		panelCrearPC.add(lblDiscosDuros);

		final JTextFieldLimitado idPC = new JTextFieldLimitado();
		idPC.setFont(new Font("Sans Serif Collection", Font.PLAIN, 13));
		idPC.setLimit(10);
		idPC.setBounds(98, 481, 88, 20);
		panelCrearPC.add(idPC);

		JLabel lblIdentificadorDeLa = new JLabel("Identificador de la PC");
		lblIdentificadorDeLa.setFont(new Font("Sans Serif Collection", Font.PLAIN, 13));
		lblIdentificadorDeLa.setBounds(88, 463, 160, 14);
		panelCrearPC.add(lblIdentificadorDeLa);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 650, 357);
		panelMother.add(scrollPane);

		tableMotherBoard = new JTable();
		tableMotherBoard.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableMotherBoard.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "Marca", "Modelo", "Socket", "Tipo de RAM", "Conexiones para discos", "Precio", "Disponibles"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableMotherBoard.getColumnModel().getColumn(0).setResizable(false);
		tableMotherBoard.getColumnModel().getColumn(1).setResizable(false);
		tableMotherBoard.getColumnModel().getColumn(2).setResizable(false);
		tableMotherBoard.getColumnModel().getColumn(2).setPreferredWidth(140);
		tableMotherBoard.getColumnModel().getColumn(3).setResizable(false);
		tableMotherBoard.getColumnModel().getColumn(3).setPreferredWidth(55);
		tableMotherBoard.getColumnModel().getColumn(4).setResizable(false);
		tableMotherBoard.getColumnModel().getColumn(4).setPreferredWidth(86);
		tableMotherBoard.getColumnModel().getColumn(5).setResizable(false);
		tableMotherBoard.getColumnModel().getColumn(5).setPreferredWidth(162);
		tableMotherBoard.getColumnModel().getColumn(6).setResizable(false);
		tableMotherBoard.getColumnModel().getColumn(7).setResizable(false);
		tableMotherBoard.getColumnModel().getColumn(7).setPreferredWidth(80);
		tableMotherBoard.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 81, 650, 367);


		tableCPU = new JTable();
		tableCPU.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCPU.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "Marca", "Modelo", "Socket", "Velocidad", "Precio", "Disponibles"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableCPU.getColumnModel().getColumn(0).setResizable(false);
		tableCPU.getColumnModel().getColumn(0).setPreferredWidth(90);
		tableCPU.getColumnModel().getColumn(1).setResizable(false);
		tableCPU.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableCPU.getColumnModel().getColumn(2).setResizable(false);
		tableCPU.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableCPU.getColumnModel().getColumn(3).setResizable(false);
		tableCPU.getColumnModel().getColumn(4).setResizable(false);
		tableCPU.getColumnModel().getColumn(5).setResizable(false);
		tableCPU.getColumnModel().getColumn(6).setResizable(false);
		tableCPU.getTableHeader().setReorderingAllowed(false);
		scrollPane_1.setViewportView(tableCPU);


		motherboards = tienda.listaMotherBoards();

		for(Componente c : motherboards){
			Object info [] = {c.getNumeroSerie(),c.getMarca(),((Motherboard)c).getModelo(),((Motherboard)c).getTipoConector(),((Motherboard)c).getTipoMemoriaRAM(),((Motherboard)c).getConexionesDiscos(),c.calcularPrecio(),c.getCantidadDisponible()};
			modeloMother = (DefaultTableModel)tableMotherBoard.getModel();
			modeloMother.addRow(info);
		}

		scrollPane.setViewportView(tableMotherBoard);

		JLabel lblEscojaUnaMotherboard = new JLabel("Escoja una Motherboard de la lista");
		lblEscojaUnaMotherboard.setFont(new Font("Sans Serif Collection", Font.PLAIN, 11));
		lblEscojaUnaMotherboard.setBounds(239, 42, 195, 23);
		panelMother.add(lblEscojaUnaMotherboard);

		final JPanel panelCPU = new JPanel();
		contentPanel.add(panelCPU, "name_91674696149300");
		panelCPU.setLayout(null);

		JLabel lblEscojaUnaCpu = new JLabel("Escoja una CPU compatible con la motherboard escogida de la lista");
		lblEscojaUnaCpu.setBounds(157, 47, 401, 23);
		panelCPU.add(lblEscojaUnaCpu);
		panelCPU.add(scrollPane_1);

		JButton btnEscoger = new JButton("Escoger");
		btnEscoger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableMotherBoard.getSelectedRows().length == 1){
					int fila = tableMotherBoard.getSelectedRow();
					String id = (String)tableMotherBoard.getValueAt(fila , 0);
					m = tienda.encontrarMotherBoardPorID(id);
					JOptionPane.showMessageDialog(null,"Se ha escogido el Modelo de Motherboard "+ m.getModelo(),"Motherboard seleccionado",JOptionPane.INFORMATION_MESSAGE);
					String socket = m.getTipoConector();
					cpus = tienda.listaCPUcompatMotherboard(socket);
					modeloCPU = (DefaultTableModel)tableCPU.getModel();
					for (Componente c : cpus){
						Object info [] = {c.getNumeroSerie(),c.getMarca(),((CPU)c).getModelo(),((CPU)c).getSocket(),((CPU)c).getVelocidad(),c.calcularPrecio(),c.getCantidadDisponible()};
						modeloCPU.addRow(info);
					}
					if(tableCPU.getRowCount() != 0){
						panelMother.setVisible(false);
						panelCPU.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"No hay stock de procesadores compatibles con su Motherboard","Sin disponibilidad",JOptionPane.ERROR_MESSAGE);	
				}
				else
					JOptionPane.showMessageDialog(null,"Seleccione solo una Motherboard","Selección incorrecta",JOptionPane.ERROR_MESSAGE);	
			}
		});
		btnEscoger.setBounds(557, 483, 103, 32);
		panelMother.add(btnEscoger);


		JButton button = new JButton("Escoger");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableCPU.getSelectedRows().length == 1){
					int fila = tableCPU.getSelectedRow();
					String id = (String)tableCPU.getValueAt(fila , 0);
					c = tienda.CPUPorID(id);
					JOptionPane.showMessageDialog(null,"Se ha escogido el Procesador de marca "+ c.getMarca() + " con modelo " + c.getModelo(),"Procesador seleccionado",JOptionPane.INFORMATION_MESSAGE);
					rams = tienda.listaRAMcompatMotherboard(m.getTipoMemoriaRAM());
					modeloRAM = (DefaultTableModel)tableRAM.getModel();
					for(Componente c : rams){
						Object info [] = {c.getNumeroSerie(),c.getMarca(),((RAM)c).getMemoria(),((RAM)c).getTipo(), c.calcularPrecio(),c.getCantidadDisponible()};
						modeloRAM.addRow(info);
					}
					if(tableRAM.getRowCount()!=0){
						panelRAM.setVisible(true);
						panelCPU.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null,"No hay stock de memorias ram compatibles con su Motherboard","Sin disponibilidad",JOptionPane.ERROR_MESSAGE);	
				}
				else
					JOptionPane.showMessageDialog(null,"Seleccione solo una CPU","Selección incorrecta",JOptionPane.ERROR_MESSAGE);	
			}	
		});
		button.setBounds(557, 483, 103, 32);
		panelCPU.add(button);

		JButton button_7 = new JButton("Regresar");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloCPU.setRowCount(0);
				panelCPU.setVisible(false);			
				panelMother.setVisible(true);
			}
		});
		button_7.setFont(new Font("Sans Serif Collection", Font.PLAIN, 11));
		button_7.setBounds(10, 11, 89, 23);
		panelCPU.add(button_7);

		JButton button_1 = new JButton("Escoger");
		button_1.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableRAM.getSelectedRows().length == 1 ){
					if(r.size()<4){
						int fila = tableRAM.getSelectedRow();
						String id = (String)tableRAM.getValueAt(fila , 0);
						RAM ram = tienda.RAMPorID(id);
						if((int)tableRAM.getValueAt(fila, 5)!= 0){
							JOptionPane.showMessageDialog(null,"Se ha escogido la RAM de marca "+ ram.getMarca() + " con " + ram.getMemoria()+" GB de Memoria.","RAM seleccionada",JOptionPane.INFORMATION_MESSAGE);
							r.add(ram);
							modeloRAM.setValueAt((int)tableRAM.getValueAt(fila, 5)-1, fila, 5);

						}
						else
							JOptionPane.showMessageDialog(null, "No hay stock disponible para escoger esa ram","Error", JOptionPane.ERROR_MESSAGE);

					}else
						JOptionPane.showMessageDialog(null,"La pc solo puede tener 4 RAMS","Selección incorrecta",JOptionPane.ERROR_MESSAGE);
				}

				else
					JOptionPane.showMessageDialog(null,"Seleccione solo una RAM a la vez","Selección incorrecta",JOptionPane.ERROR_MESSAGE);	
			}
		});
		button_1.setBounds(10, 483, 103, 32);
		panelRAM.add(button_1);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(r.size()!=0){
					hdds = tienda.listaHDDcompatMotherboard(m.getConexionesDiscos());
					modeloHDD = (DefaultTableModel)tableHDD.getModel();
					for(Componente c : hdds){
						Object info [] = {c.getNumeroSerie(),c.getMarca(),((HDD)c).getModelo(),((HDD)c).getCapacidad(),((HDD)c).getTipoConexion(), c.calcularPrecio(),c.getCantidadDisponible()};
						modeloHDD.addRow(info);
					}
					if(tableHDD.getRowCount()!=0){
						panelRAM.setVisible(false);			
						panelHDD.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"No hay stock de discos duros compatibles con su Motherboard","Sin disponibilidad",JOptionPane.ERROR_MESSAGE);	
				}
				else
					JOptionPane.showMessageDialog(null,"Seleccione al menos una RAM de la lista","Selección incorrecta",JOptionPane.ERROR_MESSAGE);	
			}
		});
		btnContinuar.setBounds(557, 483, 103, 32);
		panelRAM.add(btnContinuar);

		JButton button_4 = new JButton("Regresar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloRAM.setRowCount(0);
				r.clear();
				panelRAM.setVisible(false);			
				panelCPU.setVisible(true);
			}
		});
		button_4.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		button_4.setBounds(10, 11, 89, 23);
		panelRAM.add(button_4);

		JButton btnDeshacerUltimaEleccion = new JButton("Deshacer \u00FAltima elecci\u00F3n");
		btnDeshacerUltimaEleccion.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		btnDeshacerUltimaEleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(r.size()>0){
					RAM anterior = r.get(r.size()-1);
					String id = anterior.getNumeroSerie();
					int fila = -1;
					for(int i=0;i<tableRAM.getRowCount() && fila == -1;i++)
						if(tableRAM.getValueAt(i,0).equals(id)){
							fila = i;
						}
					modeloRAM.setValueAt((int)tableRAM.getValueAt(fila, 5)+1, fila, 5);
					JOptionPane.showMessageDialog(null,"Se deshizo su última memoria ram escogida de sus selecciones la ram tiene id: "+anterior.getNumeroSerie(),"Elección removida",JOptionPane.INFORMATION_MESSAGE);
					r.remove(r.size()-1);
				}
				else
					JOptionPane.showMessageDialog(null,"No se puede deshacer si no se ha escogido alguna RAM.","Sin selecciones",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnDeshacerUltimaEleccion.setBounds(463, 11, 197, 23);
		panelRAM.add(btnDeshacerUltimaEleccion);

		JButton button_2 = new JButton("Escoger");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableHDD.getSelectedRows().length == 1 ){
					if(h.size()<4){
						int fila = tableHDD.getSelectedRow();
						String id = (String)tableHDD.getValueAt(fila , 0);
						HDD hdd = tienda.HDDPorID(id);

						if((int)tableHDD.getValueAt(fila, 6)!= 0){
							JOptionPane.showMessageDialog(null,"Se ha escogido el disco duro de marca "+ hdd.getMarca() + " con " + hdd.getCapacidad()+" GB de Memoria.","HDD seleccionado",JOptionPane.INFORMATION_MESSAGE);
							h.add(hdd);
							modeloHDD.setValueAt((int)tableHDD.getValueAt(fila, 6)-1, fila, 6);
						}
						else
							JOptionPane.showMessageDialog(null, "No hay stock disponible para escoger ese disco duro","Error", JOptionPane.ERROR_MESSAGE);

					}else
						JOptionPane.showMessageDialog(null,"La pc solo puede tener 4 discos duros","Selección incorrecta",JOptionPane.ERROR_MESSAGE);
				}

				else
					JOptionPane.showMessageDialog(null,"Seleccione solo un disco a la vez","Selección incorrecta",JOptionPane.ERROR_MESSAGE);	
			}
		});
		button_2.setBounds(10, 466, 103, 32);
		panelHDD.add(button_2);

		JButton button_3 = new JButton("Continuar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(h.size()!=0){
					panelHDD.setVisible(false);
					panelCrearPC.setVisible(true);
					modelo = (DefaultTableModel) table.getModel();
					modelo.setRowCount(0);
					Object [] info = {m.getModelo(),c.getModelo()};
					modelo.addRow(info);
					modelo = (DefaultTableModel) table_1.getModel();
					modelo.setRowCount(0);
					for(RAM ram : r){
						Object [] info2 = {ram.getNumeroSerie(),ram.getTipo(),ram.getMemoria(),ram.getCantidadDisponible()};
						modelo.addRow(info2);
					}
					modelo = (DefaultTableModel) table_2.getModel();
					modelo.setRowCount(0);
					for (HDD hdd : h){
						Object [] info2 = {hdd.getMarca(),hdd.getModelo(),hdd.getCapacidad()};
						modelo.addRow(info2);
					}
				} else
					JOptionPane.showMessageDialog(null,"Seleccione al menos un disco de la lista","Selección incorrecta",JOptionPane.ERROR_MESSAGE);	

			}
		});
		button_3.setBounds(557, 466, 103, 32);
		panelHDD.add(button_3);

		JButton button_5 = new JButton("Regresar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloHDD.setRowCount(0);
				modeloRAM.setRowCount(0);
				h.clear();
				r.clear();

				rams = tienda.listaRAMcompatMotherboard(m.getTipoMemoriaRAM());
				for(Componente c : rams){
					Object info [] = {c.getNumeroSerie(),c.getMarca(),((RAM)c).getMemoria(),((RAM)c).getTipo(), c.calcularPrecio(),c.getCantidadDisponible()};
					modeloRAM.addRow(info);
				}

				panelRAM.setVisible(true);			
				panelHDD.setVisible(false);
			}
		});
		button_5.setFont(new Font("Sans Serif Collection", Font.PLAIN, 11));
		button_5.setBounds(10, 11, 89, 23);
		panelHDD.add(button_5);

		JButton button_8 = new JButton("Deshacer \u00FAltima elecci\u00F3n");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(h.size()>0){
					HDD anterior = h.get(h.size()-1);
					String id = anterior.getNumeroSerie();
					int fila = -1;
					for(int i=0;i<tableHDD.getRowCount() && fila == -1;i++)
						if(tableHDD.getValueAt(i,0).equals(id)){
							fila = i;
						}
					modeloHDD.setValueAt((int)tableHDD.getValueAt(fila, 6)+1, fila, 6);
					JOptionPane.showMessageDialog(null,"Se deshizo su último disco duro escogido de sus selecciones el hdd tiene id: "+anterior.getNumeroSerie(),"Elección removida",JOptionPane.INFORMATION_MESSAGE);
					h.remove(h.size()-1);
				}
				else
					JOptionPane.showMessageDialog(null,"No se puede deshacer si no se ha escogido algún HDD.","Sin selecciones",JOptionPane.ERROR_MESSAGE);
			}
		});
		button_8.setFont(new Font("Sans Serif Collection", Font.PLAIN, 12));
		button_8.setBounds(470, 10, 190, 23);
		panelHDD.add(button_8);

		JButton btnCrearPc = new JButton("Crear PC");
		btnCrearPc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = idPC.getText();
				try{
					tienda.addPC(id,m,c,r,h);
					PC pc = new PC(id,m,c);
					pc.setHddsPC(h);
					pc.addRamsPC(r);
					tienda.actualizarComponentes(pc);
					tienda.eliminarComponentesFueraStock();
					JOptionPane.showMessageDialog(null,"La creación de la PC fue exitosa, el costo de esta es de "+ pc.calcularPrecioTotal()+" $." ,"Ingreso Correcto",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				catch(IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnCrearPc.setBounds(524, 481, 103, 34);
		panelCrearPC.add(btnCrearPc);

		JButton button_6 = new JButton("Regresar");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				h.clear();
				modeloHDD.setRowCount(0);
				hdds = tienda.listaHDDcompatMotherboard(m.getConexionesDiscos());
				for(Componente c : hdds){
					Object info [] = {c.getNumeroSerie(),c.getMarca(),((HDD)c).getModelo(),((HDD)c).getCapacidad(),((HDD)c).getTipoConexion(), c.calcularPrecio(),c.getCantidadDisponible()};
					modeloHDD.addRow(info);
				}

				panelCrearPC.setVisible(false);			
				panelHDD.setVisible(true);
			}
		});
		button_6.setFont(new Font("Sans Serif Collection", Font.PLAIN, 11));
		button_6.setBounds(10, 2, 89, 23);
		panelCrearPC.add(button_6);
	}
}

