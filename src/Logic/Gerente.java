package Logic;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.time.DateTimeException;
import java.time.LocalDate; 
public class Gerente {
	private String nombre;
	private String apellidos;
	private LocalDate fecha;

	public Gerente(String nombre, String apellidos,int anio, int mes, int dia) {
		setNombre(nombre);
		setApellidos(apellidos);
		setFecha(anio, mes, dia);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		boolean digit = false;
		if(!nombre.isEmpty() && nombre != null){
			nombre = Normalizer.normalize(nombre, Form.NFC);
			for (char c : nombre.toCharArray()) {
				if (!Character.isLetter(c) && !Character.isSpaceChar(c))
					digit = true;
			}
			if(!digit)
				this.nombre = nombre;
			else
				throw new IllegalArgumentException("No puede contener números.");
		}
		else
			throw new IllegalArgumentException("El nombre del Gerente está vacío.");

	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		boolean digit = false;
		if(!apellidos.isEmpty() && apellidos != null){
			apellidos = Normalizer.normalize(nombre, Form.NFC);
			for (char c : apellidos.toCharArray()) {
				if (!Character.isLetter(c) && !Character.isSpaceChar(c))
					digit = true;
			}
			if(!digit)
				this.apellidos = apellidos;
			else
				throw new IllegalArgumentException("Los Apellidos no pueden contener números.");
		}
		else
			throw new IllegalArgumentException("Los Apellidos del Gerente están vacíos.");

	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(int anio, int mes, int dia) {
		LocalDate fecha = LocalDate.of(anio, mes, dia);
		if (anio < 1940) 
			throw new DateTimeException("No debe ser tan viejo el Gerente. Cambie el año");
		else if(fecha.isAfter(LocalDate.now()))
			throw new DateTimeException("La fecha no puede exceder a la fecha actual");


		else
			this.fecha = fecha;
	}

}
