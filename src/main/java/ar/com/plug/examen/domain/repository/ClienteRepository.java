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
	


}
