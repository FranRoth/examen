package ar.com.plug.examen.domain.service;

import java.util.List;

import ar.com.plug.examen.domain.model.Vendedor;

public interface IVendedorService {
	
	public List<Vendedor> listarVendedor()  throws Exception;
	
	public Vendedor agregar(Vendedor v) throws Exception;
	
	public Vendedor actualizar(Long id, Vendedor v) throws Exception;
	
	public String eliminar(Vendedor v) throws Exception;
	


}
