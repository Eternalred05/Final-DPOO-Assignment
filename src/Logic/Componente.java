package Logic;
public abstract class Componente {
	protected int cantidadDisponible;
	protected String numeroSerie;
	protected double precioBase;
	protected String marca;

	public Componente(int cantidadDisponible, String numeroSerie, double precioBase, String marca) {
		setCantidadDisponible(cantidadDisponible);
		setNumeroSerie(numeroSerie);
		setPrecioBase(precioBase);
		setMarca(marca);
	}

	public void setPrecioBase(double precioBase){
		if(precioBase > 0)
			this.precioBase = precioBase;
		else
			throw new IllegalArgumentException("El precio deberia ser mayor que 0");
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		if(numeroSerie != null && !numeroSerie.isEmpty())
			this.numeroSerie = numeroSerie;
		else
			throw new IllegalArgumentException("El numero de serie no puede estar vacío");
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}
	public void setCantidadDisponible(int cantidadDisponible) {
		if(cantidadDisponible >= 0)
			this.cantidadDisponible = cantidadDisponible;
		else
			throw new IllegalArgumentException("La cantidad disponible debe ser mayor a 0");
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

	public abstract double calcularPrecio();
}

