package ar.com.plug.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@Configuration
@ComponentScan("ar.com.plug")
public class Application {
	
	@Autowired
	private JdbcTemplate template;

    public static void main(final String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
    
   
	public void run(String... args) throws Exception {
		template.execute("DROP TABLE CLIENTE IF EXISTS"); 
		template.execute("CREATE TABLE CLIENTE(id INTEGER(11) PRYMARY KEY auto_increment,  nombre VARCHAR(255), apellido VARCHAR(255))");
		
		
		for( int i = 0; i < args.length; i++) {
			template.update("insert into cliente(nombre) values('Cliente 000"+i+"')");
		}
	}
	
	public void runVendedor(String... args) throws Exception {
		template.execute("DROP TABLE VENDEDOR IF EXISTS"); 
		template.execute("CREATE TABLE VENDEDOR(id INTEGER(11) PRYMARY KEY auto_increment,  nombre VARCHAR(255), apellido VARCHAR(255))");
		
		
		for( int i = 0; i < args.length; i++) {
			template.update("insert into vendedor(nombre) values('Vendedor 000"+i+"')");
		}
	}
	
	public void runProducto(String... args) throws Exception {
		template.execute("DROP TABLE PRODUCTO IF EXISTS"); 
		template.execute("CREATE TABLE PRODUCTO(id INTEGER(11) PRYMARY KEY auto_increment,  nombreProducto VARCHAR(255), tipoProducto VARCHAR(255))");
		
		
		for( int i = 0; i < args.length; i++) {
			template.update("insert into nameProducto(nombre) values('Producto 000"+i+"')");
		}
	}
	
	public void runCompra(String... args) throws Exception {
		template.execute("DROP TABLE COMPRA IF EXISTS"); 
		template.execute("CREATE TABLE COMPRA(id INTEGER(11) PRYMARY KEY auto_increment,  nombreCompra VARCHAR(255), numeroProducto VARCHAR(255))");
		
		
		for( int i = 0; i < args.length; i++) {
			template.update("insert into nombreCompra(nombre) values('nombreCompra 000"+i+"')");
		}
	}
}
