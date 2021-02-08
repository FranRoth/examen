package ar.com.plug.examen.domain.repository;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ar.com.plug.examen.domain.model.Cliente;
import ar.com.plug.examen.domain.model.Vendedor;
import ar.com.plug.examen.domain.vo.ClienteVO;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
	
	final static Logger logger = LoggerFactory.getLogger(ClienteRepository.class);
	
	@Query(value = "SELECT * FROM CLIENTE WHERE ID = ?1", nativeQuery = true)
	Cliente findById(Long id);

	@Query(value = "SELECT * FROM CLIENTE WHERE NOMBRE = ?1", nativeQuery = true)
	Cliente findByName(String name);
	
	@Query(value = "SELECT * FROM CLIENTE WHERE APELLIDO = ?1", nativeQuery = true)
	Cliente findByLastName(String apellido);
	
	//
	@Query(value = "SELECT * FROM CLIENTE ", nativeQuery = true)
	List<Cliente> findAll();
	
	
	
	
	
	
	
	
	
	/*
	@Autowired
	private JdbcTemplate jdbcTemplates;
	
	private final static Logger logger = LoggerFactory.getLogger(ClienteRepository.class);
	
	
	private static final String SQL_LISTAR_CLIENTES = "SELECT * FROM cliente";
	


	public List<ClienteVO> listarClientes() {
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			return jdbcTemplates.query(
					SQL_LISTAR_CLIENTES, new Object[] { },
					 (rs, rowNum)  -> {		
						 ClienteVO listaClientes = new ClienteVO();
							listaClientes.setIdCliente(rs.getLong("id"));
							listaClientes.setNombreCliente(rs.getString("nombre"));
							listaClientes.setApellidoCliente(rs.getString("apellido"));
							return listaClientes;
					});
		}catch(Exception e){
			logger.error("Exception (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") :" + " causa: "
					+ e.getCause() + " mensaje: " + e.getMessage());
			return null;
		}
	
		
	}*/

}
