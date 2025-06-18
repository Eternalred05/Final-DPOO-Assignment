package GUI;
import Logic.Tienda;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InfoTienda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public InfoTienda(Tienda tienda, MenuTienda parent) {
		super(parent,true);
		setResizable(false);
		setType(Type.POPUP);
		setForeground(Color.BLUE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InfoTienda.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		setTitle("Informaci\u00F3n de la Tienda");
		setBounds(100, 100, 634, 381);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// estas variables son para rellenar los label con la informacion que se tiene	

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String nombre = tienda.getNombre();
		String direccion = tienda.getDireccion();
		String id = tienda.getId();
		String telefono = tienda.getTelefono();
		String fechaGerente = tienda.getGerente().getFecha().format(formato);
		String nombreG = tienda.getGerente().getNombre();
		String apellidos = tienda.getGerente().getApellidos();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(0, 0, 618, 342);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNombreDelGerente = new JLabel("Nombre del Gerente:");
		lblNombreDelGerente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreDelGerente.setBounds(26, 228, 223, 26);
		panel.add(lblNombreDelGerente);

		JLabel lblFechaDeIngreso = new JLabel("Fecha de ingreso del Gerente:");
		lblFechaDeIngreso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaDeIngreso.setBounds(26, 243, 311, 54);
		panel.add(lblFechaDeIngreso);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(10, 228, 598, 66);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNombregerente = new JLabel(nombreG + " " +apellidos);
		lblNombregerente.setBounds(191, 0, 352, 26);
		panel_1.add(lblNombregerente);
		lblNombregerente.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel labelFecha = new JLabel(fechaGerente);
		labelFecha.setBounds(261, 29, 138, 26);
		panel_1.add(labelFecha);
		labelFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblInformacimDelGerente = new JLabel("Informaci\u00F3n sobre el Gerente:");
		lblInformacimDelGerente.setForeground(Color.BLACK);
		lblInformacimDelGerente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacimDelGerente.setBounds(179, 206, 321, 26);
		panel.add(lblInformacimDelGerente);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(10, 57, 598, 138);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel labelPhone = new JLabel(telefono);
		labelPhone.setBounds(240, 107, 179, 26);
		panel_2.add(labelPhone);
		labelPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblId = new JLabel(id);
		lblId.setBounds(240, 76, 303, 26);
		panel_2.add(lblId);
		lblId.setBackground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblDireccion = new JLabel(direccion);
		lblDireccion.setBounds(240, 39, 329, 26);
		panel_2.add(lblDireccion);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblDeLaTienda = new JLabel("Tel\u00E9fono de la Tienda:");
		lblDeLaTienda.setBounds(10, 113, 232, 14);
		panel_2.add(lblDeLaTienda);
		lblDeLaTienda.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblIdentificadorDeLa = new JLabel("Identificador de la Tienda:");
		lblIdentificadorDeLa.setBounds(10, 76, 270, 26);
		panel_2.add(lblIdentificadorDeLa);
		lblIdentificadorDeLa.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblDireccinDeLa = new JLabel("Direcci\u00F3n de la Tienda:");
		lblDireccinDeLa.setBounds(10, 39, 270, 26);
		panel_2.add(lblDireccinDeLa);
		lblDireccinDeLa.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblNombreDeLa = new JLabel("Nombre de la Tienda:");
		lblNombreDeLa.setBounds(10, 2, 223, 26);
		panel_2.add(lblNombreDeLa);
		lblNombreDeLa.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblNombreTienda = new JLabel(nombre);
		lblNombreTienda.setBounds(221, 5, 311, 21);
		panel_2.add(lblNombreTienda);
		lblNombreTienda.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblInformacinSobreLa = new JLabel("Informaci\u00F3n sobre la Tienda:");
		lblInformacinSobreLa.setForeground(Color.BLACK);
		lblInformacinSobreLa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacinSobreLa.setBounds(146, 30, 303, 26);
		panel.add(lblInformacinSobreLa);



	}
}
