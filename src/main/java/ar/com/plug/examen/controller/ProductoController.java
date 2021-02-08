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

import ar.com.plug.examen.domain.model.Cliente;
import ar.com.plug.examen.domain.model.Producto;
import ar.com.plug.examen.domain.service.IProductoService;
import ar.com.plug.examen.domain.vo.ProductoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/productos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Clase para gestionar productos de la aplicaicon")
public class ProductoController {
	
	private final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private IProductoService serviceProduc; 
	
	@GetMapping("/listarProductos")
	@ApiOperation(value = "Metodo listar productos", notes = "metodo para consultar y obtener la lista de productos")
	public  ResponseEntity<?> listar() {	
		Map<String, Object> response = new HashMap<>();
		List<Producto> RespuestaListaProductos;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaListaProductos = serviceProduc.listarProductos();
			response.put("mensaje", "lista productos encontrados.");
			response.put("listProductos", RespuestaListaProductos);
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
	
	
	
	@GetMapping("/crearProducto")
	@ApiOperation(value = "Metodo crear productos", notes = "metodo para crear productos")
	public  ResponseEntity<?> agregar(@RequestBody Producto producto) {	
		Map<String, Object> response = new HashMap<>();
		Producto RespuestaCrearProductos;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaCrearProductos = serviceProduc.agregar(producto);
			response.put("mensaje", "productos creados.");
			response.put("crearProductos", RespuestaCrearProductos);
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
	
	
	@GetMapping("/actualizarProducto")
	@ApiOperation(value = "Metodo actualizar productos", notes = "metodo para actualizar productos")
	public  ResponseEntity<?> editar(@RequestParam("id") Long id, @RequestBody Producto producto) {	
		Map<String, Object> response = new HashMap<>();
		Producto RespuestaActualizarProductos;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaActualizarProductos = serviceProduc.actualizar(id, producto);
			response.put("mensaje", "productos actualizados.");
			response.put("actualizarProductos", RespuestaActualizarProductos);
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
	
	
	@GetMapping("/eliminarProducto")
	@ApiOperation(value = "Metodo elimina productos", notes = "metodo para eliminar productos")
	public  ResponseEntity<?> eliminar(@RequestBody Producto producto) {	
		Map<String, Object> response = new HashMap<>();
		String RespuestaEliminaProductos;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaEliminaProductos = serviceProduc.eliminar(producto);
			response.put("mensaje", "productos eliminados.");
			response.put("eliminaProductos", RespuestaEliminaProductos);
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
	
	
	/*
	@GetMapping("/agregarProductos")
	@ApiOperation(value = "Metodo listar productos", notes = "metodo para consultar y obtener la lista de productos")
	public  ResponseEntity<?> agregar(@RequestBody List<ProductoVO> listProductos) {	
		Map<String, Object> response = new HashMap<>();
		List<ProductoVO> RespuestaAgregarProductos;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaAgregarProductos = serviceProduc.listarProductos();
			response.put("mensaje", "lista productos encontrados.");
			response.put("listProductos", RespuestaAgregarProductos);
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
	

	
	@GetMapping("/actualizarProductos")
	@ApiOperation(value = "Metodo actualiza productos", notes = "metodo para actualizar  la lista de productos")
	public  ResponseEntity<?> actualizar(@RequestBody List<ProductoVO> listProductos) {	
		Map<String, Object> response = new HashMap<>();
		List<ProductoVO> RespuestaAgregarProductos;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaAgregarProductos = serviceProduc.listarProductos();
			response.put("mensaje", "productos actualizados.");
			response.put("actualizaProductos", RespuestaAgregarProductos);
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
	
	@GetMapping("/eliminaProductos")
	@ApiOperation(value = "Metodo elimina productos", notes = "metodo para eliminar productos")
	public  ResponseEntity<?> eliminar(@RequestBody List<ProductoVO> listProductos) {	
		Map<String, Object> response = new HashMap<>();
		boolean RespuestaEliminarProductos;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaEliminarProductos = serviceProduc.eliminar(listProductos);
			response.put("mensaje", "productos actualizados.");
			response.put("actualizaProductos", RespuestaEliminarProductos);
			logger.info("Finalizo de: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Exception (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") :" + " causa: "
					+ e.getCause() + " mensaje: " + e.getMessage());
			response.put("mensaje: ", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}*/

}
