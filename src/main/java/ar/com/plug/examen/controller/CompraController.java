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
import org.springframework.web.bind.annotation.RestController;
import ar.com.plug.examen.app.api.CompraApi;
import ar.com.plug.examen.domain.service.ICompraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/comprar")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Clase para gestionar las compras de la aplicaicon")
public class CompraController {
	
private final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ICompraService service; 
	
	@GetMapping("/crearCompra")
	@ApiOperation(value = "Metodo aprobar compra", notes = "metodo para aprobar las compras en la aplicacion")
	public  ResponseEntity<?> crear(@RequestBody CompraApi compra) {	
		Map<String, Object> response = new HashMap<>();
		CompraApi RespuestaCompra;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaCompra = service.crear(compra);
			response.put("mensaje", "compras aprobadas.");
			response.put("aprobarCompra", RespuestaCompra);
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
	
	@GetMapping("/buscarCompra")
	@ApiOperation(value = "Metodo buscar compra", notes = "metodo para buscar las compras en la aplicacion")
	public  ResponseEntity<?> buscar() {	
		Map<String, Object> response = new HashMap<>();
		List<CompraApi> RespuestaCompra;

		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			RespuestaCompra = service.buscar();
			response.put("mensaje", "compras encontradas.");
			response.put("buscarCompra", RespuestaCompra);
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
