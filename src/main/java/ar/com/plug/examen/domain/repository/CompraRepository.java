package ar.com.plug.examen.domain.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ar.com.plug.examen.domain.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, String>{
	
	final static Logger logger = LoggerFactory.getLogger(ClienteRepository.class);
	
	
	@Query(value = "SELECT * FROM COMPRA WHERE ID = ?1", nativeQuery = true)
	Compra findById(Long id);
	
	@Query(value = "SELECT * FROM COMPRA WHERE NOMBRECOMPRA = ?1", nativeQuery = true)
	Compra findByCompra(String nameCompra);
	
	@Query(value = "SELECT * FROM COMPRA WHERE NUMEROPRODUCTO = ?1", nativeQuery = true)
	Compra findByProducto(String numeroProducto);
	
	//
	@Query(value = "SELECT * FROM COMPRA ", nativeQuery = true)
	List<Compra> findAll();


	

}
