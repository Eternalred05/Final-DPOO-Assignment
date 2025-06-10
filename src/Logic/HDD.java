package Logic;
public class HDD extends Componente {
	private String modelo;
	private double capacidad; // se expresa la cantidad en Gigabytes y con un minimo de 128gb y maximo 4096gb(4TB) siendo el maximo comercial actual
	private String tipoConexion; 

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		if(capacidad >= 128 && capacidad <= 4096 )
			this.capacidad = capacidad;
		else
			throw new IllegalArgumentException("La capacidad no se encuentra en los límites dados");
	}

	public HDD(int cantidadDisponible, String numeroSerie, String marca, String modelo,double capacidad, String tipoConexion,double precioBase) {
		super(cantidadDisponible, numeroSerie,precioBase,marca);
		setModelo(modelo);
		setCapacidad(capacidad);
		setTipoConexion(tipoConexion);
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

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		if(tipoConexion!= null && !tipoConexion.isEmpty())
			this.tipoConexion = tipoConexion;
		else
			throw new IllegalArgumentException("No puede estar vacío el tipo de conexión");
	}


	@Override
	public double calcularPrecio() {
		double aporteCapacidad = capacidad * 0.5;
		double aporteConexion = "SATA-3".equalsIgnoreCase(tipoConexion) ? 40 : "SATA-2".equalsIgnoreCase(tipoConexion) ? 35 : "SATA".equalsIgnoreCase(tipoConexion) ? 30 : 20;
		return precioBase + aporteCapacidad + aporteConexion;
	}
}


