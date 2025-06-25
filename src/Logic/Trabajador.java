package Logic;

import java.time.DateTimeException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.time.LocalDate;

public class Trabajador {
	private String nombre;
	private String apellidos;
	private String id;
	private int numeroTrabajador;  
	private double salario;
	private String nivelEscolar; // se usara los niveles primarios, secundarios, preuniversitario, tecnico medio, obrero calificado, Universitario, Tecnico profesional.
	private String cargo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		boolean digit = false;
		if(!nombre.isEmpty()){
			nombre = Normalizer.normalize(nombre, Form.NFC);
			for (char c : nombre.toCharArray()) {
				if (!Character.isLetter(c) && !Character.isSpaceChar(c))
					digit = true;
			}
			if(!digit)
				this.nombre = nombre;
			else
				throw new IllegalArgumentException("El nombre no puede contener números.");
		}
		else
			throw new IllegalArgumentException("El nombre del trabajador está vacío.");

	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		boolean digit = false;
		if(!apellidos.isEmpty() && apellidos != null){
			apellidos = Normalizer.normalize(apellidos, Form.NFC);
			for (char c : apellidos.toCharArray()) {
				if (!Character.isLetter(c) && !Character.isSpaceChar(c))
					digit = true;
			}
			if(!digit)
				this.apellidos = apellidos;
			else
				throw new IllegalArgumentException("Los apellidos no deben contener números.");
		}
		else
			throw new IllegalArgumentException("Los apellidos están vacíos.");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id.length() == 11) {
			for(char c : id.toCharArray())
				if (Character.isLetter(c))
					throw new IllegalArgumentException("No puede contener letras.");
			char [] cadena = id.toCharArray();
			int anio = (cadena[0] - '0') * 10 + (cadena[1] - '0');
			int mes = (cadena[2] - '0') * 10 + (cadena[3] - '0');
			int dia = (cadena[4] - '0') * 10 + (cadena[5] - '0');
			int siglo = Character.getNumericValue(id.charAt(6));
			int edad;
			int anioActual = LocalDate.now().getYear();

			try {
				@SuppressWarnings("unused")
				LocalDate fechaCarnet = LocalDate.of(anio, mes, dia);
			}
			catch (DateTimeException e){
				throw new IllegalArgumentException ("La fecha del carnet es incorrecta");
			}

			if(siglo >= 6 && siglo <=8){
				edad = 2000+anio;
				if(edad > anioActual || edad==2000) // el año 2000 en si no pertenece al siglo XXI
					throw new IllegalArgumentException("El siglo de su carnet no coincide con su edad o es imposible que sea ese");	
				if((anioActual-edad)<18) // comprobar que sea mayor de edad
					throw new IllegalArgumentException("El carnet es válido pero se esta ingresando a un menor de edad");	
			}

			this.id = id;
		} 

		else throw new IllegalArgumentException("El tamaño del carnet debe ser de 11 digitos");
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if(salario>=2000 && salario <=15000)
			this.salario = salario;
		else
			throw new IllegalArgumentException ("El salario debe estar entre 2000 y 15000");
	}

	public String getNivelEscolar() {
		return nivelEscolar;
	}

	public void setNivelEscolar(String nivelEscolar) {
		if(!nivelEscolar.isEmpty())
			this.nivelEscolar = nivelEscolar;
		else
			throw new IllegalArgumentException("El nivel escolar del trabajador está vacío.");
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		if(!cargo.isEmpty())
			this.cargo = cargo;
		else
			throw new IllegalArgumentException("El cargo del trabajador está vacío.");
	}

	public int getNumeroTrabajador() {
		return numeroTrabajador;
	}

	public Trabajador(String nombre, String apellidos, String id, int numeroTrabajador,
			double salario, String nivelEscolar, String cargo) {
		setNombre(nombre);
		setApellidos(apellidos);
		setId(id);
		this.numeroTrabajador = numeroTrabajador;
		setSalario(salario);
		setNivelEscolar(nivelEscolar);
		setCargo(cargo);
	}

}

