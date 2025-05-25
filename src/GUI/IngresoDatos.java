package GUI;

import Logic.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.CardLayout;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import Logic.Gerente;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.DateTimeException;

import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import Componentes.JTextFieldLimitado;

public class IngresoDatos extends JFrame {

	private JPanel contentPane;
	private boolean ingresoGerente;
	private boolean ingresoTienda;
	private Gerente gerente;
	private Tienda tienda;

	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel defaultComboBoxModel;

	public IngresoDatos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IngresoDatos.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
		setTitle("Ingresar Datos Sobre la Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 793, 624);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));

		final JPanel panelGerente = new JPanel();
		panelGerente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ingrese los datos del Gerente del Local", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelGerente.setBackground(new Color(245, 245, 245));
		final JPanel panelTienda = new JPanel();
		panelTienda.setBorder(new TitledBorder(null, "Ingrese los Datos de la Tienda", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelTienda.setBackground(new Color(245, 245, 245));
		panel.add(panelGerente, "Gerente");
		panelGerente.setLayout(null);

		JLabel labelGerenteNombre = new JLabel("Ingrese su nombre");
		labelGerenteNombre.setFont(new Font("Arial Black", Font.PLAIN, 25));
		labelGerenteNombre.setBounds(240, 93, 267, 50);
		panelGerente.add(labelGerenteNombre);

		JLabel label_1 = new JLabel("Ingrese sus apellidos");
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 25));
		label_1.setBounds(215, 179, 320, 57);
		panelGerente.add(label_1);

		JLabel labelFechaIngreso = new JLabel("Fecha de Ingreso");
		labelFechaIngreso.setFont(new Font("Arial Black", Font.PLAIN, 25));
		labelFechaIngreso.setBounds(240, 339, 249, 30);
		panelGerente.add(labelFechaIngreso);

		JLabel labelDia = new JLabel("Dia");
		labelDia.setFont(new Font("Arial Black", Font.PLAIN, 25));
		labelDia.setBounds(168, 377, 63, 50);
		panelGerente.add(labelDia);

		JLabel labelMes = new JLabel("Mes");
		labelMes.setFont(new Font("Arial Black", Font.PLAIN, 25));
		labelMes.setBounds(320, 380, 70, 44);
		panelGerente.add(labelMes);

		JLabel labelAnio = new JLabel("A\u00F1o");
		labelAnio.setFont(new Font("Arial Black", Font.PLAIN, 25));
		labelAnio.setBounds(514, 380, 70, 44);
		panelGerente.add(labelAnio);

		final JTextFieldLimitado NombreGerente = new JTextFieldLimitado();
		NombreGerente.setHorizontalAlignment(SwingConstants.CENTER);
		NombreGerente.setLimit(25);
		NombreGerente.setFont(new Font("Arial Black", Font.PLAIN, 20));
		NombreGerente.setBounds(168, 150, 400, 30);
		panelGerente.add(NombreGerente);

		final JTextFieldLimitado ApellidosGerente = new JTextFieldLimitado();
		ApellidosGerente.setHorizontalAlignment(SwingConstants.CENTER);
		ApellidosGerente.setLimit(30);
		ApellidosGerente.setFont(new Font("Arial Black", Font.PLAIN, 20));
		ApellidosGerente.setBounds(168, 247, 400, 30);
		panelGerente.add(ApellidosGerente);


		final JComboBox comboBoxDias = new JComboBox();
		comboBoxDias.setFont(new Font("Arial Black", Font.PLAIN, 20));
		comboBoxDias.setBounds(168, 421, 59, 30);
		Object num[] = new Object[31];
		for(int i=0;i<num.length;i++)
			num[i]=i+1;
		defaultComboBoxModel = new DefaultComboBoxModel(num);
		comboBoxDias.setModel(defaultComboBoxModel);
		panelGerente.add(comboBoxDias);

		final JComboBox comboBoxMes = new JComboBox();
		comboBoxMes.setFont(new Font("Arial Black", Font.PLAIN, 20));
		comboBoxMes.setBounds(255, 421, 202, 30);
		Object meses[] = new Object[12];
		meses[0] = "Enero";
		meses[1] = "Febrero";
		meses[2] = "Marzo";
		meses[3] = "Abril";
		meses[4] = "Mayo";
		meses[5] = "Junio";
		meses[6] = "Julio";
		meses[7] = "Agosto";
		meses[8] = "Septiembre";
		meses[9] = "Octubre";
		meses[10] = "Noviembre";
		meses[11] = "Diciembre";
		defaultComboBoxModel = new DefaultComboBoxModel(meses);
		comboBoxMes.setModel(defaultComboBoxModel);

		panelGerente.add(comboBoxMes);

		final JComboBox comboBoxAnio = new JComboBox();
		comboBoxAnio.setFont(new Font("Arial Black", Font.PLAIN, 20));
		comboBoxAnio.setBounds(501, 421, 86, 30);
		num = new Object[46];
		for(int i = 0;i<num.length;i++)
			num[i]= i+1980;
		defaultComboBoxModel = new DefaultComboBoxModel(num);
		comboBoxAnio.setModel(defaultComboBoxModel);
		panelGerente.add(comboBoxAnio);


		JButton buttonIngresarGerente = new JButton("Ingresar Gerente");
		buttonIngresarGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre;
				String apellidos;
				int anio,mes,dia;
				try{
					anio = (int)comboBoxAnio.getSelectedItem();
					mes = (int)comboBoxMes.getSelectedIndex()+1;
					dia = (int)comboBoxDias.getSelectedItem();
					nombre = NombreGerente.getText();
					apellidos = ApellidosGerente.getText();
					gerente = new Gerente (nombre, apellidos, anio, mes, dia);
					ingresoGerente = true;
					JOptionPane.showMessageDialog(null,"Los datos del Gerente ha sido ingresados satisfactoriamente","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);
				}
				catch (DateTimeException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null,"Valores incorrectos en la fecha","Error",JOptionPane.ERROR_MESSAGE);
				}
				catch (IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buttonIngresarGerente.setFont(new Font("Arial Black", Font.PLAIN, 21));
		buttonIngresarGerente.setBounds(240, 490, 249, 44);
		panelGerente.add(buttonIngresarGerente);

		final JButton btnContinuarGerente = new JButton("Continuar");
		btnContinuarGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ingresoGerente){
					panelGerente.setVisible(false);
					panelTienda.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Ingrese los Datos del Gerente antes de continuar.","Error",JOptionPane.ERROR_MESSAGE);

			}
		});
		btnContinuarGerente.setFont(new Font("Arial Black", Font.PLAIN, 21));
		btnContinuarGerente.setBounds(534, 569, 249, 44);
		panelGerente.add(btnContinuarGerente);

		JButton btnInicializargerente = new JButton("Inicializar Gerente");
		btnInicializargerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ingresoGerente){
					gerente = new Gerente("Alexandro", "Valdés Piñeda", 2005,9,15);
					JOptionPane.showMessageDialog(null,"Los datos del Gerente han sido inicializados y añadidos satisfactoriamente","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);
					NombreGerente.setText("Alexandro");
					ApellidosGerente.setText("Valdés Piñeda"); 
					comboBoxDias.setSelectedIndex(14);
					comboBoxMes.setSelectedIndex(8);
					comboBoxAnio.setSelectedIndex(25);
					ingresoGerente = true;
					btnContinuarGerente.doClick();
				}
				else
					JOptionPane.showMessageDialog(null,"Ya se ha ingresado un Gerente, no es necesario inicializar.","Advertencia",JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		btnInicializargerente.setFont(new Font("Arial Black", Font.PLAIN, 21));
		btnInicializargerente.setBounds(10, 569, 249, 44);
		panelGerente.add(btnInicializargerente);

		panel.add(panelTienda, "Tienda");
		panelTienda.setLayout(null);

		final JTextFieldLimitado TiendaName = new JTextFieldLimitado();
		TiendaName.setHorizontalAlignment(SwingConstants.CENTER);
		TiendaName.setFont(new Font("Arial Black", Font.PLAIN, 20));
		TiendaName.setLimit(30);
		TiendaName.setBounds(125, 137, 501, 32);
		panelTienda.add(TiendaName);

		final JTextFieldLimitado TiendaAddress = new JTextFieldLimitado();
		TiendaAddress.setHorizontalAlignment(SwingConstants.CENTER);
		TiendaAddress.setFont(new Font("Arial Black", Font.PLAIN, 20));
		TiendaAddress.setLimit(30);
		TiendaAddress.setBounds(125, 224, 501, 32);
		panelTienda.add(TiendaAddress);

		final JTextFieldLimitado TiendaPhone = new JTextFieldLimitado();
		TiendaPhone.setHorizontalAlignment(SwingConstants.CENTER);
		TiendaPhone.setFont(new Font("Arial Black", Font.PLAIN, 20));
		TiendaPhone.setLimit(8);
		TiendaPhone.setBounds(125, 318, 501, 32);
		panelTienda.add(TiendaPhone);

		final JTextFieldLimitado TiendaID = new JTextFieldLimitado();
		TiendaID.setHorizontalAlignment(SwingConstants.CENTER);
		TiendaID.setFont(new Font("Arial Black", Font.PLAIN, 20));
		TiendaID.setLimit(15);
		TiendaID.setBounds(125, 412, 501, 32);
		panelTienda.add(TiendaID);

		JButton buttonIngresoTienda = new JButton("Ingresar Tienda");
		buttonIngresoTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre;
				String direccion;
				String telefono;
				String id;
				try{
					nombre = TiendaName.getText();
					id = TiendaID.getText();
					direccion = TiendaAddress.getText();
					telefono = TiendaPhone.getText();
					tienda = new Tienda(nombre,id,direccion,telefono,gerente);
					ingresoTienda = true;
					JOptionPane.showMessageDialog(null,"Los datos de la tienda han sido ingresados satisfactoriamente","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);
				}
				catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		buttonIngresoTienda.setFont(new Font("Arial Black", Font.PLAIN, 21));
		buttonIngresoTienda.setBounds(262, 489, 225, 39);
		panelTienda.add(buttonIngresoTienda);

		JLabel labelID = new JLabel("Ingrese el ID");
		labelID.setFont(new Font("Arial Black", Font.PLAIN, 25));
		labelID.setBounds(278, 361, 189, 40);
		panelTienda.add(labelID);

		JLabel lblAddress = new JLabel("Ingrese la direcci\u00F3n");
		lblAddress.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblAddress.setBounds(233, 173, 296, 32);
		panelTienda.add(lblAddress);

		JLabel lblPhone = new JLabel("Ingrese el n\u00FAmero de tel\u00E9fono");
		lblPhone.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblPhone.setBounds(182, 257, 444, 70);
		panelTienda.add(lblPhone);

		JLabel lblName = new JLabel("Ingrese el nombre ");
		lblName.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblName.setBounds(245, 86, 257, 40);
		panelTienda.add(lblName);

		final JButton buttonContinuarTienda = new JButton("Continuar");
		buttonContinuarTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ingresoTienda) {
					contentPane.setVisible(false);;
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MenuTienda frame = new MenuTienda(tienda);
								frame.setVisible(true);
								dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				else
					JOptionPane.showMessageDialog(null,"Ingrese los datos de la tienda antes de continuar.","Error",JOptionPane.ERROR_MESSAGE);		
			}
		});
		buttonContinuarTienda.setFont(new Font("Arial Black", Font.PLAIN, 21));
		buttonContinuarTienda.setBounds(534, 569, 249, 44);
		panelTienda.add(buttonContinuarTienda);

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGerente.setVisible(true);
				panelTienda.setVisible(false);
			}
		});
		btnRegresar.setBounds(10, 11, 89, 23);
		panelTienda.add(btnRegresar);

		JButton btnInicializarTienda = new JButton("Inicializar Tienda");
		btnInicializarTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ingresoTienda){
					tienda = new Tienda("GameStop777","GAME05","Avenida 33A Calle 156, Playa","72627762",gerente);
					ingresoTienda = true;
					JOptionPane.showMessageDialog(null,"Los datos de la tienda se han inicializado satisfactoriamente","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);
					buttonContinuarTienda.doClick();
				}
			}
		});
		btnInicializarTienda.setFont(new Font("Arial Black", Font.PLAIN, 21));
		btnInicializarTienda.setBounds(10, 569, 249, 44);
		panelTienda.add(btnInicializarTienda);
	}
}
