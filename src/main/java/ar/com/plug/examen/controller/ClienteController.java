package ar.com.plug.examen.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.plug.examen.domain.model.Cliente;
import ar.com.plug.examen.domain.service.IClienteService;
import ar.com.plug.examen.domain.vo.ClienteVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;


@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Clase para gestionar clientes de la aplicaicon")
public class ClienteController {
	
	
	private final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private IClienteService service; 
	
	@GetMapping("/listar")
	@ApiOperation(value = "Metodo listar clientes", notes = "metodo para consultar y obtener la lista clientes")
	public  ResponseEntity<?> listar() {	
		Map<String, Object> response = new HashMap<>();
		List<Cliente> RespuestaListaClientes;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaListaClientes = service.listarClientes();
			response.put("mensaje", "lista clientes encontrados.");
			response.put("listClientes", RespuestaListaClientes);
			logger.info("Finalizo de: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Exception (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") :" + " causa: "
					+ e.getCause() + " mensaje: " + e.getMessage());
			response.put("mensaje: ", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/crearCliente")
	@ApiOperation(value = "Metodo crear clientes", notes = "metodo para clientes clientes")
	public  ResponseEntity<?> agregar(@RequestBody Cliente cliente) {	
		Map<String, Object> response = new HashMap<>();
		Cliente RespuestaCrearClientes;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaCrearClientes = service.agregar(cliente);
			response.put("mensaje", "cilentes creados.");
			response.put("crearClientes", RespuestaCrearClientes);
			logger.info("Finalizo de: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Exception (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") :" + " causa: "
					+ e.getCause() + " mensaje: " + e.getMessage());
			response.put("mensaje: ", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	
	@GetMapping("/actualizarCliente")
	@ApiOperation(value = "Metodo actualizar clientes", notes = "metodo para actualizar clientes")
	public  ResponseEntity<?> editar(@RequestParam("id") Long id, @RequestBody Cliente cliente) {	
		Map<String, Object> response = new HashMap<>();
		Cliente RespuestaActualizarClientes;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaActualizarClientes = service.actualizar(id, cliente);
			response.put("mensaje", "cilentes actualizados.");
			response.put("actualizarClientes", RespuestaActualizarClientes);
			logger.info("Finalizo de: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Exception (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") :" + " causa: "
					+ e.getCause() + " mensaje: " + e.getMessage());
			response.put("mensaje: ", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	
	@GetMapping("/eliminarCliente")
	@ApiOperation(value = "Metodo elimina clientes", notes = "metodo para eliminar clientes")
	public  ResponseEntity<?> eliminar(@RequestBody Cliente cliente) {	
		Map<String, Object> response = new HashMap<>();
		String RespuestaEliminaClientes;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaEliminaClientes = service.eliminar(cliente);
			response.put("mensaje", "clientes eliminados.");
			response.put("eliminarClientes", RespuestaEliminaClientes);
			logger.info("Finalizo de: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Exception (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") :" + " causa: "
					+ e.getCause() + " mensaje: " + e.getMessage());
			response.put("mensaje: ", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

}
