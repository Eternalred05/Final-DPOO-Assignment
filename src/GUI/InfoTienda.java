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
		panel.setBackground(new Color(0, 0, 139));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(0, 0, 618, 342);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNombreDeLa = new JLabel("Nombre de la Tienda:");
		lblNombreDeLa.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNombreDeLa.setBounds(26, 57, 223, 26);
		panel.add(lblNombreDeLa);

		JLabel lblNombreTienda = new JLabel(nombre);
		lblNombreTienda.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNombreTienda.setBounds(243, 60, 311, 21);
		panel.add(lblNombreTienda);

		JLabel lblDireccinDeLa = new JLabel("Direcci\u00F3n de la Tienda:");
		lblDireccinDeLa.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblDireccinDeLa.setBounds(26, 84, 270, 26);
		panel.add(lblDireccinDeLa);

		JLabel lblDireccion = new JLabel(direccion);
		lblDireccion.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblDireccion.setBounds(266, 84, 329, 26);
		panel.add(lblDireccion);

		JLabel lblIdentificadorDeLa = new JLabel("Identificador de la Tienda:");
		lblIdentificadorDeLa.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblIdentificadorDeLa.setBounds(26, 121, 270, 14);
		panel.add(lblIdentificadorDeLa);

		JLabel lblId = new JLabel(id);
		lblId.setBackground(Color.WHITE);
		lblId.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblId.setBounds(292, 115, 303, 26);
		panel.add(lblId);

		JLabel lblDeLaTienda = new JLabel("Tel\u00E9fono de la Tienda:");
		lblDeLaTienda.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblDeLaTienda.setBounds(26, 152, 232, 14);
		panel.add(lblDeLaTienda);

		JLabel labelPhone = new JLabel(telefono);
		labelPhone.setFont(new Font("Arial Black", Font.PLAIN, 18));
		labelPhone.setBounds(255, 146, 138, 26);
		panel.add(labelPhone);

		JLabel lblNombreDelGerente = new JLabel("Nombre del Gerente:");
		lblNombreDelGerente.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNombreDelGerente.setBounds(26, 228, 223, 26);
		panel.add(lblNombreDelGerente);

		JLabel lblNombregerente = new JLabel(nombreG + " " +apellidos);
		lblNombregerente.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNombregerente.setBounds(243, 228, 352, 26);
		panel.add(lblNombregerente);

		JLabel lblFechaDeIngreso = new JLabel("Fecha de ingreso del Gerente:");
		lblFechaDeIngreso.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblFechaDeIngreso.setBounds(26, 243, 311, 54);
		panel.add(lblFechaDeIngreso);

		JLabel labelFecha = new JLabel(fechaGerente);
		labelFecha.setFont(new Font("Arial Black", Font.PLAIN, 18));
		labelFecha.setBounds(335, 257, 138, 26);
		panel.add(labelFecha);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 228, 598, 66);
		panel.add(panel_1);

		JLabel lblInformacimDelGerente = new JLabel("Informaci\u00F3n sobre el Gerente:");
		lblInformacimDelGerente.setForeground(new Color(255, 255, 255));
		lblInformacimDelGerente.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblInformacimDelGerente.setBounds(136, 206, 321, 26);
		panel.add(lblInformacimDelGerente);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 57, 598, 119);
		panel.add(panel_2);

		JLabel lblInformacinSobreLa = new JLabel("Informaci\u00F3n sobre la Tienda:");
		lblInformacinSobreLa.setForeground(new Color(255, 255, 255));
		lblInformacinSobreLa.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblInformacinSobreLa.setBounds(146, 30, 303, 26);
		panel.add(lblInformacinSobreLa);



	}
}
