package Logic;
import java.util.ArrayList;
public class PC {
	private Motherboard motherboardPC;
	private CPU cpuPC;
	private ArrayList<RAM> ramsPC; // La pc solo cuenta con 4 zocalos de ram
	private ArrayList<HDD> hddsPC; // se asume que la pc solo puede tener 4 discos duros

	public PC(Motherboard motherboardPC, CPU cpuPC) {

	}

	public double calcularPrecioTotal() {
		double total = 0;
		total += motherboardPC.calcularPrecio()+ cpuPC.calcularPrecio();
		return total;
	}
}
