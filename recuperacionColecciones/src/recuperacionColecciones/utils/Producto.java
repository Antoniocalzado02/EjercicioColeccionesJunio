package recuperacionColecciones.utils;

import java.time.LocalDate;

public class Producto {
	
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private String nombre;
	private Integer id;
	private String descripcion;
	private double precioUnitario;
	
	
	
	
	public Producto() {
		super();
	}

	public Producto(LocalDate fechaAlta, LocalDate fechaBaja, String nombre, Integer id, String descripcion,
			double precioUnitario) {
		super();
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.nombre = nombre;
		this.id = id;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}
	
	public boolean isActivo() {
		boolean resultado=false;
		if(this.fechaBaja==null) {
			resultado=true;
		}
		return resultado;
		
	}

	@Override
	public String toString() {
		return "Producto [fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", nombre=" + nombre + ", id=" + id
				+ ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + "]";
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public LocalDate getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
	
	
	

}
