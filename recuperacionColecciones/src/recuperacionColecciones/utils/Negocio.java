package recuperacionColecciones.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Negocio {
	
	//negocio lleva 3 colecciones que son catalogo, cliente, pedido
	
	private List<Catalogo> listaCatalogo= new ArrayList<Catalogo>();
	
	private List<Pedido> listaPedido= new ArrayList<Pedido>();
	
	private List<Cliente> listaClientes= new ArrayList<Cliente>();
	
	
	public Negocio() {
		super();
	}
	
	public boolean addCliente(Cliente nuevoCliente) {
		boolean resultado=false;
		if(!listaClientes.contains(nuevoCliente)) {
			listaClientes.add(nuevoCliente);
			resultado=true;
		}
		return resultado;
		
	}
	
	public boolean eliminarCliente(Cliente antiguoCliente) {
		boolean resultado=false;
		if(listaClientes.contains(antiguoCliente)) {
			listaClientes.remove(antiguoCliente);
			resultado=true;
		}
		return resultado;
	}
	
	public String listarClientePorImporteVenta() {
		listaPedido.sort(new Comparator<Pedido>() {

			@Override
			public int compare(Pedido o1, Pedido o2) {
				// TODO Auto-generated method stub
				return o1.getCostePedido().compareTo(o2.getCostePedido());
			}
		});
		StringBuilder sb=new StringBuilder();
		for (Pedido i: listaPedido) {
			sb.append(i.getCostePedido());
			sb.append(i.getCliente());
		}
		
		return sb.toString();
		
	}
	
	public String listarClientePorEdad() {
		
		/*Set<Cliente> conjunto = new HashSet<>();
		new ArrayList<>(conjunto);*/
		listaClientes.sort(new Comparator<Cliente>() {

			@Override
			public int compare(Cliente o1, Cliente o2) {
				return o1.getFechaNac().compareTo(o2.getFechaNac());
			}
		});
		return listaClientes.toString();
		
	}
	
	public String mostrarProductosPorClientes() {
		StringBuilder sb=new StringBuilder();
		Map<Cliente,Set<Producto>> productosPorCliente= new HashMap<>();
		for (Pedido i: listaPedido) {
			productosPorCliente.put(i.getCliente(), new HashSet<>());
			for(Linea l: i.getListaLinea()) {
				productosPorCliente.get(i.getCliente()).add(l.getProducto());
			}
		}
		return productosPorCliente.toString();
		
	}
	
	public String mostrarPedidosYLineasPorId() {
		listaPedido.sort(new Comparator<Pedido>() {

			@Override
			public int compare(Pedido o1, Pedido o2) {
				// TODO Auto-generated method stub
				return o1.getId().compareTo(o2.getId());
			}
		});
		for (Pedido i: listaPedido) {
			i.getListaLinea().sort(new Comparator<Linea>() {

				@Override
				public int compare(Linea o1, Linea o2) {
					// TODO Auto-generated method stub
					return o1.getId().compareTo(o2.getId());
				}
			});
		}
		StringBuilder sb=new StringBuilder();
		for (Pedido p: listaPedido) {
			sb.append(p);
		}
		return sb.toString();
		
	}
	
	public String mostrarPedidosYLineasPorPrecio() {
		listaPedido.sort(new Comparator<Pedido>() {

			@Override
			public int compare(Pedido o1, Pedido o2) {
				// TODO Auto-generated method stub
				return o1.getCostePedido().compareTo(o2.getCostePedido());
			}
		});
		for (Pedido i: listaPedido) {
			i.getListaLinea().sort(new Comparator<Linea>() {

				@Override
				public int compare(Linea o1, Linea o2) {
					// TODO Auto-generated method stub
					return o1.getImporte().compareTo(o2.getImporte());
				}
			});
		}
		StringBuilder sb=new StringBuilder();
		for(Pedido p: listaPedido) {
			sb.append(p);
		}
		return sb.toString();
		
	}
	
	public Pedido pedidoConMayorCantidadDeProductos() {
		Pedido pedidoMayor=null;
		Integer pedidMayor=0;
		for(Pedido i: listaPedido) {
			if(i.cantidadMayorDePedido()>pedidMayor) {
				pedidMayor=i.cantidadMayorDePedido();
				pedidoMayor=i;
			}
		}
		
		return pedidoMayor;
	}
	
	public Pedido mediaPedidoporPrecioUnitarioMasAlto() {
		Double mediaPrecio=0.0;
		Double contador=0.0;
		Pedido pedidoMedia=null;
		for (Pedido i: listaPedido) {
			mediaPrecio=i.getCostePedido()/i.getNumeroProductos();
			if(mediaPrecio>contador) {
				contador=mediaPrecio;
				pedidoMedia=i;	
			}
		}
		return pedidoMedia;
		
	}
	
	public Pedido mediaPedidoporPrecioUnitarioMasBajo() {
		Double mediaPrecio=0.0;
		Double contador=9999999.0;
		Pedido pedidoMedia=null;
		for (Pedido i: listaPedido) {
			mediaPrecio=i.getCostePedido()/i.getNumeroProductos();
			if(mediaPrecio<contador) {
				contador=mediaPrecio;
				pedidoMedia=i;	
			}
		}
		return pedidoMedia;
		
	}
	
	public Pedido productoMasCaro() {
		Pedido p1=new Pedido();
		Double valor=0.0;
		for(Pedido i: listaPedido) {
			for(Linea l: i.getListaLinea()) {
				if(l.getProducto().getPrecioUnitario()>valor) {
					valor=l.getProducto().getPrecioUnitario();
					p1=i;
				}
			}
		}
		return p1;
		
	}
	
	public Pedido productoMasBarato() {
		Pedido p1=new Pedido();
		Double valor=9999999.0;
		for(Pedido i: listaPedido) {
			for(Linea l: i.getListaLinea()) {
				if(l.getProducto().getPrecioUnitario()<valor) {
					valor=l.getProducto().getPrecioUnitario();
					p1=i;
				}
			}
		}
		return p1;
		
	}
	
	public Cliente clienteConProductoMasComprado() {
		Map<Cliente,Integer> clienteConPedidos= new HashMap<>();
		for(Pedido i : listaPedido) {	
			if(!clienteConPedidos.containsKey(i.getCliente())) {
				clienteConPedidos.put(i.getCliente(), i.getNumeroProductos());
			}else if(clienteConPedidos.containsKey(i.getCliente())) {
				clienteConPedidos.put(i.getCliente(), clienteConPedidos.get(i.getCliente())+i.getNumeroProductos());
			}
		}
		Cliente c1=null;
		Integer valor=0;
		for(Cliente e: clienteConPedidos.keySet()) {
			if(clienteConPedidos.get(e)>valor) {
				c1=e;
				valor=clienteConPedidos.get(e);
			}
		}
		
		return c1;
		
	}
	
	public Cliente clienteVip() {
		Map<Cliente,Double> clienteConPedidos= new HashMap<>();
		for(Pedido i : listaPedido) {	
			if(!clienteConPedidos.containsKey(i.getCliente())) {
				clienteConPedidos.put(i.getCliente(), i.getCostePedido());
			}else if(clienteConPedidos.containsKey(i.getCliente())) {
				clienteConPedidos.put(i.getCliente(), clienteConPedidos.get(i.getCliente())+i.getCostePedido());
			}
		}
		Cliente c1=null;
		Double valor=0.0;
		for(Cliente e: clienteConPedidos.keySet()) {
			if(clienteConPedidos.get(e)>valor) {
				c1=e;
				valor=clienteConPedidos.get(e);
			}
		}
		
		return c1;
		
	}
	
	public Producto productoMasVendido() {
		Map<Producto,Integer> cantidadPorProdructo= new HashMap<>();
		for(Pedido a: listaPedido) {
			for(Linea i: a.getListaLinea()) {
				if(!cantidadPorProdructo.containsKey(i.getProducto())) {
					cantidadPorProdructo.put(i.getProducto(), i.getCantidad());
				}else if(cantidadPorProdructo.containsKey(i.getProducto())) {
					cantidadPorProdructo.put(i.getProducto(), cantidadPorProdructo.get(i.getProducto())+i.getCantidad());
				}
			}
		}
		
		Producto p1=null;
		Integer valor=0;
		
		for(Producto e: cantidadPorProdructo.keySet()) {
			if(cantidadPorProdructo.get(e)>valor) {
				p1=e;
				valor=cantidadPorProdructo.get(e);
			}
		}
		return p1;
		
	}
	
	
	
	

}
