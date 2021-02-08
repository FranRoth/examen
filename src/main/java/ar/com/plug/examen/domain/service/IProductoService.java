package ar.com.plug.examen.domain.service;

import java.util.List;

import ar.com.plug.examen.domain.model.Producto;



public interface IProductoService {
	
	
	//public List<Cliente>listar();
	public List<Producto> listarProductos()  throws Exception;
	
	public Producto listProductoID(int id) throws Exception;
	
	public Producto agregar(Producto p) throws Exception;
	
	public Producto actualizar(Long id,Producto p) throws Exception;
	
	public String eliminar(Producto id) throws Exception;
	

}
