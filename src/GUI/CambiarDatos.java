package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logic.*;

import java.awt.CardLayout;

import javax.swing.JLabel;

import java.awt.Font;

import Componentes.JTextFieldLimitado;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.DateTimeException;
import java.awt.Window.Type;

public class CambiarDatos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Gerente gerente;
	private Tienda tienda;
	private Tienda tiendaPrueba;

	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel defaultComboBoxModel;


	public CambiarDatos(MenuTienda parent, Tienda tiendaPC) {
		super(parent,true);
		setType(Type.POPUP);
		setTitle("Modificar datos de la Tienda");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 686, 565);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		setLocationRelativeTo(parent);


		tienda = tiendaPC;

		final JPanel panelGerente = new JPanel();
		contentPanel.add(panelGerente, "name_49294859223800");
		panelGerente.setLayout(null);

		final JPanel panelTienda = new JPanel();
		contentPanel.add(panelTienda, "name_50237300691400");
		panelTienda.setLayout(null);

		JButton button_1 = new JButton("Regresar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGerente.setVisible(true);
				panelTienda.setVisible(false);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_1.setBounds(10, 11, 89, 23);
		panelTienda.add(button_1);

		JLabel label_7 = new JLabel("Ingrese los Datos de la Tienda");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 27));
		label_7.setBounds(124, 45, 420, 31);
		panelTienda.add(label_7);

		JLabel label_8 = new JLabel("Ingrese el nombre ");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_8.setBounds(231, 87, 225, 40);
		panelTienda.add(label_8);

		final JTextFieldLimitado TiendaName = new JTextFieldLimitado();
		TiendaName.setLimit(30);
		TiendaName.setHorizontalAlignment(SwingConstants.CENTER);
		TiendaName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		TiendaName.setBounds(84, 126, 501, 32);
		panelTienda.add(TiendaName);

		JLabel label_9 = new JLabel("Ingrese la direcci\u00F3n");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_9.setBounds(242, 169, 225, 32);
		panelTienda.add(label_9);

		final JTextFieldLimitado TiendaAddress = new JTextFieldLimitado();
		TiendaAddress.setLimit(30);
		TiendaAddress.setHorizontalAlignment(SwingConstants.CENTER);
		TiendaAddress.setFont(new Font("Tahoma", Font.PLAIN, 22));
		TiendaAddress.setBounds(84, 212, 501, 32);
		panelTienda.add(TiendaAddress);

		JLabel label_10 = new JLabel("Ingrese el n\u00FAmero de tel\u00E9fono");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_10.setBounds(192, 255, 338, 40);
		panelTienda.add(label_10);

		final JTextFieldLimitado TiendaPhone = new JTextFieldLimitado();
		TiendaPhone.setLimit(8);
		TiendaPhone.setHorizontalAlignment(SwingConstants.CENTER);
		TiendaPhone.setFont(new Font("Tahoma", Font.PLAIN, 22));
		TiendaPhone.setBounds(84, 306, 501, 32);
		panelTienda.add(TiendaPhone);

		JLabel label_11 = new JLabel("Ingrese el ID");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_11.setBounds(270, 349, 153, 40);
		panelTienda.add(label_11);

		final JTextFieldLimitado TiendaID = new JTextFieldLimitado();
		TiendaID.setLimit(15);
		TiendaID.setHorizontalAlignment(SwingConstants.CENTER);
		TiendaID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		TiendaID.setBounds(84, 399, 501, 32);
		panelTienda.add(TiendaID);


		JLabel label = new JLabel("Ingrese los datos del Gerente del Local");
		label.setFont(new Font("Tahoma", Font.BOLD, 26));
		label.setBounds(70, 22, 525, 30);
		panelGerente.add(label);

		JLabel label_1 = new JLabel("Ingrese su nombre");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label_1.setBounds(239, 83, 202, 50);
		panelGerente.add(label_1);

		final JTextFieldLimitado NombreGerente = new JTextFieldLimitado();
		NombreGerente.setLimit(25);
		NombreGerente.setHorizontalAlignment(SwingConstants.CENTER);
		NombreGerente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		NombreGerente.setBounds(126, 145, 400, 30);
		panelGerente.add(NombreGerente);

		JLabel label_2 = new JLabel("Ingrese sus apellidos");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label_2.setBounds(239, 184, 230, 44);
		panelGerente.add(label_2);

		final JTextFieldLimitado ApellidosGerente = new JTextFieldLimitado();
		ApellidosGerente.setLimit(30);
		ApellidosGerente.setHorizontalAlignment(SwingConstants.CENTER);
		ApellidosGerente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ApellidosGerente.setBounds(126, 239, 400, 30);
		panelGerente.add(ApellidosGerente);

		JLabel label_3 = new JLabel("Fecha de Ingreso");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label_3.setBounds(239, 283, 213, 30);
		panelGerente.add(label_3);

		JLabel label_4 = new JLabel("Mes");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label_4.setBounds(306, 324, 70, 44);
		panelGerente.add(label_4);

		final JComboBox comboBoxMes = new JComboBox();
		comboBoxMes.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboBoxMes.setBounds(226, 363, 202, 30);
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

		JLabel label_5 = new JLabel("Dia");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label_5.setBounds(126, 321, 63, 50);
		panelGerente.add(label_5);

		final JComboBox comboBoxDias = new JComboBox();
		comboBoxDias.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboBoxDias.setBounds(126, 363, 59, 30);
		Object num[] = new Object[31];
		for(int i=0;i<num.length;i++)
			num[i]=i+1;
		defaultComboBoxModel = new DefaultComboBoxModel(num);
		comboBoxDias.setModel(defaultComboBoxModel);
		panelGerente.add(comboBoxDias);

		final JComboBox comboBoxAnio = new JComboBox();
		comboBoxAnio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboBoxAnio.setBounds(459, 363, 86, 30);
		num = new Object[46];
		for(int i = 0;i<num.length;i++)
			num[i]= i+1980;
		defaultComboBoxModel = new DefaultComboBoxModel(num);
		comboBoxAnio.setModel(defaultComboBoxModel);
		panelGerente.add(comboBoxAnio);

		JLabel label_6 = new JLabel("A\u00F1o");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label_6.setBounds(472, 322, 70, 44);
		panelGerente.add(label_6);

		JButton button = new JButton("Ingresar Gerente");
		button.addActionListener(new ActionListener() {
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
					JOptionPane.showMessageDialog(null,"Los datos del Gerente ha sido ingresados satisfactoriamente","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);
					panelGerente.setVisible(false);
					panelTienda.setVisible(true);
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
		button.setFont(new Font("Tahoma", Font.PLAIN, 21));
		button.setBounds(453, 471, 207, 44);
		panelGerente.add(button);

		JButton button_2 = new JButton("Ingresar Tienda");
		button_2.addActionListener(new ActionListener() {
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
					tiendaPrueba = new Tienda(nombre, id, direccion, telefono, gerente);
					JOptionPane.showMessageDialog(null,"Los datos de la tienda han sido modificados satisfactoriamente","Modificación Exitosa",JOptionPane.INFORMATION_MESSAGE);
					tienda.setDireccion(direccion);
					tienda.setGerente(gerente);
					tienda.setNombre(nombre);
					tienda.setTelefono(telefono);
					tienda.setId(id);
					tienda.getTrabajadores().get(0).setNombre(gerente.getNombre());
					tienda.getTrabajadores().get(0).setApellidos(gerente.getApellidos());
					dispose();
				}
				catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button_2.setBounds(463, 476, 197, 39);
		panelTienda.add(button_2);
	}
}
