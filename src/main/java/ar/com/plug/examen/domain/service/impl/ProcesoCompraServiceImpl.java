package ar.com.plug.examen.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.plug.examen.app.api.CompraApi;
import ar.com.plug.examen.controller.ClienteController;
import ar.com.plug.examen.domain.model.Cliente;
import ar.com.plug.examen.domain.model.Compra;
import ar.com.plug.examen.domain.model.Producto;
import ar.com.plug.examen.domain.model.Vendedor;
import ar.com.plug.examen.domain.repository.ClienteRepository;
import ar.com.plug.examen.domain.repository.CompraRepository;
import ar.com.plug.examen.domain.repository.ProductoRepository;
import ar.com.plug.examen.domain.repository.VendedorRepository;
import ar.com.plug.examen.domain.service.ICompraService;

public class ProcesoCompraServiceImpl implements ICompraService{
	
	private final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ProductoRepository productoRepository;

	@Autowired
	VendedorRepository vendedorRepository;

	@Autowired
	CompraRepository compraRepository;

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public CompraApi crear(CompraApi compraApi) {
		logger.info("Inicio: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Compra compras = modelMapper.map(compraApi, Compra.class);
		Cliente clientes = clienteRepository.findById(compraApi.getCliente().getId());
		Producto productos = productoRepository.findById(compraApi.getProduco().getId());
		Vendedor vendedores = vendedorRepository.findById(compraApi.getVendedor().getIdVendedor());
		compras.setCliente(clientes);
		compras.setProducto(productos);
		compras.setVendedor(vendedores);
		compras = compraRepository.saveAndFlush(compras);
		compraApi = modelMapper.map(compras, CompraApi.class);
		logger.info("Finalizo: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return compraApi;
	}


	@Override
	public List<CompraApi> buscar() {
		logger.info("Inicio: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		List<CompraApi> comprasList = new ArrayList<CompraApi>();
		List<Compra> compras = compraRepository.findAll();
		
		compras.forEach(compra -> {
			CompraApi compraApi = modelMapper.map(compra, CompraApi.class);
			compraApi.setCliente(modelMapper.map(compra.getCliente(), Cliente.class));
			compraApi.setProduco(modelMapper.map(compra.getProducto(), Producto.class));
			compraApi.setVendedor(modelMapper.map(compra.getVendedor(), Vendedor.class));
			comprasList.add(compraApi);
		});
		
		logger.info("Finalizo: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return comprasList;
	}

}
