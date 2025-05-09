package Logic;

public class RAM extends Componente {
	private String marca;
	private double memoria; // se expresa en Gb la memoria con un maximo por modulo de 128gb y minimo 0.5gb(aproximadaente 512mb)
	private String tipo;


	public double getMemoria() {
		return memoria;
	}
	public void setMemoria(double memoria) {
		if(memoria >= 0.5 && memoria <= 128)
			this.memoria = memoria;
		else
			throw new IllegalArgumentException("La memoria no se encuentra en los limites dados");
	}
	public RAM(int cantidadDisponible, String numeroSerie, String marca, double memoria , String tipo, double precioBase) {
		super(cantidadDisponible, numeroSerie,precioBase);
		this.marca = marca;
		setTipo(tipo);
		setMemoria(memoria);
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		if("DDR5".equalsIgnoreCase(tipo)|| "DDR4".equalsIgnoreCase(tipo) || "DDR3".equalsIgnoreCase(tipo) || "DDR2".equalsIgnoreCase(tipo)|| "DDR".equalsIgnoreCase(tipo))
			this.tipo = tipo;
		else
			throw new IllegalArgumentException("No se ingresó un tipo de RAM comercial válida");
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
	@Override
	public double calcularPrecio() {
		double aporteMemoria = memoria * 10; 
		double aporteTipo = "DDR5".equalsIgnoreCase(tipo) ? 60 : "DDR4".equalsIgnoreCase(tipo) ? 45 : "DDR3".equalsIgnoreCase(tipo) ? 30 :"DDR2".equalsIgnoreCase(tipo) ? 20 : 15;
		return precioBase + aporteMemoria + aporteTipo;
	} 

}
