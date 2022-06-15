package recuperacionColecciones.utils;

import java.util.ArrayList;
import java.util.List;

public class Linea {
	
	private Integer id=1;
	private String codigo;
	private Integer cantidad;
	private Double importe;
	private Producto producto;
	private static Integer secuencia=0;
	
	public Linea() {
		super();	
	}

	public Linea(String codigo, Producto nuevoproducto,Integer cantidad, double importe) {
		super();
		this.id = secuencia++;
		this.codigo = codigo;
		this.producto=nuevoproducto;
		this.cantidad=cantidad;
		this.importe=cantidad*producto.getPrecioUnitario();
		
	}
	
	public boolean addProducto(Producto nuevoProducto) {
		boolean resultado=false;
		if(nuevoProducto.getFechaBaja()==null && this.importe>0) {
			setProducto(nuevoProducto);
			resultado=true;
		}
		return resultado;
		
	}
	
	public boolean eliminarProducto(Integer idProducto) {
		boolean resultado=false;
		if(this.producto.getId().equals(idProducto)) {
			producto=null;
			resultado=true;
		}
		return resultado;
		
	}
	
	public boolean vaciarLinea() {
		this.cantidad=null;
		this.codigo=null;
		this.id=null;
		this.importe=null;
		this.producto=null;
		return true;
		
	}

	@Override
	public String toString() {
		return "Linea [id=" + id + ", codigo=" + codigo + ", cantidad=" + cantidad + ", importe=" + importe + "]";
	}
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	
	
	
	

}
