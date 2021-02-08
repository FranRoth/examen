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
	

	
	/*
	@Autowired
	private JdbcTemplate jdbcTemplates;
	
	private final static Logger logger = LoggerFactory.getLogger(ClienteRepository.class);
	
	
	private static final String SQL_LISTAR_PRODUCTOS = "SELECT * FROM producto";
	
	private static final String SQL_INSERTAR_PRODUCTOS = "INSERT INTO nameProducto, tipoProducto  values(?,?)";
	
	private static final String SQL_ACTUALIZAR_PRODUCTOS = "UPDATE producto set nombreProducto = ? , tipoProducto = ?";
	
	private static final String SQL_ELIMINAR_PRODUCTOS = "DELETE FROM producto where idProducto = ?";
	
	private int swExito = 0;
	
	private boolean succes = false;

	
	public List<ProductoVO> listarProducto() {
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			return jdbcTemplates.query(
					SQL_LISTAR_PRODUCTOS, new Object[] { },
					 (rs, rowNum)  -> {		
						 ProductoVO listaProductos = new ProductoVO();
							 listaProductos.setIdProducto(rs.getLong("id"));
							 listaProductos.setNombreProducto(rs.getString("nombre"));
							 listaProductos.setTipoProducto(rs.getString("tipoProducto"));
							return listaProductos;
					});
		}catch(Exception e){
			logger.error("Exception (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") :" + " causa: "
					+ e.getCause() + " mensaje: " + e.getMessage());
			return null;
		}
	
		
	}
	
	public  int  agregar(List<ProductoVO> listaProductos) {
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		 List <ProductoVO>listaProduc = new ArrayList<ProductoVO>();
		 listaProduc = listaProductos;
		try {
			for (int i = 0; i < listaProduc.size();) {
				return jdbcTemplates.query(
						SQL_INSERTAR_PRODUCTOS, new Object[] {
								listaProductos.get(i).getNombreProducto(), listaProductos.get(i).getTipoProducto()},
						(rs) -> {
		                    if (rs.next())
		                        return swExito = 1;
		                    else
		                        return swExito = 0;
		                });
			 }
			
		}catch(Exception e){
			logger.error("Exception (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") :" + " causa: "
					+ e.getCause() + " mensaje: " + e.getMessage());
		}
		return swExito;
		
	}
	
	
	public  boolean actualizar(List<ProductoVO> listaProductos) {
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		 List <ProductoVO>listaProduc = new ArrayList<ProductoVO>();
		 listaProduc = listaProductos;
		try {
			for (int i = 0; i < listaProduc.size();) {
				return jdbcTemplates.query(
						SQL_ACTUALIZAR_PRODUCTOS, new Object[] {
								listaProductos.get(i).getIdProducto()},
						(rs) -> {
		                    if (rs.next())
		                        return succes = true;
		                    else
		                        return succes = false;
		                });
			 }
			
		}catch(Exception e){
			logger.error("Exception (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") :" + " causa: "
					+ e.getCause() + " mensaje: " + e.getMessage());
		}
		return succes;
		
	}
	
	
	public  boolean eliminar(List<ProductoVO> listaProductos) {
		logger.info("Ingreso a: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		 List <ProductoVO>listaProduc = new ArrayList<ProductoVO>();
		 listaProduc = listaProductos;
		try {
			for (int i = 0; i < listaProduc.size();) {
				return jdbcTemplates.query(
						SQL_ELIMINAR_PRODUCTOS, new Object[] {
								listaProductos.get(i).getIdProducto()},
						(rs) -> {
		                    if (rs.next())
		                        return succes = true;
		                    else
		                        return succes = false;
		                });
			 }
			
		}catch(Exception e){
			logger.error("Exception (" + Thread.currentThread().getStackTrace()[1].getMethodName() + ") :" + " causa: "
					+ e.getCause() + " mensaje: " + e.getMessage());
		}
		return succes;
		
	}*/
}
