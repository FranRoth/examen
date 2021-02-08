package ar.com.plug.examen.domain.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ar.com.plug.examen.controller.ClienteController;
import ar.com.plug.examen.domain.model.Producto;
import ar.com.plug.examen.domain.model.Vendedor;
import ar.com.plug.examen.domain.repository.VendedorRepository;
import ar.com.plug.examen.domain.service.IVendedorService;

public class VendedorServiceImpl implements IVendedorService{
	

	private final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	VendedorRepository vendedorRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<Vendedor> listarVendedor() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendedor agregar(Vendedor v) {
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Vendedor vender = modelMapper.map(v, Vendedor.class);
		vender = vendedorRepository.saveAndFlush(vender);
		v = modelMapper.map(vender, Vendedor.class);
		logger.info("Finalizo: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return v;
	}

	@Override
	public  Vendedor actualizar(Long id, Vendedor vendedor){
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Vendedor vender = modelMapper.map(vendedor, Vendedor.class);
		vender = vendedorRepository.findById(id);
		vender.setNombreVendedor(vendedor.getNombreVendedor());
		vender.setApellidoVendedor(vendedor.getApellidoVendedor());
		vender = vendedorRepository.saveAndFlush(vender);
		vender = modelMapper.map(vender, Vendedor.class);
		logger.info("Finalizo: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return vender;
	}

	@Override
	public String eliminar(Vendedor vendedor) {
		String succes;
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Vendedor vender = modelMapper.map(vendedor, Vendedor.class);
		vendedorRepository.delete(vender);		
		succes = "Se elimino el producto " + vendedor.getNombreVendedor();
		logger.info("Finalizo: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return succes;		
	} 

}
