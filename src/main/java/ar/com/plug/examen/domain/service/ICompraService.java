package ar.com.plug.examen.domain.service;

import java.util.List;

import ar.com.plug.examen.app.api.CompraApi;

public interface ICompraService {
	
	public CompraApi crear(CompraApi compraApi)  throws Exception;

	public List<CompraApi> buscar() throws Exception;

}
