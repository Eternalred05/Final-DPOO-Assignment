package Utils;
import javax.swing.table.DefaultTableModel;

public class TrabajadorTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	public TrabajadorTableModel(){
		String[] columnNames = {"Número","Nombre", "Apellidos","Cargo", "Nivel Escolar", "CI", 
		"Salario"};
		this.setColumnIdentifiers(columnNames);
	}
	public void adicionar(String num, String nombre ,String apellidos, String
			cargo, String nivel, String id , String salario){
		Object[] fila = new Object[]{num, nombre , apellidos, cargo, nivel, id, salario};
		addRow(fila);
	}

}

