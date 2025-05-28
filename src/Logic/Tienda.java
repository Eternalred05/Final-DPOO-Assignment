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
			throw new IllegalArgumentException("No puede estar vacío el gerente.");
	}

	public void addTrabajador(String nombre, String apellidos, String id, int numeroTrabajador,double salario, String nivelEscolar, String cargo) {
		Trabajador t = new Trabajador (nombre,apellidos,id,numeroTrabajador,salario,nivelEscolar,cargo);		
		for(Trabajador a : trabajadores){
			if(a.getNombre().toLowerCase().equals(t.getNombre().toLowerCase()) && a.getApellidos().toLowerCase().equals(t.getApellidos().toLowerCase()))
				throw new IllegalArgumentException("Ya se ingreso este trabajador con este nombre.");
			if(a.getId().equals(t.getId()))
				throw new IllegalArgumentException("Ya se ingreso un trabajador con este id.");
		}
		trabajadores.add(t);
	}

	public void addPC(PC p) {
		if(p != null)
			computadoras.add(p);
		else
			throw new IllegalArgumentException("No puede ser null la PC.");
	}

	public void addRAM(int cantidadDisponible, String numeroSerie, String marca, double memoria , String tipo, double precioBase) {
		RAM ram = new RAM(cantidadDisponible,numeroSerie,marca, memoria , tipo,precioBase);
		for(Componente c : componentes){
			if(c instanceof RAM){
				if(c.getNumeroSerie().toLowerCase().equals(ram.numeroSerie.toLowerCase()))
					throw new IllegalArgumentException("Ya se ingresó una RAM con este ID.");

			}
		}
		componentes.add(ram);
	}
	public void addMotherboard(int cantidadDisponible, String numeroSerie, String marca, String modelo,String tipoConector, String tipoMemoriaRAM, ArrayList<String> conexionesDiscos,double precioBase){
		Motherboard m = new Motherboard(cantidadDisponible,numeroSerie, marca, modelo,tipoConector,tipoMemoriaRAM,conexionesDiscos,precioBase);
		for(Componente c : componentes){
			if(c instanceof Motherboard){
				if(c.getNumeroSerie().toLowerCase().equals(m.numeroSerie.toLowerCase()))
					throw new IllegalArgumentException("Ya se ingresó una Motherboard con este ID.");
			}
		}
		componentes.add(m);
	}

	public void addCPU(int cantidadDisponible, String numeroSerie, String marca, String modelo,String socket, double velocidad, double precioBase){
		CPU cpu = new CPU(cantidadDisponible,numeroSerie,marca,modelo,socket, velocidad,precioBase);
		for(Componente c : componentes){
			if(c instanceof CPU){
				if(c.getNumeroSerie().toLowerCase().equals(cpu.numeroSerie.toLowerCase()))
					throw new IllegalArgumentException("Ya se ingresó un procesador con este ID.");
			}
		}
		componentes.add(cpu);
	}
	public void addHDD(int cantidadDisponible, String numeroSerie, String marca, String modelo,double capacidad, String tipoConexion,double precioBase){
		HDD hdd = new HDD(cantidadDisponible,numeroSerie,marca,modelo,capacidad,tipoConexion,precioBase);
		for(Componente c : componentes){
			if(c instanceof HDD){
				if(c.getNumeroSerie().toLowerCase().equals(hdd.numeroSerie.toLowerCase()))
					throw new IllegalArgumentException("Ya se ingresó un Disco Duro con este ID.");
			}
		}
		componentes.add(hdd);
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

	// Conjunto de Reportes
	public ArrayList<Trabajador> trabajadoresPorSalarioCargoEscolaridad(double salario, String cargo, String escolaridad){ // el salario de los trabajadores mayores que uno dado
		ArrayList<Trabajador> listado = new ArrayList<>();
		for(Trabajador t : trabajadores)
			if(t.getSalario() >= salario && t.getCargo().toLowerCase().equals(cargo.toLowerCase()) && t.getNivelEscolar().toLowerCase().equals(escolaridad.toLowerCase()))
				listado.add(t);
		return listado;
	}

	public ArrayList<PC> pcPorPrecio(double precio){ // pc con precios menores a un precio especificado
		ArrayList<PC> listado = new ArrayList<>();
		for(PC p : computadoras)
			if(p.calcularPrecioTotal() <= precio)
				listado.add(p);
		return listado;
	}
	public ArrayList<Componente> componentesPorMarcaPrecio(String marca, double precio){ // componentes con precios menores a un precio especificado
		ArrayList<Componente> listado = new ArrayList<>();
		for(Componente c : componentes)
			if(c.getMarca().toLowerCase().equals(marca.toLowerCase()) && c.calcularPrecio()<=precio)
				listado.add(c);
		return listado;
	}

	public ArrayList<Componente> ramsPorVelocidadMemoria(String tipo, double memoria){ // RAMS con memorias con tamaño mayores que uno dado
		ArrayList<Componente> listado = new ArrayList<>();
		for(Componente c : componentes)
			if(c instanceof RAM)
				if(((RAM) c).getMemoria() >= memoria && ((RAM)c).getTipo().equals(tipo))
					listado.add(c);
		return listado;
	}

}

