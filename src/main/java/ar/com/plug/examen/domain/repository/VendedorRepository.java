package ar.com.plug.examen.domain.repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ar.com.plug.examen.domain.model.Vendedor;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, String> {
	
	
	
	final static Logger logger = LoggerFactory.getLogger(ClienteRepository.class);
	
	@Query(value = "SELECT * FROM VENDEDOR WHERE ID = ?1", nativeQuery = true)
	Vendedor findById(Long id);

	@Query(value = "SELECT * FROM VENDEDOR WHERE NOMBRE = ?1", nativeQuery = true)
	Vendedor findByName(String name);
	
	@Query(value = "SELECT * FROM VENDEDOR WHERE APELLIDO = ?1", nativeQuery = true)
	Vendedor findByLastName(String apellido);
	
	//
	@Query(value = "SELECT * FROM VENDEDOR ", nativeQuery = true)
	List<Vendedor> findAll();
	

/*
	public List<VendedorVO> listarVendedor() {
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			return jdbcTemplates.query(
					SQL_LISTAR_VENDEDORES, new Object[] { },
					 (rs, rowNum)  -> {		
						 VendedorVO listaVendedores = new VendedorVO();
							 listaVendedores.setIdVendedor(rs.getLong("id"));
							 listaVendedores.setNombreVendedor(rs.getString("nombre"));
							 listaVendedores.setApellidoVendedor(rs.getString("apellido"));
							return listaVendedores;
					});
		}catch(Exception e){
			logger.error("Exception (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") :" + " causa: "
					+ e.getCause() + " mensaje: " + e.getMessage());
			return null;
		}
	
		
	}*/


}
