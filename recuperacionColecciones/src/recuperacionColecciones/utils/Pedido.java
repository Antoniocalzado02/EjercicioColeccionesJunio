package recuperacionColecciones.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Pedido {
	
	private Integer id=0;
	private String codigo;
	private Status status;
	private Cliente cliente;
	private List<Linea> listaLinea= new ArrayList<Linea>();
	private static Integer secuencia=0;
	
	
	public Pedido() {
		super();
	}


	public Pedido(String codigo,Status estadopedido ,Cliente nuevoCliente) {
		super();
		this.id = secuencia++;
		this.status=estadopedido;
		this.codigo = codigo;
		this.cliente=nuevoCliente;
		
	}
	
	public void addLinea(Linea nuevaLinea) {
		listaLinea.add(nuevaLinea);
	}
	
	public void borrarLinea(Integer idExistente) {
		Iterator <Linea> it=listaLinea.iterator();
		while (it.hasNext()) {
			Linea linea=it.next();
			if(linea.getId().equals(idExistente) && status!=status.ENVIADO) {
				listaLinea.remove(linea);
			}
		}
		/*
		for (Linea i: listaLinea) {
			if(i.getId().equals(idExistente)){
			
			}
		}*/
	}
	
	public void vaciarPedido() {
		listaLinea.clear();
	}
	
	public Double getCostePedido() {
		double cantidadPedido=0;
		for (Linea i: listaLinea) {
			cantidadPedido+=i.getImporte();
		}
		return cantidadPedido;
		
	}
	
	public Integer getNumeroProductos() {
		Integer cantidadPedido=0;
		for (Linea i: listaLinea) {
			cantidadPedido+=i.getCantidad();
		}
		return cantidadPedido;
		
	}
	
	public String mostrarLineasPorIdAscendente() {
		listaLinea.sort(new Comparator<Linea>() {

			@Override
			public int compare(Linea o1, Linea o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});
		return listaLinea.toString();
		
	}
	
	public String mostrarLineasPorPrecioDescendente() {
		listaLinea.sort(new Comparator<Linea>() {

			@Override
			public int compare(Linea o1, Linea o2) {
				return o2.getImporte().compareTo(o1.getImporte());
			}
		});
		return listaLinea.toString();
		
	}
	
	public String obtenerProductos() {
		Producto p1= new Producto();
		for (Linea i: listaLinea) {
			p1=i.getProducto();
		}
		return p1.toString();
		
	}


	@Override
	public String toString() {
		return "Pedido [id=" + id + ", codigo=" + codigo + ", status=" + status + "]";
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


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Linea> getListaLinea() {
		return listaLinea;
	}


	public void setListaLinea(List<Linea> listaLinea) {
		this.listaLinea = listaLinea;
	}
	
	public int cantidadMayorDePedido() {
		Integer cantidadMayor=0;
		for (Linea i: listaLinea) {
			cantidadMayor+=i.getCantidad();
		}
		return cantidadMayor;
		
	}
	
	public Double precioUnitariodelPedido() {
		Double mediaProductos=0.0;
		
		
		
		return null ;
		
	}
	
	

	

}
