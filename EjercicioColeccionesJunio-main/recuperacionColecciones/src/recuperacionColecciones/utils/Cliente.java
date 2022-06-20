package recuperacionColecciones.utils;

import java.time.LocalDate;

public class Cliente {
	
	private Integer id;
	private String nombre;
	private String apellidos;
	private String email;
	private String dni;
	private LocalDate fechaNac;
	private Genero genero;
	
	
	public Cliente() {
		super();
	}


	public Cliente(Integer id, String nombre, String apellidos, String email, String dni, LocalDate fechaNac,
			Genero genero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.dni = dni;
		this.fechaNac = fechaNac;
		this.genero = genero;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", dni="
				+ dni + ", fechaNac=" + fechaNac + ", genero=" + genero + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public LocalDate getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
	
	

}
