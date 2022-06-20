package recuperacionColecciones.utils;

import java.util.HashSet;
import java.util.Set;

public class Catalogo {
	
	Set<Producto> conjuntoProductos= new HashSet<>();

	public Catalogo() {
		super();
	}
	public void addProducto(Producto nuevoProducto) {
		conjuntoProductos.add(nuevoProducto);
	}
	
	public String mostrarProductos() {
		StringBuilder sb=new StringBuilder();
		for (Producto i: conjuntoProductos) {
			sb.append(i);
		}
		return sb.toString();
		
	}
	
	public String mostrarProductosActivos() {
		Set<Producto> nuevoProductos= new HashSet<>();
		for(Producto i: conjuntoProductos) {
			if(i.isActivo()) {
				nuevoProductos.add(i);
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for (Producto i: nuevoProductos) {
			sb.append(i);
		}
		return sb.toString();
		
	}
	
	@Override
	public String toString() {
		return "Catalogo [conjuntoProductos=" + conjuntoProductos + "]";
	}
	
	
	
	

}
