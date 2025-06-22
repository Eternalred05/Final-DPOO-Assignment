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
			if(a.getId().equals(t.getId()))
				throw new IllegalArgumentException("Ya se ingresó un trabajador con este id.");
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

	public void addPC(String id,Motherboard m,CPU c, ArrayList<RAM> r, ArrayList<HDD> h){
		PC pc = new PC(id, m, c);
		pc.setHddsPC(h);
		pc.addRamsPC(r);
		for(PC p : computadoras)
			if(p.getId().equalsIgnoreCase(id))
				throw new IllegalArgumentException("Ya se ingresó una computadora con este ID.");
		computadoras.add(pc);
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

	public ArrayList<Componente> ramsPorTipoyMemoria(String tipo, double memoria){ // RAMS con memorias con tamaño mayores que uno dado
		ArrayList<Componente> listado = new ArrayList<>();
		for(Componente c : componentes)
			if(c instanceof RAM)
				if(((RAM) c).getMemoria() >= memoria && ((RAM)c).getTipo().equals(tipo))
					listado.add(c);
		return listado;
	}

	public int buscarRAMS(){ // funcion para el reporte de las RAMS 
		int cantidad = 0;
		for(Componente c : componentes)
			if(c instanceof RAM)
				cantidad++;
		return cantidad;
	}
	// funcion para buscar componentes
	public int buscarMotherboards(){ // funcion para el reporte de las RAMS 
		int cantidad = 0;
		for(Componente c : componentes)
			if(c instanceof Motherboard)
				cantidad++;
		return cantidad;
	}
	public int buscarCPUS(){ // funcion para el reporte de las RAMS 
		int cantidad = 0;
		for(Componente c : componentes)
			if(c instanceof CPU)
				cantidad++;
		return cantidad;
	}
	public int buscarHDDS(){ // funcion para el reporte de las RAMS 
		int cantidad = 0;
		for(Componente c : componentes)
			if(c instanceof HDD)
				cantidad++;
		return cantidad;

	}
	// nuevos para crear PC
	public ArrayList<Componente> listaMotherBoards() {
		ArrayList<Componente> motherboards = new ArrayList<>();
		for (Componente c : componentes)
			if(c instanceof Motherboard)
				motherboards.add(c);
		return motherboards;
	}
	public ArrayList<Componente> listaCPUcompatMotherboard(String socket) {
		ArrayList<Componente> cpus = new ArrayList<>();
		for (Componente c : componentes)
			if(c instanceof CPU && ((CPU)c).getSocket().equals(socket))
				cpus.add(c);
		return cpus;
	}
	public Motherboard encontrarMotherBoardPorID(String ID){
		int posicion = -1;
		for(int i=0; i<componentes.size() && posicion == -1;i++)
			if(componentes.get(i) instanceof Motherboard && componentes.get(i).getNumeroSerie().equals(ID))
				posicion = i;
		return (Motherboard)componentes.get(posicion);
	}

	public CPU CPUPorID(String id){
		int posicion = -1;
		for(int i=0; i<componentes.size() && posicion == -1;i++)
			if(componentes.get(i) instanceof CPU && componentes.get(i).getNumeroSerie().equals(id))
				posicion = i;
		return (CPU)componentes.get(posicion);
	}
	public RAM RAMPorID(String id){
		int posicion = -1;
		for(int i=0; i<componentes.size() && posicion == -1;i++)
			if(componentes.get(i) instanceof RAM && componentes.get(i).getNumeroSerie().equals(id))
				posicion = i;
		return (RAM)componentes.get(posicion);
	}
	public ArrayList<Componente> listaHDDcompatMotherboard(ArrayList<String> conexiones) {
		ArrayList<Componente> hdds = new ArrayList<>();
		for (Componente c : componentes)
			if(c instanceof HDD && conexiones.contains(((HDD)c).getTipoConexion()))
				hdds.add(c);
		return hdds;
	}

	public ArrayList<Componente> listaRAMcompatMotherboard(String tipoMem) {
		ArrayList<Componente> rams = new ArrayList<>();
		for (Componente c : componentes)
			if(c instanceof RAM && ((RAM)c).getTipo().equals(tipoMem))
				rams.add(c);
		return rams;
	}
	public HDD HDDPorID(String id){
		int posicion = -1;
		for(int i=0; i<componentes.size() && posicion == -1;i++)
			if(componentes.get(i) instanceof HDD && componentes.get(i).getNumeroSerie().equals(id))
				posicion = i;
		return (HDD)componentes.get(posicion);
	}
	// Buscar posiciones de los objetos

	public int posTrabajadorPorID(String ID){
		int posicion = -1;
		for(int i=0; i<trabajadores.size() && posicion == -1;i++)
			if(trabajadores.get(i).getId().equals(ID))
				posicion = i;
		return posicion;
	}

	public int posMotherboardPorID(String ID){
		int posicion = -1;
		for(int i=0; i<componentes.size() && posicion == -1;i++)
			if(componentes.get(i) instanceof Motherboard && componentes.get(i).getNumeroSerie().equals(ID))
				posicion = i;
		return posicion;
	}

	public int posRAMPorID(String ID){
		int posicion = -1;
		for(int i=0; i<componentes.size() && posicion == -1;i++)
			if(componentes.get(i) instanceof RAM && componentes.get(i).getNumeroSerie().equals(ID))
				posicion = i;
		return posicion;
	}

	public int posCPUPorID(String ID){
		int posicion = -1;
		for(int i=0; i<componentes.size() && posicion == -1;i++)
			if(componentes.get(i) instanceof CPU && componentes.get(i).getNumeroSerie().equals(ID))
				posicion = i;
		return posicion;
	}

	public int posHDDPorID(String ID){
		int posicion = -1;
		for(int i=0; i<componentes.size() && posicion == -1;i++)
			if(componentes.get(i) instanceof HDD && componentes.get(i).getNumeroSerie().equals(ID))
				posicion = i;
		return posicion;
	}

	public int posPCPorID(String ID){
		int posicion = -1;
		for(int i=0; i<computadoras.size() && posicion == -1;i++)
			if(computadoras.get(i).getId().equals(ID))
				posicion = i;
		return posicion;
	}

	public void actualizarComponentes(PC pc){
		String id;
		int pos;
		int cant;
		id = pc.getMotherboardPC().getNumeroSerie();
		pos = posMotherboardPorID(id);
		cant = componentes.get(pos).getCantidadDisponible();
		componentes.get(pos).setCantidadDisponible(cant-1);
		//CPU
		id = pc.getCpuPC().getNumeroSerie();
		pos = posCPUPorID(id);
		cant = componentes.get(pos).getCantidadDisponible();
		componentes.get(pos).setCantidadDisponible(cant-1);
		// RAMS
		for(RAM r : pc.getRamsPC()){
			id = r.getNumeroSerie();
			pos = posRAMPorID(id);
			cant = componentes.get(pos).getCantidadDisponible();
			componentes.get(pos).setCantidadDisponible(cant-1);
		}

		for(HDD h : pc.getHddsPC()){
			id = h.getNumeroSerie();
			pos = posHDDPorID(id);
			cant = componentes.get(pos).getCantidadDisponible();
			componentes.get(pos).setCantidadDisponible(cant-1);
		}	
	}
	public void eliminarComponentesFueraStock() {
		for (int i = 0; i<componentes.size() ; i++) {
			Componente c = componentes.get(i);
			if (c.getCantidadDisponible() == 0) {
				componentes.remove(i);
			}
		}
	} 
	public void editarTrabajador(Trabajador t, String nombre, String apellidos,double salario,String cargo, String escolaridad){
		@SuppressWarnings("unused")
		Trabajador nuevo = new Trabajador(nombre, apellidos, t.getId(),t.getNumeroTrabajador(), salario,escolaridad, cargo);

		t.setNombre(nombre);
		t.setApellidos(apellidos);
		t.setCargo(cargo);
		t.setNivelEscolar(escolaridad);
		t.setSalario(salario);
	}

	public void editarRAM(RAM r,int cantidadDisponible, String marca, double memoria , String tipo, double precioBase){
		@SuppressWarnings("unused")
		RAM nuevo = new RAM (cantidadDisponible,r.getNumeroSerie(),marca,memoria,tipo,precioBase);

		r.setCantidadDisponible(cantidadDisponible);
		r.setMarca(marca);
		r.setMemoria(memoria);
		r.setTipo(tipo);
		r.setPrecioBase(precioBase);
	}

	public void editarCPU(CPU c,int cantidadDisponible,String marca, String modelo, String socket, double velocidad, double precioBase){
		@SuppressWarnings("unused")
		CPU nuevo = new CPU(cantidadDisponible, c.getNumeroSerie(), marca, modelo, socket, velocidad, precioBase);

		c.setCantidadDisponible(cantidadDisponible);
		c.setMarca(marca);
		c.setModelo(modelo);
		c.setSocket(socket);
		c.setVelocidad(velocidad);
		c.setPrecioBase(precioBase);
	}

	public void editarMotherboard(Motherboard m,int cantidadDisponible,String marca, String modelo,String tipoConector, String tipoMemoriaRAM, ArrayList<String> conexiones,double precioBase) {
		@SuppressWarnings("unused")
		Motherboard nuevo = new Motherboard(cantidadDisponible, m.getNumeroSerie(), marca, modelo, tipoConector, tipoMemoriaRAM, conexiones, precioBase);

		m.setCantidadDisponible(cantidadDisponible);
		m.setMarca(marca);
		m.setModelo(modelo);
		m.setTipoConector(tipoConector);
		m.setTipoMemoriaRAM(tipoMemoriaRAM);
		m.setPrecioBase(precioBase);
		m.getConexionesDiscos().clear();
		m.addConexionesDiscos(conexiones);
	}

	public void editarHDD(HDD h, int cantidadDisponible, String marca, String modelo,double capacidad, String tipoConexion,double precioBase){
		@SuppressWarnings("unused")
		HDD nuevo = new HDD(cantidadDisponible, h.getNumeroSerie(), marca, modelo, capacidad, tipoConexion, precioBase);

		h.setCantidadDisponible(cantidadDisponible);
		h.setMarca(marca);
		h.setModelo(modelo);
		h.setCapacidad(capacidad);
		h.setTipoConexion(tipoConexion);
		h.setPrecioBase(precioBase);
	}

	// Inicializar datos
	public static Tienda inicializarTienda(){
		Gerente gerente = new Gerente("Alexandro", "Valdés Piñeda", 2005,9,15);	
		return new Tienda("GameStop777","GAME05","Avenida 33A Calle 156, Playa","72627762",gerente);
	}

	public void inicializarTrabajadores(){
		addTrabajador("Alexandro", "Valdés Piñeda","05091568088",0, 15000, "Universitario", "Gerente");
		addTrabajador("Gloria", "Santos Rosado","06030867876",1, 5000, "Universitario", "Especialista en productos");
		addTrabajador("Jorge Luis", "Valdés Piñeda", "97070758088", 2 ,15000, "Universitario", "Especialista en software");
		addTrabajador("Javier", "Soto Villanueva", "05090160882",3,7000, "Universitario", "Asesor de ventas");
		addTrabajador("Ronal", "Sálazar Hernández", "05101568066",4,6500, "Universitario", "Especialista en software");
		addTrabajador("Aylin", "Vázquez Alvarez", "06061367412",5,4000, "Obrero Calificado", "Encargado de inventario");
		addTrabajador("Rodolfo", "Remesar Martín","72081843200", 6, 9900,"Universitario", "Especialista en software");
		addTrabajador("Cristiano", "Ronaldo Aveiro","87020501669", 7, 12000,"Universitario", "Especialista en software");
	}
	public void inicializarComponentes(){
		ArrayList<String> conexiones = new ArrayList<String>();
		conexiones.add("SATA");
		conexiones.add("SATA-2");
		conexiones.add("SATA-3");
		addMotherboard(5, "MBX-1234", "ASUS", "ROG STRIX B550-F", "LGA", "DDR4", conexiones, 179.99);
		addMotherboard(3, "MBY-5678", "Gigabyte", "AORUS X570 Master", "BGA", "DDR4", conexiones, 349.99);
		addMotherboard(7, "MBZ-9101", "MSI", "MAG B660M Mortar WiFi", "LGA", "DDR5", conexiones, 199.99);
		addMotherboard(2, "MBW-1121", "ASRock", "Z790 Taichi", "LGA", "DDR5",conexiones, 499.99);
		addMotherboard(4, "MBT-3141", "EVGA", "Z690 CLASSIFIED", "LGA", "DDR4", conexiones,449.99);
		addCPU(5, "Intel-G4400", "Intel", "Core i5-1135G7", "LGA", 4.2,150);
		addCPU(3, "AMD-Ryzen5600X", "AMD", "Ryzen 5 5600X", "PGA", 4.6, 230);
		addCPU(7, "Intel-i7-9700K", "Intel", "Core i7-9700K", "LGA", 4.9, 350);
		addCPU(2, "Threadripper3990X", "AMD", "Threadripper 3990X", "BGA", 4.3, 1500);
		addCPU(4, "Intel-XeonE5-2680", "Intel", "Xeon E5-2680 v4", "LGA", 3.3, 500);
		addRAM(5, "SM5-16G", "Samsung", 16, "DDR5", 60);
		addRAM(7, "HX4-32G", "Hynyx", 32, "DDR4", 45);
		addRAM(10, "TS5-64GB", "Toshiba", 64, "DDR5", 80);
		addRAM(20, "RZB-128G", "Razor Blade", 128, "DDR5", 120);
		addRAM(15, "MCN-8EB", "Micron", 8, "DDR2", 10);
		addHDD(5, "SM5-512G", "Samsung", "SM512HDD", 512, "SATA-3",50);
		addHDD(7, "SM7-256G", "Samsung", "SM245HDD", 256, "SATA-2",45);
		addHDD(12, "TS-128G", "Toshiba", "TS128HDD", 128, "SATA",30);
		addHDD(15, "HX5-4TB", "Hynyx", "HX4TBHDD", 4096, "SATA-3",120);
		addHDD(10, "WD-1TB", "Western Digital", "WD1024HDD", 1024, "SATA-3",90);
	}
}

