package Logic;
import java.util.ArrayList;
public class PC {
	String id;
	private Motherboard motherboardPC;
	private CPU cpuPC;
	private ArrayList<RAM> ramsPC; // La pc solo cuenta con 4 zocalos de ram
	private ArrayList<HDD> hddsPC; // se asume que la pc solo puede tener 4 discos duros

	public PC(String id, Motherboard motherboardPC, CPU cpuPC) {
		setId(id);
		setMotherboardPC(motherboardPC);
		setCpuPC(cpuPC);
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Motherboard getMotherboardPC() {
		return motherboardPC;
	}

	public void setMotherboardPC(Motherboard motherboardPC) {
		if(motherboardPC != null)
			this.motherboardPC = motherboardPC;
		else
			throw new IllegalArgumentException("La motherboard esta vacia");
	}

	public CPU getCpuPC() {
		return cpuPC;
	}

	public void setCpuPC(CPU cpuPC) {
		if(cpuPC != null)
			this.cpuPC = cpuPC;
		else
			throw new IllegalArgumentException("La CPU esta vacia");
	}

	public ArrayList<RAM> getRamsPC() {
		return ramsPC;
	}

	public void addRamsPC(ArrayList<RAM> ramsPC) {
		if(ramsPC != null){
			if(this.ramsPC.size() <= 4){
				this.ramsPC = ramsPC;
			} else
				throw new IllegalArgumentException("Solo se pueden anadir 4 modulos de RAM");	
		}else
			throw new IllegalArgumentException("Las rams de la PC estan vacias");

	}

	public ArrayList<HDD> getHddsPC() {
		return hddsPC;
	}

	public void setHddsPC(ArrayList<HDD> hddsPC) {
		this.hddsPC = hddsPC;
	}

	public double calcularPrecioTotal() {
		double total = 0;
		total += motherboardPC.calcularPrecio()+ cpuPC.calcularPrecio();
		return total;
	}
}
