package ar.com.plug.examen.domain.service;

import java.util.List;

import ar.com.plug.examen.domain.model.Cliente;
import ar.com.plug.examen.domain.vo.ClienteVO;

public interface IClienteService {
	
	
	
	 public List<Cliente> listarClientes()  throws Exception;
	
	 public Cliente listClienteNombre(String nombre) throws Exception;
	
	 public Cliente agregar(Cliente c) throws Exception;
	
	 public Cliente actualizar(Long id, Cliente c) throws Exception;
	
	 public String eliminar(Cliente c) throws Exception;
	

}
