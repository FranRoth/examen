package ar.com.plug.examen.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "vendedor")
public class Vendedor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idVendedor")
	private long idVendedor;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "nombreVendedor")
	private String nombreVendedor;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "apellidoVendedor")
	private String apellidoVendedor;
	
	public Vendedor() {		
	}
	    
	public long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(long idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public String getApellidoVendedor() {
		return apellidoVendedor;
	}

	public void setApellidoVendedor(String apellidoVendedor) {
		this.apellidoVendedor = apellidoVendedor;
	}


}
