package GUI;
import Logic.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.time.DateTimeException;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField NombreGerente;
	private JTextField ApellidosGerente;
	private JLabel lblIngreseSuNombre;
	private JLabel lblIngreseSusApellidos;
	private JTextField textDia;
	private JTextField textAnio;
	private JTextField textMes;
	private JLabel lblDia;
	private JLabel lblMes;
	private JLabel lblAo;
	private JLabel lblFechaDeIngreso;
	private JLabel lblIngreseElNombre;
	private JTextField TiendaName;
	private JLabel lblIngreseElNmero;
	private JTextField TiendaPhone;
	private JTextField TiendaAddress;
	private JLabel lblIngreseLaDireccion;
	private JLabel lblIngreseElId;
	private JTextField TiendaID;
	private JButton btnContinuar;
	private boolean ingresoGerente;
	Gerente gerente;
	Tienda tienda;
	private JButton btnIngresarTienda;
	private JButton btnIngresarGerente;
	private boolean ingresoTienda = false;
	public Login() {
		setTitle("Login de Gerencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getNombreGerente());
		contentPane.add(getApellidosGerente());
		contentPane.add(getLblIngreseSuNombre());
		contentPane.add(getLblIngreseSusApellidos());
		contentPane.add(getTextDia());
		contentPane.add(getTextAnio());
		contentPane.add(getTextMes());
		contentPane.add(getLblDia());
		contentPane.add(getLblMes());
		contentPane.add(getLblAo());
		contentPane.add(getLblFechaDeIngreso());
		contentPane.add(getLblIngreseElNombre());
		contentPane.add(getTiendaName());
		contentPane.add(getLblIngreseElNmero());
		contentPane.add(getTiendaPhone());
		contentPane.add(getTiendaAddress());
		contentPane.add(getLblIngreseLaDireccion());
		contentPane.add(getLblIngreseElId());
		contentPane.add(getTiendaID());
		contentPane.add(getBtnContinuar());
		contentPane.add(getBtnIngresarTienda());
		contentPane.add(getBtnIngresarGerente());
	}
	private JTextField getNombreGerente() {
		if (NombreGerente == null) {
			NombreGerente = new JTextField();
			NombreGerente.setBounds(10, 36, 223, 20);
			NombreGerente.setColumns(10);
		}
		return NombreGerente;
	}
	private JTextField getApellidosGerente() {
		if (ApellidosGerente == null) {
			ApellidosGerente = new JTextField();
			ApellidosGerente.setBounds(10, 94, 223, 20);
			ApellidosGerente.setColumns(10);
		}
		return ApellidosGerente;
	}
	private JLabel getLblIngreseSuNombre() {
		if (lblIngreseSuNombre == null) {
			lblIngreseSuNombre = new JLabel("Ingrese su nombre");
			lblIngreseSuNombre.setBounds(57, 11, 124, 14);
		}
		return lblIngreseSuNombre;
	}
	private JLabel getLblIngreseSusApellidos() {
		if (lblIngreseSusApellidos == null) {
			lblIngreseSusApellidos = new JLabel("Ingrese sus apellidos");
			lblIngreseSusApellidos.setBounds(57, 67, 124, 14);
		}
		return lblIngreseSusApellidos;
	}
	private JTextField getTextDia() {
		if (textDia == null) {
			textDia = new JTextField();
			textDia.setBounds(50, 176, 37, 20);
			textDia.setColumns(10);
		}
		return textDia;
	}
	private JTextField getTextAnio() {
		if (textAnio == null) {
			textAnio = new JTextField();
			textAnio.setColumns(10);
			textAnio.setBounds(144, 176, 37, 20);
		}
		return textAnio;
	}
	private JTextField getTextMes() {
		if (textMes == null) {
			textMes = new JTextField();
			textMes.setColumns(10);
			textMes.setBounds(97, 176, 37, 20);
		}
		return textMes;
	}
	private JLabel getLblDia() {
		if (lblDia == null) {
			lblDia = new JLabel("Dia");
			lblDia.setBounds(58, 161, 29, 14);
		}
		return lblDia;
	}
	private JLabel getLblMes() {
		if (lblMes == null) {
			lblMes = new JLabel("Mes");
			lblMes.setBounds(105, 161, 29, 14);
		}
		return lblMes;
	}
	private JLabel getLblAo() {
		if (lblAo == null) {
			lblAo = new JLabel("A\u00F1o");
			lblAo.setBounds(152, 161, 29, 14);
		}
		return lblAo;
	}
	private JLabel getLblFechaDeIngreso() {
		if (lblFechaDeIngreso == null) {
			lblFechaDeIngreso = new JLabel("Fecha de Ingreso");
			lblFechaDeIngreso.setBounds(44, 136, 97, 14);
		}
		return lblFechaDeIngreso;
	}

	private JLabel getLblIngreseElNombre() {
		if (lblIngreseElNombre == null) {
			lblIngreseElNombre = new JLabel("Ingrese el Nombre de la tienda");
			lblIngreseElNombre.setBounds(275, 11, 213, 14);
		}
		return lblIngreseElNombre;
	}
	private JTextField getTiendaName() {
		if (TiendaName == null) {
			TiendaName = new JTextField();
			TiendaName.setColumns(10);
			TiendaName.setBounds(253, 36, 223, 20);
		}
		return TiendaName;
	}
	private JLabel getLblIngreseElNmero() {
		if (lblIngreseElNmero == null) {
			lblIngreseElNmero = new JLabel("Ingrese el n\u00FAmero de telefono de la tienda");
			lblIngreseElNmero.setBounds(263, 67, 246, 14);
		}
		return lblIngreseElNmero;
	}
	private JTextField getTiendaPhone() {
		if (TiendaPhone == null) {
			TiendaPhone = new JTextField();
			TiendaPhone.setColumns(10);
			TiendaPhone.setBounds(253, 94, 223, 20);
		}
		return TiendaPhone;
	}
	private JTextField getTiendaAddress() {
		if (TiendaAddress == null) {
			TiendaAddress = new JTextField();
			TiendaAddress.setColumns(10);
			TiendaAddress.setBounds(253, 158, 223, 20);
		}
		return TiendaAddress;
	}
	private JLabel getLblIngreseLaDireccion() {
		if (lblIngreseLaDireccion == null) {
			lblIngreseLaDireccion = new JLabel("Ingrese la direccion");
			lblIngreseLaDireccion.setBounds(310, 136, 135, 14);
		}
		return lblIngreseLaDireccion;
	}
	private JLabel getLblIngreseElId() {
		if (lblIngreseElId == null) {
			lblIngreseElId = new JLabel("Ingrese el ID");
			lblIngreseElId.setBounds(331, 198, 72, 14);
		}
		return lblIngreseElId;
	}
	private JTextField getTiendaID() {
		if (TiendaID == null) {
			TiendaID = new JTextField();
			TiendaID.setColumns(10);
			TiendaID.setBounds(253, 217, 223, 20);
		}
		return TiendaID;
	}
	private JButton getBtnContinuar() {
		if (btnContinuar == null) {
			btnContinuar = new JButton("Continuar");
			btnContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(ingresoTienda) {
						contentPane.setVisible(false);;
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Test frame = new Test(tienda);
									frame.setVisible(true);
									dispose();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					else
						JOptionPane.showMessageDialog(null,"Ingrese la Tienda antes","Error",JOptionPane.ERROR_MESSAGE);		
				}
			});
			btnContinuar.setBounds(444, 328, 89, 23);
		}
		return btnContinuar;
	}
	private JButton getBtnIngresarTienda() {
		if (btnIngresarTienda == null) {
			btnIngresarTienda = new JButton("Ingresar Tienda");
			btnIngresarTienda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(ingresoGerente){
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
							JOptionPane.showMessageDialog(null,"La tienda ha sido Ingresado Satisfactoriamente","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);
						}
						catch (IllegalArgumentException e) {
							JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

						}
					}
					else
						JOptionPane.showMessageDialog(null,"Ingrese el Gerente primero","Error",JOptionPane.ERROR_MESSAGE);	

				}
			});
			btnIngresarTienda.setBounds(289, 248, 145, 23);
		}
		return btnIngresarTienda;
	}
	private JButton getBtnIngresarGerente() {
		if (btnIngresarGerente == null) {
			btnIngresarGerente = new JButton("Ingresar Gerente");
			btnIngresarGerente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nombre;
					String apellidos;
					int anio,mes,dia;
					try{
						anio = Integer.parseInt(textAnio.getText());
						mes = Integer.parseInt(textMes.getText());
						dia = Integer.parseInt(textDia.getText());
						nombre = NombreGerente.getText();
						apellidos = ApellidosGerente.getText();
						gerente = new Gerente (nombre, apellidos, anio, mes, dia);
						ingresoGerente = true;
						JOptionPane.showMessageDialog(null,"El Gerente ha sido Ingresado Satisfactoriamente","Ingreso Exitoso",JOptionPane.INFORMATION_MESSAGE);
					}
					catch (DateTimeException e) {
						JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					}
					catch (NumberFormatException e){
						JOptionPane.showMessageDialog(null,"La fecha está vacía","Error",JOptionPane.ERROR_MESSAGE);
					}
					catch (IllegalArgumentException e){
						JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					}

				}
			});
			btnIngresarGerente.setBounds(44, 207, 145, 23);
		}
		return btnIngresarGerente;
	}
}
