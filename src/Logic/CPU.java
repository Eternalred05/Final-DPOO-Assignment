package Logic;
public class CPU extends Componente {
	private String marca;
	private String modelo;
	private String socket;
	private double velocidad; // se expresará en Ghz y se usará de un rango de 1Ghz hasta 4.8Ghz como en la gran cantidad de ordenadores modernos

	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		if(velocidad >=1 && velocidad <= 4.8)
			this.velocidad = velocidad;
		else 
			throw new IllegalArgumentException("La velocidad no se encuentra en los limites dados");
	}
	public CPU(int cantidadDisponible, String numeroSerie, String marca, String modelo,
			String socket, double velocidad, double precioBase) {
		super(cantidadDisponible, numeroSerie, precioBase);
		setMarca(marca);
		setModelo(modelo);
		this.socket = socket;
		setVelocidad(velocidad);
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		if(marca!= null && !marca.isEmpty())
			this.marca = marca;
		else
			throw new IllegalArgumentException("No puede estar vacia la marca");
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		if(modelo!= null && !modelo.isEmpty())
			this.modelo = modelo;
		else
			throw new IllegalArgumentException("No puede estar vacia el modelo");
	}

	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		if(socket!= null && !socket.isEmpty())
			this.socket = socket;
		else
			throw new IllegalArgumentException("No puede estar vacia el modelo");
	}
	@Override
	public double calcularPrecio() {
		double aporteVelocidad = velocidad * 50; 
		return precioBase + aporteVelocidad;
	}
}

