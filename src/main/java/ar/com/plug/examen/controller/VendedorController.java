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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.plug.examen.domain.model.Producto;
import ar.com.plug.examen.domain.model.Vendedor;
import ar.com.plug.examen.domain.service.IVendedorService;
import ar.com.plug.examen.domain.vo.VendedorVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;


@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/vendedores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Clase para gestionar vendedores ")
public class VendedorController {
	
	private final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private IVendedorService service; 
	
	@GetMapping("/listarVendedor")
	@ApiOperation(value = "Metodo listar vendedores", notes = "metodo para consultar y obtener la lista de vendedores")
	public  ResponseEntity<?> listar() {	
		Map<String, Object> response = new HashMap<>();
		List<Vendedor> RespuestaListaVendedores;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaListaVendedores = service.listarVendedor();
			response.put("mensaje", "lista vendedores encontrados.");
			response.put("listVendedores", RespuestaListaVendedores);
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
	

	@GetMapping("/crearVendedor")
	@ApiOperation(value = "Metodo crear vendedores", notes = "metodo para crear vendedores")
	public  ResponseEntity<?> agregar(@RequestBody Vendedor vendedor) {	
		Map<String, Object> response = new HashMap<>();
		Vendedor RespuestaCrearVendedores;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaCrearVendedores = service.agregar(vendedor);
			response.put("mensaje", "vendedores creados.");
			response.put("crearVendedores", RespuestaCrearVendedores);
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
	
	
	@GetMapping("/actualizarVendedores")
	@ApiOperation(value = "Metodo actualizar vendedores", notes = "metodo para actualizar vendedores")
	public  ResponseEntity<?> editar(@RequestParam("id") Long id, @RequestBody Vendedor vendedor) {	
		Map<String, Object> response = new HashMap<>();
		Vendedor RespuestaActualizarVendedores;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaActualizarVendedores = service.actualizar(id, vendedor);
			response.put("mensaje", "vendedores actualizados.");
			response.put("actualizarVendedores", RespuestaActualizarVendedores);
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
	
	
	@GetMapping("/eliminarVendedor")
	@ApiOperation(value = "Metodo elimina vendedor", notes = "metodo para eliminar vendedores")
	public  ResponseEntity<?> eliminar(@RequestBody Vendedor vendedor) {	
		Map<String, Object> response = new HashMap<>();
		String RespuestaEliminaVendedores;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaEliminaVendedores = service.eliminar(vendedor);
			response.put("mensaje", "vendedores eliminados.");
			response.put("eliminaVendedores", RespuestaEliminaVendedores);
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
