package Logic;
import java.util.ArrayList;

public class Motherboard extends Componente {
	private String modelo;
	private String tipoSocket;
	private String tipoMemoriaRAM;
	private ArrayList<String> conexionesDiscos;

	public String getTipoMemoriaRAM() {
		return tipoMemoriaRAM;
	}
	public void setTipoMemoriaRAM(String tipo) {
		if("DDR5".equalsIgnoreCase(tipo)|| "DDR4".equalsIgnoreCase(tipo) || "DDR3".equalsIgnoreCase(tipo) || "DDR2".equalsIgnoreCase(tipo)|| "DDR".equalsIgnoreCase(tipo))
			this.tipoMemoriaRAM = tipo;
		else 
			throw new IllegalArgumentException("Ese tipo de RAM no se encuentra disponible");
	}
	public Motherboard(int cantidadDisponible, String numeroSerie, String marca, String modelo,String tipoConector, String tipoMemoriaRAM, ArrayList<String> conexionesDiscos,double precioBase) {
		super(cantidadDisponible, numeroSerie,precioBase,marca);
		setModelo(modelo);
		setTipoConector(tipoConector);
		setTipoMemoriaRAM(tipoMemoriaRAM);
		setConexionesDiscos(conexionesDiscos);
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		if(modelo!= null && !modelo.isEmpty())
			this.modelo = modelo;
		else
			throw new IllegalArgumentException("No puede estar vacío el modelo");
	}
	public String getTipoConector() {
		return tipoSocket;
	}
	public void setTipoConector(String tipoSocket) {
		if(tipoSocket != null && !tipoSocket.isEmpty())
			this.tipoSocket= tipoSocket;
		else
			throw new IllegalArgumentException("No puede estar vacio el tipo de socket");
	}

	public ArrayList<String> getConexionesDiscos() {
		return conexionesDiscos;
	}

	public void setConexionesDiscos(ArrayList<String> conexionesDiscos) {
		if(conexionesDiscos != null && conexionesDiscos.size()!=0)
			this.conexionesDiscos = conexionesDiscos;
		else
			throw new IllegalArgumentException("Ingrese al menos una conexión de disco que soporta el Motherboard");	
	}

	@Override
	public double calcularPrecio() {
		double aporteSocket = "LGA".equals(tipoSocket) ? 40 : "PGA".equals(tipoSocket) ? 30 : "BGA".equals(tipoSocket) ? 20 : 10 ;
		double aporteMemoria = "DDR5".equalsIgnoreCase(tipoMemoriaRAM) ? 60 : "DDR4".equalsIgnoreCase(tipoMemoriaRAM) ? 45 : "DDR3".equalsIgnoreCase(tipoMemoriaRAM) ? 30 :"DDR2".equalsIgnoreCase(tipoMemoriaRAM) ? 20 : 15;
		return precioBase + aporteSocket + aporteMemoria;
	}
}

