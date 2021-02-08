package ar.com.plug.examen.domain.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.plug.examen.controller.ClienteController;
import ar.com.plug.examen.domain.model.Cliente;
import ar.com.plug.examen.domain.repository.ClienteRepository;
import ar.com.plug.examen.domain.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	
private final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public Cliente agregar(Cliente c) {
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Cliente client = modelMapper.map(c, Cliente.class);
		client = clienteRepository.saveAndFlush(client);
		c = modelMapper.map(client, Cliente.class);
		logger.info("Finalizo: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return c;
	}
	
	@Override
	public  Cliente actualizar(Long id, Cliente cliente){
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Cliente client = modelMapper.map(cliente, Cliente.class);
		client = clienteRepository.findById(id);
		client.setName(cliente.getName());
		client.setApellido(cliente.getApellido());
		client = clienteRepository.saveAndFlush(client);
		cliente = modelMapper.map(client, Cliente.class);
		logger.info("Finalizo: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return cliente;
	}
	
	@Override
	public String eliminar(Cliente c) {
		String succes;
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Cliente client = modelMapper.map(c, Cliente.class);
		clienteRepository.delete(client);		
		succes = "Se limino el cliente " + c.getName();
		logger.info("Finalizo: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return succes;
		
	} 


	@Override
	public List<Cliente> listarClientes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente listClienteNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}




}
