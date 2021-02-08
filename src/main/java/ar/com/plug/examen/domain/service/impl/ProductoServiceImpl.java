package ar.com.plug.examen.domain.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.plug.examen.controller.ClienteController;
import ar.com.plug.examen.domain.model.Cliente;
import ar.com.plug.examen.domain.model.Producto;
import ar.com.plug.examen.domain.repository.ProductoRepository;
import ar.com.plug.examen.domain.service.IProductoService;


@Service
public class ProductoServiceImpl implements IProductoService {
	
	private final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public Producto agregar(Producto p) {
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Producto product = modelMapper.map(p, Producto.class);
		product = productoRepository.saveAndFlush(product);
		p = modelMapper.map(product, Producto.class);
		logger.info("Finalizo: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return p;
	}

	@Override
	public  Producto actualizar(Long id, Producto producto){
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Producto product = modelMapper.map(producto, Producto.class);
		product = productoRepository.findById(id);
		product.setNombreProducto(producto.getNombreProducto());
		product.setTipoProducto(producto.getTipoProducto());
		product = productoRepository.saveAndFlush(product);
		product = modelMapper.map(product, Producto.class);
		logger.info("Finalizo: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return product;
	}
	
	@Override
	public String eliminar(Producto p) {
		String succes;
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Producto client = modelMapper.map(p, Producto.class);
		productoRepository.delete(client);		
		succes = "Se elimino el producto " + p.getNombreProducto();
		logger.info("Finalizo: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return succes;		
	} 
	

	@Override
	public List<Producto> listarProductos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto listProductoID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
