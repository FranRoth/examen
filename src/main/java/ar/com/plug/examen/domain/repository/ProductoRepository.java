package ar.com.plug.examen.domain.repository;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ar.com.plug.examen.domain.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String>{
	
	
final static Logger logger = LoggerFactory.getLogger(ClienteRepository.class);
	
	@Query(value = "SELECT * FROM PRODUCTO WHERE ID = ?1", nativeQuery = true)
	Producto findById(Long id);

	@Query(value = "SELECT * FROM PRODUCTO WHERE NOMBREPRODUCTO = ?1", nativeQuery = true)
	Producto findByNombreProducto(String name);
	
	@Query(value = "SELECT * FROM PRODUCTO WHERE TIPOPRODUCTO = ?1", nativeQuery = true)
	Producto findByLastTipoProducto(String apellido);
	
	//
	@Query(value = "SELECT * FROM PRODUCTO ", nativeQuery = true)
	List<Producto> findAll();

}
