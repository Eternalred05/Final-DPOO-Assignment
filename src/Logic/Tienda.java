package Logic;
import java.util.ArrayList;
public class Tienda {
	private String nombre;
	private String id;
	private String direccion;
	private String telefono;
	private Gerente gerente;
	private ArrayList<Trabajador> trabajadores;
	private ArrayList<PC> computadoras;
	private ArrayList<Componente> componentes;
	public Tienda(String nombre, String id, String direccion, String telefono, Gerente gerente) {
		setNombre(nombre);
		setId(id);
		setDireccion(direccion);
		setTelefono(telefono);
		setGerente(gerente);
		trabajadores = new ArrayList<Trabajador>();
		computadoras = new ArrayList<PC>();
		componentes = new ArrayList<Componente>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(!nombre.isEmpty())
			this.nombre = nombre;
		else
			throw new IllegalArgumentException("El nombre de la tienda está vacío.");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(!id.isEmpty())
			this.id = id;
		else
			throw new IllegalArgumentException("El ID de la tienda está vacío.");
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if(!direccion.isEmpty())
			this.direccion = direccion;
		else
			throw new IllegalArgumentException("La dirección de la tienda está vacía.");
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if(!telefono.isEmpty()){
			if(telefono.length() == 8){
				boolean letter = false;
				for (char c : telefono.toCharArray()) {
					if (!Character.isDigit(c))
						letter = true;
				}
				if(!letter)
					this.telefono = telefono;
				else
					throw new IllegalArgumentException("No puede contener letras el teléfono.");
			}
			else
				throw new IllegalArgumentException("El teléfono debe tener 8 dígitos.");
		}
		else
			throw new IllegalArgumentException("El teléfono de la tienda está vacío.");
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		if(gerente != null)
			this.gerente = gerente;
		else
			throw new IllegalArgumentException("No puede ser null el gerente.");
	}

	public void addTrabajador(Trabajador t) {
		if(t != null)
			trabajadores.add(t);
		else
			throw new IllegalArgumentException("No puede ser null el trabajador.");
	}
	public void addPC(PC p) {
		if(p != null)
			computadoras.add(p);
		else
			throw new IllegalArgumentException("No puede ser null la PC.");
	}

	public void addComponente(Componente c) {
		if(c != null)
			componentes.add(c);
		else
			throw new IllegalArgumentException("No puede ser null el componente.");
	}

	public ArrayList<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public ArrayList<PC> getComputadoras() {
		return computadoras;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

}

