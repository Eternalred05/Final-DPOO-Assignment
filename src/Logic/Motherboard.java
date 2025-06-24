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
	public Motherboard(int cantidadDisponible, String numeroSerie, String marca, String modelo,String tipoConector, String tipoMemoriaRAM, ArrayList<String> conexiones,double precioBase) {
		super(cantidadDisponible, numeroSerie,precioBase,marca);
		setModelo(modelo);
		setTipoConector(tipoConector);
		setTipoMemoriaRAM(tipoMemoriaRAM);
		conexionesDiscos = new ArrayList<>();
		addConexionesDiscos(conexiones);
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

	public void addConexionesDiscos(ArrayList<String> conexiones) {
		if(conexiones != null && conexiones.size()!=0){
			for(String s : conexiones)
				conexionesDiscos.add(s);
		}
		else 
			throw new IllegalArgumentException("Ingrese al menos una conexión de disco que soporta el Motherboard");	
	}

	@Override
	public double calcularPrecio() {
		double aporteSocket = "LGA".equals(tipoSocket) ? 40 : "PGA".equals(tipoSocket) ? 30 : "BGA".equals(tipoSocket) ? 20 : 10 ;
		double aporteMemoria = "DDR5".equalsIgnoreCase(tipoMemoriaRAM) ? 60 : "DDR4".equalsIgnoreCase(tipoMemoriaRAM) ? 45 : "DDR3".equalsIgnoreCase(tipoMemoriaRAM) ? 30 :"DDR2".equalsIgnoreCase(tipoMemoriaRAM) ? 20 : 15;
		double aporteConexiones = 0;
		for(String s : conexionesDiscos)
			aporteConexiones += "SATA".equals(s) ? 4.5 : "SATA-2".equals(s) ? 5.0 : "SATA-3".equals(s) ? 10 : 3.5 ; ;
			return precioBase + aporteSocket + aporteMemoria+aporteConexiones;
	}

}

